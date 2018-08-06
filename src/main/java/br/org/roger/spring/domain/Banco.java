package br.org.roger.spring.domain;

import javax.persistence.*;

/**
 * Created by selma on 11/09/2015.
 */
@Entity
@Table(name = "FL_BANCO")
@NamedQueries({
})
public class Banco {
    public static final class Queries {
    }

    public static final int ATIVO = 1;
    public static final int INATIVO = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_BANCO", unique = true, nullable = false, precision = 4, scale = 0)
    private Long id;

    @Column(name = "NUMERO_BANCO")
    private String numero;

    @Column(name = "NOME_BANCO")
    private String nome;

    @Column(name = "COD_BANCO_STATUS")
    private Integer statusId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}
