package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * A TenderGoodsItems.
 */
@Entity
@Table(name = "tender_goods_items")
public class TenderGoodsItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "indent_item_id")
    private Long indentItemId;

    @Column(name = "entry_order")
    private Integer entryOrder;

    @Column(name = "net_amt", precision = 21, scale = 2)
    private BigDecimal netAmt;

    @Column(name = "price", precision = 21, scale = 2)
    private BigDecimal price;

    @Column(name = "quantity", precision = 21, scale = 2)
    private BigDecimal quantity;

    @Column(name = "specifications")
    private String specifications;

    @Column(name = "uom_id")
    private Integer uomId;

    @Column(name = "uom_name")
    private String uomName;

    @Column(name = "sample_required_yn")
    private Boolean sampleRequiredYn;

    @ManyToOne
    @JsonIgnoreProperties(
        value = {
            "tenderSchedule",
            "tenderObjectStores",
            "tenderGoodsItems",
            "tenderSamples",
            "tenderTechnicalParameters",
            "tenderGoodsGroups",
            "tenderCriteria",
            "tenderCriterionDocuments",
            "tenderAddenda",
            "tenderCorrigendums",
            "tenderQueries",
            "tenderScrutinyCommittees",
        },
        allowSetters = true
    )
    private NoticeInvitingTender noticeInvitingTender;

    @ManyToOne
    @JsonIgnoreProperties(value = { "tenderGoodsItems", "noticeInvitingTender" }, allowSetters = true)
    private TenderGoodsGroup tenderGoodsGroup;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TenderGoodsItems id(Long id) {
        this.id = id;
        return this;
    }

    public String getItemCode() {
        return this.itemCode;
    }

    public TenderGoodsItems itemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return this.itemName;
    }

    public TenderGoodsItems itemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getIndentItemId() {
        return this.indentItemId;
    }

    public TenderGoodsItems indentItemId(Long indentItemId) {
        this.indentItemId = indentItemId;
        return this;
    }

    public void setIndentItemId(Long indentItemId) {
        this.indentItemId = indentItemId;
    }

    public Integer getEntryOrder() {
        return this.entryOrder;
    }

    public TenderGoodsItems entryOrder(Integer entryOrder) {
        this.entryOrder = entryOrder;
        return this;
    }

    public void setEntryOrder(Integer entryOrder) {
        this.entryOrder = entryOrder;
    }

    public BigDecimal getNetAmt() {
        return this.netAmt;
    }

    public TenderGoodsItems netAmt(BigDecimal netAmt) {
        this.netAmt = netAmt;
        return this;
    }

    public void setNetAmt(BigDecimal netAmt) {
        this.netAmt = netAmt;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public TenderGoodsItems price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public TenderGoodsItems quantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getSpecifications() {
        return this.specifications;
    }

    public TenderGoodsItems specifications(String specifications) {
        this.specifications = specifications;
        return this;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Integer getUomId() {
        return this.uomId;
    }

    public TenderGoodsItems uomId(Integer uomId) {
        this.uomId = uomId;
        return this;
    }

    public void setUomId(Integer uomId) {
        this.uomId = uomId;
    }

    public String getUomName() {
        return this.uomName;
    }

    public TenderGoodsItems uomName(String uomName) {
        this.uomName = uomName;
        return this;
    }

    public void setUomName(String uomName) {
        this.uomName = uomName;
    }

    public Boolean getSampleRequiredYn() {
        return this.sampleRequiredYn;
    }

    public TenderGoodsItems sampleRequiredYn(Boolean sampleRequiredYn) {
        this.sampleRequiredYn = sampleRequiredYn;
        return this;
    }

    public void setSampleRequiredYn(Boolean sampleRequiredYn) {
        this.sampleRequiredYn = sampleRequiredYn;
    }

    public NoticeInvitingTender getNoticeInvitingTender() {
        return this.noticeInvitingTender;
    }

    public TenderGoodsItems noticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
        this.setNoticeInvitingTender(noticeInvitingTender);
        return this;
    }

    public void setNoticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
        this.noticeInvitingTender = noticeInvitingTender;
    }

    public TenderGoodsGroup getTenderGoodsGroup() {
        return this.tenderGoodsGroup;
    }

    public TenderGoodsItems tenderGoodsGroup(TenderGoodsGroup tenderGoodsGroup) {
        this.setTenderGoodsGroup(tenderGoodsGroup);
        return this;
    }

    public void setTenderGoodsGroup(TenderGoodsGroup tenderGoodsGroup) {
        this.tenderGoodsGroup = tenderGoodsGroup;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderGoodsItems)) {
            return false;
        }
        return id != null && id.equals(((TenderGoodsItems) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderGoodsItems{" +
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
            "}";
    }
}
