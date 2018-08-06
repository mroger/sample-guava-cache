package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(GestorSettings.class)
public abstract class GestorSettings_ {

	public static volatile SingularAttribute<GestorSettings, Gestor> gestor;
	public static volatile SingularAttribute<GestorSettings, Long> gestorId;
	public static volatile SingularAttribute<GestorSettings, Country> country;
	public static volatile SingularAttribute<GestorSettings, Integer> countryCode;
	public static volatile SingularAttribute<GestorSettings, Integer> erpSystem;
	public static volatile SingularAttribute<GestorSettings, String> showItensPorcentagem;
	public static volatile SingularAttribute<GestorSettings, Integer> erpKey;

}

