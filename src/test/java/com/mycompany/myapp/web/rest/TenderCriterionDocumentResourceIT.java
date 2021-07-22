package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.TenderCriterionDocument;
import com.mycompany.myapp.repository.TenderCriterionDocumentRepository;
import com.mycompany.myapp.service.dto.TenderCriterionDocumentDTO;
import com.mycompany.myapp.service.mapper.TenderCriterionDocumentMapper;
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
 * Integration tests for the {@link TenderCriterionDocumentResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TenderCriterionDocumentResourceIT {

    private static final String DEFAULT_DOCUMENT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENT_NAME = "BBBBBBBBBB";

    private static final Boolean DEFAULT_OPTIONAL = false;
    private static final Boolean UPDATED_OPTIONAL = true;

    private static final String ENTITY_API_URL = "/api/tender-criterion-documents";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private TenderCriterionDocumentRepository tenderCriterionDocumentRepository;

    @Autowired
    private TenderCriterionDocumentMapper tenderCriterionDocumentMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTenderCriterionDocumentMockMvc;

    private TenderCriterionDocument tenderCriterionDocument;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderCriterionDocument createEntity(EntityManager em) {
        TenderCriterionDocument tenderCriterionDocument = new TenderCriterionDocument()
            .documentName(DEFAULT_DOCUMENT_NAME)
            .optional(DEFAULT_OPTIONAL);
        return tenderCriterionDocument;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderCriterionDocument createUpdatedEntity(EntityManager em) {
        TenderCriterionDocument tenderCriterionDocument = new TenderCriterionDocument()
            .documentName(UPDATED_DOCUMENT_NAME)
            .optional(UPDATED_OPTIONAL);
        return tenderCriterionDocument;
    }

    @BeforeEach
    public void initTest() {
        tenderCriterionDocument = createEntity(em);
    }

    @Test
    @Transactional
    void createTenderCriterionDocument() throws Exception {
        int databaseSizeBeforeCreate = tenderCriterionDocumentRepository.findAll().size();
        // Create the TenderCriterionDocument
        TenderCriterionDocumentDTO tenderCriterionDocumentDTO = tenderCriterionDocumentMapper.toDto(tenderCriterionDocument);
        restTenderCriterionDocumentMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDocumentDTO))
            )
            .andExpect(status().isCreated());

        // Validate the TenderCriterionDocument in the database
        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeCreate + 1);
        TenderCriterionDocument testTenderCriterionDocument = tenderCriterionDocumentList.get(tenderCriterionDocumentList.size() - 1);
        assertThat(testTenderCriterionDocument.getDocumentName()).isEqualTo(DEFAULT_DOCUMENT_NAME);
        assertThat(testTenderCriterionDocument.getOptional()).isEqualTo(DEFAULT_OPTIONAL);
    }

    @Test
    @Transactional
    void createTenderCriterionDocumentWithExistingId() throws Exception {
        // Create the TenderCriterionDocument with an existing ID
        tenderCriterionDocument.setId(1L);
        TenderCriterionDocumentDTO tenderCriterionDocumentDTO = tenderCriterionDocumentMapper.toDto(tenderCriterionDocument);

        int databaseSizeBeforeCreate = tenderCriterionDocumentRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTenderCriterionDocumentMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDocumentDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCriterionDocument in the database
        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkDocumentNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = tenderCriterionDocumentRepository.findAll().size();
        // set the field null
        tenderCriterionDocument.setDocumentName(null);

        // Create the TenderCriterionDocument, which fails.
        TenderCriterionDocumentDTO tenderCriterionDocumentDTO = tenderCriterionDocumentMapper.toDto(tenderCriterionDocument);

        restTenderCriterionDocumentMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDocumentDTO))
            )
            .andExpect(status().isBadRequest());

        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkOptionalIsRequired() throws Exception {
        int databaseSizeBeforeTest = tenderCriterionDocumentRepository.findAll().size();
        // set the field null
        tenderCriterionDocument.setOptional(null);

        // Create the TenderCriterionDocument, which fails.
        TenderCriterionDocumentDTO tenderCriterionDocumentDTO = tenderCriterionDocumentMapper.toDto(tenderCriterionDocument);

        restTenderCriterionDocumentMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDocumentDTO))
            )
            .andExpect(status().isBadRequest());

        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllTenderCriterionDocuments() throws Exception {
        // Initialize the database
        tenderCriterionDocumentRepository.saveAndFlush(tenderCriterionDocument);

        // Get all the tenderCriterionDocumentList
        restTenderCriterionDocumentMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tenderCriterionDocument.getId().intValue())))
            .andExpect(jsonPath("$.[*].documentName").value(hasItem(DEFAULT_DOCUMENT_NAME)))
            .andExpect(jsonPath("$.[*].optional").value(hasItem(DEFAULT_OPTIONAL.booleanValue())));
    }

    @Test
    @Transactional
    void getTenderCriterionDocument() throws Exception {
        // Initialize the database
        tenderCriterionDocumentRepository.saveAndFlush(tenderCriterionDocument);

        // Get the tenderCriterionDocument
        restTenderCriterionDocumentMockMvc
            .perform(get(ENTITY_API_URL_ID, tenderCriterionDocument.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(tenderCriterionDocument.getId().intValue()))
            .andExpect(jsonPath("$.documentName").value(DEFAULT_DOCUMENT_NAME))
            .andExpect(jsonPath("$.optional").value(DEFAULT_OPTIONAL.booleanValue()));
    }

    @Test
    @Transactional
    void getNonExistingTenderCriterionDocument() throws Exception {
        // Get the tenderCriterionDocument
        restTenderCriterionDocumentMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewTenderCriterionDocument() throws Exception {
        // Initialize the database
        tenderCriterionDocumentRepository.saveAndFlush(tenderCriterionDocument);

        int databaseSizeBeforeUpdate = tenderCriterionDocumentRepository.findAll().size();

        // Update the tenderCriterionDocument
        TenderCriterionDocument updatedTenderCriterionDocument = tenderCriterionDocumentRepository
            .findById(tenderCriterionDocument.getId())
            .get();
        // Disconnect from session so that the updates on updatedTenderCriterionDocument are not directly saved in db
        em.detach(updatedTenderCriterionDocument);
        updatedTenderCriterionDocument.documentName(UPDATED_DOCUMENT_NAME).optional(UPDATED_OPTIONAL);
        TenderCriterionDocumentDTO tenderCriterionDocumentDTO = tenderCriterionDocumentMapper.toDto(updatedTenderCriterionDocument);

        restTenderCriterionDocumentMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderCriterionDocumentDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDocumentDTO))
            )
            .andExpect(status().isOk());

        // Validate the TenderCriterionDocument in the database
        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeUpdate);
        TenderCriterionDocument testTenderCriterionDocument = tenderCriterionDocumentList.get(tenderCriterionDocumentList.size() - 1);
        assertThat(testTenderCriterionDocument.getDocumentName()).isEqualTo(UPDATED_DOCUMENT_NAME);
        assertThat(testTenderCriterionDocument.getOptional()).isEqualTo(UPDATED_OPTIONAL);
    }

    @Test
    @Transactional
    void putNonExistingTenderCriterionDocument() throws Exception {
        int databaseSizeBeforeUpdate = tenderCriterionDocumentRepository.findAll().size();
        tenderCriterionDocument.setId(count.incrementAndGet());

        // Create the TenderCriterionDocument
        TenderCriterionDocumentDTO tenderCriterionDocumentDTO = tenderCriterionDocumentMapper.toDto(tenderCriterionDocument);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderCriterionDocumentMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderCriterionDocumentDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDocumentDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCriterionDocument in the database
        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTenderCriterionDocument() throws Exception {
        int databaseSizeBeforeUpdate = tenderCriterionDocumentRepository.findAll().size();
        tenderCriterionDocument.setId(count.incrementAndGet());

        // Create the TenderCriterionDocument
        TenderCriterionDocumentDTO tenderCriterionDocumentDTO = tenderCriterionDocumentMapper.toDto(tenderCriterionDocument);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderCriterionDocumentMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDocumentDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCriterionDocument in the database
        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTenderCriterionDocument() throws Exception {
        int databaseSizeBeforeUpdate = tenderCriterionDocumentRepository.findAll().size();
        tenderCriterionDocument.setId(count.incrementAndGet());

        // Create the TenderCriterionDocument
        TenderCriterionDocumentDTO tenderCriterionDocumentDTO = tenderCriterionDocumentMapper.toDto(tenderCriterionDocument);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderCriterionDocumentMockMvc
            .perform(
                put(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDocumentDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderCriterionDocument in the database
        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTenderCriterionDocumentWithPatch() throws Exception {
        // Initialize the database
        tenderCriterionDocumentRepository.saveAndFlush(tenderCriterionDocument);

        int databaseSizeBeforeUpdate = tenderCriterionDocumentRepository.findAll().size();

        // Update the tenderCriterionDocument using partial update
        TenderCriterionDocument partialUpdatedTenderCriterionDocument = new TenderCriterionDocument();
        partialUpdatedTenderCriterionDocument.setId(tenderCriterionDocument.getId());

        restTenderCriterionDocumentMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderCriterionDocument.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderCriterionDocument))
            )
            .andExpect(status().isOk());

        // Validate the TenderCriterionDocument in the database
        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeUpdate);
        TenderCriterionDocument testTenderCriterionDocument = tenderCriterionDocumentList.get(tenderCriterionDocumentList.size() - 1);
        assertThat(testTenderCriterionDocument.getDocumentName()).isEqualTo(DEFAULT_DOCUMENT_NAME);
        assertThat(testTenderCriterionDocument.getOptional()).isEqualTo(DEFAULT_OPTIONAL);
    }

    @Test
    @Transactional
    void fullUpdateTenderCriterionDocumentWithPatch() throws Exception {
        // Initialize the database
        tenderCriterionDocumentRepository.saveAndFlush(tenderCriterionDocument);

        int databaseSizeBeforeUpdate = tenderCriterionDocumentRepository.findAll().size();

        // Update the tenderCriterionDocument using partial update
        TenderCriterionDocument partialUpdatedTenderCriterionDocument = new TenderCriterionDocument();
        partialUpdatedTenderCriterionDocument.setId(tenderCriterionDocument.getId());

        partialUpdatedTenderCriterionDocument.documentName(UPDATED_DOCUMENT_NAME).optional(UPDATED_OPTIONAL);

        restTenderCriterionDocumentMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderCriterionDocument.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderCriterionDocument))
            )
            .andExpect(status().isOk());

        // Validate the TenderCriterionDocument in the database
        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeUpdate);
        TenderCriterionDocument testTenderCriterionDocument = tenderCriterionDocumentList.get(tenderCriterionDocumentList.size() - 1);
        assertThat(testTenderCriterionDocument.getDocumentName()).isEqualTo(UPDATED_DOCUMENT_NAME);
        assertThat(testTenderCriterionDocument.getOptional()).isEqualTo(UPDATED_OPTIONAL);
    }

    @Test
    @Transactional
    void patchNonExistingTenderCriterionDocument() throws Exception {
        int databaseSizeBeforeUpdate = tenderCriterionDocumentRepository.findAll().size();
        tenderCriterionDocument.setId(count.incrementAndGet());

        // Create the TenderCriterionDocument
        TenderCriterionDocumentDTO tenderCriterionDocumentDTO = tenderCriterionDocumentMapper.toDto(tenderCriterionDocument);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderCriterionDocumentMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, tenderCriterionDocumentDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDocumentDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCriterionDocument in the database
        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTenderCriterionDocument() throws Exception {
        int databaseSizeBeforeUpdate = tenderCriterionDocumentRepository.findAll().size();
        tenderCriterionDocument.setId(count.incrementAndGet());

        // Create the TenderCriterionDocument
        TenderCriterionDocumentDTO tenderCriterionDocumentDTO = tenderCriterionDocumentMapper.toDto(tenderCriterionDocument);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderCriterionDocumentMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDocumentDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCriterionDocument in the database
        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTenderCriterionDocument() throws Exception {
        int databaseSizeBeforeUpdate = tenderCriterionDocumentRepository.findAll().size();
        tenderCriterionDocument.setId(count.incrementAndGet());

        // Create the TenderCriterionDocument
        TenderCriterionDocumentDTO tenderCriterionDocumentDTO = tenderCriterionDocumentMapper.toDto(tenderCriterionDocument);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderCriterionDocumentMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDocumentDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderCriterionDocument in the database
        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTenderCriterionDocument() throws Exception {
        // Initialize the database
        tenderCriterionDocumentRepository.saveAndFlush(tenderCriterionDocument);

        int databaseSizeBeforeDelete = tenderCriterionDocumentRepository.findAll().size();

        // Delete the tenderCriterionDocument
        restTenderCriterionDocumentMockMvc
            .perform(delete(ENTITY_API_URL_ID, tenderCriterionDocument.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<TenderCriterionDocument> tenderCriterionDocumentList = tenderCriterionDocumentRepository.findAll();
        assertThat(tenderCriterionDocumentList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
