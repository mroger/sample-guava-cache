package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(BaixaHist.class)
public abstract class BaixaHist_ {

	public static volatile SingularAttribute<BaixaHist, Long> codIdenfificacao;
	public static volatile SingularAttribute<BaixaHist, Date> dataAcao;
	public static volatile SingularAttribute<BaixaHist, Integer> codModulo;
	public static volatile SingularAttribute<BaixaHist, Long> id;
	public static volatile SingularAttribute<BaixaHist, Integer> codAcao;

}

