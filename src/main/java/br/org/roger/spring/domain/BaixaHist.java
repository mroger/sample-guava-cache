package br.org.roger.spring.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by selma on 15/03/2016.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_BAIXA_HIST")
public class BaixaHist implements Serializable {

    @Id
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "COD_HISTORICO", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

    @Column(name = "COD_IDENTIFICACAO", precision = 9, scale = 0)
    private Long codIdenfificacao;

    @Column(name = "COD_MODULO", precision = 2, scale = 0)
    private Integer codModulo;

    @Column(name = "COD_ACAO", precision = 1, scale = 0)
    private Integer codAcao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ACAO", columnDefinition = "date")
    private Date dataAcao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodIdenfificacao() {
        return codIdenfificacao;
    }

    public void setCodIdenfificacao(Long codIdenfificacao) {
        this.codIdenfificacao = codIdenfificacao;
    }

    public Integer getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(Integer codModulo) {
        this.codModulo = codModulo;
    }

    public Integer getCodAcao() {
        return codAcao;
    }

    public void setCodAcao(Integer codAcao) {
        this.codAcao = codAcao;
    }

    public Date getDataAcao() {
        return dataAcao;
    }

    public void setDataAcao(Date dataAcao) {
        this.dataAcao = dataAcao;
    }
}
