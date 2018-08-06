package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(DocumentTypeCategory.class)
public abstract class DocumentTypeCategory_ {

	public static volatile SingularAttribute<DocumentTypeCategory, String> description;
	public static volatile SingularAttribute<DocumentTypeCategory, Integer> id;

}

