package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.util.Date;

@StaticMetamodel(Pagamento.class)
public abstract class Pagamento_ {

	public static volatile SingularAttribute<Pagamento, Long> entidadePagarId;
	public static volatile SetAttribute<Pagamento, GrupoLancamento> entryGroups;
	public static volatile SingularAttribute<Pagamento, String> instrucaoPagto;
	public static volatile SingularAttribute<Pagamento, Long> statusId;
	public static volatile SingularAttribute<Pagamento, String> identificacao;
	public static volatile SingularAttribute<Pagamento, BigDecimal> valorBruto;
	public static volatile SingularAttribute<Pagamento, Date> dataVencimento;
	public static volatile SingularAttribute<Pagamento, Long> id;
	public static volatile SingularAttribute<Pagamento, Date> dataPagto;
	public static volatile SingularAttribute<Pagamento, Date> dataCriacao;
	public static volatile SingularAttribute<Pagamento, PagamentoStatus> status;

}

