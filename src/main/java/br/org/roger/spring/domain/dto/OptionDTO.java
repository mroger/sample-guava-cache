package br.org.roger.spring.domain.dto;

import java.io.Serializable;


public class OptionDTO  implements Serializable, Comparable {

    private String value;
    private Boolean selected;
    private String label;
    private Long quantity;

    public OptionDTO() {
    }

    public OptionDTO(String value, String label, Long quantity) {
        this.value = value;
        this.label = value + "-" + label;
        this.quantity = quantity;
    }

    public OptionDTO(Long value, String label, Long quantity) {
        this.value = String.valueOf(value);
        this.label = value + "-" + label;
        this.quantity = quantity;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Object o) {
        OptionDTO obj = (OptionDTO) o;
        return this.getLabel().compareTo(obj.getLabel());
    }
}
