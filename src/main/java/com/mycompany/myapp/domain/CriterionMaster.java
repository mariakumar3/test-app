package com.mycompany.myapp.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * A CriterionMaster.
 */
@Entity
@Table(name = "criterion_master")
public class CriterionMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "criterion_type")
    private String criterionType;

    @Column(name = "document_name")
    private Long documentName;

    @Column(name = "description")
    private String description;

    @Column(name = "tender_category")
    private String tenderCategory;

    @Column(name = "active_yn")
    private Boolean activeYn;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CriterionMaster id(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public CriterionMaster type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCriterionType() {
        return this.criterionType;
    }

    public CriterionMaster criterionType(String criterionType) {
        this.criterionType = criterionType;
        return this;
    }

    public void setCriterionType(String criterionType) {
        this.criterionType = criterionType;
    }

    public Long getDocumentName() {
        return this.documentName;
    }

    public CriterionMaster documentName(Long documentName) {
        this.documentName = documentName;
        return this;
    }

    public void setDocumentName(Long documentName) {
        this.documentName = documentName;
    }

    public String getDescription() {
        return this.description;
    }

    public CriterionMaster description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTenderCategory() {
        return this.tenderCategory;
    }

    public CriterionMaster tenderCategory(String tenderCategory) {
        this.tenderCategory = tenderCategory;
        return this;
    }

    public void setTenderCategory(String tenderCategory) {
        this.tenderCategory = tenderCategory;
    }

    public Boolean getActiveYn() {
        return this.activeYn;
    }

    public CriterionMaster activeYn(Boolean activeYn) {
        this.activeYn = activeYn;
        return this;
    }

    public void setActiveYn(Boolean activeYn) {
        this.activeYn = activeYn;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CriterionMaster)) {
            return false;
        }
        return id != null && id.equals(((CriterionMaster) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CriterionMaster{" +
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
