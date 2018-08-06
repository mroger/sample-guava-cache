package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(GrupoOfertaFaixaValor.class)
public abstract class GrupoOfertaFaixaValor_ {

	public static volatile SingularAttribute<GrupoOfertaFaixaValor, TipoItemPagamento> tipoItemPagamento;
	public static volatile SingularAttribute<GrupoOfertaFaixaValor, BigDecimal> valorInicial;
	public static volatile SingularAttribute<GrupoOfertaFaixaValor, GrupoOfertaItemPagamentoId> id;
	public static volatile SingularAttribute<GrupoOfertaFaixaValor, BigDecimal> valorTaxa;
	public static volatile SingularAttribute<GrupoOfertaFaixaValor, BigDecimal> valorFinal;

}

