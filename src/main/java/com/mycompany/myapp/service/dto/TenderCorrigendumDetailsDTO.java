package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderCorrigendumDetails} entity.
 */
public class TenderCorrigendumDetailsDTO implements Serializable {

    private Long id;

    private String referenceNumber;

    private String readAs;

    private TenderCorrigendumDTO tenderCorrigendum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getReadAs() {
        return readAs;
    }

    public void setReadAs(String readAs) {
        this.readAs = readAs;
    }

    public TenderCorrigendumDTO getTenderCorrigendum() {
        return tenderCorrigendum;
    }

    public void setTenderCorrigendum(TenderCorrigendumDTO tenderCorrigendum) {
        this.tenderCorrigendum = tenderCorrigendum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderCorrigendumDetailsDTO)) {
            return false;
        }

        TenderCorrigendumDetailsDTO tenderCorrigendumDetailsDTO = (TenderCorrigendumDetailsDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderCorrigendumDetailsDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderCorrigendumDetailsDTO{" +
            "id=" + getId() +
            ", referenceNumber='" + getReferenceNumber() + "'" +
            ", readAs='" + getReadAs() + "'" +
            ", tenderCorrigendum=" + getTenderCorrigendum() +
            "}";
    }
}
