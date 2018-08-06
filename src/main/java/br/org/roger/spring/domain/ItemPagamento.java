package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Table;

/* Created by walter on 23/03/17. */

@javax.persistence.Entity
@Table(name = "FL_PAGAMENTO_ITEM")
public class ItemPagamento {

    @EmbeddedId
    private ItemPagamentoId id;

    @Column(name = "COD_PAGAMENTO", insertable = false, updatable = false)
    private Long paymentId;

    @Column(name= "COD_GRUPO_LANCAMENTO", insertable = false, updatable = false)
    private Long entryGroup;

    public ItemPagamento() {
    }

    public ItemPagamento(ItemPagamentoId id, Long paymentId, Long entryGroup) {
        this.id = id;
        this.paymentId = paymentId;
        this.entryGroup = entryGroup;
    }

    public ItemPagamentoId getId() {
        return id;
    }

    public void setId(ItemPagamentoId id) {
        this.id = id;
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
