package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderGoodsGroup} entity.
 */
public class TenderGoodsGroupDTO implements Serializable {

    private Long id;

    private String groupName;

    private Boolean bidItemsMandatoryYn;

    private Boolean groupMandatoryYn;

    private NoticeInvitingTenderDTO noticeInvitingTender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Boolean getBidItemsMandatoryYn() {
        return bidItemsMandatoryYn;
    }

    public void setBidItemsMandatoryYn(Boolean bidItemsMandatoryYn) {
        this.bidItemsMandatoryYn = bidItemsMandatoryYn;
    }

    public Boolean getGroupMandatoryYn() {
        return groupMandatoryYn;
    }

    public void setGroupMandatoryYn(Boolean groupMandatoryYn) {
        this.groupMandatoryYn = groupMandatoryYn;
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
        if (!(o instanceof TenderGoodsGroupDTO)) {
            return false;
        }

        TenderGoodsGroupDTO tenderGoodsGroupDTO = (TenderGoodsGroupDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderGoodsGroupDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderGoodsGroupDTO{" +
            "id=" + getId() +
            ", groupName='" + getGroupName() + "'" +
            ", bidItemsMandatoryYn='" + getBidItemsMandatoryYn() + "'" +
            ", groupMandatoryYn='" + getGroupMandatoryYn() + "'" +
            ", noticeInvitingTender=" + getNoticeInvitingTender() +
            "}";
    }
}
