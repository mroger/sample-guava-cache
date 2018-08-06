package br.org.roger.spring.domain.dto;

/* Created by walter on 28/03/17 */

public class SaleOrderStatusDTO {

    private Long codVenda;

    private String description;

    public SaleOrderStatusDTO() {
    }

    public SaleOrderStatusDTO(Long codVenda, String description) {
        this.codVenda = codVenda;
        this.description = description;
    }

    public Long getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Long codVenda) {
        this.codVenda = codVenda;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
