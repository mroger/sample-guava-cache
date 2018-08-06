package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Lancamento.class)
public abstract class Lancamento_ {

	public static volatile SingularAttribute<Lancamento, Long> tipoItemPagamentoId;
	public static volatile SingularAttribute<Lancamento, TipoItemPagamento> tipoItemPagamento;
	public static volatile SingularAttribute<Lancamento, Integer> statusId;
	public static volatile SingularAttribute<Lancamento, BigDecimal> valorItem;
	public static volatile SingularAttribute<Lancamento, LancamentoStatus> lancamentoStatus;
	public static volatile SingularAttribute<Lancamento, BigDecimal> valorItemTotal;
	public static volatile SingularAttribute<Lancamento, GrupoLancamento> grupoLancamento;
	public static volatile SingularAttribute<Lancamento, BigDecimal> valorImposto;
	public static volatile SingularAttribute<Lancamento, LancamentoId> id;

}

