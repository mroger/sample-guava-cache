package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by selma on 09/10/2015.
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "DOCUMENT_TYPE_CATEGORY")
public class DocumentTypeCategory implements Serializable {

    public static final int CEDULA_IDENTIDADE = 1;
    public static final int IDENTIFICACAO_FISCAL = 2;

    @Id
    @Column(name = "DOCUMENT_TYPE_CATEGORY_ID")
    private Integer id;

    @Column(name = "DOCUMENT_TYPE_CATEGORY_DESC")
    private String description;

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
}
