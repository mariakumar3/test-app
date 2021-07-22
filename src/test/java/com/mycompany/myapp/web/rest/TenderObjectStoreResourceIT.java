package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.TenderObjectStore;
import com.mycompany.myapp.repository.TenderObjectStoreRepository;
import com.mycompany.myapp.service.dto.TenderObjectStoreDTO;
import com.mycompany.myapp.service.mapper.TenderObjectStoreMapper;
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
 * Integration tests for the {@link TenderObjectStoreResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TenderObjectStoreResourceIT {

    private static final Long DEFAULT_REFERENCE_ID = 1L;
    private static final Long UPDATED_REFERENCE_ID = 2L;

    private static final Long DEFAULT_REFERENCE_TYPE = 1L;
    private static final Long UPDATED_REFERENCE_TYPE = 2L;

    private static final Boolean DEFAULT_ACTIVE_YN = false;
    private static final Boolean UPDATED_ACTIVE_YN = true;

    private static final String ENTITY_API_URL = "/api/tender-object-stores";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private TenderObjectStoreRepository tenderObjectStoreRepository;

    @Autowired
    private TenderObjectStoreMapper tenderObjectStoreMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTenderObjectStoreMockMvc;

    private TenderObjectStore tenderObjectStore;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderObjectStore createEntity(EntityManager em) {
        TenderObjectStore tenderObjectStore = new TenderObjectStore()
            .referenceId(DEFAULT_REFERENCE_ID)
            .referenceType(DEFAULT_REFERENCE_TYPE)
            .activeYn(DEFAULT_ACTIVE_YN);
        return tenderObjectStore;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderObjectStore createUpdatedEntity(EntityManager em) {
        TenderObjectStore tenderObjectStore = new TenderObjectStore()
            .referenceId(UPDATED_REFERENCE_ID)
            .referenceType(UPDATED_REFERENCE_TYPE)
            .activeYn(UPDATED_ACTIVE_YN);
        return tenderObjectStore;
    }

    @BeforeEach
    public void initTest() {
        tenderObjectStore = createEntity(em);
    }

    @Test
    @Transactional
    void createTenderObjectStore() throws Exception {
        int databaseSizeBeforeCreate = tenderObjectStoreRepository.findAll().size();
        // Create the TenderObjectStore
        TenderObjectStoreDTO tenderObjectStoreDTO = tenderObjectStoreMapper.toDto(tenderObjectStore);
        restTenderObjectStoreMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderObjectStoreDTO))
            )
            .andExpect(status().isCreated());

        // Validate the TenderObjectStore in the database
        List<TenderObjectStore> tenderObjectStoreList = tenderObjectStoreRepository.findAll();
        assertThat(tenderObjectStoreList).hasSize(databaseSizeBeforeCreate + 1);
        TenderObjectStore testTenderObjectStore = tenderObjectStoreList.get(tenderObjectStoreList.size() - 1);
        assertThat(testTenderObjectStore.getReferenceId()).isEqualTo(DEFAULT_REFERENCE_ID);
        assertThat(testTenderObjectStore.getReferenceType()).isEqualTo(DEFAULT_REFERENCE_TYPE);
        assertThat(testTenderObjectStore.getActiveYn()).isEqualTo(DEFAULT_ACTIVE_YN);
    }

    @Test
    @Transactional
    void createTenderObjectStoreWithExistingId() throws Exception {
        // Create the TenderObjectStore with an existing ID
        tenderObjectStore.setId(1L);
        TenderObjectStoreDTO tenderObjectStoreDTO = tenderObjectStoreMapper.toDto(tenderObjectStore);

        int databaseSizeBeforeCreate = tenderObjectStoreRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTenderObjectStoreMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderObjectStoreDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderObjectStore in the database
        List<TenderObjectStore> tenderObjectStoreList = tenderObjectStoreRepository.findAll();
        assertThat(tenderObjectStoreList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllTenderObjectStores() throws Exception {
        // Initialize the database
        tenderObjectStoreRepository.saveAndFlush(tenderObjectStore);

        // Get all the tenderObjectStoreList
        restTenderObjectStoreMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tenderObjectStore.getId().intValue())))
            .andExpect(jsonPath("$.[*].referenceId").value(hasItem(DEFAULT_REFERENCE_ID.intValue())))
            .andExpect(jsonPath("$.[*].referenceType").value(hasItem(DEFAULT_REFERENCE_TYPE.intValue())))
            .andExpect(jsonPath("$.[*].activeYn").value(hasItem(DEFAULT_ACTIVE_YN.booleanValue())));
    }

    @Test
    @Transactional
    void getTenderObjectStore() throws Exception {
        // Initialize the database
        tenderObjectStoreRepository.saveAndFlush(tenderObjectStore);

        // Get the tenderObjectStore
        restTenderObjectStoreMockMvc
            .perform(get(ENTITY_API_URL_ID, tenderObjectStore.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(tenderObjectStore.getId().intValue()))
            .andExpect(jsonPath("$.referenceId").value(DEFAULT_REFERENCE_ID.intValue()))
            .andExpect(jsonPath("$.referenceType").value(DEFAULT_REFERENCE_TYPE.intValue()))
            .andExpect(jsonPath("$.activeYn").value(DEFAULT_ACTIVE_YN.booleanValue()));
    }

    @Test
    @Transactional
    void getNonExistingTenderObjectStore() throws Exception {
        // Get the tenderObjectStore
        restTenderObjectStoreMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewTenderObjectStore() throws Exception {
        // Initialize the database
        tenderObjectStoreRepository.saveAndFlush(tenderObjectStore);

        int databaseSizeBeforeUpdate = tenderObjectStoreRepository.findAll().size();

        // Update the tenderObjectStore
        TenderObjectStore updatedTenderObjectStore = tenderObjectStoreRepository.findById(tenderObjectStore.getId()).get();
        // Disconnect from session so that the updates on updatedTenderObjectStore are not directly saved in db
        em.detach(updatedTenderObjectStore);
        updatedTenderObjectStore.referenceId(UPDATED_REFERENCE_ID).referenceType(UPDATED_REFERENCE_TYPE).activeYn(UPDATED_ACTIVE_YN);
        TenderObjectStoreDTO tenderObjectStoreDTO = tenderObjectStoreMapper.toDto(updatedTenderObjectStore);

        restTenderObjectStoreMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderObjectStoreDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderObjectStoreDTO))
            )
            .andExpect(status().isOk());

        // Validate the TenderObjectStore in the database
        List<TenderObjectStore> tenderObjectStoreList = tenderObjectStoreRepository.findAll();
        assertThat(tenderObjectStoreList).hasSize(databaseSizeBeforeUpdate);
        TenderObjectStore testTenderObjectStore = tenderObjectStoreList.get(tenderObjectStoreList.size() - 1);
        assertThat(testTenderObjectStore.getReferenceId()).isEqualTo(UPDATED_REFERENCE_ID);
        assertThat(testTenderObjectStore.getReferenceType()).isEqualTo(UPDATED_REFERENCE_TYPE);
        assertThat(testTenderObjectStore.getActiveYn()).isEqualTo(UPDATED_ACTIVE_YN);
    }

    @Test
    @Transactional
    void putNonExistingTenderObjectStore() throws Exception {
        int databaseSizeBeforeUpdate = tenderObjectStoreRepository.findAll().size();
        tenderObjectStore.setId(count.incrementAndGet());

        // Create the TenderObjectStore
        TenderObjectStoreDTO tenderObjectStoreDTO = tenderObjectStoreMapper.toDto(tenderObjectStore);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderObjectStoreMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderObjectStoreDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderObjectStoreDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderObjectStore in the database
        List<TenderObjectStore> tenderObjectStoreList = tenderObjectStoreRepository.findAll();
        assertThat(tenderObjectStoreList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTenderObjectStore() throws Exception {
        int databaseSizeBeforeUpdate = tenderObjectStoreRepository.findAll().size();
        tenderObjectStore.setId(count.incrementAndGet());

        // Create the TenderObjectStore
        TenderObjectStoreDTO tenderObjectStoreDTO = tenderObjectStoreMapper.toDto(tenderObjectStore);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderObjectStoreMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderObjectStoreDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderObjectStore in the database
        List<TenderObjectStore> tenderObjectStoreList = tenderObjectStoreRepository.findAll();
        assertThat(tenderObjectStoreList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTenderObjectStore() throws Exception {
        int databaseSizeBeforeUpdate = tenderObjectStoreRepository.findAll().size();
        tenderObjectStore.setId(count.incrementAndGet());

        // Create the TenderObjectStore
        TenderObjectStoreDTO tenderObjectStoreDTO = tenderObjectStoreMapper.toDto(tenderObjectStore);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderObjectStoreMockMvc
            .perform(
                put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderObjectStoreDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderObjectStore in the database
        List<TenderObjectStore> tenderObjectStoreList = tenderObjectStoreRepository.findAll();
        assertThat(tenderObjectStoreList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTenderObjectStoreWithPatch() throws Exception {
        // Initialize the database
        tenderObjectStoreRepository.saveAndFlush(tenderObjectStore);

        int databaseSizeBeforeUpdate = tenderObjectStoreRepository.findAll().size();

        // Update the tenderObjectStore using partial update
        TenderObjectStore partialUpdatedTenderObjectStore = new TenderObjectStore();
        partialUpdatedTenderObjectStore.setId(tenderObjectStore.getId());

        partialUpdatedTenderObjectStore.referenceId(UPDATED_REFERENCE_ID);

        restTenderObjectStoreMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderObjectStore.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderObjectStore))
            )
            .andExpect(status().isOk());

        // Validate the TenderObjectStore in the database
        List<TenderObjectStore> tenderObjectStoreList = tenderObjectStoreRepository.findAll();
        assertThat(tenderObjectStoreList).hasSize(databaseSizeBeforeUpdate);
        TenderObjectStore testTenderObjectStore = tenderObjectStoreList.get(tenderObjectStoreList.size() - 1);
        assertThat(testTenderObjectStore.getReferenceId()).isEqualTo(UPDATED_REFERENCE_ID);
        assertThat(testTenderObjectStore.getReferenceType()).isEqualTo(DEFAULT_REFERENCE_TYPE);
        assertThat(testTenderObjectStore.getActiveYn()).isEqualTo(DEFAULT_ACTIVE_YN);
    }

    @Test
    @Transactional
    void fullUpdateTenderObjectStoreWithPatch() throws Exception {
        // Initialize the database
        tenderObjectStoreRepository.saveAndFlush(tenderObjectStore);

        int databaseSizeBeforeUpdate = tenderObjectStoreRepository.findAll().size();

        // Update the tenderObjectStore using partial update
        TenderObjectStore partialUpdatedTenderObjectStore = new TenderObjectStore();
        partialUpdatedTenderObjectStore.setId(tenderObjectStore.getId());

        partialUpdatedTenderObjectStore.referenceId(UPDATED_REFERENCE_ID).referenceType(UPDATED_REFERENCE_TYPE).activeYn(UPDATED_ACTIVE_YN);

        restTenderObjectStoreMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderObjectStore.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderObjectStore))
            )
            .andExpect(status().isOk());

        // Validate the TenderObjectStore in the database
        List<TenderObjectStore> tenderObjectStoreList = tenderObjectStoreRepository.findAll();
        assertThat(tenderObjectStoreList).hasSize(databaseSizeBeforeUpdate);
        TenderObjectStore testTenderObjectStore = tenderObjectStoreList.get(tenderObjectStoreList.size() - 1);
        assertThat(testTenderObjectStore.getReferenceId()).isEqualTo(UPDATED_REFERENCE_ID);
        assertThat(testTenderObjectStore.getReferenceType()).isEqualTo(UPDATED_REFERENCE_TYPE);
        assertThat(testTenderObjectStore.getActiveYn()).isEqualTo(UPDATED_ACTIVE_YN);
    }

    @Test
    @Transactional
    void patchNonExistingTenderObjectStore() throws Exception {
        int databaseSizeBeforeUpdate = tenderObjectStoreRepository.findAll().size();
        tenderObjectStore.setId(count.incrementAndGet());

        // Create the TenderObjectStore
        TenderObjectStoreDTO tenderObjectStoreDTO = tenderObjectStoreMapper.toDto(tenderObjectStore);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderObjectStoreMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, tenderObjectStoreDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderObjectStoreDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderObjectStore in the database
        List<TenderObjectStore> tenderObjectStoreList = tenderObjectStoreRepository.findAll();
        assertThat(tenderObjectStoreList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTenderObjectStore() throws Exception {
        int databaseSizeBeforeUpdate = tenderObjectStoreRepository.findAll().size();
        tenderObjectStore.setId(count.incrementAndGet());

        // Create the TenderObjectStore
        TenderObjectStoreDTO tenderObjectStoreDTO = tenderObjectStoreMapper.toDto(tenderObjectStore);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderObjectStoreMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderObjectStoreDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderObjectStore in the database
        List<TenderObjectStore> tenderObjectStoreList = tenderObjectStoreRepository.findAll();
        assertThat(tenderObjectStoreList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTenderObjectStore() throws Exception {
        int databaseSizeBeforeUpdate = tenderObjectStoreRepository.findAll().size();
        tenderObjectStore.setId(count.incrementAndGet());

        // Create the TenderObjectStore
        TenderObjectStoreDTO tenderObjectStoreDTO = tenderObjectStoreMapper.toDto(tenderObjectStore);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderObjectStoreMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderObjectStoreDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderObjectStore in the database
        List<TenderObjectStore> tenderObjectStoreList = tenderObjectStoreRepository.findAll();
        assertThat(tenderObjectStoreList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTenderObjectStore() throws Exception {
        // Initialize the database
        tenderObjectStoreRepository.saveAndFlush(tenderObjectStore);

        int databaseSizeBeforeDelete = tenderObjectStoreRepository.findAll().size();

        // Delete the tenderObjectStore
        restTenderObjectStoreMockMvc
            .perform(delete(ENTITY_API_URL_ID, tenderObjectStore.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<TenderObjectStore> tenderObjectStoreList = tenderObjectStoreRepository.findAll();
        assertThat(tenderObjectStoreList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
