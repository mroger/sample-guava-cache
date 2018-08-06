package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(PreLancamentoItem.class)
public abstract class PreLancamentoItem_ {

	public static volatile SingularAttribute<PreLancamentoItem, TipoItemPagamento> tipoItemPagamento;
	public static volatile SingularAttribute<PreLancamentoItem, BigDecimal> valorItem;
	public static volatile SingularAttribute<PreLancamentoItem, Integer> codConta;
	public static volatile SingularAttribute<PreLancamentoItem, PreLancamento> preLancamento;
	public static volatile SingularAttribute<PreLancamentoItem, BigDecimal> valorImposto;
	public static volatile SingularAttribute<PreLancamentoItem, PreLancamentoItemId> id;
	public static volatile SingularAttribute<PreLancamentoItem, ContaPagamento> contaPagamento;

}

