package br.org.roger.spring.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PERFIL")
@NamedQueries({
		@NamedQuery(name = Perfil.Queries.FIND_PERFIL_BY_USER_ID_AND_PORTAL,
				query =  "SELECT p FROM Perfil p WHERE p.entityId = :userId and p.portalId = :portalId"
		)
})
public class Perfil {

	public static final class Queries {
		public static final String FIND_PERFIL_BY_USER_ID_AND_PORTAL = "FIND_PERFIL_BY_USER_ID_AND_PORTAL";
	}

	@Id
	@GeneratedValue(generator="triggerGenerator")
	@GenericGenerator(name="triggerGenerator", strategy="net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
	@Column(name = "PERFIL_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTITY_ID", updatable=false, insertable=false)
	private UserEntity entity;

	@Column(name = "ENTITY_ID")
	private Long entityId;

	@Column(name = "EREG_PORTAL_ID")
	private Integer portalId;

	@Column(name = "MOEDA_REFERENCIAL_ID")
	private String currencyCode;

	@Column(name = "LOCALE_ID")
	private String locale;

	@Column(name = "TIMEZONE_ID")
	private String timezoneId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE")
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getEntity() {
		return entity;
	}

	public void setEntity(UserEntity entity) {
		this.entity = entity;
	}

	public Integer getPortalId() {
		return portalId;
	}

	public void setPortalId(Integer portalId) {
		this.portalId = portalId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getTimezoneId() {
		return timezoneId;
	}

	public void setTimezoneId(String timezoneId) {
		this.timezoneId = timezoneId;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
