package cl.challenge.restclient.service.interfaces;

import java.util.List;

import cl.challenge.restclient.domain.ClientEntity;
import cl.challenge.restclient.dto.client.BaseClientDto;
import cl.challenge.restclient.dto.client.ClientDto;
import cl.challenge.restclient.shared.exception.SystemException;

public interface ClientServiceI {
	public List<ClientEntity> getAll();
	public List<ClientEntity> getActives();
	public ClientEntity getById(String email, String rut);
	public ClientEntity save(ClientDto client) throws SystemException;
	public ClientEntity update(ClientDto client)throws SystemException;
	public ClientEntity update(BaseClientDto client)throws SystemException;
	public void deleteById(String email, String rut) throws SystemException;
}
