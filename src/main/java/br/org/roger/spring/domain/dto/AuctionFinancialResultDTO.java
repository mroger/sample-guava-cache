package br.org.roger.spring.domain.dto;

import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chen on 06/02/2015.
 */
@XmlRootElement(name="AuctionFinancialResultDTO")
public class AuctionFinancialResultDTO {

    @ApiModelProperty(required = true)
    private Long auctionId;
    @ApiModelProperty(required = true)
    private List<OfferResultDTO> offerResultDTOList;

    public AuctionFinancialResultDTO() {
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    @XmlElement(name = "offerResult")
    @XmlElementWrapper(name = "offerResults")
    public List<OfferResultDTO> getOfferResultDTOList() {
        return offerResultDTOList;
    }

    public void setOfferResultDTOList(List<OfferResultDTO> offerResultDTOList) {
        this.offerResultDTOList = offerResultDTOList;
    }
}
