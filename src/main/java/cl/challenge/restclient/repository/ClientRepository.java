package cl.challenge.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.challenge.restclient.domain.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
	public ClientEntity getByEmailAndRut(String email, String rut);
}
