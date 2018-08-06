package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ailson on 21/11/2016.
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "FL_LANCAMENTO_STATUS")
public class LancamentoStatus {

    public static final Integer ATIVO = 1;
    public static final Integer INATIVO = 2;

    @Id
    @Column(name = "COD_STATUS_LANCAMENTO", unique = true, nullable = false, precision = 2)
    private Integer id;

    @Column(name = "DESCRICAO_STATUS_LANCAMENTO")
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
