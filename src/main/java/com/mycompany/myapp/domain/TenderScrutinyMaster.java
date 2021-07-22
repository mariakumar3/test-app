package com.mycompany.myapp.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * A TenderScrutinyMaster.
 */
@Entity
@Table(name = "tender_scrutiny_master")
public class TenderScrutinyMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private String value;

    @Column(name = "max_users")
    private Integer maxUsers;

    @Column(name = "min_users")
    private Integer minUsers;

    @Column(name = "active_yn")
    private Boolean activeYn;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TenderScrutinyMaster id(Long id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return this.value;
    }

    public TenderScrutinyMaster value(String value) {
        this.value = value;
        return this;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getMaxUsers() {
        return this.maxUsers;
    }

    public TenderScrutinyMaster maxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
        return this;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    public Integer getMinUsers() {
        return this.minUsers;
    }

    public TenderScrutinyMaster minUsers(Integer minUsers) {
        this.minUsers = minUsers;
        return this;
    }

    public void setMinUsers(Integer minUsers) {
        this.minUsers = minUsers;
    }

    public Boolean getActiveYn() {
        return this.activeYn;
    }

    public TenderScrutinyMaster activeYn(Boolean activeYn) {
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
        if (!(o instanceof TenderScrutinyMaster)) {
            return false;
        }
        return id != null && id.equals(((TenderScrutinyMaster) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderScrutinyMaster{" +
            "id=" + getId() +
            ", value='" + getValue() + "'" +
            ", maxUsers=" + getMaxUsers() +
            ", minUsers=" + getMinUsers() +
            ", activeYn='" + getActiveYn() + "'" +
            "}";
    }
}
