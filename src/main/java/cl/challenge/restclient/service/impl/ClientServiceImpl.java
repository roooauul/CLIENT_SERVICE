package cl.challenge.restclient.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.challenge.restclient.domain.ClientEntity;
import cl.challenge.restclient.dto.client.BaseClientDto;
import cl.challenge.restclient.dto.client.ClientDto;
import cl.challenge.restclient.repository.ClientRepository;
import cl.challenge.restclient.service.interfaces.ClientServiceI;
import cl.challenge.restclient.shared.SystemConstants;
import cl.challenge.restclient.shared.exception.SystemException;

@Service
public class ClientServiceImpl implements ClientServiceI {
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<ClientEntity> getAll() {
		return this.clientRepository
			.findAll();
	}
	
	@Override
	public List<ClientEntity> getActives() {
		return this.clientRepository
			.findAll()
			.stream()
			.filter(client -> client.getDeletionDate() == null)
			.collect(Collectors.toList());
	}

	@Override
	public ClientEntity getById(String email, String rut) {
		return this.clientRepository.getByEmailAndRut(email, rut);
	}

	@Override
	public ClientEntity save(ClientDto client) throws SystemException {
		ClientEntity clientToSave = this.clientRepository.getByEmailAndRut(client.getEmail(), client.getRut());
		if (clientToSave != null) {
			throw new SystemException("Cant create client", "The client [" + client.getEmail() + ", "+ client.getRut() + "] is registered.", SystemConstants.CLIENT_REGISTERED);
		}
		clientToSave = new ClientEntity();
		clientToSave.setRut(client.getRut());
		clientToSave.setEmail(client.getEmail());
		clientToSave.setCreationDate(new Date());
		clientToSave.setModificationDate(null);
		clientToSave.setDeletionDate(null);
		clientToSave.setCellphone(client.getCellphone());
		clientToSave.setName(client.getName());
		clientToSave.setSurname(client.getSurname());
		return this.clientRepository.save(clientToSave);
	}

	@Override
	public ClientEntity update(ClientDto client) throws SystemException {
		ClientEntity clientToSave = this.clientRepository.getByEmailAndRut(client.getEmail(), client.getRut());
		if (clientToSave == null) {
			throw new SystemException("Cant create client", "The client [" + client.getEmail() + ", "+ client.getRut() + "] is not registered.", SystemConstants.CLIENT_NOT_REGISTERED);
		}
		clientToSave.setModificationDate(new Date());
		clientToSave.setDeletionDate(clientToSave.getDeletionDate());
		clientToSave.setCellphone(client.getCellphone());
		clientToSave.setName(client.getName());
		clientToSave.setSurname(client.getSurname());
		return this.clientRepository.save(clientToSave);
	}
	
	@Override
	public ClientEntity update(BaseClientDto client) throws SystemException {
		ClientEntity clientToSave = this.clientRepository.getByEmailAndRut(client.getEmail(), client.getRut());
		if (clientToSave == null) {
			throw new SystemException("Cant create client", "The client [" + client.getEmail() + ", "+ client.getRut() + "] is not registered.", SystemConstants.CLIENT_NOT_REGISTERED);
		}
		clientToSave.setModificationDate(new Date());
		clientToSave.setDeletionDate(clientToSave.getDeletionDate());
		if (client.getCellphone() != null) {
			clientToSave.setCellphone(client.getCellphone());
		}
		if (client.getName() != null) {
			clientToSave.setName(client.getName());
		}
		if (client.getSurname() != null) {
			clientToSave.setSurname(client.getSurname());
		}
		return this.clientRepository.save(clientToSave);
	}

	@Override
	public void deleteById(String email, String rut) throws SystemException {
		ClientEntity clientToSave = this.clientRepository.getByEmailAndRut(email, rut);
		if (clientToSave == null) {
			throw new SystemException("Cant create client", "The client [" + email + ", "+ rut + "] is not registered.", SystemConstants.CLIENT_NOT_REGISTERED);
		}
		clientToSave.setDeletionDate(new Date());
		this.clientRepository.save(clientToSave);
	}

}
