package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(GrupoLancamento.class)
public abstract class GrupoLancamento_ {

	public static volatile SingularAttribute<GrupoLancamento, CancelamentoHistorico> cancelamentoHistorico;
	public static volatile SingularAttribute<GrupoLancamento, Long> entidadeReceberId;
	public static volatile SetAttribute<GrupoLancamento, Boleto> boleto;
	public static volatile SetAttribute<GrupoLancamento, PagamentoItem> pagamentoItem;
	public static volatile SingularAttribute<GrupoLancamento, Date> dataEmissao;
	public static volatile SingularAttribute<GrupoLancamento, Date> dataCancelamento;
	public static volatile SingularAttribute<GrupoLancamento, Integer> origemLancamentoId;
	public static volatile SetAttribute<GrupoLancamento, Lancamento> lancamento;
	public static volatile SingularAttribute<GrupoLancamento, Long> origemId;
	public static volatile SingularAttribute<GrupoLancamento, Date> dataProgramada;
	public static volatile SingularAttribute<GrupoLancamento, PreLancamento> preLancamento;
	public static volatile SingularAttribute<GrupoLancamento, Long> id;
	public static volatile SingularAttribute<GrupoLancamento, ContaPagamento> contaPagamento;
	public static volatile SingularAttribute<GrupoLancamento, Integer> sequenceOrigem;
	public static volatile SingularAttribute<GrupoLancamento, Long> entidadePagarId;
	public static volatile SingularAttribute<GrupoLancamento, Long> vendaId;
	public static volatile SingularAttribute<GrupoLancamento, Date> dataPagamento;
	public static volatile SingularAttribute<GrupoLancamento, Date> dataAprovacao;
	public static volatile SetAttribute<GrupoLancamento, Pagamento> pagamentos;
	public static volatile SingularAttribute<GrupoLancamento, NotaArrematacao> notaArrematacao;
	public static volatile SingularAttribute<GrupoLancamento, Deposito> deposito;
	public static volatile SingularAttribute<GrupoLancamento, GrupoLancamentoStatus> grupoLancamentoStatus;
	public static volatile SingularAttribute<GrupoLancamento, Long> notaArrematacaoId;
	public static volatile SingularAttribute<GrupoLancamento, Long> sequenceUltimaGeracao;
	public static volatile SingularAttribute<GrupoLancamento, Venda> venda;
	public static volatile SingularAttribute<GrupoLancamento, Integer> statusId;
	public static volatile SingularAttribute<GrupoLancamento, String> instrucaoPagamento;
	public static volatile SingularAttribute<GrupoLancamento, Date> dataVencimento;
	public static volatile SingularAttribute<GrupoLancamento, Date> dataRepasse;
	public static volatile SingularAttribute<GrupoLancamento, Long> statusIntegracaoId;
	public static volatile SetAttribute<GrupoLancamento, GLancIntegracao> integracoes;
	public static volatile SetAttribute<GrupoLancamento, UserEntity> comprador;
}

