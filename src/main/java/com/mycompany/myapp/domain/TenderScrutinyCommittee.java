package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

/**
 * A TenderScrutinyCommittee.
 */
@Entity
@Table(name = "tender_scrutiny_committee")
public class TenderScrutinyCommittee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_id")
    private Long staffId;

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

    public TenderScrutinyCommittee id(Long id) {
        this.id = id;
        return this;
    }

    public Long getStaffId() {
        return this.staffId;
    }

    public TenderScrutinyCommittee staffId(Long staffId) {
        this.staffId = staffId;
        return this;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public NoticeInvitingTender getNoticeInvitingTender() {
        return this.noticeInvitingTender;
    }

    public TenderScrutinyCommittee noticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
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
        if (!(o instanceof TenderScrutinyCommittee)) {
            return false;
        }
        return id != null && id.equals(((TenderScrutinyCommittee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderScrutinyCommittee{" +
            "id=" + getId() +
            ", staffId=" + getStaffId() +
            "}";
    }
}
