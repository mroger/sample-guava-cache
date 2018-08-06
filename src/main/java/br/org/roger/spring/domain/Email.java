package br.org.roger.spring.domain;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("serial")
@Entity
@Table(name = "EMAIL")
@NamedQueries({
		@NamedQuery(name = Email.Queries.FIND_EMAIL,
				query = " select " +
						"  e " +
						" from " +
						"  Email e " +
						" where" +
						"	lower(e.email) = lower(:email) "
		),
		@NamedQuery(name = Email.Queries.FIND_EMAIL_FROM_USER,
				query = " select e " +
						" from " +
						"  Email e " +
						" where e.entityId = :entityId"
		),
		@NamedQuery(name = Email.Queries.FIND_EMAIL_ADDRESS,
				query = " select e" +
						" from " +
						"  Email e JOIN FETCH e.entity user " +
						" where lower(e.address) = lower(:emailAddress)"
		)

	
})
public class Email implements Serializable {

	public static final int PESSOAL = 1;
	public static final int COMERCIAL = 2;
	public static final int PORTAL = 3;
	public static final int VENDA = 4;
	public static final int COMPRA = 5;

	public static final class Queries {
		public static final String FIND_EMAIL = "FIND_EMAIL";
		public static final String FIND_EMAIL_REGISTRATION_COMPLETED = "FIND_EMAIL_REGISTRATION_COMPLETED";
		public static final String FIND_EMAIL_FROM_USER = "FIND_EMAIL_FROM_USER";
		public static final String FIND_EMAIL_ADDRESS = "FIND_EMAIL_ADDRESS";
	}

	@Id
	@GeneratedValue(generator="triggerGenerator")
	@GenericGenerator(name="triggerGenerator", strategy="net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "EMAIL_ID")
    private Long id;

	@Column(name= "EMAIL_TYPE_ID")
	private Integer typeId;
    
    @Column(name = "EMAIL_PREFIX")
    private String prefix;
    
    @Column(name = "EMAIL_PROVIDER")
    private String provider;

	@Column(name = "EMAIL_ADDRESS")
	private String address;
    
    @Deprecated
	@Formula(value="EMAIL_PREFIX || '@' || EMAIL_PROVIDER")
    private String email;
    
    @Column(name = "EMAIL_MASTER")
	@Type(type = "net.s4bdigital.libs.jpa.usertype.TrueFalseCharType")
    private Boolean master;

	@Column(name = "VALIDATED")
	@Type(type = "net.s4bdigital.libs.jpa.usertype.TrueFalseCharType")
	private Boolean validated;

	@Column(name = "VALIDATED_DATE")
	private Date validatedAt;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTITY_ID", insertable = false, updatable = false)
	private UserEntity entity;

	@Column(name = "ENTITY_ID")
	private Long entityId;


	public Boolean getValidated() {
		return validated;
	}

	public void setValidated(Boolean validated) {
		this.validated = validated;
	}

	public Date getValidatedAt() {
		return validatedAt;
	}

	public void setValidatedAt(Date validatedAt) {
		this.validatedAt = validatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getMaster() {
		return master;
	}

	public void setMaster(Boolean master) {
		this.master = master;
	}

	public UserEntity getEntity() {
		return entity;
	}

	public void setEntity(UserEntity entity) {
		this.entity = entity;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
