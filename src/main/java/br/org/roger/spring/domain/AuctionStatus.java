package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by chen on 14/09/2015.
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "AUCTION_STATUS")
public class AuctionStatus {

    public static final Integer ABERTO = 1;
    public static final Integer FECHADO = 2;
    public static final Integer DESENVOLVIMENTO = 3;
    public static final Integer EM_BREVE = 4;
    public static final Integer EM_LOTEAMENTO = 5;
    public static final Integer ACESSO_RESTRITO = 8;
    public static final Integer ACESSO_BLOQUEADO = 9;
    public static final Integer CATALOGO_ELETRONICO = 10;
    public static final Integer CANCELADO = 11;
    public static final Integer LIQ_PARCIAL = 12;
    public static final Integer LIQ_FINAN = 13;

    @Id
    @Column(name = "AUCTION_STATUS_ID", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

}
