package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A TenderSchedule.
 */
@Entity
@Table(name = "tender_schedule")
public class TenderSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "tender_number", length = 50)
    private String tenderNumber;

    @Size(max = 512)
    @Column(name = "title", length = 512)
    private String title;

    @Size(max = 50)
    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "category")
    private Integer category;

    @Column(name = "ecv", precision = 21, scale = 2)
    private BigDecimal ecv;

    @Column(name = "indent_id")
    private Long indentId;

    @Column(name = "dept_id")
    private Long deptId;

    @Size(max = 25)
    @Column(name = "status", length = 25)
    private String status;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "parent_tender_ref")
    private Integer parentTenderRef;

    @Column(name = "no_of_calls")
    private Integer noOfCalls;

    @Column(name = "process_id")
    private Integer processId;

    @Column(name = "csr_value", precision = 21, scale = 2)
    private BigDecimal csrValue;

    @Column(name = "ecvtendery_yn")
    private Boolean ecvtenderyYn;

    @Column(name = "certificate_id")
    private Integer certificateId;

    @Column(name = "payments_verified")
    private Integer paymentsVerified;

    @Column(name = "dts_approval_date")
    private ZonedDateTime dtsApprovalDate;

    @Column(name = "mandatory_clause")
    private String mandatoryClause;

    @Column(name = "location")
    private Integer location;

    @Column(name = "delegate_to")
    private Integer delegateTo;

    @Column(name = "is_approved_by_self")
    private Integer isApprovedBySelf;

    @Size(max = 255)
    @Column(name = "cat_work_category_name", length = 255)
    private String catWorkCategoryName;

    @Size(max = 25)
    @Column(name = "negotiation_status", length = 25)
    private String negotiationStatus;

    @Column(name = "manual_tender_yn")
    private Boolean manualTenderYn;

    @Column(name = "district_id")
    private Long districtId;

    @Size(max = 50)
    @Column(name = "draft_publish_status", length = 50)
    private String draftPublishStatus;

    @Column(name = "csr_remarks")
    private String csrRemarks;

    @Column(name = "proc_entity_type")
    private Integer procEntityType;

    @Size(max = 175)
    @Column(name = "dts_approved_by", length = 175)
    private String dtsApprovedBy;

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
    @OneToOne(mappedBy = "tenderSchedule")
    private NoticeInvitingTender noticeInvitingTender;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TenderSchedule id(Long id) {
        this.id = id;
        return this;
    }

    public String getTenderNumber() {
        return this.tenderNumber;
    }

    public TenderSchedule tenderNumber(String tenderNumber) {
        this.tenderNumber = tenderNumber;
        return this;
    }

    public void setTenderNumber(String tenderNumber) {
        this.tenderNumber = tenderNumber;
    }

    public String getTitle() {
        return this.title;
    }

    public TenderSchedule title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public TenderSchedule description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategory() {
        return this.category;
    }

    public TenderSchedule category(Integer category) {
        this.category = category;
        return this;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public BigDecimal getEcv() {
        return this.ecv;
    }

    public TenderSchedule ecv(BigDecimal ecv) {
        this.ecv = ecv;
        return this;
    }

    public void setEcv(BigDecimal ecv) {
        this.ecv = ecv;
    }

    public Long getIndentId() {
        return this.indentId;
    }

    public TenderSchedule indentId(Long indentId) {
        this.indentId = indentId;
        return this;
    }

    public void setIndentId(Long indentId) {
        this.indentId = indentId;
    }

    public Long getDeptId() {
        return this.deptId;
    }

    public TenderSchedule deptId(Long deptId) {
        this.deptId = deptId;
        return this;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getStatus() {
        return this.status;
    }

    public TenderSchedule status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public TenderSchedule remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getParentTenderRef() {
        return this.parentTenderRef;
    }

    public TenderSchedule parentTenderRef(Integer parentTenderRef) {
        this.parentTenderRef = parentTenderRef;
        return this;
    }

    public void setParentTenderRef(Integer parentTenderRef) {
        this.parentTenderRef = parentTenderRef;
    }

    public Integer getNoOfCalls() {
        return this.noOfCalls;
    }

    public TenderSchedule noOfCalls(Integer noOfCalls) {
        this.noOfCalls = noOfCalls;
        return this;
    }

    public void setNoOfCalls(Integer noOfCalls) {
        this.noOfCalls = noOfCalls;
    }

    public Integer getProcessId() {
        return this.processId;
    }

    public TenderSchedule processId(Integer processId) {
        this.processId = processId;
        return this;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public BigDecimal getCsrValue() {
        return this.csrValue;
    }

    public TenderSchedule csrValue(BigDecimal csrValue) {
        this.csrValue = csrValue;
        return this;
    }

    public void setCsrValue(BigDecimal csrValue) {
        this.csrValue = csrValue;
    }

    public Boolean getEcvtenderyYn() {
        return this.ecvtenderyYn;
    }

    public TenderSchedule ecvtenderyYn(Boolean ecvtenderyYn) {
        this.ecvtenderyYn = ecvtenderyYn;
        return this;
    }

    public void setEcvtenderyYn(Boolean ecvtenderyYn) {
        this.ecvtenderyYn = ecvtenderyYn;
    }

    public Integer getCertificateId() {
        return this.certificateId;
    }

    public TenderSchedule certificateId(Integer certificateId) {
        this.certificateId = certificateId;
        return this;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    public Integer getPaymentsVerified() {
        return this.paymentsVerified;
    }

    public TenderSchedule paymentsVerified(Integer paymentsVerified) {
        this.paymentsVerified = paymentsVerified;
        return this;
    }

    public void setPaymentsVerified(Integer paymentsVerified) {
        this.paymentsVerified = paymentsVerified;
    }

    public ZonedDateTime getDtsApprovalDate() {
        return this.dtsApprovalDate;
    }

    public TenderSchedule dtsApprovalDate(ZonedDateTime dtsApprovalDate) {
        this.dtsApprovalDate = dtsApprovalDate;
        return this;
    }

    public void setDtsApprovalDate(ZonedDateTime dtsApprovalDate) {
        this.dtsApprovalDate = dtsApprovalDate;
    }

    public String getMandatoryClause() {
        return this.mandatoryClause;
    }

    public TenderSchedule mandatoryClause(String mandatoryClause) {
        this.mandatoryClause = mandatoryClause;
        return this;
    }

    public void setMandatoryClause(String mandatoryClause) {
        this.mandatoryClause = mandatoryClause;
    }

    public Integer getLocation() {
        return this.location;
    }

    public TenderSchedule location(Integer location) {
        this.location = location;
        return this;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getDelegateTo() {
        return this.delegateTo;
    }

    public TenderSchedule delegateTo(Integer delegateTo) {
        this.delegateTo = delegateTo;
        return this;
    }

    public void setDelegateTo(Integer delegateTo) {
        this.delegateTo = delegateTo;
    }

    public Integer getIsApprovedBySelf() {
        return this.isApprovedBySelf;
    }

    public TenderSchedule isApprovedBySelf(Integer isApprovedBySelf) {
        this.isApprovedBySelf = isApprovedBySelf;
        return this;
    }

    public void setIsApprovedBySelf(Integer isApprovedBySelf) {
        this.isApprovedBySelf = isApprovedBySelf;
    }

    public String getCatWorkCategoryName() {
        return this.catWorkCategoryName;
    }

    public TenderSchedule catWorkCategoryName(String catWorkCategoryName) {
        this.catWorkCategoryName = catWorkCategoryName;
        return this;
    }

    public void setCatWorkCategoryName(String catWorkCategoryName) {
        this.catWorkCategoryName = catWorkCategoryName;
    }

    public String getNegotiationStatus() {
        return this.negotiationStatus;
    }

    public TenderSchedule negotiationStatus(String negotiationStatus) {
        this.negotiationStatus = negotiationStatus;
        return this;
    }

    public void setNegotiationStatus(String negotiationStatus) {
        this.negotiationStatus = negotiationStatus;
    }

    public Boolean getManualTenderYn() {
        return this.manualTenderYn;
    }

    public TenderSchedule manualTenderYn(Boolean manualTenderYn) {
        this.manualTenderYn = manualTenderYn;
        return this;
    }

    public void setManualTenderYn(Boolean manualTenderYn) {
        this.manualTenderYn = manualTenderYn;
    }

    public Long getDistrictId() {
        return this.districtId;
    }

    public TenderSchedule districtId(Long districtId) {
        this.districtId = districtId;
        return this;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDraftPublishStatus() {
        return this.draftPublishStatus;
    }

    public TenderSchedule draftPublishStatus(String draftPublishStatus) {
        this.draftPublishStatus = draftPublishStatus;
        return this;
    }

    public void setDraftPublishStatus(String draftPublishStatus) {
        this.draftPublishStatus = draftPublishStatus;
    }

    public String getCsrRemarks() {
        return this.csrRemarks;
    }

    public TenderSchedule csrRemarks(String csrRemarks) {
        this.csrRemarks = csrRemarks;
        return this;
    }

    public void setCsrRemarks(String csrRemarks) {
        this.csrRemarks = csrRemarks;
    }

    public Integer getProcEntityType() {
        return this.procEntityType;
    }

    public TenderSchedule procEntityType(Integer procEntityType) {
        this.procEntityType = procEntityType;
        return this;
    }

    public void setProcEntityType(Integer procEntityType) {
        this.procEntityType = procEntityType;
    }

    public String getDtsApprovedBy() {
        return this.dtsApprovedBy;
    }

    public TenderSchedule dtsApprovedBy(String dtsApprovedBy) {
        this.dtsApprovedBy = dtsApprovedBy;
        return this;
    }

    public void setDtsApprovedBy(String dtsApprovedBy) {
        this.dtsApprovedBy = dtsApprovedBy;
    }

    public NoticeInvitingTender getNoticeInvitingTender() {
        return this.noticeInvitingTender;
    }

    public TenderSchedule noticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
        this.setNoticeInvitingTender(noticeInvitingTender);
        return this;
    }

    public void setNoticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
        if (this.noticeInvitingTender != null) {
            this.noticeInvitingTender.setTenderSchedule(null);
        }
        if (noticeInvitingTender != null) {
            noticeInvitingTender.setTenderSchedule(this);
        }
        this.noticeInvitingTender = noticeInvitingTender;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderSchedule)) {
            return false;
        }
        return id != null && id.equals(((TenderSchedule) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderSchedule{" +
            "id=" + getId() +
            ", tenderNumber='" + getTenderNumber() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", category=" + getCategory() +
            ", ecv=" + getEcv() +
            ", indentId=" + getIndentId() +
            ", deptId=" + getDeptId() +
            ", status='" + getStatus() + "'" +
            ", remarks='" + getRemarks() + "'" +
            ", parentTenderRef=" + getParentTenderRef() +
            ", noOfCalls=" + getNoOfCalls() +
            ", processId=" + getProcessId() +
            ", csrValue=" + getCsrValue() +
            ", ecvtenderyYn='" + getEcvtenderyYn() + "'" +
            ", certificateId=" + getCertificateId() +
            ", paymentsVerified=" + getPaymentsVerified() +
            ", dtsApprovalDate='" + getDtsApprovalDate() + "'" +
            ", mandatoryClause='" + getMandatoryClause() + "'" +
            ", location=" + getLocation() +
            ", delegateTo=" + getDelegateTo() +
            ", isApprovedBySelf=" + getIsApprovedBySelf() +
            ", catWorkCategoryName='" + getCatWorkCategoryName() + "'" +
            ", negotiationStatus='" + getNegotiationStatus() + "'" +
            ", manualTenderYn='" + getManualTenderYn() + "'" +
            ", districtId=" + getDistrictId() +
            ", draftPublishStatus='" + getDraftPublishStatus() + "'" +
            ", csrRemarks='" + getCsrRemarks() + "'" +
            ", procEntityType=" + getProcEntityType() +
            ", dtsApprovedBy='" + getDtsApprovedBy() + "'" +
            "}";
    }
}
