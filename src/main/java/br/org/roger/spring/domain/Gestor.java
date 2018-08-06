package br.org.roger.spring.domain;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "GESTOR")
@NamedQueries({
	
})
public class Gestor implements java.io.Serializable {

	public static final Long GESTOR_BRASIL = 9l;
	public static final Long GESTOR_ARGENTINA = 10l;
	public static final Long GESTOR_CHILE = 12l;
	public static final Long GESTOR_COLOMBIA = 14l;
	public static final Long GESTOR_PERU = 27l;

	public static final class Queries {
	}

	@Id
	@Column(name = "GESTOR_ID", unique = true, nullable = false, precision = 9, scale = 0)
	private Long id;
	
	@Column(name = "ENTITY_ID")
	private Long entityId;

	@Column(name = "GESTOR_DESC", length = 100)
	private String gestorDesc;

	@Column(name = "GESTOR_TITLE", length = 250)
	private String gestorTitle;

	@OneToOne(mappedBy = "gestor", fetch = FetchType.LAZY)
	private GestorSettings settings;
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getGestorDesc() {
		return gestorDesc;
	}

	public void setGestorDesc(String gestorDesc) {
		this.gestorDesc = gestorDesc;
	}

	public String getGestorTitle() {
		return gestorTitle;
	}

	public void setGestorTitle(String gestorTitle) {
		this.gestorTitle = gestorTitle;
	}

	public GestorSettings getSettings() {
		return settings;
	}

	public void setSettings(GestorSettings settings) {
		this.settings = settings;
	}
}
