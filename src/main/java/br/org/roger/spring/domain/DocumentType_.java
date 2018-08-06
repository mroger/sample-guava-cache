package br.org.roger.spring.domain;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(DocumentType.class)
public abstract class DocumentType_ {

	public static volatile SingularAttribute<DocumentType, String> name;
	public static volatile SingularAttribute<DocumentType, String> description;
	public static volatile SingularAttribute<DocumentType, Integer> id;
	public static volatile ListAttribute<DocumentType, RoleDocumentType> roleDocumentType;
	public static volatile SingularAttribute<DocumentType, Integer> order;

}

