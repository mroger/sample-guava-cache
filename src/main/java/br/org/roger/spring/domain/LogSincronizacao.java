package br.org.roger.spring.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "FL_LOG_SINCRONIZACAO")
@NamedQueries({
    @NamedQuery(name = LogSincronizacao.Queries.OBTER_LOG_PRE_LANCAMENTO_PARA_SYNC,
                query =
                    " SELECT " +
                    "   logSync " +
                    " FROM" +
                    "   LogSincronizacao logSync " +
                    " WHERE" +
                    "   logSync.active = true " +
                    " AND logSync.syncDate is null " +
                    " AND logSync.operationId in (1, 2) " +
                    " ORDER BY " +
                    "   logSync.id DESC " /* CRIACAO PRE LANCAMENTO / ALTERACAO PRE LANCAMENTO*/
    ),
        @NamedQuery(name = LogSincronizacao.Queries.UPDATE_CHANGE_TO_SYNCED,
                query =
                        " UPDATE " +
                        "   LogSincronizacao log " +
                        " SET " +
                        "   log.syncDate = sysdate() " +
                        " WHERE " +
                        "   log.id = :idLog "
        )
})
public class LogSincronizacao {

    public static final class Queries {
        public static final String OBTER_LOG_PRE_LANCAMENTO_PARA_SYNC = "OBTER_LOG_PRE_LANCAMENTO_PARA_SYNC";
        public static final String UPDATE_CHANGE_TO_SYNCED = "UPDATE_CHANGE_TO_SYNCED";
    }

    @Id
    @Column(name = "LOG_SINCRONIZACAO_ID", unique = true, nullable = false, precision = 10, scale = 0)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_LOG", columnDefinition = "date")
    private Date logDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_SINCRONIZACAO", columnDefinition = "date")
    private Date syncDate;

    @Column(name = "OPERACAO_ID", precision = 2, scale = 0)
    private Integer operationId;

    @Column(name = "ATIVO")
    @Type(type = "net.s4bdigital.libs.jpa.usertype.TrueFalseCharType")
    private Boolean active;

    @Column(name = "COD_REF", precision = 9, scale = 0)
    private Long referenceCode;
}
