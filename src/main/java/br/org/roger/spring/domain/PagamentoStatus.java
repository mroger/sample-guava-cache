package br.org.roger.spring.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ailson.moreira on 13/04/2017.
 */
@Entity
@SuppressWarnings("serial")
@NamedQueries({})
@Table(name = "FL_PAGAMENTO_STATUS")
public class PagamentoStatus implements Serializable {

    public static final class Queries {
    }

    @Id
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "COD_STATUS", nullable = false, precision = 2)
    private Long id;

    @Column(name = "DESC_STATUS", precision = 50)
    private String desc;

    @Column(name = "CHAVE", precision = 30)
    private String chave;

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

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
