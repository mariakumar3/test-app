package com.mycompany.myapp.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * A CriterionDocumentMaster.
 */
@Entity
@Table(name = "criterion_document_master")
public class CriterionDocumentMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document_name")
    private String documentName;

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

    public CriterionDocumentMaster id(Long id) {
        this.id = id;
        return this;
    }

    public String getDocumentName() {
        return this.documentName;
    }

    public CriterionDocumentMaster documentName(String documentName) {
        this.documentName = documentName;
        return this;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getTenderCategory() {
        return this.tenderCategory;
    }

    public CriterionDocumentMaster tenderCategory(String tenderCategory) {
        this.tenderCategory = tenderCategory;
        return this;
    }

    public void setTenderCategory(String tenderCategory) {
        this.tenderCategory = tenderCategory;
    }

    public Boolean getActiveYn() {
        return this.activeYn;
    }

    public CriterionDocumentMaster activeYn(Boolean activeYn) {
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
        if (!(o instanceof CriterionDocumentMaster)) {
            return false;
        }
        return id != null && id.equals(((CriterionDocumentMaster) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CriterionDocumentMaster{" +
            "id=" + getId() +
            ", documentName='" + getDocumentName() + "'" +
            ", tenderCategory='" + getTenderCategory() + "'" +
            ", activeYn='" + getActiveYn() + "'" +
            "}";
    }
}
