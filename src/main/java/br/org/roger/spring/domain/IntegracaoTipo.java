package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ailson on 21/11/2016.
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "FL_INTEGRACAO_TIPO")
public class IntegracaoTipo implements Serializable {

    public static final Long INTEGRACAO_LANCAMENTO     = 1L;
    public static final Long INTEGRACAO_IMPOSTO        = 2L;
    public static final Long INTEGRACAO_SIST_PAGAMENTO = 3L;

    @Id
    @Column(name = "COD_TIPO_INTEGRACAO", nullable = false, precision = 9)
    private Long id;

    @Column(name = "DESC_TIPO_INTEGRACAO", precision = 30)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntegracaoTipo that = (IntegracaoTipo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return desc != null ? desc.equals(that.desc) : that.desc == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }
}