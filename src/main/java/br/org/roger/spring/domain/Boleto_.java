package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.util.Date;

@StaticMetamodel(Boleto.class)
public abstract class Boleto_ {

	public static volatile SingularAttribute<Boleto, BigDecimal> cofinsValue;
	public static volatile SingularAttribute<Boleto, BigDecimal> csllValue;
	public static volatile SingularAttribute<Boleto, BigDecimal> valorBruto;
	public static volatile SingularAttribute<Boleto, BigDecimal> irValue;
	public static volatile SingularAttribute<Boleto, String> nossoNumero;
	public static volatile SingularAttribute<Boleto, Date> dataProcessamento;
	public static volatile SingularAttribute<Boleto, GrupoLancamento> grupoLancamento;
	public static volatile SingularAttribute<Boleto, String> numDoc;
	public static volatile SingularAttribute<Boleto, BoletoId> id;
	public static volatile SingularAttribute<Boleto, Date> dataVencBoleto;
	public static volatile SingularAttribute<Boleto, Date> dataAlteracao;
	public static volatile SingularAttribute<Boleto, BigDecimal> pisValue;

}

