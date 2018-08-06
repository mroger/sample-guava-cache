package br.org.roger.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "FL_LOG_SINCRONIZACAO_OPERACAO")
public class LogSincronizacaoOperacao {

    @Id
    @Column(name = "OPERACAO_ID", unique = true, nullable = false, precision = 2, scale = 0)
    private Long id;

    @Column(name = "OPERACAO_DESC", precision = 100, scale = 0)
    private String operationDesc;
}
