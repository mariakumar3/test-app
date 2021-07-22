package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A NoticeInvitingTender.
 */
@Entity
@Table(name = "notice_inviting_tender")
public class NoticeInvitingTender implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "evaluation_type")
    private Integer evaluationType;

    @Column(name = "prequal_validity_period")
    private ZonedDateTime prequalValidityPeriod;

    @Column(name = "inviting_strategy")
    private Boolean invitingStrategy;

    @Column(name = "min_no_bids_receive")
    private Integer minNoBidsReceive;

    @Column(name = "procuring_entity")
    private Integer procuringEntity;

    @Column(name = "procuring_entity_designation")
    private Integer procuringEntityDesignation;

    @Column(name = "procuring_entity_address")
    private Integer procuringEntityAddress;

    @Column(name = "inviting_authority")
    private Integer invitingAuthority;

    @Column(name = "inviting_authority_designation")
    private Integer invitingAuthorityDesignation;

    @Column(name = "inviting_authority_address")
    private Integer invitingAuthorityAddress;

    @Column(name = "participating_condn_yn")
    private Boolean participatingCondnYn;

    @Column(name = "tender_fee", precision = 21, scale = 2)
    private BigDecimal tenderFee;

    @Column(name = "emd", precision = 21, scale = 2)
    private BigDecimal emd;

    @Column(name = "bid_value_type")
    private Boolean bidValueType;

    @Column(name = "tech_weightage")
    private Integer techWeightage;

    @Column(name = "prequal_tender_bid_open")
    private ZonedDateTime prequalTenderBidOpen;

    @Column(name = "tender_doc_close")
    private ZonedDateTime tenderDocClose;

    @Column(name = "tender_receipt_close")
    private ZonedDateTime tenderReceiptClose;

    @Column(name = "tender_query_close")
    private ZonedDateTime tenderQueryClose;

    @Column(name = "technical_bid_open")
    private ZonedDateTime technicalBidOpen;

    @Column(name = "financial_bid_open")
    private ZonedDateTime financialBidOpen;

    @Column(name = "published_date")
    private ZonedDateTime publishedDate;

    @Column(name = "published_by")
    private Integer publishedBy;

    @Column(name = "recalled_date")
    private ZonedDateTime recalledDate;

    @Column(name = "recalled_by")
    private Integer recalledBy;

    @Column(name = "bid_submission_start_date")
    private ZonedDateTime bidSubmissionStartDate;

    @Column(name = "bid_validity_period")
    private Integer bidValidityPeriod;

    @Column(name = "no_of_calls")
    private Integer noOfCalls;

    @Column(name = "pre_bid_meeting_date")
    private ZonedDateTime preBidMeetingDate;

    @Column(name = "pre_bid_meeting_yn")
    private Boolean preBidMeetingYn;

    @Column(name = "prebid_meeting_address")
    private Integer prebidMeetingAddress;

    @Column(name = "pre_qualification_bid_open")
    private ZonedDateTime preQualificationBidOpen;

    @Column(name = "mandate_all_items_yn")
    private Boolean mandateAllItemsYn;

    @Column(name = "queries_published")
    private Boolean queriesPublished;

    @Column(name = "denomination_type")
    private String denominationType;

    @Column(name = "retendered_yn")
    private Boolean retenderedYn;

    @Column(name = "percentage_rate_type")
    private String percentageRateType;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "split_emd_yn")
    private Boolean splitEmdYn;

    @Column(name = "emd_bank_guarantee", precision = 21, scale = 2)
    private BigDecimal emdBankGuarantee;

    @Column(name = "emd_cash", precision = 21, scale = 2)
    private BigDecimal emdCash;

    @Column(name = "bg_validity_period")
    private Integer bgValidityPeriod;

    @Column(name = "hide_weightage")
    private Boolean hideWeightage;

    @Column(name = "itemwise_tech_eval_yn")
    private Boolean itemwiseTechEvalYn;

    @Column(name = "is_multiple_supplier_selection_allowed")
    private Boolean isMultipleSupplierSelectionAllowed;

    @Column(name = "tech_eval_start_date")
    private ZonedDateTime techEvalStartDate;

    @Column(name = "tech_eval_end_date")
    private ZonedDateTime techEvalEndDate;

    @Column(name = "comm_eval_start_date")
    private ZonedDateTime commEvalStartDate;

    @Column(name = "comm_eval_end_date")
    private ZonedDateTime commEvalEndDate;

    @Column(name = "emd_verified_date")
    private ZonedDateTime emdVerifiedDate;

    @Column(name = "multiple_currency_selection_allowed_yn")
    private Boolean multipleCurrencySelectionAllowedYn;

    @Column(name = "is_editable")
    private Boolean isEditable;

    @Column(name = "is_evaluated")
    private Boolean isEvaluated;

    @Column(name = "is_tech_weightage_allowed")
    private Boolean isTechWeightageAllowed;

    @Column(name = "is_tech_weightage_completed")
    private Boolean isTechWeightageCompleted;

    @Column(name = "is_commercial_bid_edit_completed")
    private Boolean isCommercialBidEditCompleted;

    @Column(name = "template_yn")
    private Boolean templateYn;

    @Column(name = "template_id")
    private Long templateId;

    @Column(name = "payment_verified_by")
    private Integer paymentVerifiedBy;

    @Column(name = "payment_verified_date")
    private ZonedDateTime paymentVerifiedDate;

    @Column(name = "is_itemwise_csr")
    private Boolean isItemwiseCsr;

    @Column(name = "is_bid_view_enabled")
    private Boolean isBidViewEnabled;

    @Column(name = "is_negotiation")
    private Boolean isNegotiation;

    @Column(name = "highest_bidder_selection")
    private Boolean highestBidderSelection;

    @Column(name = "is_variable_emd_allowed")
    private Boolean isVariableEmdAllowed;

    @Column(name = "nit_publisher_cert_id")
    private Integer nitPublisherCertId;

    @Column(name = "auto_extend_yn")
    private Boolean autoExtendYn;

    @Column(name = "no_of_days_extend")
    private Integer noOfDaysExtend;

    @Column(name = "is_extension_available")
    private Boolean isExtensionAvailable;

    @Column(name = "special_scheme_tender")
    private Boolean specialSchemeTender;

    @Column(name = "is_bid_validity_expiry_task_created")
    private Boolean isBidValidityExpiryTaskCreated;

    @Column(name = "evaluation_type_flag")
    private Boolean evaluationTypeFlag;

    @Column(name = "qcbs_tender_yn")
    private Boolean qcbsTenderYn;

    @Column(name = "published_user")
    private String publishedUser;

    @Column(name = "is_world_bank_funded")
    private Boolean isWorldBankFunded;

    @Column(name = "ec_clearance_number")
    private String ecClearanceNumber;

    @Column(name = "ec_clearance_date")
    private ZonedDateTime ecClearanceDate;

    @JsonIgnoreProperties(value = { "noticeInvitingTender" }, allowSetters = true)
    @OneToOne
    @JoinColumn(unique = true)
    private TenderSchedule tenderSchedule;

    @OneToMany(mappedBy = "noticeInvitingTender")
    @JsonIgnoreProperties(value = { "noticeInvitingTender" }, allowSetters = true)
    private Set<TenderObjectStore> tenderObjectStores = new HashSet<>();

    @OneToMany(mappedBy = "noticeInvitingTender")
    @JsonIgnoreProperties(value = { "noticeInvitingTender", "tenderGoodsGroup" }, allowSetters = true)
    private Set<TenderGoodsItems> tenderGoodsItems = new HashSet<>();

    @OneToMany(mappedBy = "noticeInvitingTender")
    @JsonIgnoreProperties(value = { "noticeInvitingTender" }, allowSetters = true)
    private Set<TenderSample> tenderSamples = new HashSet<>();

    @OneToMany(mappedBy = "noticeInvitingTender")
    @JsonIgnoreProperties(value = { "noticeInvitingTender" }, allowSetters = true)
    private Set<TenderTechnicalParameter> tenderTechnicalParameters = new HashSet<>();

    @OneToMany(mappedBy = "noticeInvitingTender")
    @JsonIgnoreProperties(value = { "tenderGoodsItems", "noticeInvitingTender" }, allowSetters = true)
    private Set<TenderGoodsGroup> tenderGoodsGroups = new HashSet<>();

    @OneToMany(mappedBy = "noticeInvitingTender")
    @JsonIgnoreProperties(value = { "tenderCriterionDocuments", "noticeInvitingTender" }, allowSetters = true)
    private Set<TenderCriterion> tenderCriteria = new HashSet<>();

    @OneToMany(mappedBy = "noticeInvitingTender")
    @JsonIgnoreProperties(value = { "noticeInvitingTender", "tenderCriterion" }, allowSetters = true)
    private Set<TenderCriterionDocument> tenderCriterionDocuments = new HashSet<>();

    @OneToMany(mappedBy = "noticeInvitingTender")
    @JsonIgnoreProperties(value = { "noticeInvitingTender" }, allowSetters = true)
    private Set<TenderAddendum> tenderAddenda = new HashSet<>();

    @OneToMany(mappedBy = "noticeInvitingTender")
    @JsonIgnoreProperties(value = { "tenderCorrigendumDetails", "noticeInvitingTender" }, allowSetters = true)
    private Set<TenderCorrigendum> tenderCorrigendums = new HashSet<>();

    @OneToMany(mappedBy = "noticeInvitingTender")
    @JsonIgnoreProperties(value = { "tenderQueryResponses", "noticeInvitingTender" }, allowSetters = true)
    private Set<TenderQuery> tenderQueries = new HashSet<>();

    @OneToMany(mappedBy = "noticeInvitingTender")
    @JsonIgnoreProperties(value = { "noticeInvitingTender" }, allowSetters = true)
    private Set<TenderScrutinyCommittee> tenderScrutinyCommittees = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NoticeInvitingTender id(Long id) {
        this.id = id;
        return this;
    }

    public Integer getEvaluationType() {
        return this.evaluationType;
    }

    public NoticeInvitingTender evaluationType(Integer evaluationType) {
        this.evaluationType = evaluationType;
        return this;
    }

    public void setEvaluationType(Integer evaluationType) {
        this.evaluationType = evaluationType;
    }

    public ZonedDateTime getPrequalValidityPeriod() {
        return this.prequalValidityPeriod;
    }

    public NoticeInvitingTender prequalValidityPeriod(ZonedDateTime prequalValidityPeriod) {
        this.prequalValidityPeriod = prequalValidityPeriod;
        return this;
    }

    public void setPrequalValidityPeriod(ZonedDateTime prequalValidityPeriod) {
        this.prequalValidityPeriod = prequalValidityPeriod;
    }

    public Boolean getInvitingStrategy() {
        return this.invitingStrategy;
    }

    public NoticeInvitingTender invitingStrategy(Boolean invitingStrategy) {
        this.invitingStrategy = invitingStrategy;
        return this;
    }

    public void setInvitingStrategy(Boolean invitingStrategy) {
        this.invitingStrategy = invitingStrategy;
    }

    public Integer getMinNoBidsReceive() {
        return this.minNoBidsReceive;
    }

    public NoticeInvitingTender minNoBidsReceive(Integer minNoBidsReceive) {
        this.minNoBidsReceive = minNoBidsReceive;
        return this;
    }

    public void setMinNoBidsReceive(Integer minNoBidsReceive) {
        this.minNoBidsReceive = minNoBidsReceive;
    }

    public Integer getProcuringEntity() {
        return this.procuringEntity;
    }

    public NoticeInvitingTender procuringEntity(Integer procuringEntity) {
        this.procuringEntity = procuringEntity;
        return this;
    }

    public void setProcuringEntity(Integer procuringEntity) {
        this.procuringEntity = procuringEntity;
    }

    public Integer getProcuringEntityDesignation() {
        return this.procuringEntityDesignation;
    }

    public NoticeInvitingTender procuringEntityDesignation(Integer procuringEntityDesignation) {
        this.procuringEntityDesignation = procuringEntityDesignation;
        return this;
    }

    public void setProcuringEntityDesignation(Integer procuringEntityDesignation) {
        this.procuringEntityDesignation = procuringEntityDesignation;
    }

    public Integer getProcuringEntityAddress() {
        return this.procuringEntityAddress;
    }

    public NoticeInvitingTender procuringEntityAddress(Integer procuringEntityAddress) {
        this.procuringEntityAddress = procuringEntityAddress;
        return this;
    }

    public void setProcuringEntityAddress(Integer procuringEntityAddress) {
        this.procuringEntityAddress = procuringEntityAddress;
    }

    public Integer getInvitingAuthority() {
        return this.invitingAuthority;
    }

    public NoticeInvitingTender invitingAuthority(Integer invitingAuthority) {
        this.invitingAuthority = invitingAuthority;
        return this;
    }

    public void setInvitingAuthority(Integer invitingAuthority) {
        this.invitingAuthority = invitingAuthority;
    }

    public Integer getInvitingAuthorityDesignation() {
        return this.invitingAuthorityDesignation;
    }

    public NoticeInvitingTender invitingAuthorityDesignation(Integer invitingAuthorityDesignation) {
        this.invitingAuthorityDesignation = invitingAuthorityDesignation;
        return this;
    }

    public void setInvitingAuthorityDesignation(Integer invitingAuthorityDesignation) {
        this.invitingAuthorityDesignation = invitingAuthorityDesignation;
    }

    public Integer getInvitingAuthorityAddress() {
        return this.invitingAuthorityAddress;
    }

    public NoticeInvitingTender invitingAuthorityAddress(Integer invitingAuthorityAddress) {
        this.invitingAuthorityAddress = invitingAuthorityAddress;
        return this;
    }

    public void setInvitingAuthorityAddress(Integer invitingAuthorityAddress) {
        this.invitingAuthorityAddress = invitingAuthorityAddress;
    }

    public Boolean getParticipatingCondnYn() {
        return this.participatingCondnYn;
    }

    public NoticeInvitingTender participatingCondnYn(Boolean participatingCondnYn) {
        this.participatingCondnYn = participatingCondnYn;
        return this;
    }

    public void setParticipatingCondnYn(Boolean participatingCondnYn) {
        this.participatingCondnYn = participatingCondnYn;
    }

    public BigDecimal getTenderFee() {
        return this.tenderFee;
    }

    public NoticeInvitingTender tenderFee(BigDecimal tenderFee) {
        this.tenderFee = tenderFee;
        return this;
    }

    public void setTenderFee(BigDecimal tenderFee) {
        this.tenderFee = tenderFee;
    }

    public BigDecimal getEmd() {
        return this.emd;
    }

    public NoticeInvitingTender emd(BigDecimal emd) {
        this.emd = emd;
        return this;
    }

    public void setEmd(BigDecimal emd) {
        this.emd = emd;
    }

    public Boolean getBidValueType() {
        return this.bidValueType;
    }

    public NoticeInvitingTender bidValueType(Boolean bidValueType) {
        this.bidValueType = bidValueType;
        return this;
    }

    public void setBidValueType(Boolean bidValueType) {
        this.bidValueType = bidValueType;
    }

    public Integer getTechWeightage() {
        return this.techWeightage;
    }

    public NoticeInvitingTender techWeightage(Integer techWeightage) {
        this.techWeightage = techWeightage;
        return this;
    }

    public void setTechWeightage(Integer techWeightage) {
        this.techWeightage = techWeightage;
    }

    public ZonedDateTime getPrequalTenderBidOpen() {
        return this.prequalTenderBidOpen;
    }

    public NoticeInvitingTender prequalTenderBidOpen(ZonedDateTime prequalTenderBidOpen) {
        this.prequalTenderBidOpen = prequalTenderBidOpen;
        return this;
    }

    public void setPrequalTenderBidOpen(ZonedDateTime prequalTenderBidOpen) {
        this.prequalTenderBidOpen = prequalTenderBidOpen;
    }

    public ZonedDateTime getTenderDocClose() {
        return this.tenderDocClose;
    }

    public NoticeInvitingTender tenderDocClose(ZonedDateTime tenderDocClose) {
        this.tenderDocClose = tenderDocClose;
        return this;
    }

    public void setTenderDocClose(ZonedDateTime tenderDocClose) {
        this.tenderDocClose = tenderDocClose;
    }

    public ZonedDateTime getTenderReceiptClose() {
        return this.tenderReceiptClose;
    }

    public NoticeInvitingTender tenderReceiptClose(ZonedDateTime tenderReceiptClose) {
        this.tenderReceiptClose = tenderReceiptClose;
        return this;
    }

    public void setTenderReceiptClose(ZonedDateTime tenderReceiptClose) {
        this.tenderReceiptClose = tenderReceiptClose;
    }

    public ZonedDateTime getTenderQueryClose() {
        return this.tenderQueryClose;
    }

    public NoticeInvitingTender tenderQueryClose(ZonedDateTime tenderQueryClose) {
        this.tenderQueryClose = tenderQueryClose;
        return this;
    }

    public void setTenderQueryClose(ZonedDateTime tenderQueryClose) {
        this.tenderQueryClose = tenderQueryClose;
    }

    public ZonedDateTime getTechnicalBidOpen() {
        return this.technicalBidOpen;
    }

    public NoticeInvitingTender technicalBidOpen(ZonedDateTime technicalBidOpen) {
        this.technicalBidOpen = technicalBidOpen;
        return this;
    }

    public void setTechnicalBidOpen(ZonedDateTime technicalBidOpen) {
        this.technicalBidOpen = technicalBidOpen;
    }

    public ZonedDateTime getFinancialBidOpen() {
        return this.financialBidOpen;
    }

    public NoticeInvitingTender financialBidOpen(ZonedDateTime financialBidOpen) {
        this.financialBidOpen = financialBidOpen;
        return this;
    }

    public void setFinancialBidOpen(ZonedDateTime financialBidOpen) {
        this.financialBidOpen = financialBidOpen;
    }

    public ZonedDateTime getPublishedDate() {
        return this.publishedDate;
    }

    public NoticeInvitingTender publishedDate(ZonedDateTime publishedDate) {
        this.publishedDate = publishedDate;
        return this;
    }

    public void setPublishedDate(ZonedDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getPublishedBy() {
        return this.publishedBy;
    }

    public NoticeInvitingTender publishedBy(Integer publishedBy) {
        this.publishedBy = publishedBy;
        return this;
    }

    public void setPublishedBy(Integer publishedBy) {
        this.publishedBy = publishedBy;
    }

    public ZonedDateTime getRecalledDate() {
        return this.recalledDate;
    }

    public NoticeInvitingTender recalledDate(ZonedDateTime recalledDate) {
        this.recalledDate = recalledDate;
        return this;
    }

    public void setRecalledDate(ZonedDateTime recalledDate) {
        this.recalledDate = recalledDate;
    }

    public Integer getRecalledBy() {
        return this.recalledBy;
    }

    public NoticeInvitingTender recalledBy(Integer recalledBy) {
        this.recalledBy = recalledBy;
        return this;
    }

    public void setRecalledBy(Integer recalledBy) {
        this.recalledBy = recalledBy;
    }

    public ZonedDateTime getBidSubmissionStartDate() {
        return this.bidSubmissionStartDate;
    }

    public NoticeInvitingTender bidSubmissionStartDate(ZonedDateTime bidSubmissionStartDate) {
        this.bidSubmissionStartDate = bidSubmissionStartDate;
        return this;
    }

    public void setBidSubmissionStartDate(ZonedDateTime bidSubmissionStartDate) {
        this.bidSubmissionStartDate = bidSubmissionStartDate;
    }

    public Integer getBidValidityPeriod() {
        return this.bidValidityPeriod;
    }

    public NoticeInvitingTender bidValidityPeriod(Integer bidValidityPeriod) {
        this.bidValidityPeriod = bidValidityPeriod;
        return this;
    }

    public void setBidValidityPeriod(Integer bidValidityPeriod) {
        this.bidValidityPeriod = bidValidityPeriod;
    }

    public Integer getNoOfCalls() {
        return this.noOfCalls;
    }

    public NoticeInvitingTender noOfCalls(Integer noOfCalls) {
        this.noOfCalls = noOfCalls;
        return this;
    }

    public void setNoOfCalls(Integer noOfCalls) {
        this.noOfCalls = noOfCalls;
    }

    public ZonedDateTime getPreBidMeetingDate() {
        return this.preBidMeetingDate;
    }

    public NoticeInvitingTender preBidMeetingDate(ZonedDateTime preBidMeetingDate) {
        this.preBidMeetingDate = preBidMeetingDate;
        return this;
    }

    public void setPreBidMeetingDate(ZonedDateTime preBidMeetingDate) {
        this.preBidMeetingDate = preBidMeetingDate;
    }

    public Boolean getPreBidMeetingYn() {
        return this.preBidMeetingYn;
    }

    public NoticeInvitingTender preBidMeetingYn(Boolean preBidMeetingYn) {
        this.preBidMeetingYn = preBidMeetingYn;
        return this;
    }

    public void setPreBidMeetingYn(Boolean preBidMeetingYn) {
        this.preBidMeetingYn = preBidMeetingYn;
    }

    public Integer getPrebidMeetingAddress() {
        return this.prebidMeetingAddress;
    }

    public NoticeInvitingTender prebidMeetingAddress(Integer prebidMeetingAddress) {
        this.prebidMeetingAddress = prebidMeetingAddress;
        return this;
    }

    public void setPrebidMeetingAddress(Integer prebidMeetingAddress) {
        this.prebidMeetingAddress = prebidMeetingAddress;
    }

    public ZonedDateTime getPreQualificationBidOpen() {
        return this.preQualificationBidOpen;
    }

    public NoticeInvitingTender preQualificationBidOpen(ZonedDateTime preQualificationBidOpen) {
        this.preQualificationBidOpen = preQualificationBidOpen;
        return this;
    }

    public void setPreQualificationBidOpen(ZonedDateTime preQualificationBidOpen) {
        this.preQualificationBidOpen = preQualificationBidOpen;
    }

    public Boolean getMandateAllItemsYn() {
        return this.mandateAllItemsYn;
    }

    public NoticeInvitingTender mandateAllItemsYn(Boolean mandateAllItemsYn) {
        this.mandateAllItemsYn = mandateAllItemsYn;
        return this;
    }

    public void setMandateAllItemsYn(Boolean mandateAllItemsYn) {
        this.mandateAllItemsYn = mandateAllItemsYn;
    }

    public Boolean getQueriesPublished() {
        return this.queriesPublished;
    }

    public NoticeInvitingTender queriesPublished(Boolean queriesPublished) {
        this.queriesPublished = queriesPublished;
        return this;
    }

    public void setQueriesPublished(Boolean queriesPublished) {
        this.queriesPublished = queriesPublished;
    }

    public String getDenominationType() {
        return this.denominationType;
    }

    public NoticeInvitingTender denominationType(String denominationType) {
        this.denominationType = denominationType;
        return this;
    }

    public void setDenominationType(String denominationType) {
        this.denominationType = denominationType;
    }

    public Boolean getRetenderedYn() {
        return this.retenderedYn;
    }

    public NoticeInvitingTender retenderedYn(Boolean retenderedYn) {
        this.retenderedYn = retenderedYn;
        return this;
    }

    public void setRetenderedYn(Boolean retenderedYn) {
        this.retenderedYn = retenderedYn;
    }

    public String getPercentageRateType() {
        return this.percentageRateType;
    }

    public NoticeInvitingTender percentageRateType(String percentageRateType) {
        this.percentageRateType = percentageRateType;
        return this;
    }

    public void setPercentageRateType(String percentageRateType) {
        this.percentageRateType = percentageRateType;
    }

    public String getContactPerson() {
        return this.contactPerson;
    }

    public NoticeInvitingTender contactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Boolean getSplitEmdYn() {
        return this.splitEmdYn;
    }

    public NoticeInvitingTender splitEmdYn(Boolean splitEmdYn) {
        this.splitEmdYn = splitEmdYn;
        return this;
    }

    public void setSplitEmdYn(Boolean splitEmdYn) {
        this.splitEmdYn = splitEmdYn;
    }

    public BigDecimal getEmdBankGuarantee() {
        return this.emdBankGuarantee;
    }

    public NoticeInvitingTender emdBankGuarantee(BigDecimal emdBankGuarantee) {
        this.emdBankGuarantee = emdBankGuarantee;
        return this;
    }

    public void setEmdBankGuarantee(BigDecimal emdBankGuarantee) {
        this.emdBankGuarantee = emdBankGuarantee;
    }

    public BigDecimal getEmdCash() {
        return this.emdCash;
    }

    public NoticeInvitingTender emdCash(BigDecimal emdCash) {
        this.emdCash = emdCash;
        return this;
    }

    public void setEmdCash(BigDecimal emdCash) {
        this.emdCash = emdCash;
    }

    public Integer getBgValidityPeriod() {
        return this.bgValidityPeriod;
    }

    public NoticeInvitingTender bgValidityPeriod(Integer bgValidityPeriod) {
        this.bgValidityPeriod = bgValidityPeriod;
        return this;
    }

    public void setBgValidityPeriod(Integer bgValidityPeriod) {
        this.bgValidityPeriod = bgValidityPeriod;
    }

    public Boolean getHideWeightage() {
        return this.hideWeightage;
    }

    public NoticeInvitingTender hideWeightage(Boolean hideWeightage) {
        this.hideWeightage = hideWeightage;
        return this;
    }

    public void setHideWeightage(Boolean hideWeightage) {
        this.hideWeightage = hideWeightage;
    }

    public Boolean getItemwiseTechEvalYn() {
        return this.itemwiseTechEvalYn;
    }

    public NoticeInvitingTender itemwiseTechEvalYn(Boolean itemwiseTechEvalYn) {
        this.itemwiseTechEvalYn = itemwiseTechEvalYn;
        return this;
    }

    public void setItemwiseTechEvalYn(Boolean itemwiseTechEvalYn) {
        this.itemwiseTechEvalYn = itemwiseTechEvalYn;
    }

    public Boolean getIsMultipleSupplierSelectionAllowed() {
        return this.isMultipleSupplierSelectionAllowed;
    }

    public NoticeInvitingTender isMultipleSupplierSelectionAllowed(Boolean isMultipleSupplierSelectionAllowed) {
        this.isMultipleSupplierSelectionAllowed = isMultipleSupplierSelectionAllowed;
        return this;
    }

    public void setIsMultipleSupplierSelectionAllowed(Boolean isMultipleSupplierSelectionAllowed) {
        this.isMultipleSupplierSelectionAllowed = isMultipleSupplierSelectionAllowed;
    }

    public ZonedDateTime getTechEvalStartDate() {
        return this.techEvalStartDate;
    }

    public NoticeInvitingTender techEvalStartDate(ZonedDateTime techEvalStartDate) {
        this.techEvalStartDate = techEvalStartDate;
        return this;
    }

    public void setTechEvalStartDate(ZonedDateTime techEvalStartDate) {
        this.techEvalStartDate = techEvalStartDate;
    }

    public ZonedDateTime getTechEvalEndDate() {
        return this.techEvalEndDate;
    }

    public NoticeInvitingTender techEvalEndDate(ZonedDateTime techEvalEndDate) {
        this.techEvalEndDate = techEvalEndDate;
        return this;
    }

    public void setTechEvalEndDate(ZonedDateTime techEvalEndDate) {
        this.techEvalEndDate = techEvalEndDate;
    }

    public ZonedDateTime getCommEvalStartDate() {
        return this.commEvalStartDate;
    }

    public NoticeInvitingTender commEvalStartDate(ZonedDateTime commEvalStartDate) {
        this.commEvalStartDate = commEvalStartDate;
        return this;
    }

    public void setCommEvalStartDate(ZonedDateTime commEvalStartDate) {
        this.commEvalStartDate = commEvalStartDate;
    }

    public ZonedDateTime getCommEvalEndDate() {
        return this.commEvalEndDate;
    }

    public NoticeInvitingTender commEvalEndDate(ZonedDateTime commEvalEndDate) {
        this.commEvalEndDate = commEvalEndDate;
        return this;
    }

    public void setCommEvalEndDate(ZonedDateTime commEvalEndDate) {
        this.commEvalEndDate = commEvalEndDate;
    }

    public ZonedDateTime getEmdVerifiedDate() {
        return this.emdVerifiedDate;
    }

    public NoticeInvitingTender emdVerifiedDate(ZonedDateTime emdVerifiedDate) {
        this.emdVerifiedDate = emdVerifiedDate;
        return this;
    }

    public void setEmdVerifiedDate(ZonedDateTime emdVerifiedDate) {
        this.emdVerifiedDate = emdVerifiedDate;
    }

    public Boolean getMultipleCurrencySelectionAllowedYn() {
        return this.multipleCurrencySelectionAllowedYn;
    }

    public NoticeInvitingTender multipleCurrencySelectionAllowedYn(Boolean multipleCurrencySelectionAllowedYn) {
        this.multipleCurrencySelectionAllowedYn = multipleCurrencySelectionAllowedYn;
        return this;
    }

    public void setMultipleCurrencySelectionAllowedYn(Boolean multipleCurrencySelectionAllowedYn) {
        this.multipleCurrencySelectionAllowedYn = multipleCurrencySelectionAllowedYn;
    }

    public Boolean getIsEditable() {
        return this.isEditable;
    }

    public NoticeInvitingTender isEditable(Boolean isEditable) {
        this.isEditable = isEditable;
        return this;
    }

    public void setIsEditable(Boolean isEditable) {
        this.isEditable = isEditable;
    }

    public Boolean getIsEvaluated() {
        return this.isEvaluated;
    }

    public NoticeInvitingTender isEvaluated(Boolean isEvaluated) {
        this.isEvaluated = isEvaluated;
        return this;
    }

    public void setIsEvaluated(Boolean isEvaluated) {
        this.isEvaluated = isEvaluated;
    }

    public Boolean getIsTechWeightageAllowed() {
        return this.isTechWeightageAllowed;
    }

    public NoticeInvitingTender isTechWeightageAllowed(Boolean isTechWeightageAllowed) {
        this.isTechWeightageAllowed = isTechWeightageAllowed;
        return this;
    }

    public void setIsTechWeightageAllowed(Boolean isTechWeightageAllowed) {
        this.isTechWeightageAllowed = isTechWeightageAllowed;
    }

    public Boolean getIsTechWeightageCompleted() {
        return this.isTechWeightageCompleted;
    }

    public NoticeInvitingTender isTechWeightageCompleted(Boolean isTechWeightageCompleted) {
        this.isTechWeightageCompleted = isTechWeightageCompleted;
        return this;
    }

    public void setIsTechWeightageCompleted(Boolean isTechWeightageCompleted) {
        this.isTechWeightageCompleted = isTechWeightageCompleted;
    }

    public Boolean getIsCommercialBidEditCompleted() {
        return this.isCommercialBidEditCompleted;
    }

    public NoticeInvitingTender isCommercialBidEditCompleted(Boolean isCommercialBidEditCompleted) {
        this.isCommercialBidEditCompleted = isCommercialBidEditCompleted;
        return this;
    }

    public void setIsCommercialBidEditCompleted(Boolean isCommercialBidEditCompleted) {
        this.isCommercialBidEditCompleted = isCommercialBidEditCompleted;
    }

    public Boolean getTemplateYn() {
        return this.templateYn;
    }

    public NoticeInvitingTender templateYn(Boolean templateYn) {
        this.templateYn = templateYn;
        return this;
    }

    public void setTemplateYn(Boolean templateYn) {
        this.templateYn = templateYn;
    }

    public Long getTemplateId() {
        return this.templateId;
    }

    public NoticeInvitingTender templateId(Long templateId) {
        this.templateId = templateId;
        return this;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Integer getPaymentVerifiedBy() {
        return this.paymentVerifiedBy;
    }

    public NoticeInvitingTender paymentVerifiedBy(Integer paymentVerifiedBy) {
        this.paymentVerifiedBy = paymentVerifiedBy;
        return this;
    }

    public void setPaymentVerifiedBy(Integer paymentVerifiedBy) {
        this.paymentVerifiedBy = paymentVerifiedBy;
    }

    public ZonedDateTime getPaymentVerifiedDate() {
        return this.paymentVerifiedDate;
    }

    public NoticeInvitingTender paymentVerifiedDate(ZonedDateTime paymentVerifiedDate) {
        this.paymentVerifiedDate = paymentVerifiedDate;
        return this;
    }

    public void setPaymentVerifiedDate(ZonedDateTime paymentVerifiedDate) {
        this.paymentVerifiedDate = paymentVerifiedDate;
    }

    public Boolean getIsItemwiseCsr() {
        return this.isItemwiseCsr;
    }

    public NoticeInvitingTender isItemwiseCsr(Boolean isItemwiseCsr) {
        this.isItemwiseCsr = isItemwiseCsr;
        return this;
    }

    public void setIsItemwiseCsr(Boolean isItemwiseCsr) {
        this.isItemwiseCsr = isItemwiseCsr;
    }

    public Boolean getIsBidViewEnabled() {
        return this.isBidViewEnabled;
    }

    public NoticeInvitingTender isBidViewEnabled(Boolean isBidViewEnabled) {
        this.isBidViewEnabled = isBidViewEnabled;
        return this;
    }

    public void setIsBidViewEnabled(Boolean isBidViewEnabled) {
        this.isBidViewEnabled = isBidViewEnabled;
    }

    public Boolean getIsNegotiation() {
        return this.isNegotiation;
    }

    public NoticeInvitingTender isNegotiation(Boolean isNegotiation) {
        this.isNegotiation = isNegotiation;
        return this;
    }

    public void setIsNegotiation(Boolean isNegotiation) {
        this.isNegotiation = isNegotiation;
    }

    public Boolean getHighestBidderSelection() {
        return this.highestBidderSelection;
    }

    public NoticeInvitingTender highestBidderSelection(Boolean highestBidderSelection) {
        this.highestBidderSelection = highestBidderSelection;
        return this;
    }

    public void setHighestBidderSelection(Boolean highestBidderSelection) {
        this.highestBidderSelection = highestBidderSelection;
    }

    public Boolean getIsVariableEmdAllowed() {
        return this.isVariableEmdAllowed;
    }

    public NoticeInvitingTender isVariableEmdAllowed(Boolean isVariableEmdAllowed) {
        this.isVariableEmdAllowed = isVariableEmdAllowed;
        return this;
    }

    public void setIsVariableEmdAllowed(Boolean isVariableEmdAllowed) {
        this.isVariableEmdAllowed = isVariableEmdAllowed;
    }

    public Integer getNitPublisherCertId() {
        return this.nitPublisherCertId;
    }

    public NoticeInvitingTender nitPublisherCertId(Integer nitPublisherCertId) {
        this.nitPublisherCertId = nitPublisherCertId;
        return this;
    }

    public void setNitPublisherCertId(Integer nitPublisherCertId) {
        this.nitPublisherCertId = nitPublisherCertId;
    }

    public Boolean getAutoExtendYn() {
        return this.autoExtendYn;
    }

    public NoticeInvitingTender autoExtendYn(Boolean autoExtendYn) {
        this.autoExtendYn = autoExtendYn;
        return this;
    }

    public void setAutoExtendYn(Boolean autoExtendYn) {
        this.autoExtendYn = autoExtendYn;
    }

    public Integer getNoOfDaysExtend() {
        return this.noOfDaysExtend;
    }

    public NoticeInvitingTender noOfDaysExtend(Integer noOfDaysExtend) {
        this.noOfDaysExtend = noOfDaysExtend;
        return this;
    }

    public void setNoOfDaysExtend(Integer noOfDaysExtend) {
        this.noOfDaysExtend = noOfDaysExtend;
    }

    public Boolean getIsExtensionAvailable() {
        return this.isExtensionAvailable;
    }

    public NoticeInvitingTender isExtensionAvailable(Boolean isExtensionAvailable) {
        this.isExtensionAvailable = isExtensionAvailable;
        return this;
    }

    public void setIsExtensionAvailable(Boolean isExtensionAvailable) {
        this.isExtensionAvailable = isExtensionAvailable;
    }

    public Boolean getSpecialSchemeTender() {
        return this.specialSchemeTender;
    }

    public NoticeInvitingTender specialSchemeTender(Boolean specialSchemeTender) {
        this.specialSchemeTender = specialSchemeTender;
        return this;
    }

    public void setSpecialSchemeTender(Boolean specialSchemeTender) {
        this.specialSchemeTender = specialSchemeTender;
    }

    public Boolean getIsBidValidityExpiryTaskCreated() {
        return this.isBidValidityExpiryTaskCreated;
    }

    public NoticeInvitingTender isBidValidityExpiryTaskCreated(Boolean isBidValidityExpiryTaskCreated) {
        this.isBidValidityExpiryTaskCreated = isBidValidityExpiryTaskCreated;
        return this;
    }

    public void setIsBidValidityExpiryTaskCreated(Boolean isBidValidityExpiryTaskCreated) {
        this.isBidValidityExpiryTaskCreated = isBidValidityExpiryTaskCreated;
    }

    public Boolean getEvaluationTypeFlag() {
        return this.evaluationTypeFlag;
    }

    public NoticeInvitingTender evaluationTypeFlag(Boolean evaluationTypeFlag) {
        this.evaluationTypeFlag = evaluationTypeFlag;
        return this;
    }

    public void setEvaluationTypeFlag(Boolean evaluationTypeFlag) {
        this.evaluationTypeFlag = evaluationTypeFlag;
    }

    public Boolean getQcbsTenderYn() {
        return this.qcbsTenderYn;
    }

    public NoticeInvitingTender qcbsTenderYn(Boolean qcbsTenderYn) {
        this.qcbsTenderYn = qcbsTenderYn;
        return this;
    }

    public void setQcbsTenderYn(Boolean qcbsTenderYn) {
        this.qcbsTenderYn = qcbsTenderYn;
    }

    public String getPublishedUser() {
        return this.publishedUser;
    }

    public NoticeInvitingTender publishedUser(String publishedUser) {
        this.publishedUser = publishedUser;
        return this;
    }

    public void setPublishedUser(String publishedUser) {
        this.publishedUser = publishedUser;
    }

    public Boolean getIsWorldBankFunded() {
        return this.isWorldBankFunded;
    }

    public NoticeInvitingTender isWorldBankFunded(Boolean isWorldBankFunded) {
        this.isWorldBankFunded = isWorldBankFunded;
        return this;
    }

    public void setIsWorldBankFunded(Boolean isWorldBankFunded) {
        this.isWorldBankFunded = isWorldBankFunded;
    }

    public String getEcClearanceNumber() {
        return this.ecClearanceNumber;
    }

    public NoticeInvitingTender ecClearanceNumber(String ecClearanceNumber) {
        this.ecClearanceNumber = ecClearanceNumber;
        return this;
    }

    public void setEcClearanceNumber(String ecClearanceNumber) {
        this.ecClearanceNumber = ecClearanceNumber;
    }

    public ZonedDateTime getEcClearanceDate() {
        return this.ecClearanceDate;
    }

    public NoticeInvitingTender ecClearanceDate(ZonedDateTime ecClearanceDate) {
        this.ecClearanceDate = ecClearanceDate;
        return this;
    }

    public void setEcClearanceDate(ZonedDateTime ecClearanceDate) {
        this.ecClearanceDate = ecClearanceDate;
    }

    public TenderSchedule getTenderSchedule() {
        return this.tenderSchedule;
    }

    public NoticeInvitingTender tenderSchedule(TenderSchedule tenderSchedule) {
        this.setTenderSchedule(tenderSchedule);
        return this;
    }

    public void setTenderSchedule(TenderSchedule tenderSchedule) {
        this.tenderSchedule = tenderSchedule;
    }

    public Set<TenderObjectStore> getTenderObjectStores() {
        return this.tenderObjectStores;
    }

    public NoticeInvitingTender tenderObjectStores(Set<TenderObjectStore> tenderObjectStores) {
        this.setTenderObjectStores(tenderObjectStores);
        return this;
    }

    public NoticeInvitingTender addTenderObjectStore(TenderObjectStore tenderObjectStore) {
        this.tenderObjectStores.add(tenderObjectStore);
        tenderObjectStore.setNoticeInvitingTender(this);
        return this;
    }

    public NoticeInvitingTender removeTenderObjectStore(TenderObjectStore tenderObjectStore) {
        this.tenderObjectStores.remove(tenderObjectStore);
        tenderObjectStore.setNoticeInvitingTender(null);
        return this;
    }

    public void setTenderObjectStores(Set<TenderObjectStore> tenderObjectStores) {
        if (this.tenderObjectStores != null) {
            this.tenderObjectStores.forEach(i -> i.setNoticeInvitingTender(null));
        }
        if (tenderObjectStores != null) {
            tenderObjectStores.forEach(i -> i.setNoticeInvitingTender(this));
        }
        this.tenderObjectStores = tenderObjectStores;
    }

    public Set<TenderGoodsItems> getTenderGoodsItems() {
        return this.tenderGoodsItems;
    }

    public NoticeInvitingTender tenderGoodsItems(Set<TenderGoodsItems> tenderGoodsItems) {
        this.setTenderGoodsItems(tenderGoodsItems);
        return this;
    }

    public NoticeInvitingTender addTenderGoodsItem(TenderGoodsItems tenderGoodsItems) {
        this.tenderGoodsItems.add(tenderGoodsItems);
        tenderGoodsItems.setNoticeInvitingTender(this);
        return this;
    }

    public NoticeInvitingTender removeTenderGoodsItem(TenderGoodsItems tenderGoodsItems) {
        this.tenderGoodsItems.remove(tenderGoodsItems);
        tenderGoodsItems.setNoticeInvitingTender(null);
        return this;
    }

    public void setTenderGoodsItems(Set<TenderGoodsItems> tenderGoodsItems) {
        if (this.tenderGoodsItems != null) {
            this.tenderGoodsItems.forEach(i -> i.setNoticeInvitingTender(null));
        }
        if (tenderGoodsItems != null) {
            tenderGoodsItems.forEach(i -> i.setNoticeInvitingTender(this));
        }
        this.tenderGoodsItems = tenderGoodsItems;
    }

    public Set<TenderSample> getTenderSamples() {
        return this.tenderSamples;
    }

    public NoticeInvitingTender tenderSamples(Set<TenderSample> tenderSamples) {
        this.setTenderSamples(tenderSamples);
        return this;
    }

    public NoticeInvitingTender addTenderSample(TenderSample tenderSample) {
        this.tenderSamples.add(tenderSample);
        tenderSample.setNoticeInvitingTender(this);
        return this;
    }

    public NoticeInvitingTender removeTenderSample(TenderSample tenderSample) {
        this.tenderSamples.remove(tenderSample);
        tenderSample.setNoticeInvitingTender(null);
        return this;
    }

    public void setTenderSamples(Set<TenderSample> tenderSamples) {
        if (this.tenderSamples != null) {
            this.tenderSamples.forEach(i -> i.setNoticeInvitingTender(null));
        }
        if (tenderSamples != null) {
            tenderSamples.forEach(i -> i.setNoticeInvitingTender(this));
        }
        this.tenderSamples = tenderSamples;
    }

    public Set<TenderTechnicalParameter> getTenderTechnicalParameters() {
        return this.tenderTechnicalParameters;
    }

    public NoticeInvitingTender tenderTechnicalParameters(Set<TenderTechnicalParameter> tenderTechnicalParameters) {
        this.setTenderTechnicalParameters(tenderTechnicalParameters);
        return this;
    }

    public NoticeInvitingTender addTenderTechnicalParameter(TenderTechnicalParameter tenderTechnicalParameter) {
        this.tenderTechnicalParameters.add(tenderTechnicalParameter);
        tenderTechnicalParameter.setNoticeInvitingTender(this);
        return this;
    }

    public NoticeInvitingTender removeTenderTechnicalParameter(TenderTechnicalParameter tenderTechnicalParameter) {
        this.tenderTechnicalParameters.remove(tenderTechnicalParameter);
        tenderTechnicalParameter.setNoticeInvitingTender(null);
        return this;
    }

    public void setTenderTechnicalParameters(Set<TenderTechnicalParameter> tenderTechnicalParameters) {
        if (this.tenderTechnicalParameters != null) {
            this.tenderTechnicalParameters.forEach(i -> i.setNoticeInvitingTender(null));
        }
        if (tenderTechnicalParameters != null) {
            tenderTechnicalParameters.forEach(i -> i.setNoticeInvitingTender(this));
        }
        this.tenderTechnicalParameters = tenderTechnicalParameters;
    }

    public Set<TenderGoodsGroup> getTenderGoodsGroups() {
        return this.tenderGoodsGroups;
    }

    public NoticeInvitingTender tenderGoodsGroups(Set<TenderGoodsGroup> tenderGoodsGroups) {
        this.setTenderGoodsGroups(tenderGoodsGroups);
        return this;
    }

    public NoticeInvitingTender addTenderGoodsGroup(TenderGoodsGroup tenderGoodsGroup) {
        this.tenderGoodsGroups.add(tenderGoodsGroup);
        tenderGoodsGroup.setNoticeInvitingTender(this);
        return this;
    }

    public NoticeInvitingTender removeTenderGoodsGroup(TenderGoodsGroup tenderGoodsGroup) {
        this.tenderGoodsGroups.remove(tenderGoodsGroup);
        tenderGoodsGroup.setNoticeInvitingTender(null);
        return this;
    }

    public void setTenderGoodsGroups(Set<TenderGoodsGroup> tenderGoodsGroups) {
        if (this.tenderGoodsGroups != null) {
            this.tenderGoodsGroups.forEach(i -> i.setNoticeInvitingTender(null));
        }
        if (tenderGoodsGroups != null) {
            tenderGoodsGroups.forEach(i -> i.setNoticeInvitingTender(this));
        }
        this.tenderGoodsGroups = tenderGoodsGroups;
    }

    public Set<TenderCriterion> getTenderCriteria() {
        return this.tenderCriteria;
    }

    public NoticeInvitingTender tenderCriteria(Set<TenderCriterion> tenderCriteria) {
        this.setTenderCriteria(tenderCriteria);
        return this;
    }

    public NoticeInvitingTender addTenderCriterion(TenderCriterion tenderCriterion) {
        this.tenderCriteria.add(tenderCriterion);
        tenderCriterion.setNoticeInvitingTender(this);
        return this;
    }

    public NoticeInvitingTender removeTenderCriterion(TenderCriterion tenderCriterion) {
        this.tenderCriteria.remove(tenderCriterion);
        tenderCriterion.setNoticeInvitingTender(null);
        return this;
    }

    public void setTenderCriteria(Set<TenderCriterion> tenderCriteria) {
        if (this.tenderCriteria != null) {
            this.tenderCriteria.forEach(i -> i.setNoticeInvitingTender(null));
        }
        if (tenderCriteria != null) {
            tenderCriteria.forEach(i -> i.setNoticeInvitingTender(this));
        }
        this.tenderCriteria = tenderCriteria;
    }

    public Set<TenderCriterionDocument> getTenderCriterionDocuments() {
        return this.tenderCriterionDocuments;
    }

    public NoticeInvitingTender tenderCriterionDocuments(Set<TenderCriterionDocument> tenderCriterionDocuments) {
        this.setTenderCriterionDocuments(tenderCriterionDocuments);
        return this;
    }

    public NoticeInvitingTender addTenderCriterionDocument(TenderCriterionDocument tenderCriterionDocument) {
        this.tenderCriterionDocuments.add(tenderCriterionDocument);
        tenderCriterionDocument.setNoticeInvitingTender(this);
        return this;
    }

    public NoticeInvitingTender removeTenderCriterionDocument(TenderCriterionDocument tenderCriterionDocument) {
        this.tenderCriterionDocuments.remove(tenderCriterionDocument);
        tenderCriterionDocument.setNoticeInvitingTender(null);
        return this;
    }

    public void setTenderCriterionDocuments(Set<TenderCriterionDocument> tenderCriterionDocuments) {
        if (this.tenderCriterionDocuments != null) {
            this.tenderCriterionDocuments.forEach(i -> i.setNoticeInvitingTender(null));
        }
        if (tenderCriterionDocuments != null) {
            tenderCriterionDocuments.forEach(i -> i.setNoticeInvitingTender(this));
        }
        this.tenderCriterionDocuments = tenderCriterionDocuments;
    }

    public Set<TenderAddendum> getTenderAddenda() {
        return this.tenderAddenda;
    }

    public NoticeInvitingTender tenderAddenda(Set<TenderAddendum> tenderAddenda) {
        this.setTenderAddenda(tenderAddenda);
        return this;
    }

    public NoticeInvitingTender addTenderAddendum(TenderAddendum tenderAddendum) {
        this.tenderAddenda.add(tenderAddendum);
        tenderAddendum.setNoticeInvitingTender(this);
        return this;
    }

    public NoticeInvitingTender removeTenderAddendum(TenderAddendum tenderAddendum) {
        this.tenderAddenda.remove(tenderAddendum);
        tenderAddendum.setNoticeInvitingTender(null);
        return this;
    }

    public void setTenderAddenda(Set<TenderAddendum> tenderAddenda) {
        if (this.tenderAddenda != null) {
            this.tenderAddenda.forEach(i -> i.setNoticeInvitingTender(null));
        }
        if (tenderAddenda != null) {
            tenderAddenda.forEach(i -> i.setNoticeInvitingTender(this));
        }
        this.tenderAddenda = tenderAddenda;
    }

    public Set<TenderCorrigendum> getTenderCorrigendums() {
        return this.tenderCorrigendums;
    }

    public NoticeInvitingTender tenderCorrigendums(Set<TenderCorrigendum> tenderCorrigendums) {
        this.setTenderCorrigendums(tenderCorrigendums);
        return this;
    }

    public NoticeInvitingTender addTenderCorrigendum(TenderCorrigendum tenderCorrigendum) {
        this.tenderCorrigendums.add(tenderCorrigendum);
        tenderCorrigendum.setNoticeInvitingTender(this);
        return this;
    }

    public NoticeInvitingTender removeTenderCorrigendum(TenderCorrigendum tenderCorrigendum) {
        this.tenderCorrigendums.remove(tenderCorrigendum);
        tenderCorrigendum.setNoticeInvitingTender(null);
        return this;
    }

    public void setTenderCorrigendums(Set<TenderCorrigendum> tenderCorrigendums) {
        if (this.tenderCorrigendums != null) {
            this.tenderCorrigendums.forEach(i -> i.setNoticeInvitingTender(null));
        }
        if (tenderCorrigendums != null) {
            tenderCorrigendums.forEach(i -> i.setNoticeInvitingTender(this));
        }
        this.tenderCorrigendums = tenderCorrigendums;
    }

    public Set<TenderQuery> getTenderQueries() {
        return this.tenderQueries;
    }

    public NoticeInvitingTender tenderQueries(Set<TenderQuery> tenderQueries) {
        this.setTenderQueries(tenderQueries);
        return this;
    }

    public NoticeInvitingTender addTenderQuery(TenderQuery tenderQuery) {
        this.tenderQueries.add(tenderQuery);
        tenderQuery.setNoticeInvitingTender(this);
        return this;
    }

    public NoticeInvitingTender removeTenderQuery(TenderQuery tenderQuery) {
        this.tenderQueries.remove(tenderQuery);
        tenderQuery.setNoticeInvitingTender(null);
        return this;
    }

    public void setTenderQueries(Set<TenderQuery> tenderQueries) {
        if (this.tenderQueries != null) {
            this.tenderQueries.forEach(i -> i.setNoticeInvitingTender(null));
        }
        if (tenderQueries != null) {
            tenderQueries.forEach(i -> i.setNoticeInvitingTender(this));
        }
        this.tenderQueries = tenderQueries;
    }

    public Set<TenderScrutinyCommittee> getTenderScrutinyCommittees() {
        return this.tenderScrutinyCommittees;
    }

    public NoticeInvitingTender tenderScrutinyCommittees(Set<TenderScrutinyCommittee> tenderScrutinyCommittees) {
        this.setTenderScrutinyCommittees(tenderScrutinyCommittees);
        return this;
    }

    public NoticeInvitingTender addTenderScrutinyCommittee(TenderScrutinyCommittee tenderScrutinyCommittee) {
        this.tenderScrutinyCommittees.add(tenderScrutinyCommittee);
        tenderScrutinyCommittee.setNoticeInvitingTender(this);
        return this;
    }

    public NoticeInvitingTender removeTenderScrutinyCommittee(TenderScrutinyCommittee tenderScrutinyCommittee) {
        this.tenderScrutinyCommittees.remove(tenderScrutinyCommittee);
        tenderScrutinyCommittee.setNoticeInvitingTender(null);
        return this;
    }

    public void setTenderScrutinyCommittees(Set<TenderScrutinyCommittee> tenderScrutinyCommittees) {
        if (this.tenderScrutinyCommittees != null) {
            this.tenderScrutinyCommittees.forEach(i -> i.setNoticeInvitingTender(null));
        }
        if (tenderScrutinyCommittees != null) {
            tenderScrutinyCommittees.forEach(i -> i.setNoticeInvitingTender(this));
        }
        this.tenderScrutinyCommittees = tenderScrutinyCommittees;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NoticeInvitingTender)) {
            return false;
        }
        return id != null && id.equals(((NoticeInvitingTender) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NoticeInvitingTender{" +
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
            "}";
    }
}
