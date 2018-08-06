package br.org.roger.spring.domain;

import javax.persistence.*;

/**
 * Created by chen on 28/08/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_REPASSE_STATUS")
@NamedQueries({
    @NamedQuery(name = RepasseStatus.Queries.FIND_ALL_REPASSE_STATUS,
        query =
            " SELECT " +
            "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.StatusDTO( " +
            "     rs.id, " +
            "     rs.desc) " +
            " FROM RepasseStatus rs " +
            " ORDER BY rs.id "
)
})
public class RepasseStatus {

    public static final Integer ABERTO = 1;
    public static final Integer BAIXADO = 2;
    public static final Integer CANCELADO = 3;
    public static final Integer DESCONTADO = 4;

    public static final class Queries {
        public static final String FIND_ALL_REPASSE_STATUS = "FIND_ALL_REPASSE_STATUS";
    }

    @Id
    @Column(name = "COD_STATUS", unique = true, nullable = false, precision = 9, scale = 0)
    private Integer id;

    @Column(name = "DESC_STATUS")
    private String desc;

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
}
