package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.TenderQuery;
import com.mycompany.myapp.repository.TenderQueryRepository;
import com.mycompany.myapp.service.dto.TenderQueryDTO;
import com.mycompany.myapp.service.mapper.TenderQueryMapper;
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
import org.springframework.util.Base64Utils;

/**
 * Integration tests for the {@link TenderQueryResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TenderQueryResourceIT {

    private static final Long DEFAULT_SUPPLIER_GENERAL_INFO_ID = 1L;
    private static final Long UPDATED_SUPPLIER_GENERAL_INFO_ID = 2L;

    private static final Long DEFAULT_SERIAL_NO = 1L;
    private static final Long UPDATED_SERIAL_NO = 2L;

    private static final String DEFAULT_REFERENCE_DOCUMENT = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCE_DOCUMENT = "BBBBBBBBBB";

    private static final String DEFAULT_DOC_SECTION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DOC_SECTION_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_DOC_PAGE_NO = 1;
    private static final Integer UPDATED_DOC_PAGE_NO = 2;

    private static final String DEFAULT_TENDER_QUERY_TEXT = "AAAAAAAAAA";
    private static final String UPDATED_TENDER_QUERY_TEXT = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/tender-queries";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private TenderQueryRepository tenderQueryRepository;

    @Autowired
    private TenderQueryMapper tenderQueryMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTenderQueryMockMvc;

    private TenderQuery tenderQuery;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderQuery createEntity(EntityManager em) {
        TenderQuery tenderQuery = new TenderQuery()
            .supplierGeneralInfoId(DEFAULT_SUPPLIER_GENERAL_INFO_ID)
            .serialNo(DEFAULT_SERIAL_NO)
            .referenceDocument(DEFAULT_REFERENCE_DOCUMENT)
            .docSectionName(DEFAULT_DOC_SECTION_NAME)
            .docPageNo(DEFAULT_DOC_PAGE_NO)
            .tenderQueryText(DEFAULT_TENDER_QUERY_TEXT);
        return tenderQuery;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderQuery createUpdatedEntity(EntityManager em) {
        TenderQuery tenderQuery = new TenderQuery()
            .supplierGeneralInfoId(UPDATED_SUPPLIER_GENERAL_INFO_ID)
            .serialNo(UPDATED_SERIAL_NO)
            .referenceDocument(UPDATED_REFERENCE_DOCUMENT)
            .docSectionName(UPDATED_DOC_SECTION_NAME)
            .docPageNo(UPDATED_DOC_PAGE_NO)
            .tenderQueryText(UPDATED_TENDER_QUERY_TEXT);
        return tenderQuery;
    }

    @BeforeEach
    public void initTest() {
        tenderQuery = createEntity(em);
    }

    @Test
    @Transactional
    void createTenderQuery() throws Exception {
        int databaseSizeBeforeCreate = tenderQueryRepository.findAll().size();
        // Create the TenderQuery
        TenderQueryDTO tenderQueryDTO = tenderQueryMapper.toDto(tenderQuery);
        restTenderQueryMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderQueryDTO))
            )
            .andExpect(status().isCreated());

        // Validate the TenderQuery in the database
        List<TenderQuery> tenderQueryList = tenderQueryRepository.findAll();
        assertThat(tenderQueryList).hasSize(databaseSizeBeforeCreate + 1);
        TenderQuery testTenderQuery = tenderQueryList.get(tenderQueryList.size() - 1);
        assertThat(testTenderQuery.getSupplierGeneralInfoId()).isEqualTo(DEFAULT_SUPPLIER_GENERAL_INFO_ID);
        assertThat(testTenderQuery.getSerialNo()).isEqualTo(DEFAULT_SERIAL_NO);
        assertThat(testTenderQuery.getReferenceDocument()).isEqualTo(DEFAULT_REFERENCE_DOCUMENT);
        assertThat(testTenderQuery.getDocSectionName()).isEqualTo(DEFAULT_DOC_SECTION_NAME);
        assertThat(testTenderQuery.getDocPageNo()).isEqualTo(DEFAULT_DOC_PAGE_NO);
        assertThat(testTenderQuery.getTenderQueryText()).isEqualTo(DEFAULT_TENDER_QUERY_TEXT);
    }

    @Test
    @Transactional
    void createTenderQueryWithExistingId() throws Exception {
        // Create the TenderQuery with an existing ID
        tenderQuery.setId(1L);
        TenderQueryDTO tenderQueryDTO = tenderQueryMapper.toDto(tenderQuery);

        int databaseSizeBeforeCreate = tenderQueryRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTenderQueryMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderQueryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderQuery in the database
        List<TenderQuery> tenderQueryList = tenderQueryRepository.findAll();
        assertThat(tenderQueryList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllTenderQueries() throws Exception {
        // Initialize the database
        tenderQueryRepository.saveAndFlush(tenderQuery);

        // Get all the tenderQueryList
        restTenderQueryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tenderQuery.getId().intValue())))
            .andExpect(jsonPath("$.[*].supplierGeneralInfoId").value(hasItem(DEFAULT_SUPPLIER_GENERAL_INFO_ID.intValue())))
            .andExpect(jsonPath("$.[*].serialNo").value(hasItem(DEFAULT_SERIAL_NO.intValue())))
            .andExpect(jsonPath("$.[*].referenceDocument").value(hasItem(DEFAULT_REFERENCE_DOCUMENT)))
            .andExpect(jsonPath("$.[*].docSectionName").value(hasItem(DEFAULT_DOC_SECTION_NAME)))
            .andExpect(jsonPath("$.[*].docPageNo").value(hasItem(DEFAULT_DOC_PAGE_NO)))
            .andExpect(jsonPath("$.[*].tenderQueryText").value(hasItem(DEFAULT_TENDER_QUERY_TEXT.toString())));
    }

    @Test
    @Transactional
    void getTenderQuery() throws Exception {
        // Initialize the database
        tenderQueryRepository.saveAndFlush(tenderQuery);

        // Get the tenderQuery
        restTenderQueryMockMvc
            .perform(get(ENTITY_API_URL_ID, tenderQuery.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(tenderQuery.getId().intValue()))
            .andExpect(jsonPath("$.supplierGeneralInfoId").value(DEFAULT_SUPPLIER_GENERAL_INFO_ID.intValue()))
            .andExpect(jsonPath("$.serialNo").value(DEFAULT_SERIAL_NO.intValue()))
            .andExpect(jsonPath("$.referenceDocument").value(DEFAULT_REFERENCE_DOCUMENT))
            .andExpect(jsonPath("$.docSectionName").value(DEFAULT_DOC_SECTION_NAME))
            .andExpect(jsonPath("$.docPageNo").value(DEFAULT_DOC_PAGE_NO))
            .andExpect(jsonPath("$.tenderQueryText").value(DEFAULT_TENDER_QUERY_TEXT.toString()));
    }

    @Test
    @Transactional
    void getNonExistingTenderQuery() throws Exception {
        // Get the tenderQuery
        restTenderQueryMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewTenderQuery() throws Exception {
        // Initialize the database
        tenderQueryRepository.saveAndFlush(tenderQuery);

        int databaseSizeBeforeUpdate = tenderQueryRepository.findAll().size();

        // Update the tenderQuery
        TenderQuery updatedTenderQuery = tenderQueryRepository.findById(tenderQuery.getId()).get();
        // Disconnect from session so that the updates on updatedTenderQuery are not directly saved in db
        em.detach(updatedTenderQuery);
        updatedTenderQuery
            .supplierGeneralInfoId(UPDATED_SUPPLIER_GENERAL_INFO_ID)
            .serialNo(UPDATED_SERIAL_NO)
            .referenceDocument(UPDATED_REFERENCE_DOCUMENT)
            .docSectionName(UPDATED_DOC_SECTION_NAME)
            .docPageNo(UPDATED_DOC_PAGE_NO)
            .tenderQueryText(UPDATED_TENDER_QUERY_TEXT);
        TenderQueryDTO tenderQueryDTO = tenderQueryMapper.toDto(updatedTenderQuery);

        restTenderQueryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderQueryDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderQueryDTO))
            )
            .andExpect(status().isOk());

        // Validate the TenderQuery in the database
        List<TenderQuery> tenderQueryList = tenderQueryRepository.findAll();
        assertThat(tenderQueryList).hasSize(databaseSizeBeforeUpdate);
        TenderQuery testTenderQuery = tenderQueryList.get(tenderQueryList.size() - 1);
        assertThat(testTenderQuery.getSupplierGeneralInfoId()).isEqualTo(UPDATED_SUPPLIER_GENERAL_INFO_ID);
        assertThat(testTenderQuery.getSerialNo()).isEqualTo(UPDATED_SERIAL_NO);
        assertThat(testTenderQuery.getReferenceDocument()).isEqualTo(UPDATED_REFERENCE_DOCUMENT);
        assertThat(testTenderQuery.getDocSectionName()).isEqualTo(UPDATED_DOC_SECTION_NAME);
        assertThat(testTenderQuery.getDocPageNo()).isEqualTo(UPDATED_DOC_PAGE_NO);
        assertThat(testTenderQuery.getTenderQueryText()).isEqualTo(UPDATED_TENDER_QUERY_TEXT);
    }

    @Test
    @Transactional
    void putNonExistingTenderQuery() throws Exception {
        int databaseSizeBeforeUpdate = tenderQueryRepository.findAll().size();
        tenderQuery.setId(count.incrementAndGet());

        // Create the TenderQuery
        TenderQueryDTO tenderQueryDTO = tenderQueryMapper.toDto(tenderQuery);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderQueryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderQueryDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderQueryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderQuery in the database
        List<TenderQuery> tenderQueryList = tenderQueryRepository.findAll();
        assertThat(tenderQueryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTenderQuery() throws Exception {
        int databaseSizeBeforeUpdate = tenderQueryRepository.findAll().size();
        tenderQuery.setId(count.incrementAndGet());

        // Create the TenderQuery
        TenderQueryDTO tenderQueryDTO = tenderQueryMapper.toDto(tenderQuery);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderQueryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderQueryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderQuery in the database
        List<TenderQuery> tenderQueryList = tenderQueryRepository.findAll();
        assertThat(tenderQueryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTenderQuery() throws Exception {
        int databaseSizeBeforeUpdate = tenderQueryRepository.findAll().size();
        tenderQuery.setId(count.incrementAndGet());

        // Create the TenderQuery
        TenderQueryDTO tenderQueryDTO = tenderQueryMapper.toDto(tenderQuery);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderQueryMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderQueryDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderQuery in the database
        List<TenderQuery> tenderQueryList = tenderQueryRepository.findAll();
        assertThat(tenderQueryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTenderQueryWithPatch() throws Exception {
        // Initialize the database
        tenderQueryRepository.saveAndFlush(tenderQuery);

        int databaseSizeBeforeUpdate = tenderQueryRepository.findAll().size();

        // Update the tenderQuery using partial update
        TenderQuery partialUpdatedTenderQuery = new TenderQuery();
        partialUpdatedTenderQuery.setId(tenderQuery.getId());

        partialUpdatedTenderQuery.serialNo(UPDATED_SERIAL_NO).docSectionName(UPDATED_DOC_SECTION_NAME);

        restTenderQueryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderQuery.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderQuery))
            )
            .andExpect(status().isOk());

        // Validate the TenderQuery in the database
        List<TenderQuery> tenderQueryList = tenderQueryRepository.findAll();
        assertThat(tenderQueryList).hasSize(databaseSizeBeforeUpdate);
        TenderQuery testTenderQuery = tenderQueryList.get(tenderQueryList.size() - 1);
        assertThat(testTenderQuery.getSupplierGeneralInfoId()).isEqualTo(DEFAULT_SUPPLIER_GENERAL_INFO_ID);
        assertThat(testTenderQuery.getSerialNo()).isEqualTo(UPDATED_SERIAL_NO);
        assertThat(testTenderQuery.getReferenceDocument()).isEqualTo(DEFAULT_REFERENCE_DOCUMENT);
        assertThat(testTenderQuery.getDocSectionName()).isEqualTo(UPDATED_DOC_SECTION_NAME);
        assertThat(testTenderQuery.getDocPageNo()).isEqualTo(DEFAULT_DOC_PAGE_NO);
        assertThat(testTenderQuery.getTenderQueryText()).isEqualTo(DEFAULT_TENDER_QUERY_TEXT);
    }

    @Test
    @Transactional
    void fullUpdateTenderQueryWithPatch() throws Exception {
        // Initialize the database
        tenderQueryRepository.saveAndFlush(tenderQuery);

        int databaseSizeBeforeUpdate = tenderQueryRepository.findAll().size();

        // Update the tenderQuery using partial update
        TenderQuery partialUpdatedTenderQuery = new TenderQuery();
        partialUpdatedTenderQuery.setId(tenderQuery.getId());

        partialUpdatedTenderQuery
            .supplierGeneralInfoId(UPDATED_SUPPLIER_GENERAL_INFO_ID)
            .serialNo(UPDATED_SERIAL_NO)
            .referenceDocument(UPDATED_REFERENCE_DOCUMENT)
            .docSectionName(UPDATED_DOC_SECTION_NAME)
            .docPageNo(UPDATED_DOC_PAGE_NO)
            .tenderQueryText(UPDATED_TENDER_QUERY_TEXT);

        restTenderQueryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderQuery.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderQuery))
            )
            .andExpect(status().isOk());

        // Validate the TenderQuery in the database
        List<TenderQuery> tenderQueryList = tenderQueryRepository.findAll();
        assertThat(tenderQueryList).hasSize(databaseSizeBeforeUpdate);
        TenderQuery testTenderQuery = tenderQueryList.get(tenderQueryList.size() - 1);
        assertThat(testTenderQuery.getSupplierGeneralInfoId()).isEqualTo(UPDATED_SUPPLIER_GENERAL_INFO_ID);
        assertThat(testTenderQuery.getSerialNo()).isEqualTo(UPDATED_SERIAL_NO);
        assertThat(testTenderQuery.getReferenceDocument()).isEqualTo(UPDATED_REFERENCE_DOCUMENT);
        assertThat(testTenderQuery.getDocSectionName()).isEqualTo(UPDATED_DOC_SECTION_NAME);
        assertThat(testTenderQuery.getDocPageNo()).isEqualTo(UPDATED_DOC_PAGE_NO);
        assertThat(testTenderQuery.getTenderQueryText()).isEqualTo(UPDATED_TENDER_QUERY_TEXT);
    }

    @Test
    @Transactional
    void patchNonExistingTenderQuery() throws Exception {
        int databaseSizeBeforeUpdate = tenderQueryRepository.findAll().size();
        tenderQuery.setId(count.incrementAndGet());

        // Create the TenderQuery
        TenderQueryDTO tenderQueryDTO = tenderQueryMapper.toDto(tenderQuery);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderQueryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, tenderQueryDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderQueryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderQuery in the database
        List<TenderQuery> tenderQueryList = tenderQueryRepository.findAll();
        assertThat(tenderQueryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTenderQuery() throws Exception {
        int databaseSizeBeforeUpdate = tenderQueryRepository.findAll().size();
        tenderQuery.setId(count.incrementAndGet());

        // Create the TenderQuery
        TenderQueryDTO tenderQueryDTO = tenderQueryMapper.toDto(tenderQuery);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderQueryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderQueryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderQuery in the database
        List<TenderQuery> tenderQueryList = tenderQueryRepository.findAll();
        assertThat(tenderQueryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTenderQuery() throws Exception {
        int databaseSizeBeforeUpdate = tenderQueryRepository.findAll().size();
        tenderQuery.setId(count.incrementAndGet());

        // Create the TenderQuery
        TenderQueryDTO tenderQueryDTO = tenderQueryMapper.toDto(tenderQuery);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderQueryMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(tenderQueryDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderQuery in the database
        List<TenderQuery> tenderQueryList = tenderQueryRepository.findAll();
        assertThat(tenderQueryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTenderQuery() throws Exception {
        // Initialize the database
        tenderQueryRepository.saveAndFlush(tenderQuery);

        int databaseSizeBeforeDelete = tenderQueryRepository.findAll().size();

        // Delete the tenderQuery
        restTenderQueryMockMvc
            .perform(delete(ENTITY_API_URL_ID, tenderQuery.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<TenderQuery> tenderQueryList = tenderQueryRepository.findAll();
        assertThat(tenderQueryList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
