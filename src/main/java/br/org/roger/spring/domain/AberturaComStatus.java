package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by selma on 19/11/2015.
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "FL_ABERTURA_COM_STATUS")
public class AberturaComStatus {

    public static final int ABERTO = 1;
    public static final int GERADO = 2;
    public static final int CANCELADO = 3;

    @Id
    @Column(name = "COD_STATUS", unique = true, nullable = false, precision = 1, scale = 0)
    private Long id;

    @Column(name = "DESC_STATUS", nullable = false, length = 30)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
