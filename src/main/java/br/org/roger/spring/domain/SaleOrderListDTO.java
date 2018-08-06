package br.org.roger.spring.domain;

import br.org.roger.spring.domain.dto.SaleOrderDTO;

import java.util.List;

/**
 * Created by eduardo on 10/04/2017.
 */
public class SaleOrderListDTO {

    private Long total;

    private Integer start;

    private Integer limit;

    private List<SaleOrderDTO> saleOrders;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<SaleOrderDTO> getSaleOrders() {
        return saleOrders;
    }

    public void setSaleOrders(List<SaleOrderDTO> saleOrders) {
        this.saleOrders = saleOrders;
    }
}
