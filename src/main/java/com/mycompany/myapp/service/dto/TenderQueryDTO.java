package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderQuery} entity.
 */
public class TenderQueryDTO implements Serializable {

    private Long id;

    private Long supplierGeneralInfoId;

    private Long serialNo;

    @Size(max = 100)
    private String referenceDocument;

    @Size(max = 100)
    private String docSectionName;

    private Integer docPageNo;

    @Lob
    private String tenderQueryText;

    private NoticeInvitingTenderDTO noticeInvitingTender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierGeneralInfoId() {
        return supplierGeneralInfoId;
    }

    public void setSupplierGeneralInfoId(Long supplierGeneralInfoId) {
        this.supplierGeneralInfoId = supplierGeneralInfoId;
    }

    public Long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    public String getReferenceDocument() {
        return referenceDocument;
    }

    public void setReferenceDocument(String referenceDocument) {
        this.referenceDocument = referenceDocument;
    }

    public String getDocSectionName() {
        return docSectionName;
    }

    public void setDocSectionName(String docSectionName) {
        this.docSectionName = docSectionName;
    }

    public Integer getDocPageNo() {
        return docPageNo;
    }

    public void setDocPageNo(Integer docPageNo) {
        this.docPageNo = docPageNo;
    }

    public String getTenderQueryText() {
        return tenderQueryText;
    }

    public void setTenderQueryText(String tenderQueryText) {
        this.tenderQueryText = tenderQueryText;
    }

    public NoticeInvitingTenderDTO getNoticeInvitingTender() {
        return noticeInvitingTender;
    }

    public void setNoticeInvitingTender(NoticeInvitingTenderDTO noticeInvitingTender) {
        this.noticeInvitingTender = noticeInvitingTender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderQueryDTO)) {
            return false;
        }

        TenderQueryDTO tenderQueryDTO = (TenderQueryDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderQueryDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderQueryDTO{" +
            "id=" + getId() +
            ", supplierGeneralInfoId=" + getSupplierGeneralInfoId() +
            ", serialNo=" + getSerialNo() +
            ", referenceDocument='" + getReferenceDocument() + "'" +
            ", docSectionName='" + getDocSectionName() + "'" +
            ", docPageNo=" + getDocPageNo() +
            ", tenderQueryText='" + getTenderQueryText() + "'" +
            ", noticeInvitingTender=" + getNoticeInvitingTender() +
            "}";
    }
}
