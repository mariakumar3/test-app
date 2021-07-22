package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.CriterionDocumentMaster} entity.
 */
public class CriterionDocumentMasterDTO implements Serializable {

    private Long id;

    private String documentName;

    private String tenderCategory;

    private Boolean activeYn;

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
        if (!(o instanceof CriterionDocumentMasterDTO)) {
            return false;
        }

        CriterionDocumentMasterDTO criterionDocumentMasterDTO = (CriterionDocumentMasterDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, criterionDocumentMasterDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CriterionDocumentMasterDTO{" +
            "id=" + getId() +
            ", documentName='" + getDocumentName() + "'" +
            ", tenderCategory='" + getTenderCategory() + "'" +
            ", activeYn='" + getActiveYn() + "'" +
            "}";
    }
}
