package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RoleDocumentType.class)
public abstract class RoleDocumentType_ {

	public static volatile SingularAttribute<RoleDocumentType, Country> country;
	public static volatile SingularAttribute<RoleDocumentType, Role> role;
	public static volatile SingularAttribute<RoleDocumentType, DocumentType> documentType;
	public static volatile SingularAttribute<RoleDocumentType, Integer> roleId;
	public static volatile SingularAttribute<RoleDocumentType, String> entityType;
	public static volatile SingularAttribute<RoleDocumentType, Integer> documentTypeId;
	public static volatile SingularAttribute<RoleDocumentType, Integer> id;
	public static volatile SingularAttribute<RoleDocumentType, DocumentTypeCategory> category;
	public static volatile SingularAttribute<RoleDocumentType, Integer> countryId;
	public static volatile SingularAttribute<RoleDocumentType, Integer> categoryId;

}

