package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderSample} entity.
 */
public class TenderSampleDTO implements Serializable {

    private Long id;

    @Size(max = 50)
    private String name;

    @Size(max = 30)
    private String designationPost;

    private NoticeInvitingTenderDTO noticeInvitingTender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignationPost() {
        return designationPost;
    }

    public void setDesignationPost(String designationPost) {
        this.designationPost = designationPost;
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
        if (!(o instanceof TenderSampleDTO)) {
            return false;
        }

        TenderSampleDTO tenderSampleDTO = (TenderSampleDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderSampleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderSampleDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", designationPost='" + getDesignationPost() + "'" +
            ", noticeInvitingTender=" + getNoticeInvitingTender() +
            "}";
    }
}
