package br.org.roger.spring.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@SuppressWarnings("serial")
@Table(name = "PSP_CHECKOUT")
@NamedQuery(name = PSPCheckout.Queries.FIND_PSP_CHECKOUT_BY_PAYMENT_ID,
        query = " select psp from PSPCheckout psp where psp.id.pagamentoId = :pagamentoId and psp.ativo = true "
)
public class PSPCheckout implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final class Queries {
        public static final String FIND_PSP_CHECKOUT_BY_PAYMENT_ID = "FIND_PSP_CHECKOUT_BY_PAYMENT_ID";
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "checkoutId", column = @Column(name = "PSP_CHECKOUT_ID", nullable = false)),
            @AttributeOverride(name = "pagamentoId", column = @Column(name = "COD_PAGAMENTO", nullable = false))})
    private PSPCheckoutId id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PSP_DATA_CADASTRO", columnDefinition = "date")
    private Date pspDataCriacao;

    @Column(name = "ATIVO")
    @Type(type = "net.s4bdigital.libs.jpa.usertype.TrueFalseCharType")
    private Boolean ativo;

    public PSPCheckout() {
    }

    public PSPCheckout(PSPCheckoutId id, Date pspDataCriacao) {
        this.id = id;
        this.pspDataCriacao = pspDataCriacao;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public PSPCheckoutId getId() {
        return id;
    }

    public void setId(PSPCheckoutId id) {
        this.id = id;
    }

    public Date getPspDataCriacao() {
        return pspDataCriacao;
    }

    public void setPspDataCriacao(Date pspDataCriacao) {
        this.pspDataCriacao = pspDataCriacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
