package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderCriterionDocument} entity.
 */
public class TenderCriterionDocumentDTO implements Serializable {

    private Long id;

    @NotNull
    private String documentName;

    @NotNull
    private Boolean optional;

    private NoticeInvitingTenderDTO noticeInvitingTender;

    private TenderCriterionDTO tenderCriterion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public NoticeInvitingTenderDTO getNoticeInvitingTender() {
        return noticeInvitingTender;
    }

    public void setNoticeInvitingTender(NoticeInvitingTenderDTO noticeInvitingTender) {
        this.noticeInvitingTender = noticeInvitingTender;
    }

    public TenderCriterionDTO getTenderCriterion() {
        return tenderCriterion;
    }

    public void setTenderCriterion(TenderCriterionDTO tenderCriterion) {
        this.tenderCriterion = tenderCriterion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderCriterionDocumentDTO)) {
            return false;
        }

        TenderCriterionDocumentDTO tenderCriterionDocumentDTO = (TenderCriterionDocumentDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderCriterionDocumentDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderCriterionDocumentDTO{" +
            "id=" + getId() +
            ", documentName='" + getDocumentName() + "'" +
            ", optional='" + getOptional() + "'" +
            ", noticeInvitingTender=" + getNoticeInvitingTender() +
            ", tenderCriterion=" + getTenderCriterion() +
            "}";
    }
}
