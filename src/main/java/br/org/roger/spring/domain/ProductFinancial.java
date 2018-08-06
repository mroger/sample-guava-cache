package br.org.roger.spring.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by ailson.moreira on 26/07/2017.
 */
@Data
@Entity
@EqualsAndHashCode
@Table(name = "PRODUCT_FINANCIAL")
public class ProductFinancial {

    @Id
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "COD_CLASS_FISCAL")
    private Integer codClassFiscal;

    @Column(name = "DESCRICAO_FATURAMENTO")
    private String descFaturamento;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ID", nullable=false, insertable=false, updatable=false)
    private Product product;
}