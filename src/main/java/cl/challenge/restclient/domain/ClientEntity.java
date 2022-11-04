package cl.challenge.restclient.domain;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cl.challenge.restclient.domain.composite.ClientId;
import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Table(name = "tb_client", indexes = {
	@Index(columnList = "email"),
	@Index(columnList = "rut")
})
@IdClass(ClientId.class)
public class ClientEntity {

    @Id
    @Column(nullable = false, length = 100)
    private String email;
    
    @Id
    @Column(nullable = false, length = 10)
    private String rut;

	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Column(name = "modification_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	@Column(name = "deletion_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletionDate;
	
    @Column(nullable = false, length = 30)
    private String name;
    
    @Column(nullable = false, length = 30)
    private String surname;
    
    @Column(nullable = false)
    private Long cellphone;
}
