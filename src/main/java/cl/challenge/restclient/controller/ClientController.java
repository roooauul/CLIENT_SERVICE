package cl.challenge.restclient.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.challenge.restclient.dto.ApiResponseDto;
import cl.challenge.restclient.dto.client.ClientDto;
import cl.challenge.restclient.shared.SystemConstants;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	
    @GetMapping()
    public ResponseEntity<ApiResponseDto> getAll() {
    	return new ResponseEntity<>(new ApiResponseDto("WIP", SystemConstants.API_RESPONSE_SUCCESS, false), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ApiResponseDto> save(@Valid @RequestBody ClientDto clientDto) {
    	return new ResponseEntity<>(new ApiResponseDto(clientDto, SystemConstants.API_RESPONSE_SUCCESS, false), HttpStatus.OK);
    }
}
