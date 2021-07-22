package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TenderCorrigendum} entity.
 */
public class TenderCorrigendumDTO implements Serializable {

    private Long id;

    private String reason;

    private Integer historyOrder;

    private String status;

    private ZonedDateTime tenderDocCloseDateOriginal;

    private ZonedDateTime tenderDocCloseDateRevised;

    private ZonedDateTime tenderReceiptCloseDateOriginal;

    private ZonedDateTime tenderReceiptCloseDateRevised;

    private ZonedDateTime tenderQueryCloseDateOriginal;

    private ZonedDateTime tenderQueryCloseDateRevised;

    private ZonedDateTime technicalBidOpenDateOriginal;

    private ZonedDateTime technicalBidOpenDateRevised;

    private ZonedDateTime financialBidOpenDateOriginal;

    private ZonedDateTime financialBidOpenDateRevised;

    private ZonedDateTime prequalBidOpenDateOriginal;

    private ZonedDateTime prequalBidOpenDateRevised;

    private ZonedDateTime prequalTenderBidOpenOriginal;

    private ZonedDateTime prequalTenderBidOpenRevised;

    private ZonedDateTime preBidMeetingDateOriginal;

    private ZonedDateTime preBidMeetingDateRevised;

    private ZonedDateTime prequalValidityPeriodOriginal;

    private ZonedDateTime prequalValidityPeriodRevised;

    private Long prebidMeetingAddressOriginal;

    private Long prebidMeetingAddressRevised;

    private NoticeInvitingTenderDTO noticeInvitingTender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getHistoryOrder() {
        return historyOrder;
    }

    public void setHistoryOrder(Integer historyOrder) {
        this.historyOrder = historyOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ZonedDateTime getTenderDocCloseDateOriginal() {
        return tenderDocCloseDateOriginal;
    }

    public void setTenderDocCloseDateOriginal(ZonedDateTime tenderDocCloseDateOriginal) {
        this.tenderDocCloseDateOriginal = tenderDocCloseDateOriginal;
    }

    public ZonedDateTime getTenderDocCloseDateRevised() {
        return tenderDocCloseDateRevised;
    }

    public void setTenderDocCloseDateRevised(ZonedDateTime tenderDocCloseDateRevised) {
        this.tenderDocCloseDateRevised = tenderDocCloseDateRevised;
    }

    public ZonedDateTime getTenderReceiptCloseDateOriginal() {
        return tenderReceiptCloseDateOriginal;
    }

    public void setTenderReceiptCloseDateOriginal(ZonedDateTime tenderReceiptCloseDateOriginal) {
        this.tenderReceiptCloseDateOriginal = tenderReceiptCloseDateOriginal;
    }

    public ZonedDateTime getTenderReceiptCloseDateRevised() {
        return tenderReceiptCloseDateRevised;
    }

    public void setTenderReceiptCloseDateRevised(ZonedDateTime tenderReceiptCloseDateRevised) {
        this.tenderReceiptCloseDateRevised = tenderReceiptCloseDateRevised;
    }

    public ZonedDateTime getTenderQueryCloseDateOriginal() {
        return tenderQueryCloseDateOriginal;
    }

    public void setTenderQueryCloseDateOriginal(ZonedDateTime tenderQueryCloseDateOriginal) {
        this.tenderQueryCloseDateOriginal = tenderQueryCloseDateOriginal;
    }

    public ZonedDateTime getTenderQueryCloseDateRevised() {
        return tenderQueryCloseDateRevised;
    }

    public void setTenderQueryCloseDateRevised(ZonedDateTime tenderQueryCloseDateRevised) {
        this.tenderQueryCloseDateRevised = tenderQueryCloseDateRevised;
    }

    public ZonedDateTime getTechnicalBidOpenDateOriginal() {
        return technicalBidOpenDateOriginal;
    }

    public void setTechnicalBidOpenDateOriginal(ZonedDateTime technicalBidOpenDateOriginal) {
        this.technicalBidOpenDateOriginal = technicalBidOpenDateOriginal;
    }

    public ZonedDateTime getTechnicalBidOpenDateRevised() {
        return technicalBidOpenDateRevised;
    }

    public void setTechnicalBidOpenDateRevised(ZonedDateTime technicalBidOpenDateRevised) {
        this.technicalBidOpenDateRevised = technicalBidOpenDateRevised;
    }

    public ZonedDateTime getFinancialBidOpenDateOriginal() {
        return financialBidOpenDateOriginal;
    }

    public void setFinancialBidOpenDateOriginal(ZonedDateTime financialBidOpenDateOriginal) {
        this.financialBidOpenDateOriginal = financialBidOpenDateOriginal;
    }

    public ZonedDateTime getFinancialBidOpenDateRevised() {
        return financialBidOpenDateRevised;
    }

    public void setFinancialBidOpenDateRevised(ZonedDateTime financialBidOpenDateRevised) {
        this.financialBidOpenDateRevised = financialBidOpenDateRevised;
    }

    public ZonedDateTime getPrequalBidOpenDateOriginal() {
        return prequalBidOpenDateOriginal;
    }

    public void setPrequalBidOpenDateOriginal(ZonedDateTime prequalBidOpenDateOriginal) {
        this.prequalBidOpenDateOriginal = prequalBidOpenDateOriginal;
    }

    public ZonedDateTime getPrequalBidOpenDateRevised() {
        return prequalBidOpenDateRevised;
    }

    public void setPrequalBidOpenDateRevised(ZonedDateTime prequalBidOpenDateRevised) {
        this.prequalBidOpenDateRevised = prequalBidOpenDateRevised;
    }

    public ZonedDateTime getPrequalTenderBidOpenOriginal() {
        return prequalTenderBidOpenOriginal;
    }

    public void setPrequalTenderBidOpenOriginal(ZonedDateTime prequalTenderBidOpenOriginal) {
        this.prequalTenderBidOpenOriginal = prequalTenderBidOpenOriginal;
    }

    public ZonedDateTime getPrequalTenderBidOpenRevised() {
        return prequalTenderBidOpenRevised;
    }

    public void setPrequalTenderBidOpenRevised(ZonedDateTime prequalTenderBidOpenRevised) {
        this.prequalTenderBidOpenRevised = prequalTenderBidOpenRevised;
    }

    public ZonedDateTime getPreBidMeetingDateOriginal() {
        return preBidMeetingDateOriginal;
    }

    public void setPreBidMeetingDateOriginal(ZonedDateTime preBidMeetingDateOriginal) {
        this.preBidMeetingDateOriginal = preBidMeetingDateOriginal;
    }

    public ZonedDateTime getPreBidMeetingDateRevised() {
        return preBidMeetingDateRevised;
    }

    public void setPreBidMeetingDateRevised(ZonedDateTime preBidMeetingDateRevised) {
        this.preBidMeetingDateRevised = preBidMeetingDateRevised;
    }

    public ZonedDateTime getPrequalValidityPeriodOriginal() {
        return prequalValidityPeriodOriginal;
    }

    public void setPrequalValidityPeriodOriginal(ZonedDateTime prequalValidityPeriodOriginal) {
        this.prequalValidityPeriodOriginal = prequalValidityPeriodOriginal;
    }

    public ZonedDateTime getPrequalValidityPeriodRevised() {
        return prequalValidityPeriodRevised;
    }

    public void setPrequalValidityPeriodRevised(ZonedDateTime prequalValidityPeriodRevised) {
        this.prequalValidityPeriodRevised = prequalValidityPeriodRevised;
    }

    public Long getPrebidMeetingAddressOriginal() {
        return prebidMeetingAddressOriginal;
    }

    public void setPrebidMeetingAddressOriginal(Long prebidMeetingAddressOriginal) {
        this.prebidMeetingAddressOriginal = prebidMeetingAddressOriginal;
    }

    public Long getPrebidMeetingAddressRevised() {
        return prebidMeetingAddressRevised;
    }

    public void setPrebidMeetingAddressRevised(Long prebidMeetingAddressRevised) {
        this.prebidMeetingAddressRevised = prebidMeetingAddressRevised;
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
        if (!(o instanceof TenderCorrigendumDTO)) {
            return false;
        }

        TenderCorrigendumDTO tenderCorrigendumDTO = (TenderCorrigendumDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenderCorrigendumDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderCorrigendumDTO{" +
            "id=" + getId() +
            ", reason='" + getReason() + "'" +
            ", historyOrder=" + getHistoryOrder() +
            ", status='" + getStatus() + "'" +
            ", tenderDocCloseDateOriginal='" + getTenderDocCloseDateOriginal() + "'" +
            ", tenderDocCloseDateRevised='" + getTenderDocCloseDateRevised() + "'" +
            ", tenderReceiptCloseDateOriginal='" + getTenderReceiptCloseDateOriginal() + "'" +
            ", tenderReceiptCloseDateRevised='" + getTenderReceiptCloseDateRevised() + "'" +
            ", tenderQueryCloseDateOriginal='" + getTenderQueryCloseDateOriginal() + "'" +
            ", tenderQueryCloseDateRevised='" + getTenderQueryCloseDateRevised() + "'" +
            ", technicalBidOpenDateOriginal='" + getTechnicalBidOpenDateOriginal() + "'" +
            ", technicalBidOpenDateRevised='" + getTechnicalBidOpenDateRevised() + "'" +
            ", financialBidOpenDateOriginal='" + getFinancialBidOpenDateOriginal() + "'" +
            ", financialBidOpenDateRevised='" + getFinancialBidOpenDateRevised() + "'" +
            ", prequalBidOpenDateOriginal='" + getPrequalBidOpenDateOriginal() + "'" +
            ", prequalBidOpenDateRevised='" + getPrequalBidOpenDateRevised() + "'" +
            ", prequalTenderBidOpenOriginal='" + getPrequalTenderBidOpenOriginal() + "'" +
            ", prequalTenderBidOpenRevised='" + getPrequalTenderBidOpenRevised() + "'" +
            ", preBidMeetingDateOriginal='" + getPreBidMeetingDateOriginal() + "'" +
            ", preBidMeetingDateRevised='" + getPreBidMeetingDateRevised() + "'" +
            ", prequalValidityPeriodOriginal='" + getPrequalValidityPeriodOriginal() + "'" +
            ", prequalValidityPeriodRevised='" + getPrequalValidityPeriodRevised() + "'" +
            ", prebidMeetingAddressOriginal=" + getPrebidMeetingAddressOriginal() +
            ", prebidMeetingAddressRevised=" + getPrebidMeetingAddressRevised() +
            ", noticeInvitingTender=" + getNoticeInvitingTender() +
            "}";
    }
}
