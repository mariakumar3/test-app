package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.NoticeInvitingTender} entity.
 */
public class NoticeInvitingTenderDTO implements Serializable {

    private Long id;

    private Integer evaluationType;

    private ZonedDateTime prequalValidityPeriod;

    private Boolean invitingStrategy;

    private Integer minNoBidsReceive;

    private Integer procuringEntity;

    private Integer procuringEntityDesignation;

    private Integer procuringEntityAddress;

    private Integer invitingAuthority;

    private Integer invitingAuthorityDesignation;

    private Integer invitingAuthorityAddress;

    private Boolean participatingCondnYn;

    private BigDecimal tenderFee;

    private BigDecimal emd;

    private Boolean bidValueType;

    private Integer techWeightage;

    private ZonedDateTime prequalTenderBidOpen;

    private ZonedDateTime tenderDocClose;

    private ZonedDateTime tenderReceiptClose;

    private ZonedDateTime tenderQueryClose;

    private ZonedDateTime technicalBidOpen;

    private ZonedDateTime financialBidOpen;

    private ZonedDateTime publishedDate;

    private Integer publishedBy;

    private ZonedDateTime recalledDate;

    private Integer recalledBy;

    private ZonedDateTime bidSubmissionStartDate;

    private Integer bidValidityPeriod;

    private Integer noOfCalls;

    private ZonedDateTime preBidMeetingDate;

    private Boolean preBidMeetingYn;

    private Integer prebidMeetingAddress;

    private ZonedDateTime preQualificationBidOpen;

    private Boolean mandateAllItemsYn;

    private Boolean queriesPublished;

    private String denominationType;

    private Boolean retenderedYn;

    private String percentageRateType;

    private String contactPerson;

    private Boolean splitEmdYn;

    private BigDecimal emdBankGuarantee;

    private BigDecimal emdCash;

    private Integer bgValidityPeriod;

    private Boolean hideWeightage;

    private Boolean itemwiseTechEvalYn;

    private Boolean isMultipleSupplierSelectionAllowed;

    private ZonedDateTime techEvalStartDate;

    private ZonedDateTime techEvalEndDate;

    private ZonedDateTime commEvalStartDate;

    private ZonedDateTime commEvalEndDate;

    private ZonedDateTime emdVerifiedDate;

    private Boolean multipleCurrencySelectionAllowedYn;

    private Boolean isEditable;

    private Boolean isEvaluated;

    private Boolean isTechWeightageAllowed;

    private Boolean isTechWeightageCompleted;

    private Boolean isCommercialBidEditCompleted;

    private Boolean templateYn;

    private Long templateId;

    private Integer paymentVerifiedBy;

    private ZonedDateTime paymentVerifiedDate;

    private Boolean isItemwiseCsr;

    private Boolean isBidViewEnabled;

    private Boolean isNegotiation;

    private Boolean highestBidderSelection;

    private Boolean isVariableEmdAllowed;

    private Integer nitPublisherCertId;

    private Boolean autoExtendYn;

    private Integer noOfDaysExtend;

    private Boolean isExtensionAvailable;

    private Boolean specialSchemeTender;

    private Boolean isBidValidityExpiryTaskCreated;

    private Boolean evaluationTypeFlag;

    private Boolean qcbsTenderYn;

    private String publishedUser;

    private Boolean isWorldBankFunded;

    private String ecClearanceNumber;

    private ZonedDateTime ecClearanceDate;

    private TenderScheduleDTO tenderSchedule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(Integer evaluationType) {
        this.evaluationType = evaluationType;
    }

    public ZonedDateTime getPrequalValidityPeriod() {
        return prequalValidityPeriod;
    }

    public void setPrequalValidityPeriod(ZonedDateTime prequalValidityPeriod) {
        this.prequalValidityPeriod = prequalValidityPeriod;
    }

    public Boolean getInvitingStrategy() {
        return invitingStrategy;
    }

    public void setInvitingStrategy(Boolean invitingStrategy) {
        this.invitingStrategy = invitingStrategy;
    }

    public Integer getMinNoBidsReceive() {
        return minNoBidsReceive;
    }

    public void setMinNoBidsReceive(Integer minNoBidsReceive) {
        this.minNoBidsReceive = minNoBidsReceive;
    }

    public Integer getProcuringEntity() {
        return procuringEntity;
    }

    public void setProcuringEntity(Integer procuringEntity) {
        this.procuringEntity = procuringEntity;
    }

    public Integer getProcuringEntityDesignation() {
        return procuringEntityDesignation;
    }

    public void setProcuringEntityDesignation(Integer procuringEntityDesignation) {
        this.procuringEntityDesignation = procuringEntityDesignation;
    }

    public Integer getProcuringEntityAddress() {
        return procuringEntityAddress;
    }

    public void setProcuringEntityAddress(Integer procuringEntityAddress) {
        this.procuringEntityAddress = procuringEntityAddress;
    }

    public Integer getInvitingAuthority() {
        return invitingAuthority;
    }

    public void setInvitingAuthority(Integer invitingAuthority) {
        this.invitingAuthority = invitingAuthority;
    }

    public Integer getInvitingAuthorityDesignation() {
        return invitingAuthorityDesignation;
    }

    public void setInvitingAuthorityDesignation(Integer invitingAuthorityDesignation) {
        this.invitingAuthorityDesignation = invitingAuthorityDesignation;
    }

    public Integer getInvitingAuthorityAddress() {
        return invitingAuthorityAddress;
    }

    public void setInvitingAuthorityAddress(Integer invitingAuthorityAddress) {
        this.invitingAuthorityAddress = invitingAuthorityAddress;
    }

    public Boolean getParticipatingCondnYn() {
        return participatingCondnYn;
    }

    public void setParticipatingCondnYn(Boolean participatingCondnYn) {
        this.participatingCondnYn = participatingCondnYn;
    }

    public BigDecimal getTenderFee() {
        return tenderFee;
    }

    public void setTenderFee(BigDecimal tenderFee) {
        this.tenderFee = tenderFee;
    }

    public BigDecimal getEmd() {
        return emd;
    }

    public void setEmd(BigDecimal emd) {
        this.emd = emd;
    }

    public Boolean getBidValueType() {
        return bidValueType;
    }

    public void setBidValueType(Boolean bidValueType) {
        this.bidValueType = bidValueType;
    }

    public Integer getTechWeightage() {
        return techWeightage;
    }

    public void setTechWeightage(Integer techWeightage) {
        this.techWeightage = techWeightage;
    }

    public ZonedDateTime getPrequalTenderBidOpen() {
        return prequalTenderBidOpen;
    }

    public void setPrequalTenderBidOpen(ZonedDateTime prequalTenderBidOpen) {
        this.prequalTenderBidOpen = prequalTenderBidOpen;
    }

    public ZonedDateTime getTenderDocClose() {
        return tenderDocClose;
    }

    public void setTenderDocClose(ZonedDateTime tenderDocClose) {
        this.tenderDocClose = tenderDocClose;
    }

    public ZonedDateTime getTenderReceiptClose() {
        return tenderReceiptClose;
    }

    public void setTenderReceiptClose(ZonedDateTime tenderReceiptClose) {
        this.tenderReceiptClose = tenderReceiptClose;
    }

    public ZonedDateTime getTenderQueryClose() {
        return tenderQueryClose;
    }

    public void setTenderQueryClose(ZonedDateTime tenderQueryClose) {
        this.tenderQueryClose = tenderQueryClose;
    }

    public ZonedDateTime getTechnicalBidOpen() {
        return technicalBidOpen;
    }

    public void setTechnicalBidOpen(ZonedDateTime technicalBidOpen) {
        this.technicalBidOpen = technicalBidOpen;
    }

    public ZonedDateTime getFinancialBidOpen() {
        return financialBidOpen;
    }

    public void setFinancialBidOpen(ZonedDateTime financialBidOpen) {
        this.financialBidOpen = financialBidOpen;
    }

    public ZonedDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(ZonedDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(Integer publishedBy) {
        this.publishedBy = publishedBy;
    }

    public ZonedDateTime getRecalledDate() {
        return recalledDate;
    }

    public void setRecalledDate(ZonedDateTime recalledDate) {
        this.recalledDate = recalledDate;
    }

    public Integer getRecalledBy() {
        return recalledBy;
    }

    public void setRecalledBy(Integer recalledBy) {
        this.recalledBy = recalledBy;
    }

    public ZonedDateTime getBidSubmissionStartDate() {
        return bidSubmissionStartDate;
    }

    public void setBidSubmissionStartDate(ZonedDateTime bidSubmissionStartDate) {
        this.bidSubmissionStartDate = bidSubmissionStartDate;
    }

    public Integer getBidValidityPeriod() {
        return bidValidityPeriod;
    }

    public void setBidValidityPeriod(Integer bidValidityPeriod) {
        this.bidValidityPeriod = bidValidityPeriod;
    }

    public Integer getNoOfCalls() {
        return noOfCalls;
    }

    public void setNoOfCalls(Integer noOfCalls) {
        this.noOfCalls = noOfCalls;
    }

    public ZonedDateTime getPreBidMeetingDate() {
        return preBidMeetingDate;
    }

    public void setPreBidMeetingDate(ZonedDateTime preBidMeetingDate) {
        this.preBidMeetingDate = preBidMeetingDate;
    }

    public Boolean getPreBidMeetingYn() {
        return preBidMeetingYn;
    }

    public void setPreBidMeetingYn(Boolean preBidMeetingYn) {
        this.preBidMeetingYn = preBidMeetingYn;
    }

    public Integer getPrebidMeetingAddress() {
        return prebidMeetingAddress;
    }

    public void setPrebidMeetingAddress(Integer prebidMeetingAddress) {
        this.prebidMeetingAddress = prebidMeetingAddress;
    }

    public ZonedDateTime getPreQualificationBidOpen() {
        return preQualificationBidOpen;
    }

    public void setPreQualificationBidOpen(ZonedDateTime preQualificationBidOpen) {
        this.preQualificationBidOpen = preQualificationBidOpen;
    }

    public Boolean getMandateAllItemsYn() {
        return mandateAllItemsYn;
    }

    public void setMandateAllItemsYn(Boolean mandateAllItemsYn) {
        this.mandateAllItemsYn = mandateAllItemsYn;
    }

    public Boolean getQueriesPublished() {
        return queriesPublished;
    }

    public void setQueriesPublished(Boolean queriesPublished) {
        this.queriesPublished = queriesPublished;
    }

    public String getDenominationType() {
        return denominationType;
    }

    public void setDenominationType(String denominationType) {
        this.denominationType = denominationType;
    }

    public Boolean getRetenderedYn() {
        return retenderedYn;
    }

    public void setRetenderedYn(Boolean retenderedYn) {
        this.retenderedYn = retenderedYn;
    }

    public String getPercentageRateType() {
        return percentageRateType;
    }

    public void setPercentageRateType(String percentageRateType) {
        this.percentageRateType = percentageRateType;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Boolean getSplitEmdYn() {
        return splitEmdYn;
    }

    public void setSplitEmdYn(Boolean splitEmdYn) {
        this.splitEmdYn = splitEmdYn;
    }

    public BigDecimal getEmdBankGuarantee() {
        return emdBankGuarantee;
    }

    public void setEmdBankGuarantee(BigDecimal emdBankGuarantee) {
        this.emdBankGuarantee = emdBankGuarantee;
    }

    public BigDecimal getEmdCash() {
        return emdCash;
    }

    public void setEmdCash(BigDecimal emdCash) {
        this.emdCash = emdCash;
    }

    public Integer getBgValidityPeriod() {
        return bgValidityPeriod;
    }

    public void setBgValidityPeriod(Integer bgValidityPeriod) {
        this.bgValidityPeriod = bgValidityPeriod;
    }

    public Boolean getHideWeightage() {
        return hideWeightage;
    }

    public void setHideWeightage(Boolean hideWeightage) {
        this.hideWeightage = hideWeightage;
    }

    public Boolean getItemwiseTechEvalYn() {
        return itemwiseTechEvalYn;
    }

    public void setItemwiseTechEvalYn(Boolean itemwiseTechEvalYn) {
        this.itemwiseTechEvalYn = itemwiseTechEvalYn;
    }

    public Boolean getIsMultipleSupplierSelectionAllowed() {
        return isMultipleSupplierSelectionAllowed;
    }

    public void setIsMultipleSupplierSelectionAllowed(Boolean isMultipleSupplierSelectionAllowed) {
        this.isMultipleSupplierSelectionAllowed = isMultipleSupplierSelectionAllowed;
    }

    public ZonedDateTime getTechEvalStartDate() {
        return techEvalStartDate;
    }

    public void setTechEvalStartDate(ZonedDateTime techEvalStartDate) {
        this.techEvalStartDate = techEvalStartDate;
    }

    public ZonedDateTime getTechEvalEndDate() {
        return techEvalEndDate;
    }

    public void setTechEvalEndDate(ZonedDateTime techEvalEndDate) {
        this.techEvalEndDate = techEvalEndDate;
    }

    public ZonedDateTime getCommEvalStartDate() {
        return commEvalStartDate;
    }

    public void setCommEvalStartDate(ZonedDateTime commEvalStartDate) {
        this.commEvalStartDate = commEvalStartDate;
    }

    public ZonedDateTime getCommEvalEndDate() {
        return commEvalEndDate;
    }

    public void setCommEvalEndDate(ZonedDateTime commEvalEndDate) {
        this.commEvalEndDate = commEvalEndDate;
    }

    public ZonedDateTime getEmdVerifiedDate() {
        return emdVerifiedDate;
    }

    public void setEmdVerifiedDate(ZonedDateTime emdVerifiedDate) {
        this.emdVerifiedDate = emdVerifiedDate;
    }

    public Boolean getMultipleCurrencySelectionAllowedYn() {
        return multipleCurrencySelectionAllowedYn;
    }

    public void setMultipleCurrencySelectionAllowedYn(Boolean multipleCurrencySelectionAllowedYn) {
        this.multipleCurrencySelectionAllowedYn = multipleCurrencySelectionAllowedYn;
    }

    public Boolean getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(Boolean isEditable) {
        this.isEditable = isEditable;
    }

    public Boolean getIsEvaluated() {
        return isEvaluated;
    }

    public void setIsEvaluated(Boolean isEvaluated) {
        this.isEvaluated = isEvaluated;
    }

    public Boolean getIsTechWeightageAllowed() {
        return isTechWeightageAllowed;
    }

    public void setIsTechWeightageAllowed(Boolean isTechWeightageAllowed) {
        this.isTechWeightageAllowed = isTechWeightageAllowed;
    }

    public Boolean getIsTechWeightageCompleted() {
        return isTechWeightageCompleted;
    }

    public void setIsTechWeightageCompleted(Boolean isTechWeightageCompleted) {
        this.isTechWeightageCompleted = isTechWeightageCompleted;
    }

    public Boolean getIsCommercialBidEditCompleted() {
        return isCommercialBidEditCompleted;
    }

    public void setIsCommercialBidEditCompleted(Boolean isCommercialBidEditCompleted) {
        this.isCommercialBidEditCompleted = isCommercialBidEditCompleted;
    }

    public Boolean getTemplateYn() {
        return templateYn;
    }

    public void setTemplateYn(Boolean templateYn) {
        this.templateYn = templateYn;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Integer getPaymentVerifiedBy() {
        return paymentVerifiedBy;
    }

    public void setPaymentVerifiedBy(Integer paymentVerifiedBy) {
        this.paymentVerifiedBy = paymentVerifiedBy;
    }

    public ZonedDateTime getPaymentVerifiedDate() {
        return paymentVerifiedDate;
    }

    public void setPaymentVerifiedDate(ZonedDateTime paymentVerifiedDate) {
        this.paymentVerifiedDate = paymentVerifiedDate;
    }

    public Boolean getIsItemwiseCsr() {
        return isItemwiseCsr;
    }

    public void setIsItemwiseCsr(Boolean isItemwiseCsr) {
        this.isItemwiseCsr = isItemwiseCsr;
    }

    public Boolean getIsBidViewEnabled() {
        return isBidViewEnabled;
    }

    public void setIsBidViewEnabled(Boolean isBidViewEnabled) {
        this.isBidViewEnabled = isBidViewEnabled;
    }

    public Boolean getIsNegotiation() {
        return isNegotiation;
    }

    public void setIsNegotiation(Boolean isNegotiation) {
        this.isNegotiation = isNegotiation;
    }

    public Boolean getHighestBidderSelection() {
        return highestBidderSelection;
    }

    public void setHighestBidderSelection(Boolean highestBidderSelection) {
        this.highestBidderSelection = highestBidderSelection;
    }

    public Boolean getIsVariableEmdAllowed() {
        return isVariableEmdAllowed;
    }

    public void setIsVariableEmdAllowed(Boolean isVariableEmdAllowed) {
        this.isVariableEmdAllowed = isVariableEmdAllowed;
    }

    public Integer getNitPublisherCertId() {
        return nitPublisherCertId;
    }

    public void setNitPublisherCertId(Integer nitPublisherCertId) {
        this.nitPublisherCertId = nitPublisherCertId;
    }

    public Boolean getAutoExtendYn() {
        return autoExtendYn;
    }

    public void setAutoExtendYn(Boolean autoExtendYn) {
        this.autoExtendYn = autoExtendYn;
    }

    public Integer getNoOfDaysExtend() {
        return noOfDaysExtend;
    }

    public void setNoOfDaysExtend(Integer noOfDaysExtend) {
        this.noOfDaysExtend = noOfDaysExtend;
    }

    public Boolean getIsExtensionAvailable() {
        return isExtensionAvailable;
    }

    public void setIsExtensionAvailable(Boolean isExtensionAvailable) {
        this.isExtensionAvailable = isExtensionAvailable;
    }

    public Boolean getSpecialSchemeTender() {
        return specialSchemeTender;
    }

    public void setSpecialSchemeTender(Boolean specialSchemeTender) {
        this.specialSchemeTender = specialSchemeTender;
    }

    public Boolean getIsBidValidityExpiryTaskCreated() {
        return isBidValidityExpiryTaskCreated;
    }

    public void setIsBidValidityExpiryTaskCreated(Boolean isBidValidityExpiryTaskCreated) {
        this.isBidValidityExpiryTaskCreated = isBidValidityExpiryTaskCreated;
    }

    public Boolean getEvaluationTypeFlag() {
        return evaluationTypeFlag;
    }

    public void setEvaluationTypeFlag(Boolean evaluationTypeFlag) {
        this.evaluationTypeFlag = evaluationTypeFlag;
    }

    public Boolean getQcbsTenderYn() {
        return qcbsTenderYn;
    }

    public void setQcbsTenderYn(Boolean qcbsTenderYn) {
        this.qcbsTenderYn = qcbsTenderYn;
    }

    public String getPublishedUser() {
        return publishedUser;
    }

    public void setPublishedUser(String publishedUser) {
        this.publishedUser = publishedUser;
    }

    public Boolean getIsWorldBankFunded() {
        return isWorldBankFunded;
    }

    public void setIsWorldBankFunded(Boolean isWorldBankFunded) {
        this.isWorldBankFunded = isWorldBankFunded;
    }

    public String getEcClearanceNumber() {
        return ecClearanceNumber;
    }

    public void setEcClearanceNumber(String ecClearanceNumber) {
        this.ecClearanceNumber = ecClearanceNumber;
    }

    public ZonedDateTime getEcClearanceDate() {
        return ecClearanceDate;
    }

    public void setEcClearanceDate(ZonedDateTime ecClearanceDate) {
        this.ecClearanceDate = ecClearanceDate;
    }

    public TenderScheduleDTO getTenderSchedule() {
        return tenderSchedule;
    }

    public void setTenderSchedule(TenderScheduleDTO tenderSchedule) {
        this.tenderSchedule = tenderSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NoticeInvitingTenderDTO)) {
            return false;
        }

        NoticeInvitingTenderDTO noticeInvitingTenderDTO = (NoticeInvitingTenderDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, noticeInvitingTenderDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NoticeInvitingTenderDTO{" +
            "id=" + getId() +
            ", evaluationType=" + getEvaluationType() +
            ", prequalValidityPeriod='" + getPrequalValidityPeriod() + "'" +
            ", invitingStrategy='" + getInvitingStrategy() + "'" +
            ", minNoBidsReceive=" + getMinNoBidsReceive() +
            ", procuringEntity=" + getProcuringEntity() +
            ", procuringEntityDesignation=" + getProcuringEntityDesignation() +
            ", procuringEntityAddress=" + getProcuringEntityAddress() +
            ", invitingAuthority=" + getInvitingAuthority() +
            ", invitingAuthorityDesignation=" + getInvitingAuthorityDesignation() +
            ", invitingAuthorityAddress=" + getInvitingAuthorityAddress() +
            ", participatingCondnYn='" + getParticipatingCondnYn() + "'" +
            ", tenderFee=" + getTenderFee() +
            ", emd=" + getEmd() +
            ", bidValueType='" + getBidValueType() + "'" +
            ", techWeightage=" + getTechWeightage() +
            ", prequalTenderBidOpen='" + getPrequalTenderBidOpen() + "'" +
            ", tenderDocClose='" + getTenderDocClose() + "'" +
            ", tenderReceiptClose='" + getTenderReceiptClose() + "'" +
            ", tenderQueryClose='" + getTenderQueryClose() + "'" +
            ", technicalBidOpen='" + getTechnicalBidOpen() + "'" +
            ", financialBidOpen='" + getFinancialBidOpen() + "'" +
            ", publishedDate='" + getPublishedDate() + "'" +
            ", publishedBy=" + getPublishedBy() +
            ", recalledDate='" + getRecalledDate() + "'" +
            ", recalledBy=" + getRecalledBy() +
            ", bidSubmissionStartDate='" + getBidSubmissionStartDate() + "'" +
            ", bidValidityPeriod=" + getBidValidityPeriod() +
            ", noOfCalls=" + getNoOfCalls() +
            ", preBidMeetingDate='" + getPreBidMeetingDate() + "'" +
            ", preBidMeetingYn='" + getPreBidMeetingYn() + "'" +
            ", prebidMeetingAddress=" + getPrebidMeetingAddress() +
            ", preQualificationBidOpen='" + getPreQualificationBidOpen() + "'" +
            ", mandateAllItemsYn='" + getMandateAllItemsYn() + "'" +
            ", queriesPublished='" + getQueriesPublished() + "'" +
            ", denominationType='" + getDenominationType() + "'" +
            ", retenderedYn='" + getRetenderedYn() + "'" +
            ", percentageRateType='" + getPercentageRateType() + "'" +
            ", contactPerson='" + getContactPerson() + "'" +
            ", splitEmdYn='" + getSplitEmdYn() + "'" +
            ", emdBankGuarantee=" + getEmdBankGuarantee() +
            ", emdCash=" + getEmdCash() +
            ", bgValidityPeriod=" + getBgValidityPeriod() +
            ", hideWeightage='" + getHideWeightage() + "'" +
            ", itemwiseTechEvalYn='" + getItemwiseTechEvalYn() + "'" +
            ", isMultipleSupplierSelectionAllowed='" + getIsMultipleSupplierSelectionAllowed() + "'" +
            ", techEvalStartDate='" + getTechEvalStartDate() + "'" +
            ", techEvalEndDate='" + getTechEvalEndDate() + "'" +
            ", commEvalStartDate='" + getCommEvalStartDate() + "'" +
            ", commEvalEndDate='" + getCommEvalEndDate() + "'" +
            ", emdVerifiedDate='" + getEmdVerifiedDate() + "'" +
            ", multipleCurrencySelectionAllowedYn='" + getMultipleCurrencySelectionAllowedYn() + "'" +
            ", isEditable='" + getIsEditable() + "'" +
            ", isEvaluated='" + getIsEvaluated() + "'" +
            ", isTechWeightageAllowed='" + getIsTechWeightageAllowed() + "'" +
            ", isTechWeightageCompleted='" + getIsTechWeightageCompleted() + "'" +
            ", isCommercialBidEditCompleted='" + getIsCommercialBidEditCompleted() + "'" +
            ", templateYn='" + getTemplateYn() + "'" +
            ", templateId=" + getTemplateId() +
            ", paymentVerifiedBy=" + getPaymentVerifiedBy() +
            ", paymentVerifiedDate='" + getPaymentVerifiedDate() + "'" +
            ", isItemwiseCsr='" + getIsItemwiseCsr() + "'" +
            ", isBidViewEnabled='" + getIsBidViewEnabled() + "'" +
            ", isNegotiation='" + getIsNegotiation() + "'" +
            ", highestBidderSelection='" + getHighestBidderSelection() + "'" +
            ", isVariableEmdAllowed='" + getIsVariableEmdAllowed() + "'" +
            ", nitPublisherCertId=" + getNitPublisherCertId() +
            ", autoExtendYn='" + getAutoExtendYn() + "'" +
            ", noOfDaysExtend=" + getNoOfDaysExtend() +
            ", isExtensionAvailable='" + getIsExtensionAvailable() + "'" +
            ", specialSchemeTender='" + getSpecialSchemeTender() + "'" +
            ", isBidValidityExpiryTaskCreated='" + getIsBidValidityExpiryTaskCreated() + "'" +
            ", evaluationTypeFlag='" + getEvaluationTypeFlag() + "'" +
            ", qcbsTenderYn='" + getQcbsTenderYn() + "'" +
            ", publishedUser='" + getPublishedUser() + "'" +
            ", isWorldBankFunded='" + getIsWorldBankFunded() + "'" +
            ", ecClearanceNumber='" + getEcClearanceNumber() + "'" +
            ", ecClearanceDate='" + getEcClearanceDate() + "'" +
            ", tenderSchedule=" + getTenderSchedule() +
            "}";
    }
}
