package com.mycompany.myapp.web.rest;

import static com.mycompany.myapp.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.TenderCorrigendum;
import com.mycompany.myapp.repository.TenderCorrigendumRepository;
import com.mycompany.myapp.service.dto.TenderCorrigendumDTO;
import com.mycompany.myapp.service.mapper.TenderCorrigendumMapper;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link TenderCorrigendumResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TenderCorrigendumResourceIT {

    private static final String DEFAULT_REASON = "AAAAAAAAAA";
    private static final String UPDATED_REASON = "BBBBBBBBBB";

    private static final Integer DEFAULT_HISTORY_ORDER = 1;
    private static final Integer UPDATED_HISTORY_ORDER = 2;

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_TENDER_DOC_CLOSE_DATE_ORIGINAL = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_TENDER_DOC_CLOSE_DATE_ORIGINAL = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_TENDER_DOC_CLOSE_DATE_REVISED = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_TENDER_DOC_CLOSE_DATE_REVISED = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_TENDER_RECEIPT_CLOSE_DATE_ORIGINAL = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_TENDER_RECEIPT_CLOSE_DATE_ORIGINAL = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_TENDER_RECEIPT_CLOSE_DATE_REVISED = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_TENDER_RECEIPT_CLOSE_DATE_REVISED = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_TENDER_QUERY_CLOSE_DATE_ORIGINAL = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_TENDER_QUERY_CLOSE_DATE_ORIGINAL = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_TENDER_QUERY_CLOSE_DATE_REVISED = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_TENDER_QUERY_CLOSE_DATE_REVISED = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_TECHNICAL_BID_OPEN_DATE_ORIGINAL = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_TECHNICAL_BID_OPEN_DATE_ORIGINAL = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_TECHNICAL_BID_OPEN_DATE_REVISED = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_TECHNICAL_BID_OPEN_DATE_REVISED = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_FINANCIAL_BID_OPEN_DATE_ORIGINAL = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_FINANCIAL_BID_OPEN_DATE_ORIGINAL = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_FINANCIAL_BID_OPEN_DATE_REVISED = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_FINANCIAL_BID_OPEN_DATE_REVISED = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_PREQUAL_BID_OPEN_DATE_ORIGINAL = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_PREQUAL_BID_OPEN_DATE_ORIGINAL = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_PREQUAL_BID_OPEN_DATE_REVISED = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_PREQUAL_BID_OPEN_DATE_REVISED = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_PREQUAL_TENDER_BID_OPEN_ORIGINAL = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_PREQUAL_TENDER_BID_OPEN_ORIGINAL = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_PREQUAL_TENDER_BID_OPEN_REVISED = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_PREQUAL_TENDER_BID_OPEN_REVISED = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_PRE_BID_MEETING_DATE_ORIGINAL = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_PRE_BID_MEETING_DATE_ORIGINAL = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_PRE_BID_MEETING_DATE_REVISED = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_PRE_BID_MEETING_DATE_REVISED = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_PREQUAL_VALIDITY_PERIOD_ORIGINAL = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_PREQUAL_VALIDITY_PERIOD_ORIGINAL = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_PREQUAL_VALIDITY_PERIOD_REVISED = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_PREQUAL_VALIDITY_PERIOD_REVISED = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Long DEFAULT_PREBID_MEETING_ADDRESS_ORIGINAL = 1L;
    private static final Long UPDATED_PREBID_MEETING_ADDRESS_ORIGINAL = 2L;

    private static final Long DEFAULT_PREBID_MEETING_ADDRESS_REVISED = 1L;
    private static final Long UPDATED_PREBID_MEETING_ADDRESS_REVISED = 2L;

    private static final String ENTITY_API_URL = "/api/tender-corrigendums";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private TenderCorrigendumRepository tenderCorrigendumRepository;

    @Autowired
    private TenderCorrigendumMapper tenderCorrigendumMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTenderCorrigendumMockMvc;

    private TenderCorrigendum tenderCorrigendum;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderCorrigendum createEntity(EntityManager em) {
        TenderCorrigendum tenderCorrigendum = new TenderCorrigendum()
            .reason(DEFAULT_REASON)
            .historyOrder(DEFAULT_HISTORY_ORDER)
            .status(DEFAULT_STATUS)
            .tenderDocCloseDateOriginal(DEFAULT_TENDER_DOC_CLOSE_DATE_ORIGINAL)
            .tenderDocCloseDateRevised(DEFAULT_TENDER_DOC_CLOSE_DATE_REVISED)
            .tenderReceiptCloseDateOriginal(DEFAULT_TENDER_RECEIPT_CLOSE_DATE_ORIGINAL)
            .tenderReceiptCloseDateRevised(DEFAULT_TENDER_RECEIPT_CLOSE_DATE_REVISED)
            .tenderQueryCloseDateOriginal(DEFAULT_TENDER_QUERY_CLOSE_DATE_ORIGINAL)
            .tenderQueryCloseDateRevised(DEFAULT_TENDER_QUERY_CLOSE_DATE_REVISED)
            .technicalBidOpenDateOriginal(DEFAULT_TECHNICAL_BID_OPEN_DATE_ORIGINAL)
            .technicalBidOpenDateRevised(DEFAULT_TECHNICAL_BID_OPEN_DATE_REVISED)
            .financialBidOpenDateOriginal(DEFAULT_FINANCIAL_BID_OPEN_DATE_ORIGINAL)
            .financialBidOpenDateRevised(DEFAULT_FINANCIAL_BID_OPEN_DATE_REVISED)
            .prequalBidOpenDateOriginal(DEFAULT_PREQUAL_BID_OPEN_DATE_ORIGINAL)
            .prequalBidOpenDateRevised(DEFAULT_PREQUAL_BID_OPEN_DATE_REVISED)
            .prequalTenderBidOpenOriginal(DEFAULT_PREQUAL_TENDER_BID_OPEN_ORIGINAL)
            .prequalTenderBidOpenRevised(DEFAULT_PREQUAL_TENDER_BID_OPEN_REVISED)
            .preBidMeetingDateOriginal(DEFAULT_PRE_BID_MEETING_DATE_ORIGINAL)
            .preBidMeetingDateRevised(DEFAULT_PRE_BID_MEETING_DATE_REVISED)
            .prequalValidityPeriodOriginal(DEFAULT_PREQUAL_VALIDITY_PERIOD_ORIGINAL)
            .prequalValidityPeriodRevised(DEFAULT_PREQUAL_VALIDITY_PERIOD_REVISED)
            .prebidMeetingAddressOriginal(DEFAULT_PREBID_MEETING_ADDRESS_ORIGINAL)
            .prebidMeetingAddressRevised(DEFAULT_PREBID_MEETING_ADDRESS_REVISED);
        return tenderCorrigendum;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderCorrigendum createUpdatedEntity(EntityManager em) {
        TenderCorrigendum tenderCorrigendum = new TenderCorrigendum()
            .reason(UPDATED_REASON)
            .historyOrder(UPDATED_HISTORY_ORDER)
            .status(UPDATED_STATUS)
            .tenderDocCloseDateOriginal(UPDATED_TENDER_DOC_CLOSE_DATE_ORIGINAL)
            .tenderDocCloseDateRevised(UPDATED_TENDER_DOC_CLOSE_DATE_REVISED)
            .tenderReceiptCloseDateOriginal(UPDATED_TENDER_RECEIPT_CLOSE_DATE_ORIGINAL)
            .tenderReceiptCloseDateRevised(UPDATED_TENDER_RECEIPT_CLOSE_DATE_REVISED)
            .tenderQueryCloseDateOriginal(UPDATED_TENDER_QUERY_CLOSE_DATE_ORIGINAL)
            .tenderQueryCloseDateRevised(UPDATED_TENDER_QUERY_CLOSE_DATE_REVISED)
            .technicalBidOpenDateOriginal(UPDATED_TECHNICAL_BID_OPEN_DATE_ORIGINAL)
            .technicalBidOpenDateRevised(UPDATED_TECHNICAL_BID_OPEN_DATE_REVISED)
            .financialBidOpenDateOriginal(UPDATED_FINANCIAL_BID_OPEN_DATE_ORIGINAL)
            .financialBidOpenDateRevised(UPDATED_FINANCIAL_BID_OPEN_DATE_REVISED)
            .prequalBidOpenDateOriginal(UPDATED_PREQUAL_BID_OPEN_DATE_ORIGINAL)
            .prequalBidOpenDateRevised(UPDATED_PREQUAL_BID_OPEN_DATE_REVISED)
            .prequalTenderBidOpenOriginal(UPDATED_PREQUAL_TENDER_BID_OPEN_ORIGINAL)
            .prequalTenderBidOpenRevised(UPDATED_PREQUAL_TENDER_BID_OPEN_REVISED)
            .preBidMeetingDateOriginal(UPDATED_PRE_BID_MEETING_DATE_ORIGINAL)
            .preBidMeetingDateRevised(UPDATED_PRE_BID_MEETING_DATE_REVISED)
            .prequalValidityPeriodOriginal(UPDATED_PREQUAL_VALIDITY_PERIOD_ORIGINAL)
            .prequalValidityPeriodRevised(UPDATED_PREQUAL_VALIDITY_PERIOD_REVISED)
            .prebidMeetingAddressOriginal(UPDATED_PREBID_MEETING_ADDRESS_ORIGINAL)
            .prebidMeetingAddressRevised(UPDATED_PREBID_MEETING_ADDRESS_REVISED);
        return tenderCorrigendum;
    }

    @BeforeEach
    public void initTest() {
        tenderCorrigendum = createEntity(em);
    }

    @Test
    @Transactional
    void createTenderCorrigendum() throws Exception {
        int databaseSizeBeforeCreate = tenderCorrigendumRepository.findAll().size();
        // Create the TenderCorrigendum
        TenderCorrigendumDTO tenderCorrigendumDTO = tenderCorrigendumMapper.toDto(tenderCorrigendum);
        restTenderCorrigendumMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCorrigendumDTO))
            )
            .andExpect(status().isCreated());

        // Validate the TenderCorrigendum in the database
        List<TenderCorrigendum> tenderCorrigendumList = tenderCorrigendumRepository.findAll();
        assertThat(tenderCorrigendumList).hasSize(databaseSizeBeforeCreate + 1);
        TenderCorrigendum testTenderCorrigendum = tenderCorrigendumList.get(tenderCorrigendumList.size() - 1);
        assertThat(testTenderCorrigendum.getReason()).isEqualTo(DEFAULT_REASON);
        assertThat(testTenderCorrigendum.getHistoryOrder()).isEqualTo(DEFAULT_HISTORY_ORDER);
        assertThat(testTenderCorrigendum.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testTenderCorrigendum.getTenderDocCloseDateOriginal()).isEqualTo(DEFAULT_TENDER_DOC_CLOSE_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTenderDocCloseDateRevised()).isEqualTo(DEFAULT_TENDER_DOC_CLOSE_DATE_REVISED);
        assertThat(testTenderCorrigendum.getTenderReceiptCloseDateOriginal()).isEqualTo(DEFAULT_TENDER_RECEIPT_CLOSE_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTenderReceiptCloseDateRevised()).isEqualTo(DEFAULT_TENDER_RECEIPT_CLOSE_DATE_REVISED);
        assertThat(testTenderCorrigendum.getTenderQueryCloseDateOriginal()).isEqualTo(DEFAULT_TENDER_QUERY_CLOSE_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTenderQueryCloseDateRevised()).isEqualTo(DEFAULT_TENDER_QUERY_CLOSE_DATE_REVISED);
        assertThat(testTenderCorrigendum.getTechnicalBidOpenDateOriginal()).isEqualTo(DEFAULT_TECHNICAL_BID_OPEN_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTechnicalBidOpenDateRevised()).isEqualTo(DEFAULT_TECHNICAL_BID_OPEN_DATE_REVISED);
        assertThat(testTenderCorrigendum.getFinancialBidOpenDateOriginal()).isEqualTo(DEFAULT_FINANCIAL_BID_OPEN_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getFinancialBidOpenDateRevised()).isEqualTo(DEFAULT_FINANCIAL_BID_OPEN_DATE_REVISED);
        assertThat(testTenderCorrigendum.getPrequalBidOpenDateOriginal()).isEqualTo(DEFAULT_PREQUAL_BID_OPEN_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrequalBidOpenDateRevised()).isEqualTo(DEFAULT_PREQUAL_BID_OPEN_DATE_REVISED);
        assertThat(testTenderCorrigendum.getPrequalTenderBidOpenOriginal()).isEqualTo(DEFAULT_PREQUAL_TENDER_BID_OPEN_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrequalTenderBidOpenRevised()).isEqualTo(DEFAULT_PREQUAL_TENDER_BID_OPEN_REVISED);
        assertThat(testTenderCorrigendum.getPreBidMeetingDateOriginal()).isEqualTo(DEFAULT_PRE_BID_MEETING_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getPreBidMeetingDateRevised()).isEqualTo(DEFAULT_PRE_BID_MEETING_DATE_REVISED);
        assertThat(testTenderCorrigendum.getPrequalValidityPeriodOriginal()).isEqualTo(DEFAULT_PREQUAL_VALIDITY_PERIOD_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrequalValidityPeriodRevised()).isEqualTo(DEFAULT_PREQUAL_VALIDITY_PERIOD_REVISED);
        assertThat(testTenderCorrigendum.getPrebidMeetingAddressOriginal()).isEqualTo(DEFAULT_PREBID_MEETING_ADDRESS_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrebidMeetingAddressRevised()).isEqualTo(DEFAULT_PREBID_MEETING_ADDRESS_REVISED);
    }

    @Test
    @Transactional
    void createTenderCorrigendumWithExistingId() throws Exception {
        // Create the TenderCorrigendum with an existing ID
        tenderCorrigendum.setId(1L);
        TenderCorrigendumDTO tenderCorrigendumDTO = tenderCorrigendumMapper.toDto(tenderCorrigendum);

        int databaseSizeBeforeCreate = tenderCorrigendumRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTenderCorrigendumMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCorrigendumDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCorrigendum in the database
        List<TenderCorrigendum> tenderCorrigendumList = tenderCorrigendumRepository.findAll();
        assertThat(tenderCorrigendumList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllTenderCorrigendums() throws Exception {
        // Initialize the database
        tenderCorrigendumRepository.saveAndFlush(tenderCorrigendum);

        // Get all the tenderCorrigendumList
        restTenderCorrigendumMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tenderCorrigendum.getId().intValue())))
            .andExpect(jsonPath("$.[*].reason").value(hasItem(DEFAULT_REASON)))
            .andExpect(jsonPath("$.[*].historyOrder").value(hasItem(DEFAULT_HISTORY_ORDER)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].tenderDocCloseDateOriginal").value(hasItem(sameInstant(DEFAULT_TENDER_DOC_CLOSE_DATE_ORIGINAL))))
            .andExpect(jsonPath("$.[*].tenderDocCloseDateRevised").value(hasItem(sameInstant(DEFAULT_TENDER_DOC_CLOSE_DATE_REVISED))))
            .andExpect(
                jsonPath("$.[*].tenderReceiptCloseDateOriginal").value(hasItem(sameInstant(DEFAULT_TENDER_RECEIPT_CLOSE_DATE_ORIGINAL)))
            )
            .andExpect(
                jsonPath("$.[*].tenderReceiptCloseDateRevised").value(hasItem(sameInstant(DEFAULT_TENDER_RECEIPT_CLOSE_DATE_REVISED)))
            )
            .andExpect(jsonPath("$.[*].tenderQueryCloseDateOriginal").value(hasItem(sameInstant(DEFAULT_TENDER_QUERY_CLOSE_DATE_ORIGINAL))))
            .andExpect(jsonPath("$.[*].tenderQueryCloseDateRevised").value(hasItem(sameInstant(DEFAULT_TENDER_QUERY_CLOSE_DATE_REVISED))))
            .andExpect(jsonPath("$.[*].technicalBidOpenDateOriginal").value(hasItem(sameInstant(DEFAULT_TECHNICAL_BID_OPEN_DATE_ORIGINAL))))
            .andExpect(jsonPath("$.[*].technicalBidOpenDateRevised").value(hasItem(sameInstant(DEFAULT_TECHNICAL_BID_OPEN_DATE_REVISED))))
            .andExpect(jsonPath("$.[*].financialBidOpenDateOriginal").value(hasItem(sameInstant(DEFAULT_FINANCIAL_BID_OPEN_DATE_ORIGINAL))))
            .andExpect(jsonPath("$.[*].financialBidOpenDateRevised").value(hasItem(sameInstant(DEFAULT_FINANCIAL_BID_OPEN_DATE_REVISED))))
            .andExpect(jsonPath("$.[*].prequalBidOpenDateOriginal").value(hasItem(sameInstant(DEFAULT_PREQUAL_BID_OPEN_DATE_ORIGINAL))))
            .andExpect(jsonPath("$.[*].prequalBidOpenDateRevised").value(hasItem(sameInstant(DEFAULT_PREQUAL_BID_OPEN_DATE_REVISED))))
            .andExpect(jsonPath("$.[*].prequalTenderBidOpenOriginal").value(hasItem(sameInstant(DEFAULT_PREQUAL_TENDER_BID_OPEN_ORIGINAL))))
            .andExpect(jsonPath("$.[*].prequalTenderBidOpenRevised").value(hasItem(sameInstant(DEFAULT_PREQUAL_TENDER_BID_OPEN_REVISED))))
            .andExpect(jsonPath("$.[*].preBidMeetingDateOriginal").value(hasItem(sameInstant(DEFAULT_PRE_BID_MEETING_DATE_ORIGINAL))))
            .andExpect(jsonPath("$.[*].preBidMeetingDateRevised").value(hasItem(sameInstant(DEFAULT_PRE_BID_MEETING_DATE_REVISED))))
            .andExpect(
                jsonPath("$.[*].prequalValidityPeriodOriginal").value(hasItem(sameInstant(DEFAULT_PREQUAL_VALIDITY_PERIOD_ORIGINAL)))
            )
            .andExpect(jsonPath("$.[*].prequalValidityPeriodRevised").value(hasItem(sameInstant(DEFAULT_PREQUAL_VALIDITY_PERIOD_REVISED))))
            .andExpect(jsonPath("$.[*].prebidMeetingAddressOriginal").value(hasItem(DEFAULT_PREBID_MEETING_ADDRESS_ORIGINAL.intValue())))
            .andExpect(jsonPath("$.[*].prebidMeetingAddressRevised").value(hasItem(DEFAULT_PREBID_MEETING_ADDRESS_REVISED.intValue())));
    }

    @Test
    @Transactional
    void getTenderCorrigendum() throws Exception {
        // Initialize the database
        tenderCorrigendumRepository.saveAndFlush(tenderCorrigendum);

        // Get the tenderCorrigendum
        restTenderCorrigendumMockMvc
            .perform(get(ENTITY_API_URL_ID, tenderCorrigendum.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(tenderCorrigendum.getId().intValue()))
            .andExpect(jsonPath("$.reason").value(DEFAULT_REASON))
            .andExpect(jsonPath("$.historyOrder").value(DEFAULT_HISTORY_ORDER))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.tenderDocCloseDateOriginal").value(sameInstant(DEFAULT_TENDER_DOC_CLOSE_DATE_ORIGINAL)))
            .andExpect(jsonPath("$.tenderDocCloseDateRevised").value(sameInstant(DEFAULT_TENDER_DOC_CLOSE_DATE_REVISED)))
            .andExpect(jsonPath("$.tenderReceiptCloseDateOriginal").value(sameInstant(DEFAULT_TENDER_RECEIPT_CLOSE_DATE_ORIGINAL)))
            .andExpect(jsonPath("$.tenderReceiptCloseDateRevised").value(sameInstant(DEFAULT_TENDER_RECEIPT_CLOSE_DATE_REVISED)))
            .andExpect(jsonPath("$.tenderQueryCloseDateOriginal").value(sameInstant(DEFAULT_TENDER_QUERY_CLOSE_DATE_ORIGINAL)))
            .andExpect(jsonPath("$.tenderQueryCloseDateRevised").value(sameInstant(DEFAULT_TENDER_QUERY_CLOSE_DATE_REVISED)))
            .andExpect(jsonPath("$.technicalBidOpenDateOriginal").value(sameInstant(DEFAULT_TECHNICAL_BID_OPEN_DATE_ORIGINAL)))
            .andExpect(jsonPath("$.technicalBidOpenDateRevised").value(sameInstant(DEFAULT_TECHNICAL_BID_OPEN_DATE_REVISED)))
            .andExpect(jsonPath("$.financialBidOpenDateOriginal").value(sameInstant(DEFAULT_FINANCIAL_BID_OPEN_DATE_ORIGINAL)))
            .andExpect(jsonPath("$.financialBidOpenDateRevised").value(sameInstant(DEFAULT_FINANCIAL_BID_OPEN_DATE_REVISED)))
            .andExpect(jsonPath("$.prequalBidOpenDateOriginal").value(sameInstant(DEFAULT_PREQUAL_BID_OPEN_DATE_ORIGINAL)))
            .andExpect(jsonPath("$.prequalBidOpenDateRevised").value(sameInstant(DEFAULT_PREQUAL_BID_OPEN_DATE_REVISED)))
            .andExpect(jsonPath("$.prequalTenderBidOpenOriginal").value(sameInstant(DEFAULT_PREQUAL_TENDER_BID_OPEN_ORIGINAL)))
            .andExpect(jsonPath("$.prequalTenderBidOpenRevised").value(sameInstant(DEFAULT_PREQUAL_TENDER_BID_OPEN_REVISED)))
            .andExpect(jsonPath("$.preBidMeetingDateOriginal").value(sameInstant(DEFAULT_PRE_BID_MEETING_DATE_ORIGINAL)))
            .andExpect(jsonPath("$.preBidMeetingDateRevised").value(sameInstant(DEFAULT_PRE_BID_MEETING_DATE_REVISED)))
            .andExpect(jsonPath("$.prequalValidityPeriodOriginal").value(sameInstant(DEFAULT_PREQUAL_VALIDITY_PERIOD_ORIGINAL)))
            .andExpect(jsonPath("$.prequalValidityPeriodRevised").value(sameInstant(DEFAULT_PREQUAL_VALIDITY_PERIOD_REVISED)))
            .andExpect(jsonPath("$.prebidMeetingAddressOriginal").value(DEFAULT_PREBID_MEETING_ADDRESS_ORIGINAL.intValue()))
            .andExpect(jsonPath("$.prebidMeetingAddressRevised").value(DEFAULT_PREBID_MEETING_ADDRESS_REVISED.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingTenderCorrigendum() throws Exception {
        // Get the tenderCorrigendum
        restTenderCorrigendumMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewTenderCorrigendum() throws Exception {
        // Initialize the database
        tenderCorrigendumRepository.saveAndFlush(tenderCorrigendum);

        int databaseSizeBeforeUpdate = tenderCorrigendumRepository.findAll().size();

        // Update the tenderCorrigendum
        TenderCorrigendum updatedTenderCorrigendum = tenderCorrigendumRepository.findById(tenderCorrigendum.getId()).get();
        // Disconnect from session so that the updates on updatedTenderCorrigendum are not directly saved in db
        em.detach(updatedTenderCorrigendum);
        updatedTenderCorrigendum
            .reason(UPDATED_REASON)
            .historyOrder(UPDATED_HISTORY_ORDER)
            .status(UPDATED_STATUS)
            .tenderDocCloseDateOriginal(UPDATED_TENDER_DOC_CLOSE_DATE_ORIGINAL)
            .tenderDocCloseDateRevised(UPDATED_TENDER_DOC_CLOSE_DATE_REVISED)
            .tenderReceiptCloseDateOriginal(UPDATED_TENDER_RECEIPT_CLOSE_DATE_ORIGINAL)
            .tenderReceiptCloseDateRevised(UPDATED_TENDER_RECEIPT_CLOSE_DATE_REVISED)
            .tenderQueryCloseDateOriginal(UPDATED_TENDER_QUERY_CLOSE_DATE_ORIGINAL)
            .tenderQueryCloseDateRevised(UPDATED_TENDER_QUERY_CLOSE_DATE_REVISED)
            .technicalBidOpenDateOriginal(UPDATED_TECHNICAL_BID_OPEN_DATE_ORIGINAL)
            .technicalBidOpenDateRevised(UPDATED_TECHNICAL_BID_OPEN_DATE_REVISED)
            .financialBidOpenDateOriginal(UPDATED_FINANCIAL_BID_OPEN_DATE_ORIGINAL)
            .financialBidOpenDateRevised(UPDATED_FINANCIAL_BID_OPEN_DATE_REVISED)
            .prequalBidOpenDateOriginal(UPDATED_PREQUAL_BID_OPEN_DATE_ORIGINAL)
            .prequalBidOpenDateRevised(UPDATED_PREQUAL_BID_OPEN_DATE_REVISED)
            .prequalTenderBidOpenOriginal(UPDATED_PREQUAL_TENDER_BID_OPEN_ORIGINAL)
            .prequalTenderBidOpenRevised(UPDATED_PREQUAL_TENDER_BID_OPEN_REVISED)
            .preBidMeetingDateOriginal(UPDATED_PRE_BID_MEETING_DATE_ORIGINAL)
            .preBidMeetingDateRevised(UPDATED_PRE_BID_MEETING_DATE_REVISED)
            .prequalValidityPeriodOriginal(UPDATED_PREQUAL_VALIDITY_PERIOD_ORIGINAL)
            .prequalValidityPeriodRevised(UPDATED_PREQUAL_VALIDITY_PERIOD_REVISED)
            .prebidMeetingAddressOriginal(UPDATED_PREBID_MEETING_ADDRESS_ORIGINAL)
            .prebidMeetingAddressRevised(UPDATED_PREBID_MEETING_ADDRESS_REVISED);
        TenderCorrigendumDTO tenderCorrigendumDTO = tenderCorrigendumMapper.toDto(updatedTenderCorrigendum);

        restTenderCorrigendumMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderCorrigendumDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCorrigendumDTO))
            )
            .andExpect(status().isOk());

        // Validate the TenderCorrigendum in the database
        List<TenderCorrigendum> tenderCorrigendumList = tenderCorrigendumRepository.findAll();
        assertThat(tenderCorrigendumList).hasSize(databaseSizeBeforeUpdate);
        TenderCorrigendum testTenderCorrigendum = tenderCorrigendumList.get(tenderCorrigendumList.size() - 1);
        assertThat(testTenderCorrigendum.getReason()).isEqualTo(UPDATED_REASON);
        assertThat(testTenderCorrigendum.getHistoryOrder()).isEqualTo(UPDATED_HISTORY_ORDER);
        assertThat(testTenderCorrigendum.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testTenderCorrigendum.getTenderDocCloseDateOriginal()).isEqualTo(UPDATED_TENDER_DOC_CLOSE_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTenderDocCloseDateRevised()).isEqualTo(UPDATED_TENDER_DOC_CLOSE_DATE_REVISED);
        assertThat(testTenderCorrigendum.getTenderReceiptCloseDateOriginal()).isEqualTo(UPDATED_TENDER_RECEIPT_CLOSE_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTenderReceiptCloseDateRevised()).isEqualTo(UPDATED_TENDER_RECEIPT_CLOSE_DATE_REVISED);
        assertThat(testTenderCorrigendum.getTenderQueryCloseDateOriginal()).isEqualTo(UPDATED_TENDER_QUERY_CLOSE_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTenderQueryCloseDateRevised()).isEqualTo(UPDATED_TENDER_QUERY_CLOSE_DATE_REVISED);
        assertThat(testTenderCorrigendum.getTechnicalBidOpenDateOriginal()).isEqualTo(UPDATED_TECHNICAL_BID_OPEN_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTechnicalBidOpenDateRevised()).isEqualTo(UPDATED_TECHNICAL_BID_OPEN_DATE_REVISED);
        assertThat(testTenderCorrigendum.getFinancialBidOpenDateOriginal()).isEqualTo(UPDATED_FINANCIAL_BID_OPEN_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getFinancialBidOpenDateRevised()).isEqualTo(UPDATED_FINANCIAL_BID_OPEN_DATE_REVISED);
        assertThat(testTenderCorrigendum.getPrequalBidOpenDateOriginal()).isEqualTo(UPDATED_PREQUAL_BID_OPEN_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrequalBidOpenDateRevised()).isEqualTo(UPDATED_PREQUAL_BID_OPEN_DATE_REVISED);
        assertThat(testTenderCorrigendum.getPrequalTenderBidOpenOriginal()).isEqualTo(UPDATED_PREQUAL_TENDER_BID_OPEN_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrequalTenderBidOpenRevised()).isEqualTo(UPDATED_PREQUAL_TENDER_BID_OPEN_REVISED);
        assertThat(testTenderCorrigendum.getPreBidMeetingDateOriginal()).isEqualTo(UPDATED_PRE_BID_MEETING_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getPreBidMeetingDateRevised()).isEqualTo(UPDATED_PRE_BID_MEETING_DATE_REVISED);
        assertThat(testTenderCorrigendum.getPrequalValidityPeriodOriginal()).isEqualTo(UPDATED_PREQUAL_VALIDITY_PERIOD_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrequalValidityPeriodRevised()).isEqualTo(UPDATED_PREQUAL_VALIDITY_PERIOD_REVISED);
        assertThat(testTenderCorrigendum.getPrebidMeetingAddressOriginal()).isEqualTo(UPDATED_PREBID_MEETING_ADDRESS_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrebidMeetingAddressRevised()).isEqualTo(UPDATED_PREBID_MEETING_ADDRESS_REVISED);
    }

    @Test
    @Transactional
    void putNonExistingTenderCorrigendum() throws Exception {
        int databaseSizeBeforeUpdate = tenderCorrigendumRepository.findAll().size();
        tenderCorrigendum.setId(count.incrementAndGet());

        // Create the TenderCorrigendum
        TenderCorrigendumDTO tenderCorrigendumDTO = tenderCorrigendumMapper.toDto(tenderCorrigendum);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderCorrigendumMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderCorrigendumDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCorrigendumDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCorrigendum in the database
        List<TenderCorrigendum> tenderCorrigendumList = tenderCorrigendumRepository.findAll();
        assertThat(tenderCorrigendumList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTenderCorrigendum() throws Exception {
        int databaseSizeBeforeUpdate = tenderCorrigendumRepository.findAll().size();
        tenderCorrigendum.setId(count.incrementAndGet());

        // Create the TenderCorrigendum
        TenderCorrigendumDTO tenderCorrigendumDTO = tenderCorrigendumMapper.toDto(tenderCorrigendum);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderCorrigendumMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCorrigendumDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCorrigendum in the database
        List<TenderCorrigendum> tenderCorrigendumList = tenderCorrigendumRepository.findAll();
        assertThat(tenderCorrigendumList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTenderCorrigendum() throws Exception {
        int databaseSizeBeforeUpdate = tenderCorrigendumRepository.findAll().size();
        tenderCorrigendum.setId(count.incrementAndGet());

        // Create the TenderCorrigendum
        TenderCorrigendumDTO tenderCorrigendumDTO = tenderCorrigendumMapper.toDto(tenderCorrigendum);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderCorrigendumMockMvc
            .perform(
                put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderCorrigendumDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderCorrigendum in the database
        List<TenderCorrigendum> tenderCorrigendumList = tenderCorrigendumRepository.findAll();
        assertThat(tenderCorrigendumList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTenderCorrigendumWithPatch() throws Exception {
        // Initialize the database
        tenderCorrigendumRepository.saveAndFlush(tenderCorrigendum);

        int databaseSizeBeforeUpdate = tenderCorrigendumRepository.findAll().size();

        // Update the tenderCorrigendum using partial update
        TenderCorrigendum partialUpdatedTenderCorrigendum = new TenderCorrigendum();
        partialUpdatedTenderCorrigendum.setId(tenderCorrigendum.getId());

        partialUpdatedTenderCorrigendum
            .historyOrder(UPDATED_HISTORY_ORDER)
            .status(UPDATED_STATUS)
            .tenderDocCloseDateOriginal(UPDATED_TENDER_DOC_CLOSE_DATE_ORIGINAL)
            .technicalBidOpenDateRevised(UPDATED_TECHNICAL_BID_OPEN_DATE_REVISED)
            .financialBidOpenDateOriginal(UPDATED_FINANCIAL_BID_OPEN_DATE_ORIGINAL)
            .prequalValidityPeriodOriginal(UPDATED_PREQUAL_VALIDITY_PERIOD_ORIGINAL);

        restTenderCorrigendumMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderCorrigendum.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderCorrigendum))
            )
            .andExpect(status().isOk());

        // Validate the TenderCorrigendum in the database
        List<TenderCorrigendum> tenderCorrigendumList = tenderCorrigendumRepository.findAll();
        assertThat(tenderCorrigendumList).hasSize(databaseSizeBeforeUpdate);
        TenderCorrigendum testTenderCorrigendum = tenderCorrigendumList.get(tenderCorrigendumList.size() - 1);
        assertThat(testTenderCorrigendum.getReason()).isEqualTo(DEFAULT_REASON);
        assertThat(testTenderCorrigendum.getHistoryOrder()).isEqualTo(UPDATED_HISTORY_ORDER);
        assertThat(testTenderCorrigendum.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testTenderCorrigendum.getTenderDocCloseDateOriginal()).isEqualTo(UPDATED_TENDER_DOC_CLOSE_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTenderDocCloseDateRevised()).isEqualTo(DEFAULT_TENDER_DOC_CLOSE_DATE_REVISED);
        assertThat(testTenderCorrigendum.getTenderReceiptCloseDateOriginal()).isEqualTo(DEFAULT_TENDER_RECEIPT_CLOSE_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTenderReceiptCloseDateRevised()).isEqualTo(DEFAULT_TENDER_RECEIPT_CLOSE_DATE_REVISED);
        assertThat(testTenderCorrigendum.getTenderQueryCloseDateOriginal()).isEqualTo(DEFAULT_TENDER_QUERY_CLOSE_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTenderQueryCloseDateRevised()).isEqualTo(DEFAULT_TENDER_QUERY_CLOSE_DATE_REVISED);
        assertThat(testTenderCorrigendum.getTechnicalBidOpenDateOriginal()).isEqualTo(DEFAULT_TECHNICAL_BID_OPEN_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTechnicalBidOpenDateRevised()).isEqualTo(UPDATED_TECHNICAL_BID_OPEN_DATE_REVISED);
        assertThat(testTenderCorrigendum.getFinancialBidOpenDateOriginal()).isEqualTo(UPDATED_FINANCIAL_BID_OPEN_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getFinancialBidOpenDateRevised()).isEqualTo(DEFAULT_FINANCIAL_BID_OPEN_DATE_REVISED);
        assertThat(testTenderCorrigendum.getPrequalBidOpenDateOriginal()).isEqualTo(DEFAULT_PREQUAL_BID_OPEN_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrequalBidOpenDateRevised()).isEqualTo(DEFAULT_PREQUAL_BID_OPEN_DATE_REVISED);
        assertThat(testTenderCorrigendum.getPrequalTenderBidOpenOriginal()).isEqualTo(DEFAULT_PREQUAL_TENDER_BID_OPEN_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrequalTenderBidOpenRevised()).isEqualTo(DEFAULT_PREQUAL_TENDER_BID_OPEN_REVISED);
        assertThat(testTenderCorrigendum.getPreBidMeetingDateOriginal()).isEqualTo(DEFAULT_PRE_BID_MEETING_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getPreBidMeetingDateRevised()).isEqualTo(DEFAULT_PRE_BID_MEETING_DATE_REVISED);
        assertThat(testTenderCorrigendum.getPrequalValidityPeriodOriginal()).isEqualTo(UPDATED_PREQUAL_VALIDITY_PERIOD_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrequalValidityPeriodRevised()).isEqualTo(DEFAULT_PREQUAL_VALIDITY_PERIOD_REVISED);
        assertThat(testTenderCorrigendum.getPrebidMeetingAddressOriginal()).isEqualTo(DEFAULT_PREBID_MEETING_ADDRESS_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrebidMeetingAddressRevised()).isEqualTo(DEFAULT_PREBID_MEETING_ADDRESS_REVISED);
    }

    @Test
    @Transactional
    void fullUpdateTenderCorrigendumWithPatch() throws Exception {
        // Initialize the database
        tenderCorrigendumRepository.saveAndFlush(tenderCorrigendum);

        int databaseSizeBeforeUpdate = tenderCorrigendumRepository.findAll().size();

        // Update the tenderCorrigendum using partial update
        TenderCorrigendum partialUpdatedTenderCorrigendum = new TenderCorrigendum();
        partialUpdatedTenderCorrigendum.setId(tenderCorrigendum.getId());

        partialUpdatedTenderCorrigendum
            .reason(UPDATED_REASON)
            .historyOrder(UPDATED_HISTORY_ORDER)
            .status(UPDATED_STATUS)
            .tenderDocCloseDateOriginal(UPDATED_TENDER_DOC_CLOSE_DATE_ORIGINAL)
            .tenderDocCloseDateRevised(UPDATED_TENDER_DOC_CLOSE_DATE_REVISED)
            .tenderReceiptCloseDateOriginal(UPDATED_TENDER_RECEIPT_CLOSE_DATE_ORIGINAL)
            .tenderReceiptCloseDateRevised(UPDATED_TENDER_RECEIPT_CLOSE_DATE_REVISED)
            .tenderQueryCloseDateOriginal(UPDATED_TENDER_QUERY_CLOSE_DATE_ORIGINAL)
            .tenderQueryCloseDateRevised(UPDATED_TENDER_QUERY_CLOSE_DATE_REVISED)
            .technicalBidOpenDateOriginal(UPDATED_TECHNICAL_BID_OPEN_DATE_ORIGINAL)
            .technicalBidOpenDateRevised(UPDATED_TECHNICAL_BID_OPEN_DATE_REVISED)
            .financialBidOpenDateOriginal(UPDATED_FINANCIAL_BID_OPEN_DATE_ORIGINAL)
            .financialBidOpenDateRevised(UPDATED_FINANCIAL_BID_OPEN_DATE_REVISED)
            .prequalBidOpenDateOriginal(UPDATED_PREQUAL_BID_OPEN_DATE_ORIGINAL)
            .prequalBidOpenDateRevised(UPDATED_PREQUAL_BID_OPEN_DATE_REVISED)
            .prequalTenderBidOpenOriginal(UPDATED_PREQUAL_TENDER_BID_OPEN_ORIGINAL)
            .prequalTenderBidOpenRevised(UPDATED_PREQUAL_TENDER_BID_OPEN_REVISED)
            .preBidMeetingDateOriginal(UPDATED_PRE_BID_MEETING_DATE_ORIGINAL)
            .preBidMeetingDateRevised(UPDATED_PRE_BID_MEETING_DATE_REVISED)
            .prequalValidityPeriodOriginal(UPDATED_PREQUAL_VALIDITY_PERIOD_ORIGINAL)
            .prequalValidityPeriodRevised(UPDATED_PREQUAL_VALIDITY_PERIOD_REVISED)
            .prebidMeetingAddressOriginal(UPDATED_PREBID_MEETING_ADDRESS_ORIGINAL)
            .prebidMeetingAddressRevised(UPDATED_PREBID_MEETING_ADDRESS_REVISED);

        restTenderCorrigendumMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderCorrigendum.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderCorrigendum))
            )
            .andExpect(status().isOk());

        // Validate the TenderCorrigendum in the database
        List<TenderCorrigendum> tenderCorrigendumList = tenderCorrigendumRepository.findAll();
        assertThat(tenderCorrigendumList).hasSize(databaseSizeBeforeUpdate);
        TenderCorrigendum testTenderCorrigendum = tenderCorrigendumList.get(tenderCorrigendumList.size() - 1);
        assertThat(testTenderCorrigendum.getReason()).isEqualTo(UPDATED_REASON);
        assertThat(testTenderCorrigendum.getHistoryOrder()).isEqualTo(UPDATED_HISTORY_ORDER);
        assertThat(testTenderCorrigendum.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testTenderCorrigendum.getTenderDocCloseDateOriginal()).isEqualTo(UPDATED_TENDER_DOC_CLOSE_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTenderDocCloseDateRevised()).isEqualTo(UPDATED_TENDER_DOC_CLOSE_DATE_REVISED);
        assertThat(testTenderCorrigendum.getTenderReceiptCloseDateOriginal()).isEqualTo(UPDATED_TENDER_RECEIPT_CLOSE_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTenderReceiptCloseDateRevised()).isEqualTo(UPDATED_TENDER_RECEIPT_CLOSE_DATE_REVISED);
        assertThat(testTenderCorrigendum.getTenderQueryCloseDateOriginal()).isEqualTo(UPDATED_TENDER_QUERY_CLOSE_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTenderQueryCloseDateRevised()).isEqualTo(UPDATED_TENDER_QUERY_CLOSE_DATE_REVISED);
        assertThat(testTenderCorrigendum.getTechnicalBidOpenDateOriginal()).isEqualTo(UPDATED_TECHNICAL_BID_OPEN_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getTechnicalBidOpenDateRevised()).isEqualTo(UPDATED_TECHNICAL_BID_OPEN_DATE_REVISED);
        assertThat(testTenderCorrigendum.getFinancialBidOpenDateOriginal()).isEqualTo(UPDATED_FINANCIAL_BID_OPEN_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getFinancialBidOpenDateRevised()).isEqualTo(UPDATED_FINANCIAL_BID_OPEN_DATE_REVISED);
        assertThat(testTenderCorrigendum.getPrequalBidOpenDateOriginal()).isEqualTo(UPDATED_PREQUAL_BID_OPEN_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrequalBidOpenDateRevised()).isEqualTo(UPDATED_PREQUAL_BID_OPEN_DATE_REVISED);
        assertThat(testTenderCorrigendum.getPrequalTenderBidOpenOriginal()).isEqualTo(UPDATED_PREQUAL_TENDER_BID_OPEN_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrequalTenderBidOpenRevised()).isEqualTo(UPDATED_PREQUAL_TENDER_BID_OPEN_REVISED);
        assertThat(testTenderCorrigendum.getPreBidMeetingDateOriginal()).isEqualTo(UPDATED_PRE_BID_MEETING_DATE_ORIGINAL);
        assertThat(testTenderCorrigendum.getPreBidMeetingDateRevised()).isEqualTo(UPDATED_PRE_BID_MEETING_DATE_REVISED);
        assertThat(testTenderCorrigendum.getPrequalValidityPeriodOriginal()).isEqualTo(UPDATED_PREQUAL_VALIDITY_PERIOD_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrequalValidityPeriodRevised()).isEqualTo(UPDATED_PREQUAL_VALIDITY_PERIOD_REVISED);
        assertThat(testTenderCorrigendum.getPrebidMeetingAddressOriginal()).isEqualTo(UPDATED_PREBID_MEETING_ADDRESS_ORIGINAL);
        assertThat(testTenderCorrigendum.getPrebidMeetingAddressRevised()).isEqualTo(UPDATED_PREBID_MEETING_ADDRESS_REVISED);
    }

    @Test
    @Transactional
    void patchNonExistingTenderCorrigendum() throws Exception {
        int databaseSizeBeforeUpdate = tenderCorrigendumRepository.findAll().size();
        tenderCorrigendum.setId(count.incrementAndGet());

        // Create the TenderCorrigendum
        TenderCorrigendumDTO tenderCorrigendumDTO = tenderCorrigendumMapper.toDto(tenderCorrigendum);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderCorrigendumMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, tenderCorrigendumDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderCorrigendumDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCorrigendum in the database
        List<TenderCorrigendum> tenderCorrigendumList = tenderCorrigendumRepository.findAll();
        assertThat(tenderCorrigendumList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTenderCorrigendum() throws Exception {
        int databaseSizeBeforeUpdate = tenderCorrigendumRepository.findAll().size();
        tenderCorrigendum.setId(count.incrementAndGet());

        // Create the TenderCorrigendum
        TenderCorrigendumDTO tenderCorrigendumDTO = tenderCorrigendumMapper.toDto(tenderCorrigendum);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderCorrigendumMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderCorrigendumDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCorrigendum in the database
        List<TenderCorrigendum> tenderCorrigendumList = tenderCorrigendumRepository.findAll();
        assertThat(tenderCorrigendumList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTenderCorrigendum() throws Exception {
        int databaseSizeBeforeUpdate = tenderCorrigendumRepository.findAll().size();
        tenderCorrigendum.setId(count.incrementAndGet());

        // Create the TenderCorrigendum
        TenderCorrigendumDTO tenderCorrigendumDTO = tenderCorrigendumMapper.toDto(tenderCorrigendum);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderCorrigendumMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderCorrigendumDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderCorrigendum in the database
        List<TenderCorrigendum> tenderCorrigendumList = tenderCorrigendumRepository.findAll();
        assertThat(tenderCorrigendumList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTenderCorrigendum() throws Exception {
        // Initialize the database
        tenderCorrigendumRepository.saveAndFlush(tenderCorrigendum);

        int databaseSizeBeforeDelete = tenderCorrigendumRepository.findAll().size();

        // Delete the tenderCorrigendum
        restTenderCorrigendumMockMvc
            .perform(delete(ENTITY_API_URL_ID, tenderCorrigendum.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<TenderCorrigendum> tenderCorrigendumList = tenderCorrigendumRepository.findAll();
        assertThat(tenderCorrigendumList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
