package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by chen on 14/09/2015.
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "FL_REPASSE_TIPO_TRANSF")
public class RepasseTipoTransf {

    public static final Integer TRASFERENCIA = 1;
    public static final Integer DOC = 2;
    public static final Integer TED = 3;
    public static final Integer CHEQUE = 4;

    @Id
    @Column(name = "COD_TIPO_TRANSFERENCIA", unique = true, nullable = false, precision = 1, scale = 0)
    private Integer id;

    @Column(name = "DESC_TIPO_TRANSFERENCIA", length = 20)
    private String desc;

    @Column(name = "VALOR_MINIMO", precision = 15, scale = 3)
    private BigDecimal valorMinimo;

    @Column(name = "VALOR_MAXIMO", precision = 15, scale = 3)
    private BigDecimal valorMaximo;

    @Column(name = "SIGLA_FORMA_PAGAMENTO", length = 3)
    private String siglaTipoTransf;

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

    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public BigDecimal getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(BigDecimal valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public String getSiglaTipoTransf() {
        return siglaTipoTransf;
    }

    public void setSiglaTipoTransf(String siglaTipoTransf) {
        this.siglaTipoTransf = siglaTipoTransf;
    }
}
