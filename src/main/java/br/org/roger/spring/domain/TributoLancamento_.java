package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(TributoLancamento.class)
public abstract class TributoLancamento_ {

	public static volatile SingularAttribute<TributoLancamento, Long> grupoLancamentoId;
	public static volatile SingularAttribute<TributoLancamento, Long> tipoItemPagtoId;
	public static volatile SingularAttribute<TributoLancamento, TipoItemPagamento> tipoItemPagto;
	public static volatile SingularAttribute<TributoLancamento, BigDecimal> valor;
	public static volatile SingularAttribute<TributoLancamento, GrupoLancamento> grupoLancamento;
	public static volatile SingularAttribute<TributoLancamento, Long> id;
	public static volatile SingularAttribute<TributoLancamento, String> tributoDesc;
	public static volatile SingularAttribute<TributoLancamento, String> tributoDescCaseInsensitive;

}

