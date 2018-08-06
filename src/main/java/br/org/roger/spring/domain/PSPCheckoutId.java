package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@SuppressWarnings("serial")
@Embeddable
public class PSPCheckoutId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "PSP_CHECKOUT_ID")
    private String checkoutId;

    @Column(name = "COD_PAGAMENTO")
    private Long pagamentoId;

    public PSPCheckoutId() {
    }

    public PSPCheckoutId(String checkoutId, Long pagamentoId) {
        this.checkoutId = checkoutId;
        this.pagamentoId = pagamentoId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    public Long getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Long pagamentoId) {
        this.pagamentoId = pagamentoId;
    }
}
