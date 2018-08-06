package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Document.class)
public abstract class Document_ {

	public static volatile SingularAttribute<Document, UserEntity> userEntity;
	public static volatile SingularAttribute<Document, Integer> tipoId;
	public static volatile SingularAttribute<Document, String> numero;
	public static volatile SingularAttribute<Document, DocumentType> documentType;
	public static volatile SingularAttribute<Document, Long> entityId;
	public static volatile SingularAttribute<Document, Long> id;

}

