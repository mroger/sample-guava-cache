package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by chen on 14/09/2015.
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "FL_INTEGRACAO_STATUS")
public class IntegracaoStatus {

    public static final Long SEM_INTEGRACAO = 1L;
    public static final Long AGUARDANDO_INTEGRACAO = 2L;
    public static final Long INTEGRADO = 4L;
    public static final Long AGUARDANDO_BOLETO = 3L;

    @Id
    @Column(name = "COD_STATUS_INTEGRACAO", unique = true, nullable = false, precision = 2, scale = 0)
    private Long id;

    @Column(name = "DESCRICAO_STATUS_INTEGRACAO")
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
