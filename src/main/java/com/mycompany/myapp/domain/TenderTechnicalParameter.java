package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A TenderTechnicalParameter.
 */
@Entity
@Table(name = "tender_technical_parameter")
public class TenderTechnicalParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tender_criterion_id")
    private Long tenderCriterionId;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "min_value", precision = 21, scale = 2)
    private BigDecimal minValue;

    @Column(name = "max_value", precision = 21, scale = 2)
    private BigDecimal maxValue;

    @Column(name = "operator")
    private String operator;

    @Column(name = "data_type")
    private String dataType;

    @Column(name = "optional_yn")
    private Boolean optionalYn;

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

    public TenderTechnicalParameter id(Long id) {
        this.id = id;
        return this;
    }

    public Long getTenderCriterionId() {
        return this.tenderCriterionId;
    }

    public TenderTechnicalParameter tenderCriterionId(Long tenderCriterionId) {
        this.tenderCriterionId = tenderCriterionId;
        return this;
    }

    public void setTenderCriterionId(Long tenderCriterionId) {
        this.tenderCriterionId = tenderCriterionId;
    }

    public String getName() {
        return this.name;
    }

    public TenderTechnicalParameter name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public TenderTechnicalParameter description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMinValue() {
        return this.minValue;
    }

    public TenderTechnicalParameter minValue(BigDecimal minValue) {
        this.minValue = minValue;
        return this;
    }

    public void setMinValue(BigDecimal minValue) {
        this.minValue = minValue;
    }

    public BigDecimal getMaxValue() {
        return this.maxValue;
    }

    public TenderTechnicalParameter maxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    public void setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public String getOperator() {
        return this.operator;
    }

    public TenderTechnicalParameter operator(String operator) {
        this.operator = operator;
        return this;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDataType() {
        return this.dataType;
    }

    public TenderTechnicalParameter dataType(String dataType) {
        this.dataType = dataType;
        return this;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Boolean getOptionalYn() {
        return this.optionalYn;
    }

    public TenderTechnicalParameter optionalYn(Boolean optionalYn) {
        this.optionalYn = optionalYn;
        return this;
    }

    public void setOptionalYn(Boolean optionalYn) {
        this.optionalYn = optionalYn;
    }

    public NoticeInvitingTender getNoticeInvitingTender() {
        return this.noticeInvitingTender;
    }

    public TenderTechnicalParameter noticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
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
        if (!(o instanceof TenderTechnicalParameter)) {
            return false;
        }
        return id != null && id.equals(((TenderTechnicalParameter) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderTechnicalParameter{" +
            "id=" + getId() +
            ", tenderCriterionId=" + getTenderCriterionId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", minValue=" + getMinValue() +
            ", maxValue=" + getMaxValue() +
            ", operator='" + getOperator() + "'" +
            ", dataType='" + getDataType() + "'" +
            ", optionalYn='" + getOptionalYn() + "'" +
            "}";
    }
}
