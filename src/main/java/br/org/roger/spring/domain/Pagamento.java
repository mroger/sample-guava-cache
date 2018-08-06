package br.org.roger.spring.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ailson.moreira on 13/04/2017.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_PAGAMENTO")
@NamedQueries({
        @NamedQuery(name = Pagamento.Queries.PENDING_INTEGRATION_SALES,
                query = " select " +
                        "  pag" +
                        " from Pagamento pag" +
                        "  inner join pag.entryGroups eg," +
                        "   GLancIntegracao gl_lan, " +
                        "   GLancIntegracao gl_imp, " +
                        "   GLancIntegracao gl_pag " +
                        " where " +
                        "      eg.id = gl_lan.grupoLancamentoId " +
                        "  and eg.id = gl_imp.grupoLancamentoId " +
                        "  and eg.id = gl_pag.grupoLancamentoId " +
                        "  and gl_lan.integracaoTipoId = 1 " +
                        "  and gl_imp.integracaoTipoId = 2 " +
                        "  and gl_pag.integracaoTipoId = 3 " +
                        "  and gl_lan.statusId = 1 " +
                        "  and gl_imp.statusId = 1 " +
                        "  and gl_pag.statusId = 2 " +
                        "  and eg.contaPagamento.formaPagamentoId = 8 "
        )
})
public class Pagamento implements Serializable {

    public static final class Queries {
        public static final String PENDING_INTEGRATION_SALES = "PENDING_INTEGRATION_SALES";
    }

    @Id
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "COD_PAGAMENTO", nullable = false, precision = 9)
    private Long id;

    @Column(name = "IDENTIFICACAO", precision = 50)
    private String identificacao;

    @Column(name = "COD_ENTIDADE_PAGAR", precision = 9)
    private Long entidadePagarId;

    @Column(name = "INSTRUCAO_PAGAMENTO", precision = 256)
    private String instrucaoPagto;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CRIACAO", columnDefinition = "date")
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_VENCIMENTO", columnDefinition = "date")
    private Date dataVencimento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_PAGAMENTO", columnDefinition = "date")
    private Date dataPagto;

    @Column(name = "VALOR_BRUTO", precision = 15, scale = 3)
    private BigDecimal valorBruto;

    @Column(name = "COD_STATUS", precision = 2)
    private Integer statusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_STATUS", insertable = false, updatable = false)
    private PagamentoStatus status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "FL_PAGAMENTO_ITEM",
            joinColumns = {
                    @JoinColumn(name = "COD_PAGAMENTO", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "COD_GRUPO_LANCAMENTO", nullable = false, updatable = false)
            })
    private Set<GrupoLancamento> entryGroups = new HashSet<>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Long getEntidadePagarId() {
        return entidadePagarId;
    }

    public void setEntidadePagarId(Long entidadePagarId) {
        this.entidadePagarId = entidadePagarId;
    }

    public String getInstrucaoPagto() {
        return instrucaoPagto;
    }

    public void setInstrucaoPagto(String instrucaoPagto) {
        this.instrucaoPagto = instrucaoPagto;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagto() {
        return dataPagto;
    }

    public void setDataPagto(Date dataPagto) {
        this.dataPagto = dataPagto;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public PagamentoStatus getStatus() {
        return status;
    }

    public void setStatus(PagamentoStatus status) {
        this.status = status;
    }

    public Set<GrupoLancamento> getEntryGroups() {
        return entryGroups;
    }

    public void setEntryGroups(Set<GrupoLancamento> entryGroups) {
        this.entryGroups = entryGroups;
    }
}
