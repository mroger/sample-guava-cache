package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.util.Date;

@StaticMetamodel(PreLancamento.class)
public abstract class PreLancamento_ {

	public static volatile SingularAttribute<PreLancamento, PreLancamentoStatus> preLancamentoStatus;
	public static volatile SingularAttribute<PreLancamento, BigDecimal> quantidadeLote;
	public static volatile SetAttribute<PreLancamento, GrupoLancamento> grupoLancamento;
	public static volatile SingularAttribute<PreLancamento, BigDecimal> valorReservado;
	public static volatile SingularAttribute<PreLancamento, UserEntity> leiloeiro;
	public static volatile SingularAttribute<PreLancamento, Offer> offer;
	public static volatile SingularAttribute<PreLancamento, Long> arrematanteId;
	public static volatile SingularAttribute<PreLancamento, Integer> preLancamentoStatusId;
	public static volatile SetAttribute<PreLancamento, PreLancamentoItem> preLancamentoItem;
	public static volatile SingularAttribute<PreLancamento, BigDecimal> valorLance;
	public static volatile SingularAttribute<PreLancamento, UserEntity> comitente;
	public static volatile SingularAttribute<PreLancamento, Long> comitenteId;
	public static volatile SingularAttribute<PreLancamento, PreLancamentoTipo> preLancamentoTipo;
	public static volatile SingularAttribute<PreLancamento, Long> id;
	public static volatile SingularAttribute<PreLancamento, Date> dataCriacao;
	public static volatile SingularAttribute<PreLancamento, BigDecimal> quantidadeArrematada;

}

