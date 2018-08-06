package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "LOCALE")
public class Locale {

    @Id
    @Column(name = "SIGLA_LOCALE", insertable=false, updatable= false)
    private String id;

    @Column(name = "DESC_LOCALE", insertable=false, updatable= false)
    private String description;

    @Column(name = "MOEDA", insertable=false, updatable= false)
    private String currency;

    @Column(name = "MOEDA_ISO_4217", insertable=false, updatable= false)
    private String currencyCode;

}
