package br.org.roger.spring.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class ItemPagamentoId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "COD_PAGAMENTO")
    private Long paymentId;

    @Column(name= "COD_GRUPO_LANCAMENTO")
    private Long entryGroup;

    public ItemPagamentoId() {
    }

    public ItemPagamentoId(Long paymentId, Long entryGroup) {
        this.paymentId = paymentId;
        this.entryGroup = entryGroup;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getEntryGroup() {
        return entryGroup;
    }

    public void setEntryGroup(Long entryGroup) {
        this.entryGroup = entryGroup;
    }
}