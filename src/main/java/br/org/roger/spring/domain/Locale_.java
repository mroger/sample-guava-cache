package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Locale.class)
public abstract class Locale_ {
    public static volatile SingularAttribute<Locale, String> id;
    public static volatile SingularAttribute<Locale, String> description;
    public static volatile SingularAttribute<Locale, String> currency;
    public static volatile SingularAttribute<Locale, String> currencyCode;
}

