package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A TenderCorrigendum.
 */
@Entity
@Table(name = "tender_corrigendum")
public class TenderCorrigendum implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reason")
    private String reason;

    @Column(name = "history_order")
    private Integer historyOrder;

    @Column(name = "status")
    private String status;

    @Column(name = "tender_doc_close_date_original")
    private ZonedDateTime tenderDocCloseDateOriginal;

    @Column(name = "tender_doc_close_date_revised")
    private ZonedDateTime tenderDocCloseDateRevised;

    @Column(name = "tender_receipt_close_date_original")
    private ZonedDateTime tenderReceiptCloseDateOriginal;

    @Column(name = "tender_receipt_close_date_revised")
    private ZonedDateTime tenderReceiptCloseDateRevised;

    @Column(name = "tender_query_close_date_original")
    private ZonedDateTime tenderQueryCloseDateOriginal;

    @Column(name = "tender_query_close_date_revised")
    private ZonedDateTime tenderQueryCloseDateRevised;

    @Column(name = "technical_bid_open_date_original")
    private ZonedDateTime technicalBidOpenDateOriginal;

    @Column(name = "technical_bid_open_date_revised")
    private ZonedDateTime technicalBidOpenDateRevised;

    @Column(name = "financial_bid_open_date_original")
    private ZonedDateTime financialBidOpenDateOriginal;

    @Column(name = "financial_bid_open_date_revised")
    private ZonedDateTime financialBidOpenDateRevised;

    @Column(name = "prequal_bid_open_date_original")
    private ZonedDateTime prequalBidOpenDateOriginal;

    @Column(name = "prequal_bid_open_date_revised")
    private ZonedDateTime prequalBidOpenDateRevised;

    @Column(name = "prequal_tender_bid_open_original")
    private ZonedDateTime prequalTenderBidOpenOriginal;

    @Column(name = "prequal_tender_bid_open_revised")
    private ZonedDateTime prequalTenderBidOpenRevised;

    @Column(name = "pre_bid_meeting_date_original")
    private ZonedDateTime preBidMeetingDateOriginal;

    @Column(name = "pre_bid_meeting_date_revised")
    private ZonedDateTime preBidMeetingDateRevised;

    @Column(name = "prequal_validity_period_original")
    private ZonedDateTime prequalValidityPeriodOriginal;

    @Column(name = "prequal_validity_period_revised")
    private ZonedDateTime prequalValidityPeriodRevised;

    @Column(name = "prebid_meeting_address_original")
    private Long prebidMeetingAddressOriginal;

    @Column(name = "prebid_meeting_address_revised")
    private Long prebidMeetingAddressRevised;

    @OneToMany(mappedBy = "tenderCorrigendum")
    @JsonIgnoreProperties(value = { "tenderCorrigendum" }, allowSetters = true)
    private Set<TenderCorrigendumDetails> tenderCorrigendumDetails = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(
        value = {
            "tenderSchedule",
            "tenderObjectStores",
            "tenderGoodsItems",
            "tenderSamples",
            "tenderTechnicalParameters",
            "tenderGoodsGroups",
            "tenderCriteria",
            "tenderCriterionDocuments",
            "tenderAddenda",
            "tenderCorrigendums",
            "tenderQueries",
            "tenderScrutinyCommittees",
        },
        allowSetters = true
    )
    private NoticeInvitingTender noticeInvitingTender;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TenderCorrigendum id(Long id) {
        this.id = id;
        return this;
    }

    public String getReason() {
        return this.reason;
    }

    public TenderCorrigendum reason(String reason) {
        this.reason = reason;
        return this;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getHistoryOrder() {
        return this.historyOrder;
    }

    public TenderCorrigendum historyOrder(Integer historyOrder) {
        this.historyOrder = historyOrder;
        return this;
    }

    public void setHistoryOrder(Integer historyOrder) {
        this.historyOrder = historyOrder;
    }

    public String getStatus() {
        return this.status;
    }

    public TenderCorrigendum status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ZonedDateTime getTenderDocCloseDateOriginal() {
        return this.tenderDocCloseDateOriginal;
    }

    public TenderCorrigendum tenderDocCloseDateOriginal(ZonedDateTime tenderDocCloseDateOriginal) {
        this.tenderDocCloseDateOriginal = tenderDocCloseDateOriginal;
        return this;
    }

    public void setTenderDocCloseDateOriginal(ZonedDateTime tenderDocCloseDateOriginal) {
        this.tenderDocCloseDateOriginal = tenderDocCloseDateOriginal;
    }

    public ZonedDateTime getTenderDocCloseDateRevised() {
        return this.tenderDocCloseDateRevised;
    }

    public TenderCorrigendum tenderDocCloseDateRevised(ZonedDateTime tenderDocCloseDateRevised) {
        this.tenderDocCloseDateRevised = tenderDocCloseDateRevised;
        return this;
    }

    public void setTenderDocCloseDateRevised(ZonedDateTime tenderDocCloseDateRevised) {
        this.tenderDocCloseDateRevised = tenderDocCloseDateRevised;
    }

    public ZonedDateTime getTenderReceiptCloseDateOriginal() {
        return this.tenderReceiptCloseDateOriginal;
    }

    public TenderCorrigendum tenderReceiptCloseDateOriginal(ZonedDateTime tenderReceiptCloseDateOriginal) {
        this.tenderReceiptCloseDateOriginal = tenderReceiptCloseDateOriginal;
        return this;
    }

    public void setTenderReceiptCloseDateOriginal(ZonedDateTime tenderReceiptCloseDateOriginal) {
        this.tenderReceiptCloseDateOriginal = tenderReceiptCloseDateOriginal;
    }

    public ZonedDateTime getTenderReceiptCloseDateRevised() {
        return this.tenderReceiptCloseDateRevised;
    }

    public TenderCorrigendum tenderReceiptCloseDateRevised(ZonedDateTime tenderReceiptCloseDateRevised) {
        this.tenderReceiptCloseDateRevised = tenderReceiptCloseDateRevised;
        return this;
    }

    public void setTenderReceiptCloseDateRevised(ZonedDateTime tenderReceiptCloseDateRevised) {
        this.tenderReceiptCloseDateRevised = tenderReceiptCloseDateRevised;
    }

    public ZonedDateTime getTenderQueryCloseDateOriginal() {
        return this.tenderQueryCloseDateOriginal;
    }

    public TenderCorrigendum tenderQueryCloseDateOriginal(ZonedDateTime tenderQueryCloseDateOriginal) {
        this.tenderQueryCloseDateOriginal = tenderQueryCloseDateOriginal;
        return this;
    }

    public void setTenderQueryCloseDateOriginal(ZonedDateTime tenderQueryCloseDateOriginal) {
        this.tenderQueryCloseDateOriginal = tenderQueryCloseDateOriginal;
    }

    public ZonedDateTime getTenderQueryCloseDateRevised() {
        return this.tenderQueryCloseDateRevised;
    }

    public TenderCorrigendum tenderQueryCloseDateRevised(ZonedDateTime tenderQueryCloseDateRevised) {
        this.tenderQueryCloseDateRevised = tenderQueryCloseDateRevised;
        return this;
    }

    public void setTenderQueryCloseDateRevised(ZonedDateTime tenderQueryCloseDateRevised) {
        this.tenderQueryCloseDateRevised = tenderQueryCloseDateRevised;
    }

    public ZonedDateTime getTechnicalBidOpenDateOriginal() {
        return this.technicalBidOpenDateOriginal;
    }

    public TenderCorrigendum technicalBidOpenDateOriginal(ZonedDateTime technicalBidOpenDateOriginal) {
        this.technicalBidOpenDateOriginal = technicalBidOpenDateOriginal;
        return this;
    }

    public void setTechnicalBidOpenDateOriginal(ZonedDateTime technicalBidOpenDateOriginal) {
        this.technicalBidOpenDateOriginal = technicalBidOpenDateOriginal;
    }

    public ZonedDateTime getTechnicalBidOpenDateRevised() {
        return this.technicalBidOpenDateRevised;
    }

    public TenderCorrigendum technicalBidOpenDateRevised(ZonedDateTime technicalBidOpenDateRevised) {
        this.technicalBidOpenDateRevised = technicalBidOpenDateRevised;
        return this;
    }

    public void setTechnicalBidOpenDateRevised(ZonedDateTime technicalBidOpenDateRevised) {
        this.technicalBidOpenDateRevised = technicalBidOpenDateRevised;
    }

    public ZonedDateTime getFinancialBidOpenDateOriginal() {
        return this.financialBidOpenDateOriginal;
    }

    public TenderCorrigendum financialBidOpenDateOriginal(ZonedDateTime financialBidOpenDateOriginal) {
        this.financialBidOpenDateOriginal = financialBidOpenDateOriginal;
        return this;
    }

    public void setFinancialBidOpenDateOriginal(ZonedDateTime financialBidOpenDateOriginal) {
        this.financialBidOpenDateOriginal = financialBidOpenDateOriginal;
    }

    public ZonedDateTime getFinancialBidOpenDateRevised() {
        return this.financialBidOpenDateRevised;
    }

    public TenderCorrigendum financialBidOpenDateRevised(ZonedDateTime financialBidOpenDateRevised) {
        this.financialBidOpenDateRevised = financialBidOpenDateRevised;
        return this;
    }

    public void setFinancialBidOpenDateRevised(ZonedDateTime financialBidOpenDateRevised) {
        this.financialBidOpenDateRevised = financialBidOpenDateRevised;
    }

    public ZonedDateTime getPrequalBidOpenDateOriginal() {
        return this.prequalBidOpenDateOriginal;
    }

    public TenderCorrigendum prequalBidOpenDateOriginal(ZonedDateTime prequalBidOpenDateOriginal) {
        this.prequalBidOpenDateOriginal = prequalBidOpenDateOriginal;
        return this;
    }

    public void setPrequalBidOpenDateOriginal(ZonedDateTime prequalBidOpenDateOriginal) {
        this.prequalBidOpenDateOriginal = prequalBidOpenDateOriginal;
    }

    public ZonedDateTime getPrequalBidOpenDateRevised() {
        return this.prequalBidOpenDateRevised;
    }

    public TenderCorrigendum prequalBidOpenDateRevised(ZonedDateTime prequalBidOpenDateRevised) {
        this.prequalBidOpenDateRevised = prequalBidOpenDateRevised;
        return this;
    }

    public void setPrequalBidOpenDateRevised(ZonedDateTime prequalBidOpenDateRevised) {
        this.prequalBidOpenDateRevised = prequalBidOpenDateRevised;
    }

    public ZonedDateTime getPrequalTenderBidOpenOriginal() {
        return this.prequalTenderBidOpenOriginal;
    }

    public TenderCorrigendum prequalTenderBidOpenOriginal(ZonedDateTime prequalTenderBidOpenOriginal) {
        this.prequalTenderBidOpenOriginal = prequalTenderBidOpenOriginal;
        return this;
    }

    public void setPrequalTenderBidOpenOriginal(ZonedDateTime prequalTenderBidOpenOriginal) {
        this.prequalTenderBidOpenOriginal = prequalTenderBidOpenOriginal;
    }

    public ZonedDateTime getPrequalTenderBidOpenRevised() {
        return this.prequalTenderBidOpenRevised;
    }

    public TenderCorrigendum prequalTenderBidOpenRevised(ZonedDateTime prequalTenderBidOpenRevised) {
        this.prequalTenderBidOpenRevised = prequalTenderBidOpenRevised;
        return this;
    }

    public void setPrequalTenderBidOpenRevised(ZonedDateTime prequalTenderBidOpenRevised) {
        this.prequalTenderBidOpenRevised = prequalTenderBidOpenRevised;
    }

    public ZonedDateTime getPreBidMeetingDateOriginal() {
        return this.preBidMeetingDateOriginal;
    }

    public TenderCorrigendum preBidMeetingDateOriginal(ZonedDateTime preBidMeetingDateOriginal) {
        this.preBidMeetingDateOriginal = preBidMeetingDateOriginal;
        return this;
    }

    public void setPreBidMeetingDateOriginal(ZonedDateTime preBidMeetingDateOriginal) {
        this.preBidMeetingDateOriginal = preBidMeetingDateOriginal;
    }

    public ZonedDateTime getPreBidMeetingDateRevised() {
        return this.preBidMeetingDateRevised;
    }

    public TenderCorrigendum preBidMeetingDateRevised(ZonedDateTime preBidMeetingDateRevised) {
        this.preBidMeetingDateRevised = preBidMeetingDateRevised;
        return this;
    }

    public void setPreBidMeetingDateRevised(ZonedDateTime preBidMeetingDateRevised) {
        this.preBidMeetingDateRevised = preBidMeetingDateRevised;
    }

    public ZonedDateTime getPrequalValidityPeriodOriginal() {
        return this.prequalValidityPeriodOriginal;
    }

    public TenderCorrigendum prequalValidityPeriodOriginal(ZonedDateTime prequalValidityPeriodOriginal) {
        this.prequalValidityPeriodOriginal = prequalValidityPeriodOriginal;
        return this;
    }

    public void setPrequalValidityPeriodOriginal(ZonedDateTime prequalValidityPeriodOriginal) {
        this.prequalValidityPeriodOriginal = prequalValidityPeriodOriginal;
    }

    public ZonedDateTime getPrequalValidityPeriodRevised() {
        return this.prequalValidityPeriodRevised;
    }

    public TenderCorrigendum prequalValidityPeriodRevised(ZonedDateTime prequalValidityPeriodRevised) {
        this.prequalValidityPeriodRevised = prequalValidityPeriodRevised;
        return this;
    }

    public void setPrequalValidityPeriodRevised(ZonedDateTime prequalValidityPeriodRevised) {
        this.prequalValidityPeriodRevised = prequalValidityPeriodRevised;
    }

    public Long getPrebidMeetingAddressOriginal() {
        return this.prebidMeetingAddressOriginal;
    }

    public TenderCorrigendum prebidMeetingAddressOriginal(Long prebidMeetingAddressOriginal) {
        this.prebidMeetingAddressOriginal = prebidMeetingAddressOriginal;
        return this;
    }

    public void setPrebidMeetingAddressOriginal(Long prebidMeetingAddressOriginal) {
        this.prebidMeetingAddressOriginal = prebidMeetingAddressOriginal;
    }

    public Long getPrebidMeetingAddressRevised() {
        return this.prebidMeetingAddressRevised;
    }

    public TenderCorrigendum prebidMeetingAddressRevised(Long prebidMeetingAddressRevised) {
        this.prebidMeetingAddressRevised = prebidMeetingAddressRevised;
        return this;
    }

    public void setPrebidMeetingAddressRevised(Long prebidMeetingAddressRevised) {
        this.prebidMeetingAddressRevised = prebidMeetingAddressRevised;
    }

    public Set<TenderCorrigendumDetails> getTenderCorrigendumDetails() {
        return this.tenderCorrigendumDetails;
    }

    public TenderCorrigendum tenderCorrigendumDetails(Set<TenderCorrigendumDetails> tenderCorrigendumDetails) {
        this.setTenderCorrigendumDetails(tenderCorrigendumDetails);
        return this;
    }

    public TenderCorrigendum addTenderCorrigendumDetail(TenderCorrigendumDetails tenderCorrigendumDetails) {
        this.tenderCorrigendumDetails.add(tenderCorrigendumDetails);
        tenderCorrigendumDetails.setTenderCorrigendum(this);
        return this;
    }

    public TenderCorrigendum removeTenderCorrigendumDetail(TenderCorrigendumDetails tenderCorrigendumDetails) {
        this.tenderCorrigendumDetails.remove(tenderCorrigendumDetails);
        tenderCorrigendumDetails.setTenderCorrigendum(null);
        return this;
    }

    public void setTenderCorrigendumDetails(Set<TenderCorrigendumDetails> tenderCorrigendumDetails) {
        if (this.tenderCorrigendumDetails != null) {
            this.tenderCorrigendumDetails.forEach(i -> i.setTenderCorrigendum(null));
        }
        if (tenderCorrigendumDetails != null) {
            tenderCorrigendumDetails.forEach(i -> i.setTenderCorrigendum(this));
        }
        this.tenderCorrigendumDetails = tenderCorrigendumDetails;
    }

    public NoticeInvitingTender getNoticeInvitingTender() {
        return this.noticeInvitingTender;
    }

    public TenderCorrigendum noticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
        this.setNoticeInvitingTender(noticeInvitingTender);
        return this;
    }

    public void setNoticeInvitingTender(NoticeInvitingTender noticeInvitingTender) {
        this.noticeInvitingTender = noticeInvitingTender;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenderCorrigendum)) {
            return false;
        }
        return id != null && id.equals(((TenderCorrigendum) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenderCorrigendum{" +
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
            "}";
    }
}
