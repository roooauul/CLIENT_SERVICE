package cl.challenge.restclient.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.AUTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name = "TB_CLIENT", indexes = {
	@Index(columnList = "email"),
})
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    
	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
    @Column(nullable = false, length = 30)
    private String name;
    
    @Column(nullable = false, length = 30)
    private String surname;
    
    @Column(nullable = false, length = 100)
    private String email;
    
    @Column(nullable = false)
    private Long cellphone;
}
