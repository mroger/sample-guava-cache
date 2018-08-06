package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by selma on 15/03/2016.
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "FL_BAIXA_HIST_ACAO")
public class BaixaHistAcao implements Serializable {

    public static final Integer BAIXAR = 1;
    public static final Integer DESFAZER_BAIXA = 2;

    @Id
    @Column(name = "COD_ACAO", unique = true, nullable = false, precision = 1, scale = 0)
    private Integer id;

    @Column(name = "DESC_ACAO", length = 30)
    private String acao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
}
