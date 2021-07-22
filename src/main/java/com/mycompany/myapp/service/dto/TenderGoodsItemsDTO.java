package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderGoodsItems} entity.
 */
public class TenderGoodsItemsDTO implements Serializable {

    private Long id;

    private String itemCode;

    private String itemName;

    private Long indentItemId;

    private Integer entryOrder;

    private BigDecimal netAmt;

    private BigDecimal price;

    private BigDecimal quantity;

    private String specifications;

    private Integer uomId;

    private String uomName;

    private Boolean sampleRequiredYn;

    private NoticeInvitingTenderDTO noticeInvitingTender;

    private TenderGoodsGroupDTO tenderGoodsGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getIndentItemId() {
        return indentItemId;
    }

    public void setIndentItemId(Long indentItemId) {
        this.indentItemId = indentItemId;
    }

    public Integer getEntryOrder() {
        return entryOrder;
    }

    public void setEntryOrder(Integer entryOrder) {
        this.entryOrder = entryOrder;
    }

    public BigDecimal getNetAmt() {
        return netAmt;
    }

    public void setNetAmt(BigDecimal netAmt) {
        this.netAmt = netAmt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Integer getUomId() {
        return uomId;
    }

    public void setUomId(Integer uomId) {
        this.uomId = uomId;
    }

    public String getUomName() {
        return uomName;
    }

    public void setUomName(String uomName) {
        this.uomName = uomName;
    }

    public Boolean getSampleRequiredYn() {
        return sampleRequiredYn;
    }

    public void setSampleRequiredYn(Boolean sampleRequiredYn) {
        this.sampleRequiredYn = sampleRequiredYn;
    }

    public NoticeInvitingTenderDTO getNoticeInvitingTender() {
        return noticeInvitingTender;
    }

    public void setNoticeInvitingTender(NoticeInvitingTenderDTO noticeInvitingTender) {
        this.noticeInvitingTender = noticeInvitingTender;
    }

    public TenderGoodsGroupDTO getTenderGoodsGroup() {
        return tenderGoodsGroup;
    }

    public void setTenderGoodsGroup(TenderGoodsGroupDTO tenderGoodsGroup) {
        this.tenderGoodsGroup = tenderGoodsGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderGoodsItemsDTO)) {
            return false;
        }

        TenderGoodsItemsDTO tenderGoodsItemsDTO = (TenderGoodsItemsDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderGoodsItemsDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderGoodsItemsDTO{" +
            "id=" + getId() +
            ", itemCode='" + getItemCode() + "'" +
            ", itemName='" + getItemName() + "'" +
            ", indentItemId=" + getIndentItemId() +
            ", entryOrder=" + getEntryOrder() +
            ", netAmt=" + getNetAmt() +
            ", price=" + getPrice() +
            ", quantity=" + getQuantity() +
            ", specifications='" + getSpecifications() + "'" +
            ", uomId=" + getUomId() +
            ", uomName='" + getUomName() + "'" +
            ", sampleRequiredYn='" + getSampleRequiredYn() + "'" +
            ", noticeInvitingTender=" + getNoticeInvitingTender() +
            ", tenderGoodsGroup=" + getTenderGoodsGroup() +
            "}";
    }
}
