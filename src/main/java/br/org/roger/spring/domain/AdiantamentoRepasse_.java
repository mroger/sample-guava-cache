package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.util.Date;

@StaticMetamodel(AdiantamentoRepasse.class)
public abstract class AdiantamentoRepasse_ {

	public static volatile SingularAttribute<AdiantamentoRepasse, String> observacao;
	public static volatile SingularAttribute<AdiantamentoRepasse, Integer> tipoTransferenciaId;
	public static volatile SingularAttribute<AdiantamentoRepasse, Boolean> aprovado;
	public static volatile SingularAttribute<AdiantamentoRepasse, Long> contaRepasseId;
	public static volatile SingularAttribute<AdiantamentoRepasse, Date> dataIntegracao;
	public static volatile SingularAttribute<AdiantamentoRepasse, RepasseTipoTransf> tipoTransferencia;
	public static volatile SingularAttribute<AdiantamentoRepasse, Boolean> integracao;
	public static volatile SingularAttribute<AdiantamentoRepasse, Auction> auction;
	public static volatile SingularAttribute<AdiantamentoRepasse, Date> dataCancelamento;
	public static volatile SingularAttribute<AdiantamentoRepasse, Long> entidadeRepasseId;
	public static volatile SingularAttribute<AdiantamentoRepasse, Date> dataProgramacao;
	public static volatile SingularAttribute<AdiantamentoRepasse, IntegracaoStatus> statusIntegracao;
	public static volatile SingularAttribute<AdiantamentoRepasse, BigDecimal> valorAdiantamento;
	public static volatile SingularAttribute<AdiantamentoRepasse, UserEntity> comitente;
	public static volatile SingularAttribute<AdiantamentoRepasse, Long> id;
	public static volatile SingularAttribute<AdiantamentoRepasse, Conta> contaRepasse;
	public static volatile SingularAttribute<AdiantamentoRepasse, Date> dataCriacao;
	public static volatile SingularAttribute<AdiantamentoRepasse, UserEntity> entidadeRepasse;
	public static volatile SingularAttribute<AdiantamentoRepasse, Long> contaPagamentoOrigemId;
	public static volatile SingularAttribute<AdiantamentoRepasse, UserEntity> entidadeOrigem;
	public static volatile SingularAttribute<AdiantamentoRepasse, Integer> formaPagamentoId;
	public static volatile SingularAttribute<AdiantamentoRepasse, Date> dataAlteracao;
	public static volatile SingularAttribute<AdiantamentoRepasse, Long> auctionId;
	public static volatile SingularAttribute<AdiantamentoRepasse, Integer> statusId;
	public static volatile SingularAttribute<AdiantamentoRepasse, RepasseFormaPag> repasseFormaPagamento;
	public static volatile SingularAttribute<AdiantamentoRepasse, Long> entidadeOrigemId;
	public static volatile SingularAttribute<AdiantamentoRepasse, Long> comitenteId;
	public static volatile SingularAttribute<AdiantamentoRepasse, Date> dataRepasse;
	public static volatile SingularAttribute<AdiantamentoRepasse, Integer> statusIntegracaoId;
	public static volatile SingularAttribute<AdiantamentoRepasse, RepasseStatus> status;

}

