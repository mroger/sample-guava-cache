package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.util.Date;

@StaticMetamodel(GrupoLancamentoBaixas.class)
public abstract class GrupoLancamentoBaixas_ {

	public static volatile SingularAttribute<GrupoLancamentoBaixas, Boolean> ativo;
	public static volatile SingularAttribute<GrupoLancamentoBaixas, Integer> codBaixa;
	public static volatile SingularAttribute<GrupoLancamentoBaixas, Date> dataCancelBaixa;
	public static volatile SingularAttribute<GrupoLancamentoBaixas, Long> id;
	public static volatile SingularAttribute<GrupoLancamentoBaixas, BigDecimal> valorOriginal;
	public static volatile SingularAttribute<GrupoLancamentoBaixas, BigDecimal> valorBaixa;
	public static volatile SingularAttribute<GrupoLancamentoBaixas, Date> dataBaixa;

}

