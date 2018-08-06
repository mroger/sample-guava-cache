package br.org.roger.spring.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("serial")
@Entity
@Table(name = "AUCTION")
@NamedQueries({
    @NamedQuery(name = Auction.Queries.FIND_PAYMENT_DISTRIBUTION_ADVANCE_AUCTION,
        query =
            " SELECT DISTINCT " +
            "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.AuctionDTO( " +
            "     a.id, " +
            "     a.auctionDesc, " +
            "     a.auctionEndDate) " +
            " FROM " +
            "	Auction a " +
            "	left join a.gestor g " +
            "   left join a.offers o " +
            "   left join o.preLancamentos pl " +
            "   left join pl.preLancamentoItem pli " +
            "   left join pli.contaPagamento cp " +
            "   left join cp.conta c " +
            " WHERE " +
            "	g.id = :executerId " +
            "	and a.statusId in (" + Auction.LIQ_PARCIAL + ", " + Auction.LIQ_FINANCEIRA + ") " +
            "   and pl.preLancamentoStatus = " + PreLancamentoStatus.GERADO +
            "   and pli.id.codTipoItemPagamento = " + TipoItemPagamento.PAGAMENTO_LOTE +
            "   and pl.comitenteId <> c.userEntityId " +
            "   ORDER BY " +
            "	a.auctionEndDate DESC ")
})
public class Auction implements java.io.Serializable {

	public static final class Queries {
		public static final String FIND_PAYMENT_DISTRIBUTION_ADVANCE_AUCTION = "FIND_PAYMENT_DISTRIBUTION_ADVANCE_AUCTION";
	}

    public static final int ABERTO = 1;
    public static final int FECHADO = 2;
    public static final int LIQ_FINANCEIRA = 13;
    public static final int LIQ_PARCIAL = 12;

    @Id
	@Column(name = "AUCTION_ID", unique = true, nullable = false, precision = 9, scale = 0)
	private Long id;
	
	@Column(name = "AUCTION_DESC", nullable = false, length = 70)
	private String auctionDesc;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	@Column(name = "AUCTION_END_DATE", columnDefinition = "date", length = 7)
	private Date auctionEndDate;

    @Column(name = "AUCTION_STATUS_ID", nullable = false)
    private Integer statusId;

    @Column(name = "AUCTION_MODALITY_ID", nullable = false)
    private Integer auctionModalityId;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinTable(name="REL_GESTOR_AUCTION",
		joinColumns= @JoinColumn(name="AUCTION_ID"),
		inverseJoinColumns = @JoinColumn(name="GESTOR_ID")
	)
	private Gestor gestor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "auction")
    private Set<Offer> offers = new HashSet<Offer>(0);

    @Column(name = "EREG_PORTAL_ID")
    private Integer portalId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "EREG_PORTAL_ID", insertable = false, updatable = false)
    private Portal portal;

    @Column(name = "LOCALE_ID")
    private String localeId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "LOCALE_ID", insertable = false, updatable = false)
    private Locale locale;

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().isAssignableFrom(obj.getClass()))
			return false;
		Auction other = (Auction) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuctionDesc() {
        return auctionDesc;
    }

    public void setAuctionDesc(String auctionDesc) {
        this.auctionDesc = auctionDesc;
    }

    public Date getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setAuctionEndDate(Date auctionEndDate) {
        this.auctionEndDate = auctionEndDate;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getPortalId() {
        return portalId;
    }

    public void setPortalId(Integer portalId) {
        this.portalId = portalId;
    }

    public Integer getAuctionModalityId() {
        return auctionModalityId;
    }

    public void setAuctionModalityId(Integer auctionModalityId) {
        this.auctionModalityId = auctionModalityId;
    }

    public Portal getPortal() {
        return portal;
    }

    public void setPortal(Portal portal) {
        this.portal = portal;
    }

    public String getLocaleId() {
        return localeId;
    }

    public void setLocaleId(String localeId) {
        this.localeId = localeId;
    }
}
