package br.org.roger.spring.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static br.org.roger.spring.domain.Venda.AuctionModality.LEILAO;
import static br.org.roger.spring.domain.Venda.AuctionModality.LEILAO_JUDICIAL;
import static br.org.roger.spring.domain.Venda.AuctionModality.VENDA_DIRETA;

/**
 * Created by ailson.moreira on 07/04/2017.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_VENDA")
@NamedQueries({
        @NamedQuery(
                name = Venda.Queries.FIND_SALE_BY_ID,
                query = "from Venda v where v.id = :id"
        ),
        @NamedQuery(
                name = Venda.Queries.FIND_ACTIVE_SALE_BY_LOT,
                query = "from Venda v where v.ofertaId = :ofertaId and v.statusId = 1"
        ),
        @NamedQuery(
                name = Venda.Queries.FIND_AUCTION_ACTIVE_SALE_BY_LOT,
                query = "from Venda v inner join v.auction inner join v.offer where v.ofertaId = :ofertaId and v.statusId = 1"
        ),
        @NamedQuery(
                name = Venda.Queries.FIND_SALES,
                query = "from Venda"
        ),
        @NamedQuery(
                name = Venda.Queries.FIND_SALES_WITH_PENDING_NOTIFICATIONS,
                query = " select v from Venda v " +
                " where v.statusId = 1 " +
                "  and v.emailVendaAtivo = true " +
                "  and v.emailVendaEnviado = false " +
                "  and v.auction.auctionModalityId != " + VENDA_DIRETA
        ),
        @NamedQuery(
            name = Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS,
            query = " select v from Venda v " +
                " inner join v.auction a " +
                " where v.statusId = 1 " +
                "  and v.emailVendaAtivo = true " +
                "  and v.emailVendaEnviado = false " +
                "  and a.auctionModalityId in (" + LEILAO + "," + LEILAO_JUDICIAL + "," + VENDA_DIRETA +")"
        )
})
public class Venda implements Serializable {

    public static final class Queries {
        public static final String FIND_SALE_BY_ID = "FIND_SALE_BY_ID";
        public static final String FIND_SALES      = "FIND_SALES";
        public static final String FIND_ACTIVE_SALE_BY_LOT = "FIND_ACTIVE_SALE_BY_LOT";
        public static final String FIND_AUCTION_ACTIVE_SALE_BY_LOT = "FIND_AUCTION_ACTIVE_SALE_BY_LOT";
        public static final String FIND_SALES_WITH_PENDING_NOTIFICATIONS = "FIND_SALES_WITH_PENDING_NOTIFICATIONS";
        public static final String FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS = "FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS";
    }

    public interface AuctionModality {
        int LEILAO = 1;
        int LEILAO_JUDICIAL = 4;
        int VENDA_DIRETA = 5;
    }

    @Id
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "COD_VENDA", nullable = false, precision = 9)
    private Long id;

    @Column(name = "COD_PRE_LANCAMENTO", nullable = false, precision = 9)
    private Long preLancamentoId;

    @Column(name = "COD_LEILAO", precision = 9)
    private Long leilaoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_LEILAO", referencedColumnName = "AUCTION_ID" ,insertable = false, updatable = false)
    private Auction auction;

    @Column(name = "COD_OFERTA", precision = 9)
    private Long ofertaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_OFERTA", referencedColumnName = "EREG_OFFER_ID" ,insertable = false, updatable = false)
    private Offer offer;

    @Column(name = "COD_ENTIDADE_PAGAR", precision = 9)
    private Long entidadePagarId;

    @Column(name = "EMAIL_VENDA_ATIVO")
    @Type(type = "net.s4bdigital.libs.jpa.usertype.TrueFalseCharType")
    private Boolean emailVendaAtivo;

    @Column(name = "EMAIL_VENDA_ENVIADO")
    @Type(type = "net.s4bdigital.libs.jpa.usertype.TrueFalseCharType")
    private Boolean emailVendaEnviado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CRIACAO", columnDefinition = "date")
    private Date dataCriacao;

    @Column(name = "COD_STATUS")
    private Integer statusId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_STATUS", insertable = false, updatable = false)
    private VendaStatus status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "venda")
    private Set<GrupoLancamento> grupoLancamentos;

    public Venda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPreLancamentoId() {
        return preLancamentoId;
    }

    public void setPreLancamentoId(Long preLancamentoId) {
        this.preLancamentoId = preLancamentoId;
    }

    public Long getLeilaoId() {
        return leilaoId;
    }

    public void setLeilaoId(Long leilaoId) {
        this.leilaoId = leilaoId;
    }

    public Long getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(Long ofertaId) {
        this.ofertaId = ofertaId;
    }

    public Long getEntidadePagarId() {
        return entidadePagarId;
    }

    public void setEntidadePagarId(Long entidadePagarId) {
        this.entidadePagarId = entidadePagarId;
    }

    public Boolean getEmailVendaAtivo() {
        return emailVendaAtivo;
    }

    public void setEmailVendaAtivo(Boolean emailVendaAtivo) {
        this.emailVendaAtivo = emailVendaAtivo;
    }

    public Boolean getEmailVendaEnviado() {
        return emailVendaEnviado;
    }

    public void setEmailVendaEnviado(Boolean emailVendaEnviado) {
        this.emailVendaEnviado = emailVendaEnviado;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public VendaStatus getStatus() {
        return status;
    }

    public void setStatus(VendaStatus status) {
        this.status = status;
    }

    public Set<GrupoLancamento> getGrupoLancamentos() {
        return grupoLancamentos;
    }

    public void setGrupoLancamentos(Set<GrupoLancamento> grupoLancamentos) {
        this.grupoLancamentos = grupoLancamentos;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Offer getOffer() { return offer; }

    public void setOffer(Offer offer) { this.offer = offer; }

    /**
     * Checks if all <code>GrupoLancamento</code> integrations are complete.
     * Checks if integration is imposto, lancamento or pagamento and if the integration is pending.
     *
     * @return true if integracao is imposto, lancamento or pagamento and if they are complete, false otherwise.
     */
    public boolean isAllIntegrationsCompleted(){

        Set<GrupoLancamento> grupos = getGrupoLancamentos();

        for(GrupoLancamento grupo: grupos){
            Set<GLancIntegracao> integracoes = grupo.getIntegracoes();

            for(GLancIntegracao integracao: integracoes) {

                boolean isIntegracaoImpostoLancamentoOuPagamento =
                    integracao.isIntegracaoImpostoLancamentoOuPagamento();

                boolean isIntegracaoPendente =
                    integracao.isIntegracaoPendente();

                if( isIntegracaoImpostoLancamentoOuPagamento && isIntegracaoPendente ) {
                    return false;
                }
            }

        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venda venda = (Venda) o;

        if (id != null ? !id.equals(venda.id) : venda.id != null) return false;
        if (preLancamentoId != null ? !preLancamentoId.equals(venda.preLancamentoId) : venda.preLancamentoId != null)
            return false;
        if (leilaoId != null ? !leilaoId.equals(venda.leilaoId) : venda.leilaoId != null) return false;
        if (auction != null ? !auction.equals(venda.auction) : venda.auction != null) return false;
        if (ofertaId != null ? !ofertaId.equals(venda.ofertaId) : venda.ofertaId != null) return false;
        if (offer != null ? !offer.equals(venda.offer) : venda.offer != null) return false;
        if (entidadePagarId != null ? !entidadePagarId.equals(venda.entidadePagarId) : venda.entidadePagarId != null)
            return false;
        if (emailVendaAtivo != null ? !emailVendaAtivo.equals(venda.emailVendaAtivo) : venda.emailVendaAtivo != null)
            return false;
        if (emailVendaEnviado != null ? !emailVendaEnviado.equals(venda.emailVendaEnviado) : venda.emailVendaEnviado != null)
            return false;
        if (dataCriacao != null ? !dataCriacao.equals(venda.dataCriacao) : venda.dataCriacao != null) return false;
        if (statusId != null ? !statusId.equals(venda.statusId) : venda.statusId != null) return false;
        if (status != null ? !status.equals(venda.status) : venda.status != null) return false;
        return grupoLancamentos != null ? grupoLancamentos.equals(venda.grupoLancamentos) : venda.grupoLancamentos == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (preLancamentoId != null ? preLancamentoId.hashCode() : 0);
        result = 31 * result + (leilaoId != null ? leilaoId.hashCode() : 0);
        result = 31 * result + (auction != null ? auction.hashCode() : 0);
        result = 31 * result + (ofertaId != null ? ofertaId.hashCode() : 0);
        result = 31 * result + (offer != null ? offer.hashCode() : 0);
        result = 31 * result + (entidadePagarId != null ? entidadePagarId.hashCode() : 0);
        result = 31 * result + (emailVendaAtivo != null ? emailVendaAtivo.hashCode() : 0);
        result = 31 * result + (emailVendaEnviado != null ? emailVendaEnviado.hashCode() : 0);
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (grupoLancamentos != null ? grupoLancamentos.hashCode() : 0);
        return result;
    }
}
