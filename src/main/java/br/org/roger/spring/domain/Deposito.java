package br.org.roger.spring.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by chen on 02/08/2016.
 */
@Entity
@Table(name = "FL_DEPOSITO")
@NamedQueries(
    @NamedQuery(name = "FIND_DEPOSITO_ACCOUNT_BY_COD_GRUPO_LANCAMENTO", query =
        "select new net.s4bdigital.api.auctionfinancial.server.domain.dto.DepositAccountInformation("
            + "b.numero, b.nome, d.identificador, "
            + "c.agencia, c.agenciaDigito, c.conta , "
            + "c.contaDigito, d.valorBruto, e.name, "
            + "docs.numero, dtype.name) "
            + "from GrupoLancamento gl "
            + "inner join gl.deposito d "
            + "inner join gl.contaPagamento cp "
            + "inner join cp.conta c "
            + "inner join c.banco b "
            + "inner join c.userEntity e "
            + "inner join e.documents docs "
            + "inner join docs.documentType dtype "
            + "inner join dtype.roleDocumentType role "
            + "where gl.id = ? "
            + "  and role.categoryId = 2 "
            + "  and role.roleId = 22 "
            + "  and role.countryId = e.countryId "
            + "  and role.entityType = e.entityType ")
)
public class Deposito {

    public static final class Queries {
        public static final String FIND_DEPOSITO_ACCOUNT_BY_COD_GRUPO_LANCAMENTO =
            "FIND_DEPOSITO_ACCOUNT_BY_COD_GRUPO_LANCAMENTO";
    }

    @Id
    @Column(name = "COD_GRUPO_LANCAMENTO", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

    @Column(name = "IDENTIFICADOR")
    private String identificador;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_GRUPO_LANCAMENTO", nullable = false, insertable = false, updatable = false)
    private GrupoLancamento grupoLancamento;

    @Column(name = "VALOR_BRUTO", precision = 15, scale = 4)
    private BigDecimal valorBruto;

    @Column(name = "VALOR_IR", precision = 15, scale = 3)
    private BigDecimal irValue;

    @Column(name = "VALOR_CSLL", precision = 15, scale = 3)
    private BigDecimal csllValue;

    @Column(name = "VALOR_PIS", precision = 15, scale = 3)
    private BigDecimal pisValue;

    @Column(name = "VALOR_COFINS", precision = 15, scale = 3)
    private BigDecimal cofinsValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public GrupoLancamento getGrupoLancamento() {
        return grupoLancamento;
    }

    public void setGrupoLancamento(GrupoLancamento grupoLancamento) {
        this.grupoLancamento = grupoLancamento;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public BigDecimal getIrValue() {
        return irValue;
    }

    public void setIrValue(BigDecimal irValue) {
        this.irValue = irValue;
    }

    public BigDecimal getCsllValue() {
        return csllValue;
    }

    public void setCsllValue(BigDecimal csllValue) {
        this.csllValue = csllValue;
    }

    public BigDecimal getPisValue() {
        return pisValue;
    }

    public void setPisValue(BigDecimal pisValue) {
        this.pisValue = pisValue;
    }

    public BigDecimal getCofinsValue() {
        return cofinsValue;
    }

    public void setCofinsValue(BigDecimal cofinsValue) {
        this.cofinsValue = cofinsValue;
    }
}
