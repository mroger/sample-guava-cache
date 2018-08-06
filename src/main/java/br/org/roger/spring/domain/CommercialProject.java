package br.org.roger.spring.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ailson.moreira on 28/07/2017.
 */
@Data
@Entity
@EqualsAndHashCode
@Table(name = "COMMERCIAL_PROJECT")
public class CommercialProject {

    @Id
    @Column(name = "COMMERCIAL_PROJECT_ID", unique = true, nullable = false, precision = 9)
    private Long id;

    @Column(name = "COMMERCIAL_PROJECT_DESC", length = 120)
    private String description;

    @Column(name = "COMMERCIAL_PROJECT_STATUS_ID", precision = 4)
    private Integer statusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMERCIAL_PROJECT_STATUS_ID", nullable = false, insertable = false, updatable = false)
    private CommercialProjectStatus status;

    @Column(name = "OWNER_ID", precision = 9)
    private Long ownerId;

    @Column(name = "YOUR_REFERENCE", length = 50)
    private String yourReference;

    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "CLOSE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closeAt;

    @Column(name = "GESTOR_ID", precision = 9)
    private Integer storeId;
}
