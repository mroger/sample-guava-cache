package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(AberturaRepasse.class)
public abstract class AberturaRepasse_ {

	public static volatile SingularAttribute<AberturaRepasse, RepasseFormaPag> repasseFormaPagamento;
	public static volatile SingularAttribute<AberturaRepasse, Conta> conta;
	public static volatile SingularAttribute<AberturaRepasse, Long> id;
	public static volatile SingularAttribute<AberturaRepasse, AberturaComitente> aberturaComitente;
	public static volatile SingularAttribute<AberturaRepasse, Long> contaId;
	public static volatile SingularAttribute<AberturaRepasse, Integer> formaPagamentoId;

}

