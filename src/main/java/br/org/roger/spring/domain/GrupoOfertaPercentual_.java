package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(GrupoOfertaPercentual.class)
public abstract class GrupoOfertaPercentual_ {

	public static volatile SingularAttribute<GrupoOfertaPercentual, TipoItemPagamento> tipoItemPagamento;
	public static volatile SingularAttribute<GrupoOfertaPercentual, BigDecimal> comissao;
	public static volatile SingularAttribute<GrupoOfertaPercentual, GrupoOfertaItemPagamentoId> id;

}

