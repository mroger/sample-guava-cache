package br.org.roger.spring.domain.dto;

import java.util.Date;
import java.util.List;

public class SaleOrderDTO {

    private Long id;

    private Long preEntryId;

    private Long auctionId;

    private AuctionInfosDTO auction;

    private Long offerId;

    private String lotNumber;

    private String productShortDesc;

    private Long payerId;

    private Date createdAt;

    private Integer statusId;

    private String statusDesc;

    private List<EntryGroupDTO> entryGroup;

    private StoreDTO store;

    public SaleOrderDTO() {
    }

    public SaleOrderDTO(Long id, Long preEntryId, Long auctionId, Long offerId, Long payerId, Date createdAt, Integer statusId, String statusDesc) {
        this.id = id;
        this.preEntryId = preEntryId;
        this.auctionId = auctionId;
        this.offerId = offerId;
        this.payerId = payerId;
        this.createdAt = createdAt;
        this.statusId = statusId;
        this.statusDesc = statusDesc;
    }

    public SaleOrderDTO(Long id,               // listExpression.add(root.get(Venda_.id));
                        Long preEntryId,       // listExpression.add(root.get(Venda_.preLancamentoId));
                        Long auctionId,        // listExpression.add(root.get(Venda_.leilaoId));
                        Long offerId,          // listExpression.add(root.get(Venda_.ofertaId));
                        String lotNumber,      // listExpression.add(offerJoin.get(Offer_.lotNumberDesc));
                        String productShortDesc,
                        Long payerId,          // listExpression.add(root.get(Venda_.entidadePagarId));
                        Date createdAt,        // listExpression.add(root.get(Venda_.dataCriacao));
                        Integer statusId,      // listExpression.add(root.get(Venda_.statusId));
                        String statusDesc,     // listExpression.add(statusJoin.get(VendaStatus_.desc));
                        String auctionDesc,    // listExpression.add(auctionJoin.get(Auction_.auctionDesc));
                        Date auctionEndDate,   // listExpression.add(auctionJoin.get(Auction_.auctionEndDate));
                        Long storeId,       // listExpression.add(gestorJoin.get(Gestor_.id));
                        String storeDesc,      // listExpression.add(gestorJoin.get(Gestor_.gestorDesc));
                        Long ownerId,          // listExpression.add(gestorJoin.get(Gestor_.entityId));
                        Integer erpSystem,          // listExpression.add(gestorJoin.get(Gestor_.entityId));
                        Integer countryId,     // listExpression.add(gestorCountryJoin.get(Country_.id));
                        String countryIso) {   // listExpression.add(gestorCountryJoin.get(Country_.sigla));

        this.id = id;
        this.preEntryId = preEntryId;
        this.auctionId = auctionId;
        this.offerId = offerId;
        this.lotNumber = lotNumber;
        this.productShortDesc = productShortDesc;
        this.payerId = payerId;
        this.createdAt = createdAt;
        this.statusId = statusId;
        this.statusDesc = statusDesc;
        this.auction = new AuctionInfosDTO(
                auctionId,
                auctionDesc,
                auctionEndDate
        );
        this.store = new StoreDTO(storeId, storeDesc, ownerId, countryId, erpSystem, countryIso);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPreEntryId() {
        return preEntryId;
    }

    public void setPreEntryId(Long preEntryId) {
        this.preEntryId = preEntryId;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public List<EntryGroupDTO> getEntryGroup() {
        return entryGroup;
    }

    public void setEntryGroup(List<EntryGroupDTO> entryGroup) {
        this.entryGroup = entryGroup;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public AuctionInfosDTO getAuction() {
        return auction;
    }

    public void setAuction(AuctionInfosDTO auction) {
        this.auction = auction;
    }

    public StoreDTO getStore() {
        return store;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getProductShortDesc() {
        return productShortDesc;
    }

    public void setProductShortDesc(String productShortDesc) {
        this.productShortDesc = productShortDesc;
    }
}
