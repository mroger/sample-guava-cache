package br.org.roger.spring.domain;

import javax.persistence.*;

@Entity
@Table(name = "DOCUMENT")
@NamedQueries({
        @NamedQuery(name = Document.Queries.FIND_DOCUMENT_BY_TYPE_BY_USER,
                query =
                        " SELECT d " +
                                " FROM " +
                                "	Document d " +
                                " WHERE " +
                                "   d.tipoId = :documentTypeId " +
                                "	and d.entityId = :userEntityId " ),
        @NamedQuery(name = Document.Queries.FIND_CPF_BY_ENTITY_USER_ID,
                query =
                        " SELECT " +
                                "   d " +
                                " FROM " +
                                "	Document d " +
                                " WHERE " +
                                "	d.tipoId = " + DocumentType.CPF +
                                "	and d.entityId = :userEntityId "),
        @NamedQuery(name = Document.Queries.FIND_CNPJ_BY_ENTITY_USER_ID,
                query =
                        " SELECT " +
                                "   d " +
                                " FROM " +
                                "	Document d " +
                                " WHERE " +
                                "	d.tipoId = " + DocumentType.CNPJ +
                                "	and d.entityId = :userEntityId ")
})
public class Document {
    public static final class Queries {
        public static final String FIND_DOCUMENT_BY_TYPE_BY_USER = "FIND_DOCUMENT_BY_TYPE_BY_USER";
        public static final String FIND_CPF_BY_ENTITY_USER_ID = "FIND_CPF_BY_ENTITY_USER_ID";
        public static final String FIND_CNPJ_BY_ENTITY_USER_ID = "FIND_CNPJ_BY_ENTITY_USER_ID";
    }
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DOCUMENT_ID")
    private Long id;
	
	@Column(name = "DOCUMENT_NUMBER")
	private String numero;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "DOCUMENT_TYPE_ID", insertable = false, updatable = false)
	private DocumentType documentType;

    @Column(name = "DOCUMENT_TYPE_ID")
    private Integer tipoId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTITY_ID", insertable = false, updatable = false)
	private UserEntity userEntity;

    @Column(name = "ENTITY_ID")
    private Long entityId;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getNumero() {
        return this.numero;
    }

	public void setNumero(String numero) {
        this.numero = numero;
    }

	public DocumentType getDocumentType() {
        return this.documentType;
    }

	public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

	public UserEntity getUserEntity() {
        return this.userEntity;
    }

	public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Integer getTipoId() {
        return tipoId;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

}
