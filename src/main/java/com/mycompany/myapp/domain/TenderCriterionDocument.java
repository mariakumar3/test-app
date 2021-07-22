package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A TenderCriterionDocument.
 */
@Entity
@Table(name = "tender_criterion_document")
public class TenderCriterionDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "document_name", nullable = false)
    private String documentName;

    @NotNull
    @Column(name = "optional", nullable = false)
    private Boolean optional;

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
    @JsonIgnoreProperties(value = { "tenderCriterionDocuments", "noticeInvitingTender" }, allowSetters = true)
    private TenderCriterion tenderCriterion;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TenderCriterionDocument id(Long id) {
        this.id = id;
        return this;
    }

    public String getDocumentName() {
        return this.documentName;
    }

    public TenderCriterionDocument documentName(String documentName) {
        this.documentName = documentName;
        return this;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Boolean getOptional() {
        return this.optional;
    }

    public TenderCriterionDocument optional(Boolean optional) {
        this.optional = optional;
        return this;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public NoticeInvitingTender getNoticeInvitingTender() {
        return this.noticeInvitingTender;
    }

    public TenderCriterionDocument noticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
        this.setNoticeInvitingTender(noticeInvitingTender);
        return this;
    }

    public void setNoticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
        this.noticeInvitingTender = noticeInvitingTender;
    }

    public TenderCriterion getTenderCriterion() {
        return this.tenderCriterion;
    }

    public TenderCriterionDocument tenderCriterion(TenderCriterion tenderCriterion) {
        this.setTenderCriterion(tenderCriterion);
        return this;
    }

    public void setTenderCriterion(TenderCriterion tenderCriterion) {
        this.tenderCriterion = tenderCriterion;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderCriterionDocument)) {
            return false;
        }
        return id != null && id.equals(((TenderCriterionDocument) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderCriterionDocument{" +
            "id=" + getId() +
            ", documentName='" + getDocumentName() + "'" +
            ", optional='" + getOptional() + "'" +
            "}";
    }
}
