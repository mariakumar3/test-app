package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderQueryResponse} entity.
 */
public class TenderQueryResponseDTO implements Serializable {

    private Long id;

    private Long staffGeneralInfoId;

    @Lob
    private String tenderQueryResponse;

    private TenderQueryDTO tenderQuery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStaffGeneralInfoId() {
        return staffGeneralInfoId;
    }

    public void setStaffGeneralInfoId(Long staffGeneralInfoId) {
        this.staffGeneralInfoId = staffGeneralInfoId;
    }

    public String getTenderQueryResponse() {
        return tenderQueryResponse;
    }

    public void setTenderQueryResponse(String tenderQueryResponse) {
        this.tenderQueryResponse = tenderQueryResponse;
    }

    public TenderQueryDTO getTenderQuery() {
        return tenderQuery;
    }

    public void setTenderQuery(TenderQueryDTO tenderQuery) {
        this.tenderQuery = tenderQuery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderQueryResponseDTO)) {
            return false;
        }

        TenderQueryResponseDTO tenderQueryResponseDTO = (TenderQueryResponseDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderQueryResponseDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderQueryResponseDTO{" +
            "id=" + getId() +
            ", staffGeneralInfoId=" + getStaffGeneralInfoId() +
            ", tenderQueryResponse='" + getTenderQueryResponse() + "'" +
            ", tenderQuery=" + getTenderQuery() +
            "}";
    }
}
