package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

/**
 * A TenderCorrigendumDetails.
 */
@Entity
@Table(name = "tender_corrigendum_details")
public class TenderCorrigendumDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "read_as")
    private String readAs;

    @ManyToOne
    @JsonIgnoreProperties(value = { "tenderCorrigendumDetails", "noticeInvitingTender" }, allowSetters = true)
    private TenderCorrigendum tenderCorrigendum;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TenderCorrigendumDetails id(Long id) {
        this.id = id;
        return this;
    }

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public TenderCorrigendumDetails referenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getReadAs() {
        return this.readAs;
    }

    public TenderCorrigendumDetails readAs(String readAs) {
        this.readAs = readAs;
        return this;
    }

    public void setReadAs(String readAs) {
        this.readAs = readAs;
    }

    public TenderCorrigendum getTenderCorrigendum() {
        return this.tenderCorrigendum;
    }

    public TenderCorrigendumDetails tenderCorrigendum(TenderCorrigendum tenderCorrigendum) {
        this.setTenderCorrigendum(tenderCorrigendum);
        return this;
    }

    public void setTenderCorrigendum(TenderCorrigendum tenderCorrigendum) {
        this.tenderCorrigendum = tenderCorrigendum;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderCorrigendumDetails)) {
            return false;
        }
        return id != null && id.equals(((TenderCorrigendumDetails) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderCorrigendumDetails{" +
            "id=" + getId() +
            ", referenceNumber='" + getReferenceNumber() + "'" +
            ", readAs='" + getReadAs() + "'" +
            "}";
    }
}
