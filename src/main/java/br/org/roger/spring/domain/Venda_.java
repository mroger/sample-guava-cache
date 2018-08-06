package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Venda.class)
public abstract class Venda_ {

	public static volatile SingularAttribute<Venda, Long> entidadePagarId;
	public static volatile SetAttribute<Venda, GrupoLancamento> grupoLancamentos;
	public static volatile SingularAttribute<Venda, Long> leilaoId;
	public static volatile SingularAttribute<Venda, Boolean> emailVendaAtivo;
	public static volatile SingularAttribute<Venda, Boolean> emailVendaEnviado;
	public static volatile SingularAttribute<Venda, Long> preLancamentoId;
	public static volatile SingularAttribute<Venda, Auction> auction;
	public static volatile SingularAttribute<Venda, Offer> offer;
	public static volatile SingularAttribute<Venda, Integer> statusId;
	public static volatile SingularAttribute<Venda, Long> ofertaId;
	public static volatile SingularAttribute<Venda, Long> id;
	public static volatile SingularAttribute<Venda, Date> dataCriacao;
	public static volatile SingularAttribute<Venda, VendaStatus> status;

}

