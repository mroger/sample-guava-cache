package br.org.roger.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by eduardo on 14/07/2017.
 */
@Entity
@Table(name = "GESTOR_SETTINGS")
@Getter
@Setter
public class GestorSettings {

    public static final int ERP_SYSTEM_ORACLE_FUSION = 1;
    public static final int ERP_SYSTEM_CORPORE_RM = 2;

    @Id
    @Column(name = "GESTOR_ID")
    private Long gestorId;

    @Column(name = "SHOW_ITENS_PORCENTAGEM")
    private String showItensPorcentagem;

    @Column(name = "COD_ERP_SYSTEM")
    private Integer erpSystem;

    @Column(name = "COUNTRY_CODE")
    private Long countryId;

    @Column(name = "ERP_KEY")
    private String erpKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_CODE", updatable = false, insertable = false)
    private Country country;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GESTOR_ID", unique = true, nullable = false, insertable = false, updatable = false)
    private Gestor gestor;
}
