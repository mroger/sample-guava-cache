package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PagamentoStatus.class)
public abstract class PagamentoStatus_ {
    public static volatile SingularAttribute<PagamentoStatus, String> chave;
    public static volatile SingularAttribute<PagamentoStatus, Long>   id;
    public static volatile SingularAttribute<PagamentoStatus, String> desc;
}

