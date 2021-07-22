package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.CriterionDocumentMaster;
import com.mycompany.myapp.repository.CriterionDocumentMasterRepository;
import com.mycompany.myapp.service.dto.CriterionDocumentMasterDTO;
import com.mycompany.myapp.service.mapper.CriterionDocumentMasterMapper;
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
 * Integration tests for the {@link CriterionDocumentMasterResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CriterionDocumentMasterResourceIT {

    private static final String DEFAULT_DOCUMENT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TENDER_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_TENDER_CATEGORY = "BBBBBBBBBB";

    private static final Boolean DEFAULT_ACTIVE_YN = false;
    private static final Boolean UPDATED_ACTIVE_YN = true;

    private static final String ENTITY_API_URL = "/api/criterion-document-masters";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private CriterionDocumentMasterRepository criterionDocumentMasterRepository;

    @Autowired
    private CriterionDocumentMasterMapper criterionDocumentMasterMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCriterionDocumentMasterMockMvc;

    private CriterionDocumentMaster criterionDocumentMaster;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CriterionDocumentMaster createEntity(EntityManager em) {
        CriterionDocumentMaster criterionDocumentMaster = new CriterionDocumentMaster()
            .documentName(DEFAULT_DOCUMENT_NAME)
            .tenderCategory(DEFAULT_TENDER_CATEGORY)
            .activeYn(DEFAULT_ACTIVE_YN);
        return criterionDocumentMaster;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CriterionDocumentMaster createUpdatedEntity(EntityManager em) {
        CriterionDocumentMaster criterionDocumentMaster = new CriterionDocumentMaster()
            .documentName(UPDATED_DOCUMENT_NAME)
            .tenderCategory(UPDATED_TENDER_CATEGORY)
            .activeYn(UPDATED_ACTIVE_YN);
        return criterionDocumentMaster;
    }

    @BeforeEach
    public void initTest() {
        criterionDocumentMaster = createEntity(em);
    }

    @Test
    @Transactional
    void createCriterionDocumentMaster() throws Exception {
        int databaseSizeBeforeCreate = criterionDocumentMasterRepository.findAll().size();
        // Create the CriterionDocumentMaster
        CriterionDocumentMasterDTO criterionDocumentMasterDTO = criterionDocumentMasterMapper.toDto(criterionDocumentMaster);
        restCriterionDocumentMasterMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(criterionDocumentMasterDTO))
            )
            .andExpect(status().isCreated());

        // Validate the CriterionDocumentMaster in the database
        List<CriterionDocumentMaster> criterionDocumentMasterList = criterionDocumentMasterRepository.findAll();
        assertThat(criterionDocumentMasterList).hasSize(databaseSizeBeforeCreate + 1);
        CriterionDocumentMaster testCriterionDocumentMaster = criterionDocumentMasterList.get(criterionDocumentMasterList.size() - 1);
        assertThat(testCriterionDocumentMaster.getDocumentName()).isEqualTo(DEFAULT_DOCUMENT_NAME);
        assertThat(testCriterionDocumentMaster.getTenderCategory()).isEqualTo(DEFAULT_TENDER_CATEGORY);
        assertThat(testCriterionDocumentMaster.getActiveYn()).isEqualTo(DEFAULT_ACTIVE_YN);
    }

    @Test
    @Transactional
    void createCriterionDocumentMasterWithExistingId() throws Exception {
        // Create the CriterionDocumentMaster with an existing ID
        criterionDocumentMaster.setId(1L);
        CriterionDocumentMasterDTO criterionDocumentMasterDTO = criterionDocumentMasterMapper.toDto(criterionDocumentMaster);

        int databaseSizeBeforeCreate = criterionDocumentMasterRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restCriterionDocumentMasterMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(criterionDocumentMasterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CriterionDocumentMaster in the database
        List<CriterionDocumentMaster> criterionDocumentMasterList = criterionDocumentMasterRepository.findAll();
        assertThat(criterionDocumentMasterList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllCriterionDocumentMasters() throws Exception {
        // Initialize the database
        criterionDocumentMasterRepository.saveAndFlush(criterionDocumentMaster);

        // Get all the criterionDocumentMasterList
        restCriterionDocumentMasterMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(criterionDocumentMaster.getId().intValue())))
            .andExpect(jsonPath("$.[*].documentName").value(hasItem(DEFAULT_DOCUMENT_NAME)))
            .andExpect(jsonPath("$.[*].tenderCategory").value(hasItem(DEFAULT_TENDER_CATEGORY)))
            .andExpect(jsonPath("$.[*].activeYn").value(hasItem(DEFAULT_ACTIVE_YN.booleanValue())));
    }

    @Test
    @Transactional
    void getCriterionDocumentMaster() throws Exception {
        // Initialize the database
        criterionDocumentMasterRepository.saveAndFlush(criterionDocumentMaster);

        // Get the criterionDocumentMaster
        restCriterionDocumentMasterMockMvc
            .perform(get(ENTITY_API_URL_ID, criterionDocumentMaster.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(criterionDocumentMaster.getId().intValue()))
            .andExpect(jsonPath("$.documentName").value(DEFAULT_DOCUMENT_NAME))
            .andExpect(jsonPath("$.tenderCategory").value(DEFAULT_TENDER_CATEGORY))
            .andExpect(jsonPath("$.activeYn").value(DEFAULT_ACTIVE_YN.booleanValue()));
    }

    @Test
    @Transactional
    void getNonExistingCriterionDocumentMaster() throws Exception {
        // Get the criterionDocumentMaster
        restCriterionDocumentMasterMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewCriterionDocumentMaster() throws Exception {
        // Initialize the database
        criterionDocumentMasterRepository.saveAndFlush(criterionDocumentMaster);

        int databaseSizeBeforeUpdate = criterionDocumentMasterRepository.findAll().size();

        // Update the criterionDocumentMaster
        CriterionDocumentMaster updatedCriterionDocumentMaster = criterionDocumentMasterRepository
            .findById(criterionDocumentMaster.getId())
            .get();
        // Disconnect from session so that the updates on updatedCriterionDocumentMaster are not directly saved in db
        em.detach(updatedCriterionDocumentMaster);
        updatedCriterionDocumentMaster
            .documentName(UPDATED_DOCUMENT_NAME)
            .tenderCategory(UPDATED_TENDER_CATEGORY)
            .activeYn(UPDATED_ACTIVE_YN);
        CriterionDocumentMasterDTO criterionDocumentMasterDTO = criterionDocumentMasterMapper.toDto(updatedCriterionDocumentMaster);

        restCriterionDocumentMasterMockMvc
            .perform(
                put(ENTITY_API_URL_ID, criterionDocumentMasterDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(criterionDocumentMasterDTO))
            )
            .andExpect(status().isOk());

        // Validate the CriterionDocumentMaster in the database
        List<CriterionDocumentMaster> criterionDocumentMasterList = criterionDocumentMasterRepository.findAll();
        assertThat(criterionDocumentMasterList).hasSize(databaseSizeBeforeUpdate);
        CriterionDocumentMaster testCriterionDocumentMaster = criterionDocumentMasterList.get(criterionDocumentMasterList.size() - 1);
        assertThat(testCriterionDocumentMaster.getDocumentName()).isEqualTo(UPDATED_DOCUMENT_NAME);
        assertThat(testCriterionDocumentMaster.getTenderCategory()).isEqualTo(UPDATED_TENDER_CATEGORY);
        assertThat(testCriterionDocumentMaster.getActiveYn()).isEqualTo(UPDATED_ACTIVE_YN);
    }

    @Test
    @Transactional
    void putNonExistingCriterionDocumentMaster() throws Exception {
        int databaseSizeBeforeUpdate = criterionDocumentMasterRepository.findAll().size();
        criterionDocumentMaster.setId(count.incrementAndGet());

        // Create the CriterionDocumentMaster
        CriterionDocumentMasterDTO criterionDocumentMasterDTO = criterionDocumentMasterMapper.toDto(criterionDocumentMaster);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCriterionDocumentMasterMockMvc
            .perform(
                put(ENTITY_API_URL_ID, criterionDocumentMasterDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(criterionDocumentMasterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CriterionDocumentMaster in the database
        List<CriterionDocumentMaster> criterionDocumentMasterList = criterionDocumentMasterRepository.findAll();
        assertThat(criterionDocumentMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchCriterionDocumentMaster() throws Exception {
        int databaseSizeBeforeUpdate = criterionDocumentMasterRepository.findAll().size();
        criterionDocumentMaster.setId(count.incrementAndGet());

        // Create the CriterionDocumentMaster
        CriterionDocumentMasterDTO criterionDocumentMasterDTO = criterionDocumentMasterMapper.toDto(criterionDocumentMaster);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCriterionDocumentMasterMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(criterionDocumentMasterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CriterionDocumentMaster in the database
        List<CriterionDocumentMaster> criterionDocumentMasterList = criterionDocumentMasterRepository.findAll();
        assertThat(criterionDocumentMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamCriterionDocumentMaster() throws Exception {
        int databaseSizeBeforeUpdate = criterionDocumentMasterRepository.findAll().size();
        criterionDocumentMaster.setId(count.incrementAndGet());

        // Create the CriterionDocumentMaster
        CriterionDocumentMasterDTO criterionDocumentMasterDTO = criterionDocumentMasterMapper.toDto(criterionDocumentMaster);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCriterionDocumentMasterMockMvc
            .perform(
                put(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(criterionDocumentMasterDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the CriterionDocumentMaster in the database
        List<CriterionDocumentMaster> criterionDocumentMasterList = criterionDocumentMasterRepository.findAll();
        assertThat(criterionDocumentMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateCriterionDocumentMasterWithPatch() throws Exception {
        // Initialize the database
        criterionDocumentMasterRepository.saveAndFlush(criterionDocumentMaster);

        int databaseSizeBeforeUpdate = criterionDocumentMasterRepository.findAll().size();

        // Update the criterionDocumentMaster using partial update
        CriterionDocumentMaster partialUpdatedCriterionDocumentMaster = new CriterionDocumentMaster();
        partialUpdatedCriterionDocumentMaster.setId(criterionDocumentMaster.getId());

        partialUpdatedCriterionDocumentMaster.activeYn(UPDATED_ACTIVE_YN);

        restCriterionDocumentMasterMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCriterionDocumentMaster.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCriterionDocumentMaster))
            )
            .andExpect(status().isOk());

        // Validate the CriterionDocumentMaster in the database
        List<CriterionDocumentMaster> criterionDocumentMasterList = criterionDocumentMasterRepository.findAll();
        assertThat(criterionDocumentMasterList).hasSize(databaseSizeBeforeUpdate);
        CriterionDocumentMaster testCriterionDocumentMaster = criterionDocumentMasterList.get(criterionDocumentMasterList.size() - 1);
        assertThat(testCriterionDocumentMaster.getDocumentName()).isEqualTo(DEFAULT_DOCUMENT_NAME);
        assertThat(testCriterionDocumentMaster.getTenderCategory()).isEqualTo(DEFAULT_TENDER_CATEGORY);
        assertThat(testCriterionDocumentMaster.getActiveYn()).isEqualTo(UPDATED_ACTIVE_YN);
    }

    @Test
    @Transactional
    void fullUpdateCriterionDocumentMasterWithPatch() throws Exception {
        // Initialize the database
        criterionDocumentMasterRepository.saveAndFlush(criterionDocumentMaster);

        int databaseSizeBeforeUpdate = criterionDocumentMasterRepository.findAll().size();

        // Update the criterionDocumentMaster using partial update
        CriterionDocumentMaster partialUpdatedCriterionDocumentMaster = new CriterionDocumentMaster();
        partialUpdatedCriterionDocumentMaster.setId(criterionDocumentMaster.getId());

        partialUpdatedCriterionDocumentMaster
            .documentName(UPDATED_DOCUMENT_NAME)
            .tenderCategory(UPDATED_TENDER_CATEGORY)
            .activeYn(UPDATED_ACTIVE_YN);

        restCriterionDocumentMasterMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCriterionDocumentMaster.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCriterionDocumentMaster))
            )
            .andExpect(status().isOk());

        // Validate the CriterionDocumentMaster in the database
        List<CriterionDocumentMaster> criterionDocumentMasterList = criterionDocumentMasterRepository.findAll();
        assertThat(criterionDocumentMasterList).hasSize(databaseSizeBeforeUpdate);
        CriterionDocumentMaster testCriterionDocumentMaster = criterionDocumentMasterList.get(criterionDocumentMasterList.size() - 1);
        assertThat(testCriterionDocumentMaster.getDocumentName()).isEqualTo(UPDATED_DOCUMENT_NAME);
        assertThat(testCriterionDocumentMaster.getTenderCategory()).isEqualTo(UPDATED_TENDER_CATEGORY);
        assertThat(testCriterionDocumentMaster.getActiveYn()).isEqualTo(UPDATED_ACTIVE_YN);
    }

    @Test
    @Transactional
    void patchNonExistingCriterionDocumentMaster() throws Exception {
        int databaseSizeBeforeUpdate = criterionDocumentMasterRepository.findAll().size();
        criterionDocumentMaster.setId(count.incrementAndGet());

        // Create the CriterionDocumentMaster
        CriterionDocumentMasterDTO criterionDocumentMasterDTO = criterionDocumentMasterMapper.toDto(criterionDocumentMaster);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCriterionDocumentMasterMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, criterionDocumentMasterDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(criterionDocumentMasterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CriterionDocumentMaster in the database
        List<CriterionDocumentMaster> criterionDocumentMasterList = criterionDocumentMasterRepository.findAll();
        assertThat(criterionDocumentMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchCriterionDocumentMaster() throws Exception {
        int databaseSizeBeforeUpdate = criterionDocumentMasterRepository.findAll().size();
        criterionDocumentMaster.setId(count.incrementAndGet());

        // Create the CriterionDocumentMaster
        CriterionDocumentMasterDTO criterionDocumentMasterDTO = criterionDocumentMasterMapper.toDto(criterionDocumentMaster);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCriterionDocumentMasterMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(criterionDocumentMasterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CriterionDocumentMaster in the database
        List<CriterionDocumentMaster> criterionDocumentMasterList = criterionDocumentMasterRepository.findAll();
        assertThat(criterionDocumentMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamCriterionDocumentMaster() throws Exception {
        int databaseSizeBeforeUpdate = criterionDocumentMasterRepository.findAll().size();
        criterionDocumentMaster.setId(count.incrementAndGet());

        // Create the CriterionDocumentMaster
        CriterionDocumentMasterDTO criterionDocumentMasterDTO = criterionDocumentMasterMapper.toDto(criterionDocumentMaster);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCriterionDocumentMasterMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(criterionDocumentMasterDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the CriterionDocumentMaster in the database
        List<CriterionDocumentMaster> criterionDocumentMasterList = criterionDocumentMasterRepository.findAll();
        assertThat(criterionDocumentMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteCriterionDocumentMaster() throws Exception {
        // Initialize the database
        criterionDocumentMasterRepository.saveAndFlush(criterionDocumentMaster);

        int databaseSizeBeforeDelete = criterionDocumentMasterRepository.findAll().size();

        // Delete the criterionDocumentMaster
        restCriterionDocumentMasterMockMvc
            .perform(delete(ENTITY_API_URL_ID, criterionDocumentMaster.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CriterionDocumentMaster> criterionDocumentMasterList = criterionDocumentMasterRepository.findAll();
        assertThat(criterionDocumentMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
