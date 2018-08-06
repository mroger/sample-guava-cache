package br.org.roger.spring.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by selma on 17/11/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_ABERTURA_REPASSE")
@NamedQueries({
        @NamedQuery(name = AberturaRepasse.Queries.FIND_ABERTURA_REPASSE_FORMA_PAG,
                query =
                        " SELECT " +
                                "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.PaymentMethodDTO( " +
                                "     rf.id, " +
                                "     rf.desc, " +
                                "     rf.sigla) " +
                                " FROM  " +
                                "      AberturaRepasse ar " +
                                "      inner join ar.aberturaComitente ac " +
                                "      inner join ar.repasseFormaPagamento rf " +
                                " WHERE " +
                                "      ac.statusId <> " + AberturaComStatus.CANCELADO +
                                "  and ac.auctionId = :qAuctionId " +
                                "  and ac.comitenteId = :qSellerId "
        ),

        @NamedQuery(name = AberturaRepasse.Queries.FIND_ABERTURA_REPASSE_CONTA,
                query =
                        " SELECT " +
                                " new net.s4bdigital.api.auctionfinancial.server.domain.dto.BankAccountDTO( " +
                                "   e.name, " +
                                "   co.id, " +
                                "   b.numero, " +
                                "   b.nome, " +
                                "   co.agencia, " +
                                "   co.agenciaDigito, " +
                                "   co.conta, " +
                                "   co.contaDigito) " +
                                " FROM " +
                                "   AberturaRepasse ar " +
                                "   inner join ar.aberturaComitente ac " +
                                "   inner join ar.conta co " +
                                "   inner join co.banco b " +
                                "   inner join co.userEntity e" +
                                " WHERE " +
                                "       ac.statusId <> " + AberturaComStatus.CANCELADO +
                                "   and ac.auctionId = :qAuctionId " +
                                "   and ac.comitenteId = :qSellerId "
        ),

        @NamedQuery(name = AberturaRepasse.Queries.FIND_ABERTURA_REPASSE_FAVORECIDO,
                query =
                        " SELECT " +
                                "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.SellerDTO( " +
                                "     ue.id, " +
                                "     ue.name, " +
                                "     ue.entityType, " +
                                "     l.loginName, " +
                                "     d.numero, " +
                                "     dt.id, " +
                                "     dt.name) " +
                                " FROM " +
                                "   AberturaRepasse ar " +
                                "   inner join ar.aberturaComitente ac " +
                                "   inner join ar.conta co " +
                                "	inner join co.userEntity ue " +
                                "	inner join ue.login l " +
                                "	inner join ue.documents d " +
                                "	inner join d.documentType dt " +
                                " WHERE " +
                                "       ac.statusId <> " + AberturaComStatus.CANCELADO +
                                "   and ac.auctionId = :qAuctionId " +
                                "   and ac.comitenteId = :qSellerId " +
                                "   and ( ( ue.entityType = 'J' AND dt.id = " + DocumentType.CNPJ + " ) " +
                                "           OR  " +
                                "         ( ue.entityType = 'F' AND dt.id = " + DocumentType.CPF + " ) ) "

        )
})

public class AberturaRepasse implements Serializable {

    public static final class Queries {
        public static final String FIND_ABERTURA_REPASSE_FORMA_PAG = "FIND_ABERTURA_REPASSE_FORMA_PAG";
        public static final String FIND_ABERTURA_REPASSE_CONTA = "FIND_ABERTURA_REPASSE_CONTA";
        public static final String FIND_ABERTURA_REPASSE_FAVORECIDO = "FIND_ABERTURA_REPASSE_FAVORECIDO";
    }

    @Id
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "COD_ABERTURA_COMITENTE", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_ABERTURA_COMITENTE", insertable = false, updatable = false)
    private AberturaComitente aberturaComitente;

    @Column(name = "COD_FORMA_PAGAMENTO", precision = 1, scale = 0)
    private Integer formaPagamentoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_FORMA_PAGAMENTO", insertable = false, updatable = false)
    private RepasseFormaPag repasseFormaPagamento;

    @Column(name = "COD_CONTA", precision = 9, scale = 0)
    private Long contaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_CONTA", insertable = false, updatable = false)
    private Conta conta;

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

    public RepasseFormaPag getRepasseFormaPagamento() {
        return repasseFormaPagamento;
    }

    public void setRepasseFormaPagamento(RepasseFormaPag repasseFormaPagamento) {
        this.repasseFormaPagamento = repasseFormaPagamento;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public AberturaComitente getAberturaComitente() {
        return aberturaComitente;
    }

    public void setAberturaComitente(AberturaComitente aberturaComitente) {
        this.aberturaComitente = aberturaComitente;
    }
}
