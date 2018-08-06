package br.org.roger.spring.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by chen on 05/08/2016.
 */
@Entity
@Table(name = "Fl_NOTA_ARREMATACAO")
public class NotaArrematacao {

    @Id
    @Column(name = "COD_NOTA_ARREMATACAO", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_IMPRESSO", columnDefinition = "date")
    private Date dataImpresso;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_LIBERACAO", columnDefinition = "date")
    private Date dataLiberacao;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "notaArrematacao")
    private GrupoLancamento grupoLancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataImpresso() {
        return dataImpresso;
    }

    public void setDataImpresso(Date dataImpresso) {
        this.dataImpresso = dataImpresso;
    }

    public Date getDataLiberacao() {
        return dataLiberacao;
    }

    public void setDataLiberacao(Date dataLiberacao) {
        this.dataLiberacao = dataLiberacao;
    }
}
