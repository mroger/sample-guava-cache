package br.org.roger.spring.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ailson on 21/11/2016.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_GLANC_INTEGRACAO")
@NamedQueries({
        @NamedQuery(name = GLancIntegracao.Queries.FIND_INTEGRATION_BY_ENTRY_GROUP_ID_AND_TYPE,
                query =
                        " SELECT " +
                                " gli " +
                                " FROM " +
                                " GLancIntegracao gli " +
                                " WHERE " +
                                "     gli.grupoLancamento.id = :grupoLancamentoId " +
                                " AND gli.integracaoTipo.id = :integrationType " +
                                " ORDER BY " +
                                "  gli.id asc"
        ),
        @NamedQuery(name = GLancIntegracao.Queries.FIND_INTEGRATIONS_BY_ENTRY_GROUP_ID,
                query =
                        " SELECT " +
                                " gli " +
                                " FROM " +
                                " GLancIntegracao gli " +
                                " WHERE " +
                                "     gli.grupoLancamento.id = :grupoLancamentoId " +
                                " ORDER BY " +
                                "  gli.id asc"
        )
})
public class GLancIntegracao implements Serializable {

    public static final class Queries {
        public static final String FIND_INTEGRATIONS_BY_ENTRY_GROUP_ID = "FIND_INTEGRATIONS_BY_ENTRY_GROUP_ID";
        public static final String FIND_INTEGRATION_BY_ENTRY_GROUP_ID_AND_TYPE = "FIND_INTEGRATION_BY_ENTRY_GROUP_ID_AND_TYPE";
    }

    @Id
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "COD_GLANC_INTEGRACAO", nullable = false, precision = 9)
    private Long id;

    @Column(name = "COD_GRUPO_LANCAMENTO", nullable = false, precision = 9)
    private Long grupoLancamentoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_GRUPO_LANCAMENTO", insertable = false, updatable = false)
    private GrupoLancamento grupoLancamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_STATUS_INTEGRACAO", insertable = false, updatable = false)
    private IntegracaoStatus integrationStatus;

    @Column(name = "COD_STATUS_INTEGRACAO", precision = 2)
    private Long statusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_TIPO_INTEGRACAO", nullable = false, insertable = false, updatable = false)
    private IntegracaoTipo integracaoTipo;

    @Column(name = "COD_TIPO_INTEGRACAO", precision = 2)
    private Long integracaoTipoId;

    //@Column(name = "COD_INTEGRACAO", precision = 9)
    @Transient
    private Long integrationDataCod;

    public GLancIntegracao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGrupoLancamentoId() {
        return grupoLancamentoId;
    }

    public void setGrupoLancamentoId(Long grupoLancamentoId) {
        this.grupoLancamentoId = grupoLancamentoId;
    }

    public GrupoLancamento getGrupoLancamento() {
        return grupoLancamento;
    }

    public void setGrupoLancamento(GrupoLancamento grupoLancamento) {
        this.grupoLancamento = grupoLancamento;
    }

    public IntegracaoStatus getIntegrationStatus() {
        return integrationStatus;
    }

    public void setIntegrationStatus(IntegracaoStatus integrationStatus) {
        this.integrationStatus = integrationStatus;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public IntegracaoTipo getIntegracaoTipo() {
        return integracaoTipo;
    }

    public void setIntegracaoTipo(IntegracaoTipo integracaoTipo) {
        this.integracaoTipo = integracaoTipo;
    }

    public Long getIntegracaoTipoId() {
        return integracaoTipoId;
    }

    public void setIntegracaoTipoId(Long integracaoTipoId) {
        this.integracaoTipoId = integracaoTipoId;
    }

    /**
     * Checks if the type of this integration is Imposto or Lancamento or Pagamento
     *
     * @return true if this integration type is Imposto or Lancamento or Pagamento, false otherwise
     */
    public boolean isIntegracaoImpostoLancamentoOuPagamento() {
        return integracaoTipoId == IntegracaoTipo.INTEGRACAO_IMPOSTO ||
            integracaoTipoId == IntegracaoTipo.INTEGRACAO_LANCAMENTO ||
            integracaoTipoId == IntegracaoTipo.INTEGRACAO_SIST_PAGAMENTO;
    }

    /**
     * Checks if this integration status is pending.
     *
     * @return true if this integration status is pending, false otherwise
     */
    public boolean isIntegracaoPendente() {
        return statusId != IntegracaoStatus.INTEGRADO &&
            statusId != IntegracaoStatus.SEM_INTEGRACAO;
    }
}