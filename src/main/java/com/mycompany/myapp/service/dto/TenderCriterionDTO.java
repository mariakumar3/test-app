package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderCriterion} entity.
 */
public class TenderCriterionDTO implements Serializable {

    private Long id;

    private Long criterionMasterId;

    private String criterionType;

    private String criterionCategory;

    private String criterionTypeOthersValue;

    private String description;

    private Integer weight;

    private NoticeInvitingTenderDTO noticeInvitingTender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCriterionMasterId() {
        return criterionMasterId;
    }

    public void setCriterionMasterId(Long criterionMasterId) {
        this.criterionMasterId = criterionMasterId;
    }

    public String getCriterionType() {
        return criterionType;
    }

    public void setCriterionType(String criterionType) {
        this.criterionType = criterionType;
    }

    public String getCriterionCategory() {
        return criterionCategory;
    }

    public void setCriterionCategory(String criterionCategory) {
        this.criterionCategory = criterionCategory;
    }

    public String getCriterionTypeOthersValue() {
        return criterionTypeOthersValue;
    }

    public void setCriterionTypeOthersValue(String criterionTypeOthersValue) {
        this.criterionTypeOthersValue = criterionTypeOthersValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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
        if (!(o instanceof TenderCriterionDTO)) {
            return false;
        }

        TenderCriterionDTO tenderCriterionDTO = (TenderCriterionDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderCriterionDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderCriterionDTO{" +
            "id=" + getId() +
            ", criterionMasterId=" + getCriterionMasterId() +
            ", criterionType='" + getCriterionType() + "'" +
            ", criterionCategory='" + getCriterionCategory() + "'" +
            ", criterionTypeOthersValue='" + getCriterionTypeOthersValue() + "'" +
            ", description='" + getDescription() + "'" +
            ", weight=" + getWeight() +
            ", noticeInvitingTender=" + getNoticeInvitingTender() +
            "}";
    }
}
