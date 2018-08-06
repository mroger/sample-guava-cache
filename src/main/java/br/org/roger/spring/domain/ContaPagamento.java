package br.org.roger.spring.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by chen on 14/09/2015.
 */
@Entity
@Table(name = "FL_CONTA_PAGAMENTO")
public class ContaPagamento {

    @Id
    @Column(name = "COD_CONTA_PAGAMENTO", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

    @Column(name = "COD_FORMA_PAGAMENTO", precision = 2, scale = 0)
    private Integer formaPagamentoId;

    @Column(name = "COD_CONTA", precision = 2, scale = 0)
    private Long contaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_CONTA", insertable = false, updatable = false)
    private Conta conta;

    @Column(name = "COD_CONTA_PAGAMENTO_ST", precision = 2, scale = 0)
    private Integer statusId;

    @Column(name = "CARTEIRA", precision = 3, scale = 0)
    private Integer carteira;

    @Column(name = "COBRANCA_REGISTRADA")
    @Type(type = "net.s4bdigital.libs.jpa.usertype.TrueFalseVarcharType")
    private Boolean cobrancaRegistrada;

    @Column(name = "CONVENIO", precision = 10, scale = 0)
    private Long convenio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_CONTA_PAGAMENTO_ST", insertable = false, updatable = false)
    private ContaPagamantoStatus contaPagamantoStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_FORMA_PAGAMENTO", insertable = false, updatable = false)
    private FormaPagamento formaPagamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFormaPagamentoId() {
        return formaPagamentoId;
    }

    public void setFormaPagamentoId(Integer formaPagamentoId) {
        this.formaPagamentoId = formaPagamentoId;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getCarteira() {
        return carteira;
    }

    public void setCarteira(Integer carteira) {
        this.carteira = carteira;
    }

    public Boolean getCobrancaRegistrada() {
        return cobrancaRegistrada;
    }

    public void setCobrancaRegistrada(Boolean cobrancaRegistrada) {
        this.cobrancaRegistrada = cobrancaRegistrada;
    }

    public Long getConvenio() {
        return convenio;
    }

    public void setConvenio(Long convenio) {
        this.convenio = convenio;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public ContaPagamantoStatus getContaPagamantoStatus() {
        return contaPagamantoStatus;
    }

    public void setContaPagamantoStatus(ContaPagamantoStatus contaPagamantoStatus) {
        this.contaPagamantoStatus = contaPagamantoStatus;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
