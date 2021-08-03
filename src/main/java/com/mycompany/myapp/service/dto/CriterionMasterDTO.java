package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.CriterionMaster} entity.
 */
public class CriterionMasterDTO implements Serializable {

    private Long id;

    private String type;

    private String criterionType;

    private Long documentName;

    private String description;

    private String tenderCategory;

    private Boolean activeYn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCriterionType() {
        return criterionType;
    }

    public void setCriterionType(String criterionType) {
        this.criterionType = criterionType;
    }

    public Long getDocumentName() {
        return documentName;
    }

    public void setDocumentName(Long documentName) {
        this.documentName = documentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTenderCategory() {
        return tenderCategory;
    }

    public void setTenderCategory(String tenderCategory) {
        this.tenderCategory = tenderCategory;
    }

    public Boolean getActiveYn() {
        return activeYn;
    }

    public void setActiveYn(Boolean activeYn) {
        this.activeYn = activeYn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CriterionMasterDTO)) {
            return false;
        }

        CriterionMasterDTO criterionMasterDTO = (CriterionMasterDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, criterionMasterDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CriterionMasterDTO{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", criterionType='" + getCriterionType() + "'" +
            ", documentName=" + getDocumentName() +
            ", description='" + getDescription() + "'" +
            ", tenderCategory='" + getTenderCategory() + "'" +
            ", activeYn='" + getActiveYn() + "'" +
            "}";
    }
}
