package br.org.roger.spring.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ailson.moreira on 07/04/2017.
 */
@Entity
@SuppressWarnings("serial")
@Table(name = "FL_VENDA_STATUS")
public class VendaStatus {

    public static final Integer ABERTA = 1;
    public static final Integer BAIXADA = 2;
    public static final Integer CANCELADA = 3;

    @Id
    @Column(name = "COD_STATUS", nullable = false, precision = 2)
    private Long id;

    @Column(name = "DESC_STATUS", precision = 30)
    private String desc;

    public VendaStatus() {
    }

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
}