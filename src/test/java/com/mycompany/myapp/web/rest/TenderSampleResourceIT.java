package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.TenderSample;
import com.mycompany.myapp.repository.TenderSampleRepository;
import com.mycompany.myapp.service.dto.TenderSampleDTO;
import com.mycompany.myapp.service.mapper.TenderSampleMapper;
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
 * Integration tests for the {@link TenderSampleResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TenderSampleResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DESIGNATION_POST = "AAAAAAAAAA";
    private static final String UPDATED_DESIGNATION_POST = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/tender-samples";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private TenderSampleRepository tenderSampleRepository;

    @Autowired
    private TenderSampleMapper tenderSampleMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTenderSampleMockMvc;

    private TenderSample tenderSample;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderSample createEntity(EntityManager em) {
        TenderSample tenderSample = new TenderSample().name(DEFAULT_NAME).designationPost(DEFAULT_DESIGNATION_POST);
        return tenderSample;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderSample createUpdatedEntity(EntityManager em) {
        TenderSample tenderSample = new TenderSample().name(UPDATED_NAME).designationPost(UPDATED_DESIGNATION_POST);
        return tenderSample;
    }

    @BeforeEach
    public void initTest() {
        tenderSample = createEntity(em);
    }

    @Test
    @Transactional
    void createTenderSample() throws Exception {
        int databaseSizeBeforeCreate = tenderSampleRepository.findAll().size();
        // Create the TenderSample
        TenderSampleDTO tenderSampleDTO = tenderSampleMapper.toDto(tenderSample);
        restTenderSampleMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderSampleDTO))
            )
            .andExpect(status().isCreated());

        // Validate the TenderSample in the database
        List<TenderSample> tenderSampleList = tenderSampleRepository.findAll();
        assertThat(tenderSampleList).hasSize(databaseSizeBeforeCreate + 1);
        TenderSample testTenderSample = tenderSampleList.get(tenderSampleList.size() - 1);
        assertThat(testTenderSample.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testTenderSample.getDesignationPost()).isEqualTo(DEFAULT_DESIGNATION_POST);
    }

    @Test
    @Transactional
    void createTenderSampleWithExistingId() throws Exception {
        // Create the TenderSample with an existing ID
        tenderSample.setId(1L);
        TenderSampleDTO tenderSampleDTO = tenderSampleMapper.toDto(tenderSample);

        int databaseSizeBeforeCreate = tenderSampleRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTenderSampleMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderSampleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderSample in the database
        List<TenderSample> tenderSampleList = tenderSampleRepository.findAll();
        assertThat(tenderSampleList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllTenderSamples() throws Exception {
        // Initialize the database
        tenderSampleRepository.saveAndFlush(tenderSample);

        // Get all the tenderSampleList
        restTenderSampleMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tenderSample.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].designationPost").value(hasItem(DEFAULT_DESIGNATION_POST)));
    }

    @Test
    @Transactional
    void getTenderSample() throws Exception {
        // Initialize the database
        tenderSampleRepository.saveAndFlush(tenderSample);

        // Get the tenderSample
        restTenderSampleMockMvc
            .perform(get(ENTITY_API_URL_ID, tenderSample.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(tenderSample.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.designationPost").value(DEFAULT_DESIGNATION_POST));
    }

    @Test
    @Transactional
    void getNonExistingTenderSample() throws Exception {
        // Get the tenderSample
        restTenderSampleMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewTenderSample() throws Exception {
        // Initialize the database
        tenderSampleRepository.saveAndFlush(tenderSample);

        int databaseSizeBeforeUpdate = tenderSampleRepository.findAll().size();

        // Update the tenderSample
        TenderSample updatedTenderSample = tenderSampleRepository.findById(tenderSample.getId()).get();
        // Disconnect from session so that the updates on updatedTenderSample are not directly saved in db
        em.detach(updatedTenderSample);
        updatedTenderSample.name(UPDATED_NAME).designationPost(UPDATED_DESIGNATION_POST);
        TenderSampleDTO tenderSampleDTO = tenderSampleMapper.toDto(updatedTenderSample);

        restTenderSampleMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderSampleDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderSampleDTO))
            )
            .andExpect(status().isOk());

        // Validate the TenderSample in the database
        List<TenderSample> tenderSampleList = tenderSampleRepository.findAll();
        assertThat(tenderSampleList).hasSize(databaseSizeBeforeUpdate);
        TenderSample testTenderSample = tenderSampleList.get(tenderSampleList.size() - 1);
        assertThat(testTenderSample.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testTenderSample.getDesignationPost()).isEqualTo(UPDATED_DESIGNATION_POST);
    }

    @Test
    @Transactional
    void putNonExistingTenderSample() throws Exception {
        int databaseSizeBeforeUpdate = tenderSampleRepository.findAll().size();
        tenderSample.setId(count.incrementAndGet());

        // Create the TenderSample
        TenderSampleDTO tenderSampleDTO = tenderSampleMapper.toDto(tenderSample);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderSampleMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderSampleDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderSampleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderSample in the database
        List<TenderSample> tenderSampleList = tenderSampleRepository.findAll();
        assertThat(tenderSampleList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTenderSample() throws Exception {
        int databaseSizeBeforeUpdate = tenderSampleRepository.findAll().size();
        tenderSample.setId(count.incrementAndGet());

        // Create the TenderSample
        TenderSampleDTO tenderSampleDTO = tenderSampleMapper.toDto(tenderSample);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderSampleMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderSampleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderSample in the database
        List<TenderSample> tenderSampleList = tenderSampleRepository.findAll();
        assertThat(tenderSampleList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTenderSample() throws Exception {
        int databaseSizeBeforeUpdate = tenderSampleRepository.findAll().size();
        tenderSample.setId(count.incrementAndGet());

        // Create the TenderSample
        TenderSampleDTO tenderSampleDTO = tenderSampleMapper.toDto(tenderSample);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderSampleMockMvc
            .perform(
                put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderSampleDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderSample in the database
        List<TenderSample> tenderSampleList = tenderSampleRepository.findAll();
        assertThat(tenderSampleList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTenderSampleWithPatch() throws Exception {
        // Initialize the database
        tenderSampleRepository.saveAndFlush(tenderSample);

        int databaseSizeBeforeUpdate = tenderSampleRepository.findAll().size();

        // Update the tenderSample using partial update
        TenderSample partialUpdatedTenderSample = new TenderSample();
        partialUpdatedTenderSample.setId(tenderSample.getId());

        partialUpdatedTenderSample.name(UPDATED_NAME).designationPost(UPDATED_DESIGNATION_POST);

        restTenderSampleMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderSample.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderSample))
            )
            .andExpect(status().isOk());

        // Validate the TenderSample in the database
        List<TenderSample> tenderSampleList = tenderSampleRepository.findAll();
        assertThat(tenderSampleList).hasSize(databaseSizeBeforeUpdate);
        TenderSample testTenderSample = tenderSampleList.get(tenderSampleList.size() - 1);
        assertThat(testTenderSample.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testTenderSample.getDesignationPost()).isEqualTo(UPDATED_DESIGNATION_POST);
    }

    @Test
    @Transactional
    void fullUpdateTenderSampleWithPatch() throws Exception {
        // Initialize the database
        tenderSampleRepository.saveAndFlush(tenderSample);

        int databaseSizeBeforeUpdate = tenderSampleRepository.findAll().size();

        // Update the tenderSample using partial update
        TenderSample partialUpdatedTenderSample = new TenderSample();
        partialUpdatedTenderSample.setId(tenderSample.getId());

        partialUpdatedTenderSample.name(UPDATED_NAME).designationPost(UPDATED_DESIGNATION_POST);

        restTenderSampleMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderSample.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderSample))
            )
            .andExpect(status().isOk());

        // Validate the TenderSample in the database
        List<TenderSample> tenderSampleList = tenderSampleRepository.findAll();
        assertThat(tenderSampleList).hasSize(databaseSizeBeforeUpdate);
        TenderSample testTenderSample = tenderSampleList.get(tenderSampleList.size() - 1);
        assertThat(testTenderSample.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testTenderSample.getDesignationPost()).isEqualTo(UPDATED_DESIGNATION_POST);
    }

    @Test
    @Transactional
    void patchNonExistingTenderSample() throws Exception {
        int databaseSizeBeforeUpdate = tenderSampleRepository.findAll().size();
        tenderSample.setId(count.incrementAndGet());

        // Create the TenderSample
        TenderSampleDTO tenderSampleDTO = tenderSampleMapper.toDto(tenderSample);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderSampleMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, tenderSampleDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderSampleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderSample in the database
        List<TenderSample> tenderSampleList = tenderSampleRepository.findAll();
        assertThat(tenderSampleList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTenderSample() throws Exception {
        int databaseSizeBeforeUpdate = tenderSampleRepository.findAll().size();
        tenderSample.setId(count.incrementAndGet());

        // Create the TenderSample
        TenderSampleDTO tenderSampleDTO = tenderSampleMapper.toDto(tenderSample);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderSampleMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderSampleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderSample in the database
        List<TenderSample> tenderSampleList = tenderSampleRepository.findAll();
        assertThat(tenderSampleList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTenderSample() throws Exception {
        int databaseSizeBeforeUpdate = tenderSampleRepository.findAll().size();
        tenderSample.setId(count.incrementAndGet());

        // Create the TenderSample
        TenderSampleDTO tenderSampleDTO = tenderSampleMapper.toDto(tenderSample);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderSampleMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderSampleDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderSample in the database
        List<TenderSample> tenderSampleList = tenderSampleRepository.findAll();
        assertThat(tenderSampleList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTenderSample() throws Exception {
        // Initialize the database
        tenderSampleRepository.saveAndFlush(tenderSample);

        int databaseSizeBeforeDelete = tenderSampleRepository.findAll().size();

        // Delete the tenderSample
        restTenderSampleMockMvc
            .perform(delete(ENTITY_API_URL_ID, tenderSample.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<TenderSample> tenderSampleList = tenderSampleRepository.findAll();
        assertThat(tenderSampleList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
