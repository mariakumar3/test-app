package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderScrutinyMaster} entity.
 */
public class TenderScrutinyMasterDTO implements Serializable {

    private Long id;

    private String value;

    private Integer maxUsers;

    private Integer minUsers;

    private Boolean activeYn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    public Integer getMinUsers() {
        return minUsers;
    }

    public void setMinUsers(Integer minUsers) {
        this.minUsers = minUsers;
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
        if (!(o instanceof TenderScrutinyMasterDTO)) {
            return false;
        }

        TenderScrutinyMasterDTO tenderScrutinyMasterDTO = (TenderScrutinyMasterDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderScrutinyMasterDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderScrutinyMasterDTO{" +
            "id=" + getId() +
            ", value='" + getValue() + "'" +
            ", maxUsers=" + getMaxUsers() +
            ", minUsers=" + getMinUsers() +
            ", activeYn='" + getActiveYn() + "'" +
            "}";
    }
}
