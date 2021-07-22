package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.TenderCriterion;
import com.mycompany.myapp.repository.TenderCriterionRepository;
import com.mycompany.myapp.service.dto.TenderCriterionDTO;
import com.mycompany.myapp.service.mapper.TenderCriterionMapper;
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
 * Integration tests for the {@link TenderCriterionResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TenderCriterionResourceIT {

    private static final Long DEFAULT_CRITERION_MASTER_ID = 1L;
    private static final Long UPDATED_CRITERION_MASTER_ID = 2L;

    private static final String DEFAULT_CRITERION_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CRITERION_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CRITERION_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_CRITERION_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_CRITERION_TYPE_OTHERS_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_CRITERION_TYPE_OTHERS_VALUE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_WEIGHT = 1;
    private static final Integer UPDATED_WEIGHT = 2;

    private static final String ENTITY_API_URL = "/api/tender-criteria";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private TenderCriterionRepository tenderCriterionRepository;

    @Autowired
    private TenderCriterionMapper tenderCriterionMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTenderCriterionMockMvc;

    private TenderCriterion tenderCriterion;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderCriterion createEntity(EntityManager em) {
        TenderCriterion tenderCriterion = new TenderCriterion()
            .criterionMasterId(DEFAULT_CRITERION_MASTER_ID)
            .criterionType(DEFAULT_CRITERION_TYPE)
            .criterionCategory(DEFAULT_CRITERION_CATEGORY)
            .criterionTypeOthersValue(DEFAULT_CRITERION_TYPE_OTHERS_VALUE)
            .description(DEFAULT_DESCRIPTION)
            .weight(DEFAULT_WEIGHT);
        return tenderCriterion;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderCriterion createUpdatedEntity(EntityManager em) {
        TenderCriterion tenderCriterion = new TenderCriterion()
            .criterionMasterId(UPDATED_CRITERION_MASTER_ID)
            .criterionType(UPDATED_CRITERION_TYPE)
            .criterionCategory(UPDATED_CRITERION_CATEGORY)
            .criterionTypeOthersValue(UPDATED_CRITERION_TYPE_OTHERS_VALUE)
            .description(UPDATED_DESCRIPTION)
            .weight(UPDATED_WEIGHT);
        return tenderCriterion;
    }

    @BeforeEach
    public void initTest() {
        tenderCriterion = createEntity(em);
    }

    @Test
    @Transactional
    void createTenderCriterion() throws Exception {
        int databaseSizeBeforeCreate = tenderCriterionRepository.findAll().size();
        // Create the TenderCriterion
        TenderCriterionDTO tenderCriterionDTO = tenderCriterionMapper.toDto(tenderCriterion);
        restTenderCriterionMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderCriterionDTO))
            )
            .andExpect(status().isCreated());

        // Validate the TenderCriterion in the database
        List<TenderCriterion> tenderCriterionList = tenderCriterionRepository.findAll();
        assertThat(tenderCriterionList).hasSize(databaseSizeBeforeCreate + 1);
        TenderCriterion testTenderCriterion = tenderCriterionList.get(tenderCriterionList.size() - 1);
        assertThat(testTenderCriterion.getCriterionMasterId()).isEqualTo(DEFAULT_CRITERION_MASTER_ID);
        assertThat(testTenderCriterion.getCriterionType()).isEqualTo(DEFAULT_CRITERION_TYPE);
        assertThat(testTenderCriterion.getCriterionCategory()).isEqualTo(DEFAULT_CRITERION_CATEGORY);
        assertThat(testTenderCriterion.getCriterionTypeOthersValue()).isEqualTo(DEFAULT_CRITERION_TYPE_OTHERS_VALUE);
        assertThat(testTenderCriterion.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testTenderCriterion.getWeight()).isEqualTo(DEFAULT_WEIGHT);
    }

    @Test
    @Transactional
    void createTenderCriterionWithExistingId() throws Exception {
        // Create the TenderCriterion with an existing ID
        tenderCriterion.setId(1L);
        TenderCriterionDTO tenderCriterionDTO = tenderCriterionMapper.toDto(tenderCriterion);

        int databaseSizeBeforeCreate = tenderCriterionRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTenderCriterionMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderCriterionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCriterion in the database
        List<TenderCriterion> tenderCriterionList = tenderCriterionRepository.findAll();
        assertThat(tenderCriterionList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllTenderCriteria() throws Exception {
        // Initialize the database
        tenderCriterionRepository.saveAndFlush(tenderCriterion);

        // Get all the tenderCriterionList
        restTenderCriterionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tenderCriterion.getId().intValue())))
            .andExpect(jsonPath("$.[*].criterionMasterId").value(hasItem(DEFAULT_CRITERION_MASTER_ID.intValue())))
            .andExpect(jsonPath("$.[*].criterionType").value(hasItem(DEFAULT_CRITERION_TYPE)))
            .andExpect(jsonPath("$.[*].criterionCategory").value(hasItem(DEFAULT_CRITERION_CATEGORY)))
            .andExpect(jsonPath("$.[*].criterionTypeOthersValue").value(hasItem(DEFAULT_CRITERION_TYPE_OTHERS_VALUE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].weight").value(hasItem(DEFAULT_WEIGHT)));
    }

    @Test
    @Transactional
    void getTenderCriterion() throws Exception {
        // Initialize the database
        tenderCriterionRepository.saveAndFlush(tenderCriterion);

        // Get the tenderCriterion
        restTenderCriterionMockMvc
            .perform(get(ENTITY_API_URL_ID, tenderCriterion.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(tenderCriterion.getId().intValue()))
            .andExpect(jsonPath("$.criterionMasterId").value(DEFAULT_CRITERION_MASTER_ID.intValue()))
            .andExpect(jsonPath("$.criterionType").value(DEFAULT_CRITERION_TYPE))
            .andExpect(jsonPath("$.criterionCategory").value(DEFAULT_CRITERION_CATEGORY))
            .andExpect(jsonPath("$.criterionTypeOthersValue").value(DEFAULT_CRITERION_TYPE_OTHERS_VALUE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.weight").value(DEFAULT_WEIGHT));
    }

    @Test
    @Transactional
    void getNonExistingTenderCriterion() throws Exception {
        // Get the tenderCriterion
        restTenderCriterionMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewTenderCriterion() throws Exception {
        // Initialize the database
        tenderCriterionRepository.saveAndFlush(tenderCriterion);

        int databaseSizeBeforeUpdate = tenderCriterionRepository.findAll().size();

        // Update the tenderCriterion
        TenderCriterion updatedTenderCriterion = tenderCriterionRepository.findById(tenderCriterion.getId()).get();
        // Disconnect from session so that the updates on updatedTenderCriterion are not directly saved in db
        em.detach(updatedTenderCriterion);
        updatedTenderCriterion
            .criterionMasterId(UPDATED_CRITERION_MASTER_ID)
            .criterionType(UPDATED_CRITERION_TYPE)
            .criterionCategory(UPDATED_CRITERION_CATEGORY)
            .criterionTypeOthersValue(UPDATED_CRITERION_TYPE_OTHERS_VALUE)
            .description(UPDATED_DESCRIPTION)
            .weight(UPDATED_WEIGHT);
        TenderCriterionDTO tenderCriterionDTO = tenderCriterionMapper.toDto(updatedTenderCriterion);

        restTenderCriterionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderCriterionDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDTO))
            )
            .andExpect(status().isOk());

        // Validate the TenderCriterion in the database
        List<TenderCriterion> tenderCriterionList = tenderCriterionRepository.findAll();
        assertThat(tenderCriterionList).hasSize(databaseSizeBeforeUpdate);
        TenderCriterion testTenderCriterion = tenderCriterionList.get(tenderCriterionList.size() - 1);
        assertThat(testTenderCriterion.getCriterionMasterId()).isEqualTo(UPDATED_CRITERION_MASTER_ID);
        assertThat(testTenderCriterion.getCriterionType()).isEqualTo(UPDATED_CRITERION_TYPE);
        assertThat(testTenderCriterion.getCriterionCategory()).isEqualTo(UPDATED_CRITERION_CATEGORY);
        assertThat(testTenderCriterion.getCriterionTypeOthersValue()).isEqualTo(UPDATED_CRITERION_TYPE_OTHERS_VALUE);
        assertThat(testTenderCriterion.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testTenderCriterion.getWeight()).isEqualTo(UPDATED_WEIGHT);
    }

    @Test
    @Transactional
    void putNonExistingTenderCriterion() throws Exception {
        int databaseSizeBeforeUpdate = tenderCriterionRepository.findAll().size();
        tenderCriterion.setId(count.incrementAndGet());

        // Create the TenderCriterion
        TenderCriterionDTO tenderCriterionDTO = tenderCriterionMapper.toDto(tenderCriterion);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderCriterionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderCriterionDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCriterion in the database
        List<TenderCriterion> tenderCriterionList = tenderCriterionRepository.findAll();
        assertThat(tenderCriterionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTenderCriterion() throws Exception {
        int databaseSizeBeforeUpdate = tenderCriterionRepository.findAll().size();
        tenderCriterion.setId(count.incrementAndGet());

        // Create the TenderCriterion
        TenderCriterionDTO tenderCriterionDTO = tenderCriterionMapper.toDto(tenderCriterion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderCriterionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCriterion in the database
        List<TenderCriterion> tenderCriterionList = tenderCriterionRepository.findAll();
        assertThat(tenderCriterionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTenderCriterion() throws Exception {
        int databaseSizeBeforeUpdate = tenderCriterionRepository.findAll().size();
        tenderCriterion.setId(count.incrementAndGet());

        // Create the TenderCriterion
        TenderCriterionDTO tenderCriterionDTO = tenderCriterionMapper.toDto(tenderCriterion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderCriterionMockMvc
            .perform(
                put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderCriterionDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderCriterion in the database
        List<TenderCriterion> tenderCriterionList = tenderCriterionRepository.findAll();
        assertThat(tenderCriterionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTenderCriterionWithPatch() throws Exception {
        // Initialize the database
        tenderCriterionRepository.saveAndFlush(tenderCriterion);

        int databaseSizeBeforeUpdate = tenderCriterionRepository.findAll().size();

        // Update the tenderCriterion using partial update
        TenderCriterion partialUpdatedTenderCriterion = new TenderCriterion();
        partialUpdatedTenderCriterion.setId(tenderCriterion.getId());

        partialUpdatedTenderCriterion
            .criterionType(UPDATED_CRITERION_TYPE)
            .criterionTypeOthersValue(UPDATED_CRITERION_TYPE_OTHERS_VALUE)
            .weight(UPDATED_WEIGHT);

        restTenderCriterionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderCriterion.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderCriterion))
            )
            .andExpect(status().isOk());

        // Validate the TenderCriterion in the database
        List<TenderCriterion> tenderCriterionList = tenderCriterionRepository.findAll();
        assertThat(tenderCriterionList).hasSize(databaseSizeBeforeUpdate);
        TenderCriterion testTenderCriterion = tenderCriterionList.get(tenderCriterionList.size() - 1);
        assertThat(testTenderCriterion.getCriterionMasterId()).isEqualTo(DEFAULT_CRITERION_MASTER_ID);
        assertThat(testTenderCriterion.getCriterionType()).isEqualTo(UPDATED_CRITERION_TYPE);
        assertThat(testTenderCriterion.getCriterionCategory()).isEqualTo(DEFAULT_CRITERION_CATEGORY);
        assertThat(testTenderCriterion.getCriterionTypeOthersValue()).isEqualTo(UPDATED_CRITERION_TYPE_OTHERS_VALUE);
        assertThat(testTenderCriterion.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testTenderCriterion.getWeight()).isEqualTo(UPDATED_WEIGHT);
    }

    @Test
    @Transactional
    void fullUpdateTenderCriterionWithPatch() throws Exception {
        // Initialize the database
        tenderCriterionRepository.saveAndFlush(tenderCriterion);

        int databaseSizeBeforeUpdate = tenderCriterionRepository.findAll().size();

        // Update the tenderCriterion using partial update
        TenderCriterion partialUpdatedTenderCriterion = new TenderCriterion();
        partialUpdatedTenderCriterion.setId(tenderCriterion.getId());

        partialUpdatedTenderCriterion
            .criterionMasterId(UPDATED_CRITERION_MASTER_ID)
            .criterionType(UPDATED_CRITERION_TYPE)
            .criterionCategory(UPDATED_CRITERION_CATEGORY)
            .criterionTypeOthersValue(UPDATED_CRITERION_TYPE_OTHERS_VALUE)
            .description(UPDATED_DESCRIPTION)
            .weight(UPDATED_WEIGHT);

        restTenderCriterionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderCriterion.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderCriterion))
            )
            .andExpect(status().isOk());

        // Validate the TenderCriterion in the database
        List<TenderCriterion> tenderCriterionList = tenderCriterionRepository.findAll();
        assertThat(tenderCriterionList).hasSize(databaseSizeBeforeUpdate);
        TenderCriterion testTenderCriterion = tenderCriterionList.get(tenderCriterionList.size() - 1);
        assertThat(testTenderCriterion.getCriterionMasterId()).isEqualTo(UPDATED_CRITERION_MASTER_ID);
        assertThat(testTenderCriterion.getCriterionType()).isEqualTo(UPDATED_CRITERION_TYPE);
        assertThat(testTenderCriterion.getCriterionCategory()).isEqualTo(UPDATED_CRITERION_CATEGORY);
        assertThat(testTenderCriterion.getCriterionTypeOthersValue()).isEqualTo(UPDATED_CRITERION_TYPE_OTHERS_VALUE);
        assertThat(testTenderCriterion.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testTenderCriterion.getWeight()).isEqualTo(UPDATED_WEIGHT);
    }

    @Test
    @Transactional
    void patchNonExistingTenderCriterion() throws Exception {
        int databaseSizeBeforeUpdate = tenderCriterionRepository.findAll().size();
        tenderCriterion.setId(count.incrementAndGet());

        // Create the TenderCriterion
        TenderCriterionDTO tenderCriterionDTO = tenderCriterionMapper.toDto(tenderCriterion);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderCriterionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, tenderCriterionDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCriterion in the database
        List<TenderCriterion> tenderCriterionList = tenderCriterionRepository.findAll();
        assertThat(tenderCriterionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTenderCriterion() throws Exception {
        int databaseSizeBeforeUpdate = tenderCriterionRepository.findAll().size();
        tenderCriterion.setId(count.incrementAndGet());

        // Create the TenderCriterion
        TenderCriterionDTO tenderCriterionDTO = tenderCriterionMapper.toDto(tenderCriterion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderCriterionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderCriterion in the database
        List<TenderCriterion> tenderCriterionList = tenderCriterionRepository.findAll();
        assertThat(tenderCriterionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTenderCriterion() throws Exception {
        int databaseSizeBeforeUpdate = tenderCriterionRepository.findAll().size();
        tenderCriterion.setId(count.incrementAndGet());

        // Create the TenderCriterion
        TenderCriterionDTO tenderCriterionDTO = tenderCriterionMapper.toDto(tenderCriterion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderCriterionMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderCriterionDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderCriterion in the database
        List<TenderCriterion> tenderCriterionList = tenderCriterionRepository.findAll();
        assertThat(tenderCriterionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTenderCriterion() throws Exception {
        // Initialize the database
        tenderCriterionRepository.saveAndFlush(tenderCriterion);

        int databaseSizeBeforeDelete = tenderCriterionRepository.findAll().size();

        // Delete the tenderCriterion
        restTenderCriterionMockMvc
            .perform(delete(ENTITY_API_URL_ID, tenderCriterion.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<TenderCriterion> tenderCriterionList = tenderCriterionRepository.findAll();
        assertThat(tenderCriterionList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
