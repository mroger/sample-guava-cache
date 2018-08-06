package br.org.roger.spring.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by selma on 09/10/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "COUNTRY")
public class Country  implements Serializable {

    public static final int BRASIL = 1;

    @Id
    @Column(name = "EREF_COUNTRY_CODE")
    private Integer id;

    @Column(name = "EREF_COUNTRY_NAME")
    private String name;

    @Column(name = "DDI")
    private Integer ddi;

    @Column(name = "ISO3166_ALPHA_2")
    private String sigla;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private List<RoleDocumentType> roleDocumentType = new ArrayList<RoleDocumentType>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDdi() {
        return ddi;
    }

    public void setDdi(Integer ddi) {
        this.ddi = ddi;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<RoleDocumentType> getRoleDocumentType() {
        return roleDocumentType;
    }

    public void setRoleDocumentType(List<RoleDocumentType> roleDocumentType) {
        this.roleDocumentType = roleDocumentType;
    }
}
