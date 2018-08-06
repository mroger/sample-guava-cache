package br.org.roger.spring.domain;

import javax.persistence.*;

/**
 * Created by chen on 05/08/2016.
 */
@Entity
@Table(name = "NUMBER_SEQUENCE")
public class NumberSequence {

    @Id
    @Column(name = "SEQUENCIA_ID", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

    @Column(name = "SEQUENCIA", precision = 9, scale = 0)
    private Long sequencia;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTITY_ID")
    private UserEntity entity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSequencia() {
        return sequencia;
    }

    public void setSequencia(Long sequencia) {
        this.sequencia = sequencia;
    }

    public UserEntity getEntity() {
        return entity;
    }

    public void setEntity(UserEntity entity) {
        this.entity = entity;
    }
}
