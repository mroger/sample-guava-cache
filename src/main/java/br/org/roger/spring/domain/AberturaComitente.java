package br.org.roger.spring.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by selma on 17/11/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_ABERTURA_COMITENTE")
public class AberturaComitente implements Serializable {

    @Id
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "COD_ABERTURA_COMITENTE", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

    @Column(name = "NOME_ABERTURA_COMITENTE", nullable = false, length = 100)
    private String nomeAberturaComitente;

    @Column(name = "COD_LEILAO", precision = 9, scale = 0)
    private Long auctionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_LEILAO", insertable = false, updatable = false)
    private Auction auction;

    @Column(name = "COD_COMITENTE", precision = 9, scale = 0)
    private Long comitenteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_COMITENTE", insertable = false, updatable = false)
    private UserEntity comitente;

    @Column(name = "COD_STATUS", precision = 1, scale = 0)
    private Integer statusId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CRIACAO", columnDefinition = "date")
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_GERACAO", columnDefinition = "date")
    private Date dataGeracao;

    @Column(name = "RAIZ_DOCUMENTO", nullable = false, length = 20)
    private String raizDocumento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAberturaComitente() {
        return nomeAberturaComitente;
    }

    public void setNomeAberturaComitente(String nomeAberturaComitente) {
        this.nomeAberturaComitente = nomeAberturaComitente;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Long getComitenteId() {
        return comitenteId;
    }

    public void setComitenteId(Long comitenteId) {
        this.comitenteId = comitenteId;
    }

    public UserEntity getComitente() {
        return comitente;
    }

    public void setComitente(UserEntity comitente) {
        this.comitente = comitente;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public String getRaizDocumento() {
        return raizDocumento;
    }

    public void setRaizDocumento(String raizDocumento) {
        this.raizDocumento = raizDocumento;
    }

}
