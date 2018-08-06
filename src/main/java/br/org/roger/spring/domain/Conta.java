package br.org.roger.spring.domain;

import javax.persistence.*;

/**
 * Created by selma on 11/09/2015.
 */
@Entity
@Table(name = "FL_CONTA")
@NamedQueries({
        @NamedQuery(name = Conta.Queries.FIND_BANK_ACCOUNT_USER_ENTITY,
                query =
                        " SELECT " +
                                "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.BankAccountDTO( " +
                                "     e.name, " +
                                "     c.id, " +
                                "     b.numero, " +
                                "     b.nome, " +
                                "     c.agencia, " +
                                "     c.agenciaDigito, " +
                                "     c.conta, " +
                                "     c.contaDigito) " +
                                " FROM " +
                                "	Conta c " +
                                "	inner join c.banco b " +
                                "   inner join c.userEntity e " +
                                " WHERE " +
                                "	c.userEntityId = :userEntityId "),

        @NamedQuery(name = Conta.Queries.FIND_BANK_ACCOUNT_AUCTION_SELLER,
                query =
                        " SELECT DISTINCT " +
                                " new net.s4bdigital.api.auctionfinancial.server.domain.dto.BankAccountDTO( " +
                                "   e.name, " +
                                "   co.id, " +
                                "   cp.id, " +
                                "   b.numero, " +
                                "   b.nome, " +
                                "   co.agencia, " +
                                "   co.agenciaDigito, " +
                                "   co.conta, " +
                                "   co.contaDigito) " +
                                " FROM " +
                                "   Offer o " +
                                "   inner join o.preLancamentos pl " +
                                "   inner join pl.preLancamentoItem pli " +
                                "   inner join pl.comitente com " +
                                "   inner join pl.preLancamentoStatus pls " +
                                "   inner join pli.contaPagamento cp " +
                                "   inner join cp.conta co " +
                                "   inner join co.banco b " +
                                "   inner join co.userEntity e" +
                                " WHERE " +
                                "       pls.id = 2 " +
                                "   and pli.id.codTipoItemPagamento = 1 " +
                                "   and co.userEntityId <> com.id " +
                                "   and o.auctionId = :qAuctionId " +
                                "   and com.id = :qSellerId " )
})
public class Conta {
    public static final class Queries {
        public static final String FIND_BANK_ACCOUNT_USER_ENTITY = "FIND_BANK_ACCOUNT_USER_ENTITY";
        public static final String FIND_BANK_ACCOUNT_AUCTION_SELLER = "FIND_BANK_ACCOUNT_AUCTION_SELLER";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_CONTA", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

    @Column(name = "CONTA")
    private String conta;

    @Column(name = "CONTA_DIGITO")
    private String contaDigito;

    @Column(name = "AGENCIA")
    private String agencia;

    @Column(name = "AGENCIA_DIGITO")
    private String agenciaDigito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_ENTIDADE", insertable = false, updatable = false)
    private UserEntity userEntity;

    @Column(name = "COD_ENTIDADE")
    private Long userEntityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_BANCO", insertable = false, updatable = false)
    private Banco banco;

    @Column(name = "COD_BANCO")
    private Long bancoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getContaDigito() {
        return contaDigito;
    }

    public void setContaDigito(String contaDigito) {
        this.contaDigito = contaDigito;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getAgenciaDigito() {
        return agenciaDigito;
    }

    public void setAgenciaDigito(String agenciaDigito) {
        this.agenciaDigito = agenciaDigito;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Long getUserEntityId() {
        return userEntityId;
    }

    public void setUserEntityId(Long userEntityId) {
        this.userEntityId = userEntityId;
    }

    public Long getBancoId() {
        return bancoId;
    }

    public void setBancoId(Long bancoId) {
        this.bancoId = bancoId;
    }
}
