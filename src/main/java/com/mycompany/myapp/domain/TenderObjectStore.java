package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

/**
 * A TenderObjectStore.
 */
@Entity
@Table(name = "tender_object_store")
public class TenderObjectStore implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference_id")
    private Long referenceId;

    @Column(name = "reference_type")
    private Long referenceType;

    @Column(name = "active_yn")
    private Boolean activeYn;

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

    public TenderObjectStore id(Long id) {
        this.id = id;
        return this;
    }

    public Long getReferenceId() {
        return this.referenceId;
    }

    public TenderObjectStore referenceId(Long referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public Long getReferenceType() {
        return this.referenceType;
    }

    public TenderObjectStore referenceType(Long referenceType) {
        this.referenceType = referenceType;
        return this;
    }

    public void setReferenceType(Long referenceType) {
        this.referenceType = referenceType;
    }

    public Boolean getActiveYn() {
        return this.activeYn;
    }

    public TenderObjectStore activeYn(Boolean activeYn) {
        this.activeYn = activeYn;
        return this;
    }

    public void setActiveYn(Boolean activeYn) {
        this.activeYn = activeYn;
    }

    public NoticeInvitingTender getNoticeInvitingTender() {
        return this.noticeInvitingTender;
    }

    public TenderObjectStore noticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
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
        if (!(o instanceof TenderObjectStore)) {
            return false;
        }
        return id != null && id.equals(((TenderObjectStore) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderObjectStore{" +
            "id=" + getId() +
            ", referenceId=" + getReferenceId() +
            ", referenceType=" + getReferenceType() +
            ", activeYn='" + getActiveYn() + "'" +
            "}";
    }
}
