package br.org.roger.spring.domain;

import javax.persistence.*;

/**
 * Created by selma on 19/10/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_GRUPO_LANCAMENTO_STATUS")
@NamedQueries({})
public class GrupoLancamentoStatus  implements java.io.Serializable {
    public static final int ABERTO = 1;
    public static final int BAIXADO = 2;
    public static final int CANCELADO = 3;
    public static final int SOLICITACAO_DEVOLUCAO_ERP = 4;
    public static final int CANCELADO_ERP = 5;

    @Id
    @Column(name = "COD_STATUS_GRUPO_LANCAMENTO", unique = true, nullable = false, precision = 2, scale = 0)
    private Integer id;

    @Column(name = "DESCRICAO_STATUS_GRUPO_LANC", length = 30)
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
