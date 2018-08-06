package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Gestor.class)
public abstract class Gestor_ {

	public static volatile SingularAttribute<Gestor, String> gestorDesc;
	public static volatile SingularAttribute<Gestor, String> gestorTitle;
	public static volatile SingularAttribute<Gestor, GestorSettings> settings;
	public static volatile SingularAttribute<Gestor, Long> entityId;
	public static volatile SingularAttribute<Gestor, Long> id;

}

