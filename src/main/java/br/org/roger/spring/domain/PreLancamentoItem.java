package br.org.roger.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ailson.moreira on 15/09/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_PRE_LANCAMENTO_ITEM")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = PreLancamentoItem.Queries.FIND_PRE_LANCAMENTO_ITEM_BY_ID,
                query =   " SELECT " +
                        "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.PreEntryItemDTO( " +
                        "     preItem.preLancamento.id, " +
                        "     preItem.tipoItemPagamento.id, "+
                        "     preItem.contaPagamento.id, " +
                        "     preItem.porcentagemItem," +
                        "     preItem.valorItem, "+
                        "     preItem.valorImposto," +
                        "     conta.userEntityId)"+
                        " FROM PreLancamentoItem preItem " +
                        " inner join preItem.contaPagamento ct " +
                        " inner join ct.conta conta"+
                        " WHERE preItem.preLancamento.id = :preEntryId "
        )
})
public class PreLancamentoItem implements Serializable {

    public static final class Queries {
        public static final String FIND_PRE_LANCAMENTO_ITEM_BY_ID = "FIND_PRE_LANCAMENTO_ITEM_BY_ID";
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "codPreLancamentoId", column = @Column(name = "COD_PRE_LANCAMENTO", nullable = false,
            precision = 9, scale = 0)),
        @AttributeOverride(name = "codTipoItemPagamento", column = @Column(name = "COD_TIPO_ITEM_PAGAMENTO",
            nullable = false, precision = 2, scale = 0))})
    private PreLancamentoItemId id;

    @Column(name = "COD_CONTA_PAGAMENTO", precision = 9)
    private Integer codConta;

    @Column(name = "INSTRUCAO_PAGAMENTO")
    private String instrucaoPagamento;

    @Column(name = "PORCENTAGEM_ITEM", precision = 9, scale = 3)
    private BigDecimal porcentagemItem;

    @Column(name = "VALOR_ITEM", precision = 15, scale = 3)
    private BigDecimal valorItem;

    @Column(name = "ALIQUOTA_IMPOSTO", precision = 15, scale = 3)
    private BigDecimal aliquotaImposto;

    @Column(name = "VALOR_IMPOSTO", precision = 15, scale = 3)
    private BigDecimal valorImposto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_PRE_LANCAMENTO", nullable = false, insertable = false, updatable = false)
    private PreLancamento preLancamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_CONTA_PAGAMENTO", insertable = false, updatable = false)
    private ContaPagamento contaPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_TIPO_ITEM_PAGAMENTO", nullable = false, insertable = false, updatable = false)
    private TipoItemPagamento tipoItemPagamento;
}
