package br.org.roger.spring.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by selma on 09/10/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ROLE")
public class Role implements java.io.Serializable {

public static final int COMITENTE = 22;
public static final int COMPRADOR = 1;

    @Id
    @Column(name = "ROLE_ID", unique = true, nullable = false, precision = 5, scale = 0)
    private Integer id;

    @Column(name = "ROLE_DESC", nullable = false, length = 100)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<RoleDocumentType> roleDocumentType = new ArrayList<RoleDocumentType>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RoleDocumentType> getRoleDocumentType() {
        return roleDocumentType;
    }

    public void setRoleDocumentType(List<RoleDocumentType> roleDocumentType) {
        this.roleDocumentType = roleDocumentType;
    }
}
