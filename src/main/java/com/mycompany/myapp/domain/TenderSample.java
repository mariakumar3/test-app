package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A TenderSample.
 */
@Entity
@Table(name = "tender_sample")
public class TenderSample implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @Size(max = 30)
    @Column(name = "designation_post", length = 30)
    private String designationPost;

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

    public TenderSample id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public TenderSample name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignationPost() {
        return this.designationPost;
    }

    public TenderSample designationPost(String designationPost) {
        this.designationPost = designationPost;
        return this;
    }

    public void setDesignationPost(String designationPost) {
        this.designationPost = designationPost;
    }

    public NoticeInvitingTender getNoticeInvitingTender() {
        return this.noticeInvitingTender;
    }

    public TenderSample noticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
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
        if (!(o instanceof TenderSample)) {
            return false;
        }
        return id != null && id.equals(((TenderSample) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderSample{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", designationPost='" + getDesignationPost() + "'" +
            "}";
    }
}
