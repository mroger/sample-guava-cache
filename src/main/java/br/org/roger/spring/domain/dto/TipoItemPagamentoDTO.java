package br.org.roger.spring.domain.dto;

import lombok.Data;

/**
 * Created by abraao.silva on 07/12/2017.
 */

@Data
public class TipoItemPagamentoDTO {
    private Long id;
    private String desc;
    private Long tipoEntidadePagtoId;
    private Long tipoCobrancaId;


}