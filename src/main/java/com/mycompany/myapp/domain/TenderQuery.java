package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A TenderQuery.
 */
@Entity
@Table(name = "tender_query")
public class TenderQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_general_info_id")
    private Long supplierGeneralInfoId;

    @Column(name = "serial_no")
    private Long serialNo;

    @Size(max = 100)
    @Column(name = "reference_document", length = 100)
    private String referenceDocument;

    @Size(max = 100)
    @Column(name = "doc_section_name", length = 100)
    private String docSectionName;

    @Column(name = "doc_page_no")
    private Integer docPageNo;

    @Lob
    @Column(name = "tender_query_text")
    private String tenderQueryText;

    @OneToMany(mappedBy = "tenderQuery")
    @JsonIgnoreProperties(value = { "tenderQuery" }, allowSetters = true)
    private Set<TenderQueryResponse> tenderQueryResponses = new HashSet<>();

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

    public TenderQuery id(Long id) {
        this.id = id;
        return this;
    }

    public Long getSupplierGeneralInfoId() {
        return this.supplierGeneralInfoId;
    }

    public TenderQuery supplierGeneralInfoId(Long supplierGeneralInfoId) {
        this.supplierGeneralInfoId = supplierGeneralInfoId;
        return this;
    }

    public void setSupplierGeneralInfoId(Long supplierGeneralInfoId) {
        this.supplierGeneralInfoId = supplierGeneralInfoId;
    }

    public Long getSerialNo() {
        return this.serialNo;
    }

    public TenderQuery serialNo(Long serialNo) {
        this.serialNo = serialNo;
        return this;
    }

    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    public String getReferenceDocument() {
        return this.referenceDocument;
    }

    public TenderQuery referenceDocument(String referenceDocument) {
        this.referenceDocument = referenceDocument;
        return this;
    }

    public void setReferenceDocument(String referenceDocument) {
        this.referenceDocument = referenceDocument;
    }

    public String getDocSectionName() {
        return this.docSectionName;
    }

    public TenderQuery docSectionName(String docSectionName) {
        this.docSectionName = docSectionName;
        return this;
    }

    public void setDocSectionName(String docSectionName) {
        this.docSectionName = docSectionName;
    }

    public Integer getDocPageNo() {
        return this.docPageNo;
    }

    public TenderQuery docPageNo(Integer docPageNo) {
        this.docPageNo = docPageNo;
        return this;
    }

    public void setDocPageNo(Integer docPageNo) {
        this.docPageNo = docPageNo;
    }

    public String getTenderQueryText() {
        return this.tenderQueryText;
    }

    public TenderQuery tenderQueryText(String tenderQueryText) {
        this.tenderQueryText = tenderQueryText;
        return this;
    }

    public void setTenderQueryText(String tenderQueryText) {
        this.tenderQueryText = tenderQueryText;
    }

    public Set<TenderQueryResponse> getTenderQueryResponses() {
        return this.tenderQueryResponses;
    }

    public TenderQuery tenderQueryResponses(Set<TenderQueryResponse> tenderQueryResponses) {
        this.setTenderQueryResponses(tenderQueryResponses);
        return this;
    }

    public TenderQuery addTenderQueryResponse(TenderQueryResponse tenderQueryResponse) {
        this.tenderQueryResponses.add(tenderQueryResponse);
        tenderQueryResponse.setTenderQuery(this);
        return this;
    }

    public TenderQuery removeTenderQueryResponse(TenderQueryResponse tenderQueryResponse) {
        this.tenderQueryResponses.remove(tenderQueryResponse);
        tenderQueryResponse.setTenderQuery(null);
        return this;
    }

    public void setTenderQueryResponses(Set<TenderQueryResponse> tenderQueryResponses) {
        if (this.tenderQueryResponses != null) {
            this.tenderQueryResponses.forEach(i -> i.setTenderQuery(null));
        }
        if (tenderQueryResponses != null) {
            tenderQueryResponses.forEach(i -> i.setTenderQuery(this));
        }
        this.tenderQueryResponses = tenderQueryResponses;
    }

    public NoticeInvitingTender getNoticeInvitingTender() {
        return this.noticeInvitingTender;
    }

    public TenderQuery noticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
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
        if (!(o instanceof TenderQuery)) {
            return false;
        }
        return id != null && id.equals(((TenderQuery) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderQuery{" +
            "id=" + getId() +
            ", supplierGeneralInfoId=" + getSupplierGeneralInfoId() +
            ", serialNo=" + getSerialNo() +
            ", referenceDocument='" + getReferenceDocument() + "'" +
            ", docSectionName='" + getDocSectionName() + "'" +
            ", docPageNo=" + getDocPageNo() +
            ", tenderQueryText='" + getTenderQueryText() + "'" +
            "}";
    }
}
