package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderObjectStore} entity.
 */
public class TenderObjectStoreDTO implements Serializable {

    private Long id;

    private Long referenceId;

    private Long referenceType;

    private Boolean activeYn;

    private NoticeInvitingTenderDTO noticeInvitingTender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public Long getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(Long referenceType) {
        this.referenceType = referenceType;
    }

    public Boolean getActiveYn() {
        return activeYn;
    }

    public void setActiveYn(Boolean activeYn) {
        this.activeYn = activeYn;
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
        if (!(o instanceof TenderObjectStoreDTO)) {
            return false;
        }

        TenderObjectStoreDTO tenderObjectStoreDTO = (TenderObjectStoreDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderObjectStoreDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderObjectStoreDTO{" +
            "id=" + getId() +
            ", referenceId=" + getReferenceId() +
            ", referenceType=" + getReferenceType() +
            ", activeYn='" + getActiveYn() + "'" +
            ", noticeInvitingTender=" + getNoticeInvitingTender() +
            "}";
    }
}
