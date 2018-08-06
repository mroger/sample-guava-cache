package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by selma on 09/10/2015.
 */
@Entity
@Table(name = "ADDRESS_TYPE")
public class AddressType {
    public static final Integer RESIDENCIAL = 1;
    public static final Integer OFICIAL = 2;
    public static final Integer COMERCIAL = 3;
    public static final Integer ENTREGA = 4;
    public static final Integer AUDITORIO = 5;
    public static final Integer LOCALIDADE_LOTE = 6;
    public static final Integer PORTAL = 7;

    @Id
    @Column(name = "ADDRESS_TYPE_ID")
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="ADDRESS_TYPE_DESC")
    @NotNull
    public String description;
}
