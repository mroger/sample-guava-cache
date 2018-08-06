package br.org.roger.spring.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ailson.moreira on 15/09/2015.
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "FL_CONTA_PAGAMENTO_ST")
@NamedQueries({})
public class ContaPagamantoStatus implements Serializable {

    public static final class Queries {
    }

    @Id
    @Column(name = "COD_CONTA_PAGAMENTO_ST", unique = true, nullable = false, precision = 2, scale = 0)
    private Integer id;

    @Column(name = "DESC_CONTA_PAGAMENTO_ST", length = 30)
    private String descStatusContaPagamento;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contaPagamantoStatus")
    private Set<ContaPagamento> contaPagamentos = new HashSet<ContaPagamento>(0);

    //METHODS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescStatusContaPagamento() {
        return descStatusContaPagamento;
    }

    public void setDescStatusContaPagamento(String descStatusContaPagamento) {
        this.descStatusContaPagamento = descStatusContaPagamento;
    }

    public Set<ContaPagamento> getContaPagamentos() {
        return contaPagamentos;
    }

    public void setContaPagamentos(Set<ContaPagamento> contaPagamentos) {
        this.contaPagamentos = contaPagamentos;
    }
}
