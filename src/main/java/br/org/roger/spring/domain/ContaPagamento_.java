package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ContaPagamento.class)
public abstract class ContaPagamento_ {

	public static volatile SingularAttribute<ContaPagamento, FormaPagamento> formaPagamento;
	public static volatile SingularAttribute<ContaPagamento, ContaPagamantoStatus> contaPagamantoStatus;
	public static volatile SingularAttribute<ContaPagamento, Integer> statusId;
	public static volatile SingularAttribute<ContaPagamento, Conta> conta;
	public static volatile SingularAttribute<ContaPagamento, Integer> carteira;
	public static volatile SingularAttribute<ContaPagamento, Boolean> cobrancaRegistrada;
	public static volatile SingularAttribute<ContaPagamento, Long> convenio;
	public static volatile SingularAttribute<ContaPagamento, Long> id;
	public static volatile SingularAttribute<ContaPagamento, Long> contaId;
	public static volatile SingularAttribute<ContaPagamento, Integer> formaPagamentoId;

}

