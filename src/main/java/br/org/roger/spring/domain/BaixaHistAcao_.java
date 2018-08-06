package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(BaixaHistAcao.class)
public abstract class BaixaHistAcao_ {

	public static volatile SingularAttribute<BaixaHistAcao, Integer> id;
	public static volatile SingularAttribute<BaixaHistAcao, String> acao;

}

