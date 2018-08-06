package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(TipoItemPagamento.class)
public abstract class TipoItemPagamento_ {

	public static volatile SingularAttribute<TipoItemPagamento, Long> tipoEntidadePagtoId;
	public static volatile SingularAttribute<TipoItemPagamento, Long> tipoCobrancaId;
	public static volatile SingularAttribute<TipoItemPagamento, Long> id;
	public static volatile SingularAttribute<TipoItemPagamento, String> desc;

}

