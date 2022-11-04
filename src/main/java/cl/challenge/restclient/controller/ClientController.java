package cl.challenge.restclient.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.challenge.restclient.domain.ClientEntity;
import cl.challenge.restclient.dto.ApiResponseDto;
import cl.challenge.restclient.dto.client.BaseClientDto;
import cl.challenge.restclient.dto.client.ClientDto;
import cl.challenge.restclient.dto.client.ClientIdDto;
import cl.challenge.restclient.service.interfaces.ClientServiceI;
import cl.challenge.restclient.shared.SystemConstants;
import cl.challenge.restclient.shared.exception.SystemException;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	@Autowired
	private ClientServiceI clientService;
	
	@GetMapping()
    public ResponseEntity<ApiResponseDto> getAll() {
    	List<ClientEntity> clients = this.clientService.getAll();
    	return new ResponseEntity<>(new ApiResponseDto(clients, SystemConstants.API_RESPONSE_SUCCESS, false), HttpStatus.OK);
    }
	
	@GetMapping("actives")
    public ResponseEntity<ApiResponseDto> getActives() {
    	List<ClientEntity> clients = this.clientService.getActives();
    	return new ResponseEntity<>(new ApiResponseDto(clients, SystemConstants.API_RESPONSE_SUCCESS, false), HttpStatus.OK);
    }
	
	@PostMapping()
    public ResponseEntity<ApiResponseDto> save(@Valid @RequestBody ClientDto clientDto) throws SystemException {
    	ClientEntity client = this.clientService.save(clientDto);
    	return new ResponseEntity<>(new ApiResponseDto(client, SystemConstants.API_RESPONSE_SUCCESS, false), HttpStatus.OK);
    }
	
	@PutMapping()
    public ResponseEntity<ApiResponseDto> update(@Valid @RequestBody ClientDto clientDto) throws SystemException {
    	ClientEntity client = this.clientService.update(clientDto);
    	return new ResponseEntity<>(new ApiResponseDto(client, SystemConstants.API_RESPONSE_SUCCESS, false), HttpStatus.OK);
    }
	
	@PatchMapping()
    public ResponseEntity<ApiResponseDto> update(@Valid @RequestBody BaseClientDto baseClientDto) throws SystemException {
    	ClientEntity client = this.clientService.update(baseClientDto);
    	return new ResponseEntity<>(new ApiResponseDto(client, SystemConstants.API_RESPONSE_SUCCESS, false), HttpStatus.OK);
    }
	
	@DeleteMapping()
    public ResponseEntity<ApiResponseDto> delete(@Valid ClientIdDto clientIdDto) throws SystemException {
    	this.clientService.deleteById(clientIdDto.getEmail(), clientIdDto.getRut());
    	return new ResponseEntity<>(new ApiResponseDto(null, SystemConstants.API_RESPONSE_SUCCESS, false), HttpStatus.OK);
    }
}
