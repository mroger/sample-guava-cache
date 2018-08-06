package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(GrupoRepasse.class)
public abstract class GrupoRepasse_ {

	public static volatile SingularAttribute<GrupoRepasse, Conta> conta;
	public static volatile SingularAttribute<GrupoRepasse, Integer> formaPagamentoId;
	public static volatile SingularAttribute<GrupoRepasse, Date> dataAlteracao;
	public static volatile SingularAttribute<GrupoRepasse, Auction> auction;
	public static volatile SingularAttribute<GrupoRepasse, String> nomeGrupoRepasse;
	public static volatile SingularAttribute<GrupoRepasse, Long> auctionId;
	public static volatile SingularAttribute<GrupoRepasse, RepasseFormaPag> repasseFormaPagamento;
	public static volatile SingularAttribute<GrupoRepasse, Long> aberturaComitenteId;
	public static volatile SingularAttribute<GrupoRepasse, Long> comitenteId;
	public static volatile SingularAttribute<GrupoRepasse, UserEntity> comitente;
	public static volatile SingularAttribute<GrupoRepasse, Long> id;
	public static volatile SingularAttribute<GrupoRepasse, Long> contaId;
	public static volatile SingularAttribute<GrupoRepasse, AberturaComitente> aberturaComitente;
	public static volatile SingularAttribute<GrupoRepasse, Date> dataCriacao;

}

