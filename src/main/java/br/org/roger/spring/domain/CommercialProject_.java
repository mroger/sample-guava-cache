package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(CommercialProject.class)
public abstract class CommercialProject_ {

	public static volatile SingularAttribute<CommercialProject, Date> createdAt;
	public static volatile SingularAttribute<CommercialProject, Integer> statusId;
	public static volatile SingularAttribute<CommercialProject, String> yourReference;
	public static volatile SingularAttribute<CommercialProject, String> description;
	public static volatile SingularAttribute<CommercialProject, Long> id;
	public static volatile SingularAttribute<CommercialProject, Long> ownerId;
	public static volatile SingularAttribute<CommercialProject, Integer> storeId;
	public static volatile SingularAttribute<CommercialProject, Date> closeAt;
	public static volatile SingularAttribute<CommercialProject, CommercialProjectStatus> status;
	public static volatile SingularAttribute<CommercialProject, Date> updatedAt;

}

