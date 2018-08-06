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
@Table(name = "FL_MODULO")
public class Modulo implements Serializable {

    public static final Integer GRUPO_LANCAMENTO = 1;
    public static final Integer REPASSE = 2;
    public static final Integer COMISSAO_COMITENTE = 3;
    public static final Integer EDITAL = 4;
    public static final Integer COMISSAO_PARCEIRO = 5;
    public static final Integer RESUMO_FINANCEIRO = 6;
    public static final Integer ADIANTAMENTO_REPASSE = 7;

    @Id
    @Column(name = "COD_MODULO", unique = true, nullable = false, precision = 2, scale = 0)
    private Integer id;

    @Column(name = "DESC_MODULO", length = 30)
    private String modulo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
}
