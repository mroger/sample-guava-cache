package br.org.roger.spring.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by chen on 17/09/2015.
 */
@Entity
@Table(name = "FL_REPASSE")
public class Repasse {

    @Id
    @Column(name = "COD_REPASSE", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

    @Column(name = "COD_LEILAO", precision = 9, scale = 0)
    private Long auctionId;

    @Column(name = "COD_COMITENTE", precision = 9, scale = 0)
    private Long sellerId;

    @Column(name = "COD_ENTIDADE_ORIGEM", precision = 9, scale = 0)
    private Long entidadeOrigem;

    @Column(name = "COD_STATUS", precision = 2, scale = 0)
    private Integer statusId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repasse")
    private Set<RepasseLote> repasseLote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Set<RepasseLote> getRepasseLote() {
        return repasseLote;
    }

    public void setRepasseLote(Set<RepasseLote> repasseLote) {
        this.repasseLote = repasseLote;
    }

    public Long getEntidadeOrigem() {
        return entidadeOrigem;
    }

    public void setEntidadeOrigem(Long entidadeOrigem) {
        this.entidadeOrigem = entidadeOrigem;
    }
}
