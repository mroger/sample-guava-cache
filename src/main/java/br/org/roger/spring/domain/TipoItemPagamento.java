package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

/**
 * Created by selma on 19/10/2015.
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "FL_TIPO_ITEM_PAGAMENTO")
@NamedQueries({})
public class TipoItemPagamento implements java.io.Serializable {
    public static final int PAGAMENTO_LOTE = 1;
    public static final int COMISSAO_LEILOEIRO = 2;
    public static final int BUYERS_PREMIUM = 3;
    public static final int COMISSAO_COMITENTE = 4;
    public static final int TAXA_ADMINISTRATIVA = 5;
    public static final int MULTA_COMPRADOR = 6;
    public static final int EDITAL_COMITENTE = 7;
    public static final int ESTADIA = 8;
    public static final int REMOCAO = 9;




        @Id
    @Column(name = "COD_TIPO_ITEM_PAGAMENTO", unique = true, nullable = false, precision = 2, scale = 0)
    private Long id;

    @Column(name = "DESCRICAO_TIPO_ITEM_PAGAMENTO", length = 30)
    private String desc;

    @Column(name = "COD_TIPO_ENTIDADE_PAGAMENTO", precision = 1, scale = 0)
    private Long tipoEntidadePagtoId;

    @Column(name = "COD_TIPO_COBRANCA", precision = 1, scale = 0)
    private Long tipoCobrancaId;

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

    public Long getTipoEntidadePagtoId() {
        return tipoEntidadePagtoId;
    }

    public void setTipoEntidadePagtoId(Long tipoEntidadePagtoId) {
        this.tipoEntidadePagtoId = tipoEntidadePagtoId;
    }

    public Long getTipoCobrancaId() {
        return tipoCobrancaId;
    }

    public void setTipoCobrancaId(Long tipoCobrancaId) {
        this.tipoCobrancaId = tipoCobrancaId;
    }
}
