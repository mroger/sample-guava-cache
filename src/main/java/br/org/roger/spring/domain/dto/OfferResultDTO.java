package br.org.roger.spring.domain.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by chen on 06/02/2015.
 */
@XmlRootElement(name="OfferResultDTO")
@XmlType(propOrder = {"userId", "userName", "documentNumber", "documentTypeDesc", "businessSegmentNumber", "businessUnitNumber", "costCenterNumber", "costCenter", "lotNumber", "descricaoCurta", "bidValue", "status", "statusDesc", "dataEmissao", "comprador"})
public class OfferResultDTO {

    private Long userId;
    private String userName;
    private String documentNumber;
    private String documentTypeDesc;
    private Integer businessSegmentNumber;
    private Integer businessUnitNumber;
    private Long costCenterNumber;
    private String costCenter;
    private String lotNumber;
    private BigDecimal bidValue;
    private Integer status;
    private String statusDesc;
    private Date dataEmissao;
    private String descricaoCurta;
    private String comprador;

    public Integer getStatus() {
        return status;
    }

    public OfferResultDTO() {
    }

    public OfferResultDTO(
            Long entityId,
            String name,
            String documentTypeDesc,
            String documentNumber,
            Integer numeroSegmentoNegocio,
            Integer businessUnitNumber,
            Long projetoleilaoId,
            String lotNumber,
            String descricaoCurta,
            BigDecimal quantity,
            BigDecimal currentMaxBid,
            Integer preLancamentoStatusId,
            Integer preLancamentoTipoId,
            Date dataEmissao,
            String comprador){

        this.userId = entityId;
        this.userName = name;
        this.documentTypeDesc = documentTypeDesc;
        this.documentNumber = documentNumber;
        this.businessSegmentNumber = numeroSegmentoNegocio;
        this.businessUnitNumber = businessUnitNumber;
        this.costCenterNumber = projetoleilaoId;
        this.costCenter = String.format("%02d", numeroSegmentoNegocio)+".P."+ String.format("%08d", projetoleilaoId);
        this.lotNumber = lotNumber;
        this.descricaoCurta = descricaoCurta;
        this.bidValue = quantity.multiply(currentMaxBid);
        this.status = calculate(preLancamentoStatusId, preLancamentoTipoId);
        this.statusDesc = calculateStatusDesc(status);
        this.dataEmissao = dataEmissao;
        this.comprador = comprador;
    }

    private Integer calculate(Integer preLancamentoStatusId, Integer preLancamentoTipoId) {
        if(preLancamentoStatusId == 1){
            if(preLancamentoTipoId == 1){
                return 1; //"Vendido"
            }else if(preLancamentoTipoId == 2){
                return 2; //"Condicional Pendente";
            }else if(preLancamentoTipoId == 3){
                return 4; //"Sem Lance";
            }
        }else if(preLancamentoStatusId == 2){
            return 1; //"Vendido";
        }else if(preLancamentoStatusId == 3){
            return 3; //"Recusado";
        }else if(preLancamentoStatusId == 4){
            return 4; //"Sem Lance";
        }else if(preLancamentoStatusId == 5){
            return 5; //"Cancelado";
        }
        return 0;
    }

    private String calculateStatusDesc(Integer status) {
        if(status == 1){
            return "Vendido";
        }else if(status == 2){
            return "Condicional Pendente";
        }else if(status == 3){
            return "Recusado";
        }else if(status == 4){
            return "Sem Lance";
        }else if(status == 5){
            return "Cancelado";
        }
        return "";
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentTypeDesc() {
        return documentTypeDesc;
    }

    public void setDocumentTypeDesc(String documentTypeDesc) {
        this.documentTypeDesc = documentTypeDesc;
    }

    public Integer getBusinessSegmentNumber() {
        return businessSegmentNumber;
    }

    public void setBusinessSegmentNumber(Integer businessSegmentNumber) {
        this.businessSegmentNumber = businessSegmentNumber;
    }

    public Integer getBusinessUnitNumber() {
        return businessUnitNumber;
    }

    public void setBusinessUnitNumber(Integer businessUnitNumber) {
        this.businessUnitNumber = businessUnitNumber;
    }

    public Long getCostCenterNumber() {
        return costCenterNumber;
    }

    public void setCostCenterNumber(Long costCenterNumber) {
        this.costCenterNumber = costCenterNumber;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public BigDecimal getBidValue() {
        return bidValue;
    }

    public void setBidValue(BigDecimal bidValue) {
        this.bidValue = bidValue;
    }

     public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getDescricaoCurta() {
        return descricaoCurta;
    }

    public void setDescricaoCurta(String descricaoCurta) {
        this.descricaoCurta = descricaoCurta;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }
}