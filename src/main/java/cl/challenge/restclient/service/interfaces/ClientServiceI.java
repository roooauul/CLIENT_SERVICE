package cl.challenge.restclient.service.interfaces;

import java.util.List;

import cl.challenge.restclient.domain.ClientEntity;

public interface ClientServiceI {
	public List<ClientEntity> getAll();
	public ClientEntity getById(int id);
	public ClientEntity save();
	public ClientEntity update();
	public void deleteById(int id);
}
