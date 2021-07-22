package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderTechnicalParameter} entity.
 */
public class TenderTechnicalParameterDTO implements Serializable {

    private Long id;

    private Long tenderCriterionId;

    @Size(max = 50)
    private String name;

    @Size(max = 255)
    private String description;

    private BigDecimal minValue;

    private BigDecimal maxValue;

    private String operator;

    private String dataType;

    private Boolean optionalYn;

    private NoticeInvitingTenderDTO noticeInvitingTender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenderCriterionId() {
        return tenderCriterionId;
    }

    public void setTenderCriterionId(Long tenderCriterionId) {
        this.tenderCriterionId = tenderCriterionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMinValue() {
        return minValue;
    }

    public void setMinValue(BigDecimal minValue) {
        this.minValue = minValue;
    }

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Boolean getOptionalYn() {
        return optionalYn;
    }

    public void setOptionalYn(Boolean optionalYn) {
        this.optionalYn = optionalYn;
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
        if (!(o instanceof TenderTechnicalParameterDTO)) {
            return false;
        }

        TenderTechnicalParameterDTO tenderTechnicalParameterDTO = (TenderTechnicalParameterDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderTechnicalParameterDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderTechnicalParameterDTO{" +
            "id=" + getId() +
            ", tenderCriterionId=" + getTenderCriterionId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", minValue=" + getMinValue() +
            ", maxValue=" + getMaxValue() +
            ", operator='" + getOperator() + "'" +
            ", dataType='" + getDataType() + "'" +
            ", optionalYn='" + getOptionalYn() + "'" +
            ", noticeInvitingTender=" + getNoticeInvitingTender() +
            "}";
    }
}
