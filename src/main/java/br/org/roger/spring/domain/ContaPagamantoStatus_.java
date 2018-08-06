package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ContaPagamantoStatus.class)
public abstract class ContaPagamantoStatus_ {

	public static volatile SingularAttribute<ContaPagamantoStatus, String> descStatusContaPagamento;
	public static volatile SingularAttribute<ContaPagamantoStatus, Integer> id;
	public static volatile SetAttribute<ContaPagamantoStatus, ContaPagamento> contaPagamentos;

}

