package br.org.roger.spring.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DOCUMENT_TYPE")

public class DocumentType {

    public static final int CNPJ = 1;
    public static final int CPF = 4;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DOCUMENT_TYPE_ID")
    private Integer id;

    @Column(name = "DOCUMENT_TYPE_NAME")
    @NotNull
    public String name;

    @Column(name = "DOCUMENT_TYPE_DESCRIPTION")
    @NotNull
    public String description;

    @Column(name = "DOCUMENT_TYPE_ORDER")
    @NotNull
    public Integer order;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "documentType")
    private List<RoleDocumentType> roleDocumentType = new ArrayList<RoleDocumentType>(0);

    public static int getCnpj() {
        return CNPJ;
    }

    public static int getCpf() {
        return CPF;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}