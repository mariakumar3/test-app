package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A TenderCriterion.
 */
@Entity
@Table(name = "tender_criterion")
public class TenderCriterion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "criterion_master_id")
    private Long criterionMasterId;

    @Column(name = "criterion_type")
    private String criterionType;

    @Column(name = "criterion_category")
    private String criterionCategory;

    @Column(name = "criterion_type_others_value")
    private String criterionTypeOthersValue;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private Integer weight;

    @OneToMany(mappedBy = "tenderCriterion")
    @JsonIgnoreProperties(value = { "noticeInvitingTender", "tenderCriterion" }, allowSetters = true)
    private Set<TenderCriterionDocument> tenderCriterionDocuments = new HashSet<>();

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

    public TenderCriterion id(Long id) {
        this.id = id;
        return this;
    }

    public Long getCriterionMasterId() {
        return this.criterionMasterId;
    }

    public TenderCriterion criterionMasterId(Long criterionMasterId) {
        this.criterionMasterId = criterionMasterId;
        return this;
    }

    public void setCriterionMasterId(Long criterionMasterId) {
        this.criterionMasterId = criterionMasterId;
    }

    public String getCriterionType() {
        return this.criterionType;
    }

    public TenderCriterion criterionType(String criterionType) {
        this.criterionType = criterionType;
        return this;
    }

    public void setCriterionType(String criterionType) {
        this.criterionType = criterionType;
    }

    public String getCriterionCategory() {
        return this.criterionCategory;
    }

    public TenderCriterion criterionCategory(String criterionCategory) {
        this.criterionCategory = criterionCategory;
        return this;
    }

    public void setCriterionCategory(String criterionCategory) {
        this.criterionCategory = criterionCategory;
    }

    public String getCriterionTypeOthersValue() {
        return this.criterionTypeOthersValue;
    }

    public TenderCriterion criterionTypeOthersValue(String criterionTypeOthersValue) {
        this.criterionTypeOthersValue = criterionTypeOthersValue;
        return this;
    }

    public void setCriterionTypeOthersValue(String criterionTypeOthersValue) {
        this.criterionTypeOthersValue = criterionTypeOthersValue;
    }

    public String getDescription() {
        return this.description;
    }

    public TenderCriterion description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public TenderCriterion weight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Set<TenderCriterionDocument> getTenderCriterionDocuments() {
        return this.tenderCriterionDocuments;
    }

    public TenderCriterion tenderCriterionDocuments(Set<TenderCriterionDocument> tenderCriterionDocuments) {
        this.setTenderCriterionDocuments(tenderCriterionDocuments);
        return this;
    }

    public TenderCriterion addTenderCriterionDocument(TenderCriterionDocument tenderCriterionDocument) {
        this.tenderCriterionDocuments.add(tenderCriterionDocument);
        tenderCriterionDocument.setTenderCriterion(this);
        return this;
    }

    public TenderCriterion removeTenderCriterionDocument(TenderCriterionDocument tenderCriterionDocument) {
        this.tenderCriterionDocuments.remove(tenderCriterionDocument);
        tenderCriterionDocument.setTenderCriterion(null);
        return this;
    }

    public void setTenderCriterionDocuments(Set<TenderCriterionDocument> tenderCriterionDocuments) {
        if (this.tenderCriterionDocuments != null) {
            this.tenderCriterionDocuments.forEach(i -> i.setTenderCriterion(null));
        }
        if (tenderCriterionDocuments != null) {
            tenderCriterionDocuments.forEach(i -> i.setTenderCriterion(this));
        }
        this.tenderCriterionDocuments = tenderCriterionDocuments;
    }

    public NoticeInvitingTender getNoticeInvitingTender() {
        return this.noticeInvitingTender;
    }

    public TenderCriterion noticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
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
        if (!(o instanceof TenderCriterion)) {
            return false;
        }
        return id != null && id.equals(((TenderCriterion) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderCriterion{" +
            "id=" + getId() +
            ", criterionMasterId=" + getCriterionMasterId() +
            ", criterionType='" + getCriterionType() + "'" +
            ", criterionCategory='" + getCriterionCategory() + "'" +
            ", criterionTypeOthersValue='" + getCriterionTypeOthersValue() + "'" +
            ", description='" + getDescription() + "'" +
            ", weight=" + getWeight() +
            "}";
    }
}
