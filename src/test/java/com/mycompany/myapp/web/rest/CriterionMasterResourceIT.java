package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.CriterionMaster;
import com.mycompany.myapp.repository.CriterionMasterRepository;
import com.mycompany.myapp.service.dto.CriterionMasterDTO;
import com.mycompany.myapp.service.mapper.CriterionMasterMapper;
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
 * Integration tests for the {@link CriterionMasterResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CriterionMasterResourceIT {

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CRITERION_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CRITERION_TYPE = "BBBBBBBBBB";

    private static final Long DEFAULT_DOCUMENT_NAME = 1L;
    private static final Long UPDATED_DOCUMENT_NAME = 2L;

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_TENDER_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_TENDER_CATEGORY = "BBBBBBBBBB";

    private static final Boolean DEFAULT_ACTIVE_YN = false;
    private static final Boolean UPDATED_ACTIVE_YN = true;

    private static final String ENTITY_API_URL = "/api/criterion-masters";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private CriterionMasterRepository criterionMasterRepository;

    @Autowired
    private CriterionMasterMapper criterionMasterMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCriterionMasterMockMvc;

    private CriterionMaster criterionMaster;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CriterionMaster createEntity(EntityManager em) {
        CriterionMaster criterionMaster = new CriterionMaster()
            .type(DEFAULT_TYPE)
            .criterionType(DEFAULT_CRITERION_TYPE)
            .documentName(DEFAULT_DOCUMENT_NAME)
            .description(DEFAULT_DESCRIPTION)
            .tenderCategory(DEFAULT_TENDER_CATEGORY)
            .activeYn(DEFAULT_ACTIVE_YN);
        return criterionMaster;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CriterionMaster createUpdatedEntity(EntityManager em) {
        CriterionMaster criterionMaster = new CriterionMaster()
            .type(UPDATED_TYPE)
            .criterionType(UPDATED_CRITERION_TYPE)
            .documentName(UPDATED_DOCUMENT_NAME)
            .description(UPDATED_DESCRIPTION)
            .tenderCategory(UPDATED_TENDER_CATEGORY)
            .activeYn(UPDATED_ACTIVE_YN);
        return criterionMaster;
    }

    @BeforeEach
    public void initTest() {
        criterionMaster = createEntity(em);
    }

    @Test
    @Transactional
    void createCriterionMaster() throws Exception {
        int databaseSizeBeforeCreate = criterionMasterRepository.findAll().size();
        // Create the CriterionMaster
        CriterionMasterDTO criterionMasterDTO = criterionMasterMapper.toDto(criterionMaster);
        restCriterionMasterMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(criterionMasterDTO))
            )
            .andExpect(status().isCreated());

        // Validate the CriterionMaster in the database
        List<CriterionMaster> criterionMasterList = criterionMasterRepository.findAll();
        assertThat(criterionMasterList).hasSize(databaseSizeBeforeCreate + 1);
        CriterionMaster testCriterionMaster = criterionMasterList.get(criterionMasterList.size() - 1);
        assertThat(testCriterionMaster.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testCriterionMaster.getCriterionType()).isEqualTo(DEFAULT_CRITERION_TYPE);
        assertThat(testCriterionMaster.getDocumentName()).isEqualTo(DEFAULT_DOCUMENT_NAME);
        assertThat(testCriterionMaster.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testCriterionMaster.getTenderCategory()).isEqualTo(DEFAULT_TENDER_CATEGORY);
        assertThat(testCriterionMaster.getActiveYn()).isEqualTo(DEFAULT_ACTIVE_YN);
    }

    @Test
    @Transactional
    void createCriterionMasterWithExistingId() throws Exception {
        // Create the CriterionMaster with an existing ID
        criterionMaster.setId(1L);
        CriterionMasterDTO criterionMasterDTO = criterionMasterMapper.toDto(criterionMaster);

        int databaseSizeBeforeCreate = criterionMasterRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restCriterionMasterMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(criterionMasterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CriterionMaster in the database
        List<CriterionMaster> criterionMasterList = criterionMasterRepository.findAll();
        assertThat(criterionMasterList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllCriterionMasters() throws Exception {
        // Initialize the database
        criterionMasterRepository.saveAndFlush(criterionMaster);

        // Get all the criterionMasterList
        restCriterionMasterMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(criterionMaster.getId().intValue())))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].criterionType").value(hasItem(DEFAULT_CRITERION_TYPE)))
            .andExpect(jsonPath("$.[*].documentName").value(hasItem(DEFAULT_DOCUMENT_NAME.intValue())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].tenderCategory").value(hasItem(DEFAULT_TENDER_CATEGORY)))
            .andExpect(jsonPath("$.[*].activeYn").value(hasItem(DEFAULT_ACTIVE_YN.booleanValue())));
    }

    @Test
    @Transactional
    void getCriterionMaster() throws Exception {
        // Initialize the database
        criterionMasterRepository.saveAndFlush(criterionMaster);

        // Get the criterionMaster
        restCriterionMasterMockMvc
            .perform(get(ENTITY_API_URL_ID, criterionMaster.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(criterionMaster.getId().intValue()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE))
            .andExpect(jsonPath("$.criterionType").value(DEFAULT_CRITERION_TYPE))
            .andExpect(jsonPath("$.documentName").value(DEFAULT_DOCUMENT_NAME.intValue()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.tenderCategory").value(DEFAULT_TENDER_CATEGORY))
            .andExpect(jsonPath("$.activeYn").value(DEFAULT_ACTIVE_YN.booleanValue()));
    }

    @Test
    @Transactional
    void getNonExistingCriterionMaster() throws Exception {
        // Get the criterionMaster
        restCriterionMasterMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewCriterionMaster() throws Exception {
        // Initialize the database
        criterionMasterRepository.saveAndFlush(criterionMaster);

        int databaseSizeBeforeUpdate = criterionMasterRepository.findAll().size();

        // Update the criterionMaster
        CriterionMaster updatedCriterionMaster = criterionMasterRepository.findById(criterionMaster.getId()).get();
        // Disconnect from session so that the updates on updatedCriterionMaster are not directly saved in db
        em.detach(updatedCriterionMaster);
        updatedCriterionMaster
            .type(UPDATED_TYPE)
            .criterionType(UPDATED_CRITERION_TYPE)
            .documentName(UPDATED_DOCUMENT_NAME)
            .description(UPDATED_DESCRIPTION)
            .tenderCategory(UPDATED_TENDER_CATEGORY)
            .activeYn(UPDATED_ACTIVE_YN);
        CriterionMasterDTO criterionMasterDTO = criterionMasterMapper.toDto(updatedCriterionMaster);

        restCriterionMasterMockMvc
            .perform(
                put(ENTITY_API_URL_ID, criterionMasterDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(criterionMasterDTO))
            )
            .andExpect(status().isOk());

        // Validate the CriterionMaster in the database
        List<CriterionMaster> criterionMasterList = criterionMasterRepository.findAll();
        assertThat(criterionMasterList).hasSize(databaseSizeBeforeUpdate);
        CriterionMaster testCriterionMaster = criterionMasterList.get(criterionMasterList.size() - 1);
        assertThat(testCriterionMaster.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testCriterionMaster.getCriterionType()).isEqualTo(UPDATED_CRITERION_TYPE);
        assertThat(testCriterionMaster.getDocumentName()).isEqualTo(UPDATED_DOCUMENT_NAME);
        assertThat(testCriterionMaster.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testCriterionMaster.getTenderCategory()).isEqualTo(UPDATED_TENDER_CATEGORY);
        assertThat(testCriterionMaster.getActiveYn()).isEqualTo(UPDATED_ACTIVE_YN);
    }

    @Test
    @Transactional
    void putNonExistingCriterionMaster() throws Exception {
        int databaseSizeBeforeUpdate = criterionMasterRepository.findAll().size();
        criterionMaster.setId(count.incrementAndGet());

        // Create the CriterionMaster
        CriterionMasterDTO criterionMasterDTO = criterionMasterMapper.toDto(criterionMaster);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCriterionMasterMockMvc
            .perform(
                put(ENTITY_API_URL_ID, criterionMasterDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(criterionMasterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CriterionMaster in the database
        List<CriterionMaster> criterionMasterList = criterionMasterRepository.findAll();
        assertThat(criterionMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchCriterionMaster() throws Exception {
        int databaseSizeBeforeUpdate = criterionMasterRepository.findAll().size();
        criterionMaster.setId(count.incrementAndGet());

        // Create the CriterionMaster
        CriterionMasterDTO criterionMasterDTO = criterionMasterMapper.toDto(criterionMaster);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCriterionMasterMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(criterionMasterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CriterionMaster in the database
        List<CriterionMaster> criterionMasterList = criterionMasterRepository.findAll();
        assertThat(criterionMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamCriterionMaster() throws Exception {
        int databaseSizeBeforeUpdate = criterionMasterRepository.findAll().size();
        criterionMaster.setId(count.incrementAndGet());

        // Create the CriterionMaster
        CriterionMasterDTO criterionMasterDTO = criterionMasterMapper.toDto(criterionMaster);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCriterionMasterMockMvc
            .perform(
                put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(criterionMasterDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the CriterionMaster in the database
        List<CriterionMaster> criterionMasterList = criterionMasterRepository.findAll();
        assertThat(criterionMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateCriterionMasterWithPatch() throws Exception {
        // Initialize the database
        criterionMasterRepository.saveAndFlush(criterionMaster);

        int databaseSizeBeforeUpdate = criterionMasterRepository.findAll().size();

        // Update the criterionMaster using partial update
        CriterionMaster partialUpdatedCriterionMaster = new CriterionMaster();
        partialUpdatedCriterionMaster.setId(criterionMaster.getId());

        partialUpdatedCriterionMaster
            .type(UPDATED_TYPE)
            .criterionType(UPDATED_CRITERION_TYPE)
            .documentName(UPDATED_DOCUMENT_NAME)
            .description(UPDATED_DESCRIPTION)
            .tenderCategory(UPDATED_TENDER_CATEGORY);

        restCriterionMasterMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCriterionMaster.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCriterionMaster))
            )
            .andExpect(status().isOk());

        // Validate the CriterionMaster in the database
        List<CriterionMaster> criterionMasterList = criterionMasterRepository.findAll();
        assertThat(criterionMasterList).hasSize(databaseSizeBeforeUpdate);
        CriterionMaster testCriterionMaster = criterionMasterList.get(criterionMasterList.size() - 1);
        assertThat(testCriterionMaster.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testCriterionMaster.getCriterionType()).isEqualTo(UPDATED_CRITERION_TYPE);
        assertThat(testCriterionMaster.getDocumentName()).isEqualTo(UPDATED_DOCUMENT_NAME);
        assertThat(testCriterionMaster.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testCriterionMaster.getTenderCategory()).isEqualTo(UPDATED_TENDER_CATEGORY);
        assertThat(testCriterionMaster.getActiveYn()).isEqualTo(DEFAULT_ACTIVE_YN);
    }

    @Test
    @Transactional
    void fullUpdateCriterionMasterWithPatch() throws Exception {
        // Initialize the database
        criterionMasterRepository.saveAndFlush(criterionMaster);

        int databaseSizeBeforeUpdate = criterionMasterRepository.findAll().size();

        // Update the criterionMaster using partial update
        CriterionMaster partialUpdatedCriterionMaster = new CriterionMaster();
        partialUpdatedCriterionMaster.setId(criterionMaster.getId());

        partialUpdatedCriterionMaster
            .type(UPDATED_TYPE)
            .criterionType(UPDATED_CRITERION_TYPE)
            .documentName(UPDATED_DOCUMENT_NAME)
            .description(UPDATED_DESCRIPTION)
            .tenderCategory(UPDATED_TENDER_CATEGORY)
            .activeYn(UPDATED_ACTIVE_YN);

        restCriterionMasterMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCriterionMaster.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCriterionMaster))
            )
            .andExpect(status().isOk());

        // Validate the CriterionMaster in the database
        List<CriterionMaster> criterionMasterList = criterionMasterRepository.findAll();
        assertThat(criterionMasterList).hasSize(databaseSizeBeforeUpdate);
        CriterionMaster testCriterionMaster = criterionMasterList.get(criterionMasterList.size() - 1);
        assertThat(testCriterionMaster.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testCriterionMaster.getCriterionType()).isEqualTo(UPDATED_CRITERION_TYPE);
        assertThat(testCriterionMaster.getDocumentName()).isEqualTo(UPDATED_DOCUMENT_NAME);
        assertThat(testCriterionMaster.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testCriterionMaster.getTenderCategory()).isEqualTo(UPDATED_TENDER_CATEGORY);
        assertThat(testCriterionMaster.getActiveYn()).isEqualTo(UPDATED_ACTIVE_YN);
    }

    @Test
    @Transactional
    void patchNonExistingCriterionMaster() throws Exception {
        int databaseSizeBeforeUpdate = criterionMasterRepository.findAll().size();
        criterionMaster.setId(count.incrementAndGet());

        // Create the CriterionMaster
        CriterionMasterDTO criterionMasterDTO = criterionMasterMapper.toDto(criterionMaster);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCriterionMasterMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, criterionMasterDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(criterionMasterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CriterionMaster in the database
        List<CriterionMaster> criterionMasterList = criterionMasterRepository.findAll();
        assertThat(criterionMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchCriterionMaster() throws Exception {
        int databaseSizeBeforeUpdate = criterionMasterRepository.findAll().size();
        criterionMaster.setId(count.incrementAndGet());

        // Create the CriterionMaster
        CriterionMasterDTO criterionMasterDTO = criterionMasterMapper.toDto(criterionMaster);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCriterionMasterMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(criterionMasterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CriterionMaster in the database
        List<CriterionMaster> criterionMasterList = criterionMasterRepository.findAll();
        assertThat(criterionMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamCriterionMaster() throws Exception {
        int databaseSizeBeforeUpdate = criterionMasterRepository.findAll().size();
        criterionMaster.setId(count.incrementAndGet());

        // Create the CriterionMaster
        CriterionMasterDTO criterionMasterDTO = criterionMasterMapper.toDto(criterionMaster);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCriterionMasterMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(criterionMasterDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the CriterionMaster in the database
        List<CriterionMaster> criterionMasterList = criterionMasterRepository.findAll();
        assertThat(criterionMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteCriterionMaster() throws Exception {
        // Initialize the database
        criterionMasterRepository.saveAndFlush(criterionMaster);

        int databaseSizeBeforeDelete = criterionMasterRepository.findAll().size();

        // Delete the criterionMaster
        restCriterionMasterMockMvc
            .perform(delete(ENTITY_API_URL_ID, criterionMaster.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CriterionMaster> criterionMasterList = criterionMasterRepository.findAll();
        assertThat(criterionMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
