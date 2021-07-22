package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

/**
 * A TenderQueryResponse.
 */
@Entity
@Table(name = "tender_query_response")
public class TenderQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_general_info_id")
    private Long staffGeneralInfoId;

    @Lob
    @Column(name = "tender_query_response")
    private String tenderQueryResponse;

    @ManyToOne
    @JsonIgnoreProperties(value = { "tenderQueryResponses", "noticeInvitingTender" }, allowSetters = true)
    private TenderQuery tenderQuery;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TenderQueryResponse id(Long id) {
        this.id = id;
        return this;
    }

    public Long getStaffGeneralInfoId() {
        return this.staffGeneralInfoId;
    }

    public TenderQueryResponse staffGeneralInfoId(Long staffGeneralInfoId) {
        this.staffGeneralInfoId = staffGeneralInfoId;
        return this;
    }

    public void setStaffGeneralInfoId(Long staffGeneralInfoId) {
        this.staffGeneralInfoId = staffGeneralInfoId;
    }

    public String getTenderQueryResponse() {
        return this.tenderQueryResponse;
    }

    public TenderQueryResponse tenderQueryResponse(String tenderQueryResponse) {
        this.tenderQueryResponse = tenderQueryResponse;
        return this;
    }

    public void setTenderQueryResponse(String tenderQueryResponse) {
        this.tenderQueryResponse = tenderQueryResponse;
    }

    public TenderQuery getTenderQuery() {
        return this.tenderQuery;
    }

    public TenderQueryResponse tenderQuery(TenderQuery tenderQuery) {
        this.setTenderQuery(tenderQuery);
        return this;
    }

    public void setTenderQuery(TenderQuery tenderQuery) {
        this.tenderQuery = tenderQuery;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderQueryResponse)) {
            return false;
        }
        return id != null && id.equals(((TenderQueryResponse) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderQueryResponse{" +
            "id=" + getId() +
            ", staffGeneralInfoId=" + getStaffGeneralInfoId() +
            ", tenderQueryResponse='" + getTenderQueryResponse() + "'" +
            "}";
    }
}
