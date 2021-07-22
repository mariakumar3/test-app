package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A TenderGoodsGroup.
 */
@Entity
@Table(name = "tender_goods_group")
public class TenderGoodsGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "bid_items_mandatory_yn")
    private Boolean bidItemsMandatoryYn;

    @Column(name = "group_mandatory_yn")
    private Boolean groupMandatoryYn;

    @OneToMany(mappedBy = "tenderGoodsGroup")
    @JsonIgnoreProperties(value = { "noticeInvitingTender", "tenderGoodsGroup" }, allowSetters = true)
    private Set<TenderGoodsItems> tenderGoodsItems = new HashSet<>();

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

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TenderGoodsGroup id(Long id) {
        this.id = id;
        return this;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public TenderGoodsGroup groupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Boolean getBidItemsMandatoryYn() {
        return this.bidItemsMandatoryYn;
    }

    public TenderGoodsGroup bidItemsMandatoryYn(Boolean bidItemsMandatoryYn) {
        this.bidItemsMandatoryYn = bidItemsMandatoryYn;
        return this;
    }

    public void setBidItemsMandatoryYn(Boolean bidItemsMandatoryYn) {
        this.bidItemsMandatoryYn = bidItemsMandatoryYn;
    }

    public Boolean getGroupMandatoryYn() {
        return this.groupMandatoryYn;
    }

    public TenderGoodsGroup groupMandatoryYn(Boolean groupMandatoryYn) {
        this.groupMandatoryYn = groupMandatoryYn;
        return this;
    }

    public void setGroupMandatoryYn(Boolean groupMandatoryYn) {
        this.groupMandatoryYn = groupMandatoryYn;
    }

    public Set<TenderGoodsItems> getTenderGoodsItems() {
        return this.tenderGoodsItems;
    }

    public TenderGoodsGroup tenderGoodsItems(Set<TenderGoodsItems> tenderGoodsItems) {
        this.setTenderGoodsItems(tenderGoodsItems);
        return this;
    }

    public TenderGoodsGroup addTenderGoodsItem(TenderGoodsItems tenderGoodsItems) {
        this.tenderGoodsItems.add(tenderGoodsItems);
        tenderGoodsItems.setTenderGoodsGroup(this);
        return this;
    }

    public TenderGoodsGroup removeTenderGoodsItem(TenderGoodsItems tenderGoodsItems) {
        this.tenderGoodsItems.remove(tenderGoodsItems);
        tenderGoodsItems.setTenderGoodsGroup(null);
        return this;
    }

    public void setTenderGoodsItems(Set<TenderGoodsItems> tenderGoodsItems) {
        if (this.tenderGoodsItems != null) {
            this.tenderGoodsItems.forEach(i -> i.setTenderGoodsGroup(null));
        }
        if (tenderGoodsItems != null) {
            tenderGoodsItems.forEach(i -> i.setTenderGoodsGroup(this));
        }
        this.tenderGoodsItems = tenderGoodsItems;
    }

    public NoticeInvitingTender getNoticeInvitingTender() {
        return this.noticeInvitingTender;
    }

    public TenderGoodsGroup noticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
        this.setNoticeInvitingTender(noticeInvitingTender);
        return this;
    }

    public void setNoticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
        this.noticeInvitingTender = noticeInvitingTender;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderGoodsGroup)) {
            return false;
        }
        return id != null && id.equals(((TenderGoodsGroup) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderGoodsGroup{" +
            "id=" + getId() +
            ", groupName='" + getGroupName() + "'" +
            ", bidItemsMandatoryYn='" + getBidItemsMandatoryYn() + "'" +
            ", groupMandatoryYn='" + getGroupMandatoryYn() + "'" +
            "}";
    }
}
