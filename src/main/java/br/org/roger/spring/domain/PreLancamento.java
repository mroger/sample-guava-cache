package br.org.roger.spring.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Fl_PRE_LANCAMENTO")
@NamedQueries({
    @NamedQuery(name = PreLancamento.Queries.FIND_RESULTADO_POR_LEILAO,
                query =
                    " SELECT DISTINCT" +
                        "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.OfferResultDTO( " +
                        "     e.id, " +
                        "     e.name, " +
                        "     dt.name, " +
                        "     d.numero, " +
                        "     s.nroSegmentoNegocio, " +
                        "     u.nroUnidadeNegocio,  " +
                        "     p.id, " +
                        "     o.lotNumberDesc, " +
                        "     prd.productShortDesc, " +
                        "     o.quantity, " +
                        "     od.currentMaxBid, " +
                        "     pres.id, " +
                        "     pret.id, " +
                        "     gl.dataEmissao, " +
                        "     ec.name ) " +
                        " FROM PreLancamento pre " +
                        "    inner join pre.preLancamentoStatus pres " +
                        "    inner join pre.preLancamentoTipo pret " +
                        "    inner join pre.offer o " +
                        "    inner join o.offerDetail od " +
                        "    inner join o.product prd " +
                        "    inner join o.groupOffer go " +
                        "    inner join go.projetoLeilao p " +
                        "    inner join p.unidadeNegocio u " +
                        "    inner join u.segmentoNegocio s " +
                        "    inner join go.userEntitySeller e " +
                        "    inner join e.documents d " +
                        "    inner join d.documentType dt " +
                        "    left join pre.grupoLancamento gl with gl.statusId in (1,2) " +
                        "    left join gl.lancamento la with la.tipoItemPagamentoId = 1 " +
                        "    left join gl.comprador ec " +
                        " WHERE " +
                        "        go.auctionId = :auctionId " +
                        "    AND ( " +
                        "           ( e.entityType = 'J' AND dt.id = " + DocumentType.CNPJ + " ) " +
                        "            OR  " +
                        "           ( e.entityType = 'F' AND dt.id = " + DocumentType.CPF + " ) " +
                        "         ) " +
                        "  ORDER BY o.lotNumberDesc ASC "
    ),
    @NamedQuery(name = PreLancamento.Queries.FIND_PRE_LANCAMENTO_BY_OFFER_ID,
                query =
                    " SELECT p " +
                        " FROM PreLancamento p " +
                        " WHERE p.offer.id = :offerId "
    ),
    @NamedQuery(name = PreLancamento.Queries.FIND_PRE_LANCAMENTO_BY_ID,
                query =   " SELECT " +
                    "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.PreEntryDTO( " +
                    "     pre.id, " +
                    "     pre.preLancamentoStatusId, " +
                    "     pre.preLancamentoTipoId, "+
                    "     pre.comitenteId, "+
                    "     pre.arrematanteId, " +
                    "     pre.quantidadeLote," +
                    "     pre.quantidadeArrematada, "+
                    "     pre.valorLance, " +
                    "     prod_f.codClassFiscal, " +
                    "     o.groupOfferId, " +
                    "     pre.impostoCalculado, " +
                    "     gs.erpSystem, " +
                    "     gs.erpKey, " +
                    "     gs.gestorId )" +
                    " FROM PreLancamento pre " +
                    " inner join pre.offer o " +
                    " inner join o.product prod "+
                    " inner join prod.productFinancial prod_f "+
                    " inner join o.auction a " +
                    " inner join a.gestor g " +
                    " inner join g.settings gs " +
                    " WHERE  pre.id = :preEntryId "
    ),
        @NamedQuery(name = PreLancamento.Queries.FIND_PRE_LANCAMENTO_DETAIL_BY_ID,
                query = " SELECT " +
                        "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.PreEntryDTO( " +
                        "     pre.id, " +
                        "     pre.impostoCalculado, " +
                        "     gs.erpSystem, " +
                        "     gs.erpKey, " +
                        "     prod_f.codClassFiscal, " +
                        "     gs.gestorId)" +
                        " FROM " +
                        "   PreLancamento pre " +
                        "   inner join pre.offer o " +
                        "   inner join o.auction a " +
                        "   inner join o.product prod "+
                        "   inner join prod.productFinancial prod_f "+
                        "   inner join a.gestor g " +
                        "   inner join g.settings gs " +
                        " WHERE " +
                        "   pre.id = :preEntryId "
        )
})
public class PreLancamento {

    public static final class Queries {
        public static final String FIND_PRE_LANCAMENTO_BY_OFFER_ID = "FIND_PRE_LANCAMENTO_BY_OFFER_ID";
        public static final String FIND_RESULTADO_POR_LEILAO = "FIND_RESULTADO_POR_LEILAO";
        public static final String FIND_PRE_LANCAMENTO_BY_ID = "FIND_PRE_LANCAMENTO_BY_ID";
        public static final String FIND_PRE_LANCAMENTO_DETAIL_BY_ID = "FIND_PRE_LANCAMENTO_DETAIL_BY_ID";
    }

    @Id
    @Column(name = "COD_PRE_LANCAMENTO", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_STATUS_PRE_LANCAMENTO", insertable = false, updatable = false)
    private PreLancamentoStatus preLancamentoStatus;

    @Column(name = "COD_STATUS_PRE_LANCAMENTO", precision = 2, scale = 0)
    private Integer preLancamentoStatusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_TIPO_PRE_LANCAMENTO")
    private PreLancamentoTipo preLancamentoTipo;

    @Column(name = "COD_TIPO_PRE_LANCAMENTO", insertable = false, updatable = false)
    private Integer preLancamentoTipoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_OFERTA", insertable = false, updatable = false)
    private Offer offer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_COMITENTE", insertable = false, updatable = false)
    private UserEntity comitente;

    @Column(name = "COD_COMITENTE", precision = 9, scale = 0)
    private Long comitenteId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "preLancamento")
    private Set<PreLancamentoItem> preLancamentoItem;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "preLancamento")
    private Set<GrupoLancamento> grupoLancamento;

    @Column(name = "COD_ARREMATANTE", precision = 9, scale = 0)
    private Long arrematanteId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CRIACAO", columnDefinition = "date")
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ULTIMA_ALTERACAO", columnDefinition = "date")
    private Date dataUltimaAlteracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_LEILOEIRO", insertable = false, updatable = false)
    private UserEntity leiloeiro;

    @Column(name = "QUANTIDADE_LOTE", precision = 15, scale = 3)
    private BigDecimal quantidadeLote;

    @Column(name = "QUANTIDADE_ARREMATADA", precision = 15, scale = 3)
    private BigDecimal quantidadeArrematada;

    @Column(name = "VALOR_LANCE", precision = 15, scale = 3)
    private BigDecimal valorLance;

    @Column(name = "VALOR_RESERVADO", precision = 15, scale = 3)
    private BigDecimal valorReservado;

    @Column(name = "IMPOSTO_CALC")
    @Type(type = "net.s4bdigital.libs.jpa.usertype.TrueFalseCharType")
    private Boolean impostoCalculado;
}
