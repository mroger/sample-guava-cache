package br.org.roger.spring.domain;

import javax.persistence.*;

/**
 * Created by selma on 01/09/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_REPASSE_FORMA_PAGAMENTO")

@NamedQueries({
        @NamedQuery(name = RepasseFormaPag.Queries.FIND_ALL_REPASSE_FORMA_PAG,
                query =
                        " SELECT " +
                        "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.PaymentMethodDTO( " +
                        "     rf.id, " +
                        "     rf.desc, " +
                        "     rf.sigla) " +
                        " FROM RepasseFormaPag rf " +
                        " ORDER BY rf.id "
        )
})
public class RepasseFormaPag {

    public static final Integer TRANSF_BANCARIA = 1;
    public static final Integer CHEQUE = 2;

    public static final class Queries {
        public static final String FIND_ALL_REPASSE_FORMA_PAG = "FIND_ALL_REPASSE_FORMA_PAG";
    }

    @Id
    @Column(name = "COD_FORMA_PAGAMENTO", unique = true, nullable = false, precision = 1, scale = 0)
    private Integer id;

    @Column(name = "DESC_FORMA_PAGAMENTO")
    private String desc;

    @Column(name = "SIGLA_FORMA_PAGAMENTO")
    private String sigla;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
