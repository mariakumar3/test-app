package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderScrutinyCommittee} entity.
 */
public class TenderScrutinyCommitteeDTO implements Serializable {

    private Long id;

    private Long staffId;

    private NoticeInvitingTenderDTO noticeInvitingTender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public NoticeInvitingTenderDTO getNoticeInvitingTender() {
        return noticeInvitingTender;
    }

    public void setNoticeInvitingTender(NoticeInvitingTenderDTO noticeInvitingTender) {
        this.noticeInvitingTender = noticeInvitingTender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderScrutinyCommitteeDTO)) {
            return false;
        }

        TenderScrutinyCommitteeDTO tenderScrutinyCommitteeDTO = (TenderScrutinyCommitteeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderScrutinyCommitteeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderScrutinyCommitteeDTO{" +
            "id=" + getId() +
            ", staffId=" + getStaffId() +
            ", noticeInvitingTender=" + getNoticeInvitingTender() +
            "}";
    }
}
