package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.TenderGoodsGroup;
import com.mycompany.myapp.repository.TenderGoodsGroupRepository;
import com.mycompany.myapp.service.dto.TenderGoodsGroupDTO;
import com.mycompany.myapp.service.mapper.TenderGoodsGroupMapper;
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
 * Integration tests for the {@link TenderGoodsGroupResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TenderGoodsGroupResourceIT {

    private static final String DEFAULT_GROUP_NAME = "AAAAAAAAAA";
    private static final String UPDATED_GROUP_NAME = "BBBBBBBBBB";

    private static final Boolean DEFAULT_BID_ITEMS_MANDATORY_YN = false;
    private static final Boolean UPDATED_BID_ITEMS_MANDATORY_YN = true;

    private static final Boolean DEFAULT_GROUP_MANDATORY_YN = false;
    private static final Boolean UPDATED_GROUP_MANDATORY_YN = true;

    private static final String ENTITY_API_URL = "/api/tender-goods-groups";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private TenderGoodsGroupRepository tenderGoodsGroupRepository;

    @Autowired
    private TenderGoodsGroupMapper tenderGoodsGroupMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTenderGoodsGroupMockMvc;

    private TenderGoodsGroup tenderGoodsGroup;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderGoodsGroup createEntity(EntityManager em) {
        TenderGoodsGroup tenderGoodsGroup = new TenderGoodsGroup()
            .groupName(DEFAULT_GROUP_NAME)
            .bidItemsMandatoryYn(DEFAULT_BID_ITEMS_MANDATORY_YN)
            .groupMandatoryYn(DEFAULT_GROUP_MANDATORY_YN);
        return tenderGoodsGroup;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderGoodsGroup createUpdatedEntity(EntityManager em) {
        TenderGoodsGroup tenderGoodsGroup = new TenderGoodsGroup()
            .groupName(UPDATED_GROUP_NAME)
            .bidItemsMandatoryYn(UPDATED_BID_ITEMS_MANDATORY_YN)
            .groupMandatoryYn(UPDATED_GROUP_MANDATORY_YN);
        return tenderGoodsGroup;
    }

    @BeforeEach
    public void initTest() {
        tenderGoodsGroup = createEntity(em);
    }

    @Test
    @Transactional
    void createTenderGoodsGroup() throws Exception {
        int databaseSizeBeforeCreate = tenderGoodsGroupRepository.findAll().size();
        // Create the TenderGoodsGroup
        TenderGoodsGroupDTO tenderGoodsGroupDTO = tenderGoodsGroupMapper.toDto(tenderGoodsGroup);
        restTenderGoodsGroupMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderGoodsGroupDTO))
            )
            .andExpect(status().isCreated());

        // Validate the TenderGoodsGroup in the database
        List<TenderGoodsGroup> tenderGoodsGroupList = tenderGoodsGroupRepository.findAll();
        assertThat(tenderGoodsGroupList).hasSize(databaseSizeBeforeCreate + 1);
        TenderGoodsGroup testTenderGoodsGroup = tenderGoodsGroupList.get(tenderGoodsGroupList.size() - 1);
        assertThat(testTenderGoodsGroup.getGroupName()).isEqualTo(DEFAULT_GROUP_NAME);
        assertThat(testTenderGoodsGroup.getBidItemsMandatoryYn()).isEqualTo(DEFAULT_BID_ITEMS_MANDATORY_YN);
        assertThat(testTenderGoodsGroup.getGroupMandatoryYn()).isEqualTo(DEFAULT_GROUP_MANDATORY_YN);
    }

    @Test
    @Transactional
    void createTenderGoodsGroupWithExistingId() throws Exception {
        // Create the TenderGoodsGroup with an existing ID
        tenderGoodsGroup.setId(1L);
        TenderGoodsGroupDTO tenderGoodsGroupDTO = tenderGoodsGroupMapper.toDto(tenderGoodsGroup);

        int databaseSizeBeforeCreate = tenderGoodsGroupRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTenderGoodsGroupMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderGoodsGroupDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderGoodsGroup in the database
        List<TenderGoodsGroup> tenderGoodsGroupList = tenderGoodsGroupRepository.findAll();
        assertThat(tenderGoodsGroupList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllTenderGoodsGroups() throws Exception {
        // Initialize the database
        tenderGoodsGroupRepository.saveAndFlush(tenderGoodsGroup);

        // Get all the tenderGoodsGroupList
        restTenderGoodsGroupMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tenderGoodsGroup.getId().intValue())))
            .andExpect(jsonPath("$.[*].groupName").value(hasItem(DEFAULT_GROUP_NAME)))
            .andExpect(jsonPath("$.[*].bidItemsMandatoryYn").value(hasItem(DEFAULT_BID_ITEMS_MANDATORY_YN.booleanValue())))
            .andExpect(jsonPath("$.[*].groupMandatoryYn").value(hasItem(DEFAULT_GROUP_MANDATORY_YN.booleanValue())));
    }

    @Test
    @Transactional
    void getTenderGoodsGroup() throws Exception {
        // Initialize the database
        tenderGoodsGroupRepository.saveAndFlush(tenderGoodsGroup);

        // Get the tenderGoodsGroup
        restTenderGoodsGroupMockMvc
            .perform(get(ENTITY_API_URL_ID, tenderGoodsGroup.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(tenderGoodsGroup.getId().intValue()))
            .andExpect(jsonPath("$.groupName").value(DEFAULT_GROUP_NAME))
            .andExpect(jsonPath("$.bidItemsMandatoryYn").value(DEFAULT_BID_ITEMS_MANDATORY_YN.booleanValue()))
            .andExpect(jsonPath("$.groupMandatoryYn").value(DEFAULT_GROUP_MANDATORY_YN.booleanValue()));
    }

    @Test
    @Transactional
    void getNonExistingTenderGoodsGroup() throws Exception {
        // Get the tenderGoodsGroup
        restTenderGoodsGroupMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewTenderGoodsGroup() throws Exception {
        // Initialize the database
        tenderGoodsGroupRepository.saveAndFlush(tenderGoodsGroup);

        int databaseSizeBeforeUpdate = tenderGoodsGroupRepository.findAll().size();

        // Update the tenderGoodsGroup
        TenderGoodsGroup updatedTenderGoodsGroup = tenderGoodsGroupRepository.findById(tenderGoodsGroup.getId()).get();
        // Disconnect from session so that the updates on updatedTenderGoodsGroup are not directly saved in db
        em.detach(updatedTenderGoodsGroup);
        updatedTenderGoodsGroup
            .groupName(UPDATED_GROUP_NAME)
            .bidItemsMandatoryYn(UPDATED_BID_ITEMS_MANDATORY_YN)
            .groupMandatoryYn(UPDATED_GROUP_MANDATORY_YN);
        TenderGoodsGroupDTO tenderGoodsGroupDTO = tenderGoodsGroupMapper.toDto(updatedTenderGoodsGroup);

        restTenderGoodsGroupMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderGoodsGroupDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderGoodsGroupDTO))
            )
            .andExpect(status().isOk());

        // Validate the TenderGoodsGroup in the database
        List<TenderGoodsGroup> tenderGoodsGroupList = tenderGoodsGroupRepository.findAll();
        assertThat(tenderGoodsGroupList).hasSize(databaseSizeBeforeUpdate);
        TenderGoodsGroup testTenderGoodsGroup = tenderGoodsGroupList.get(tenderGoodsGroupList.size() - 1);
        assertThat(testTenderGoodsGroup.getGroupName()).isEqualTo(UPDATED_GROUP_NAME);
        assertThat(testTenderGoodsGroup.getBidItemsMandatoryYn()).isEqualTo(UPDATED_BID_ITEMS_MANDATORY_YN);
        assertThat(testTenderGoodsGroup.getGroupMandatoryYn()).isEqualTo(UPDATED_GROUP_MANDATORY_YN);
    }

    @Test
    @Transactional
    void putNonExistingTenderGoodsGroup() throws Exception {
        int databaseSizeBeforeUpdate = tenderGoodsGroupRepository.findAll().size();
        tenderGoodsGroup.setId(count.incrementAndGet());

        // Create the TenderGoodsGroup
        TenderGoodsGroupDTO tenderGoodsGroupDTO = tenderGoodsGroupMapper.toDto(tenderGoodsGroup);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderGoodsGroupMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderGoodsGroupDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderGoodsGroupDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderGoodsGroup in the database
        List<TenderGoodsGroup> tenderGoodsGroupList = tenderGoodsGroupRepository.findAll();
        assertThat(tenderGoodsGroupList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTenderGoodsGroup() throws Exception {
        int databaseSizeBeforeUpdate = tenderGoodsGroupRepository.findAll().size();
        tenderGoodsGroup.setId(count.incrementAndGet());

        // Create the TenderGoodsGroup
        TenderGoodsGroupDTO tenderGoodsGroupDTO = tenderGoodsGroupMapper.toDto(tenderGoodsGroup);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderGoodsGroupMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderGoodsGroupDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderGoodsGroup in the database
        List<TenderGoodsGroup> tenderGoodsGroupList = tenderGoodsGroupRepository.findAll();
        assertThat(tenderGoodsGroupList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTenderGoodsGroup() throws Exception {
        int databaseSizeBeforeUpdate = tenderGoodsGroupRepository.findAll().size();
        tenderGoodsGroup.setId(count.incrementAndGet());

        // Create the TenderGoodsGroup
        TenderGoodsGroupDTO tenderGoodsGroupDTO = tenderGoodsGroupMapper.toDto(tenderGoodsGroup);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderGoodsGroupMockMvc
            .perform(
                put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(tenderGoodsGroupDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderGoodsGroup in the database
        List<TenderGoodsGroup> tenderGoodsGroupList = tenderGoodsGroupRepository.findAll();
        assertThat(tenderGoodsGroupList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTenderGoodsGroupWithPatch() throws Exception {
        // Initialize the database
        tenderGoodsGroupRepository.saveAndFlush(tenderGoodsGroup);

        int databaseSizeBeforeUpdate = tenderGoodsGroupRepository.findAll().size();

        // Update the tenderGoodsGroup using partial update
        TenderGoodsGroup partialUpdatedTenderGoodsGroup = new TenderGoodsGroup();
        partialUpdatedTenderGoodsGroup.setId(tenderGoodsGroup.getId());

        partialUpdatedTenderGoodsGroup
            .groupName(UPDATED_GROUP_NAME)
            .bidItemsMandatoryYn(UPDATED_BID_ITEMS_MANDATORY_YN)
            .groupMandatoryYn(UPDATED_GROUP_MANDATORY_YN);

        restTenderGoodsGroupMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderGoodsGroup.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderGoodsGroup))
            )
            .andExpect(status().isOk());

        // Validate the TenderGoodsGroup in the database
        List<TenderGoodsGroup> tenderGoodsGroupList = tenderGoodsGroupRepository.findAll();
        assertThat(tenderGoodsGroupList).hasSize(databaseSizeBeforeUpdate);
        TenderGoodsGroup testTenderGoodsGroup = tenderGoodsGroupList.get(tenderGoodsGroupList.size() - 1);
        assertThat(testTenderGoodsGroup.getGroupName()).isEqualTo(UPDATED_GROUP_NAME);
        assertThat(testTenderGoodsGroup.getBidItemsMandatoryYn()).isEqualTo(UPDATED_BID_ITEMS_MANDATORY_YN);
        assertThat(testTenderGoodsGroup.getGroupMandatoryYn()).isEqualTo(UPDATED_GROUP_MANDATORY_YN);
    }

    @Test
    @Transactional
    void fullUpdateTenderGoodsGroupWithPatch() throws Exception {
        // Initialize the database
        tenderGoodsGroupRepository.saveAndFlush(tenderGoodsGroup);

        int databaseSizeBeforeUpdate = tenderGoodsGroupRepository.findAll().size();

        // Update the tenderGoodsGroup using partial update
        TenderGoodsGroup partialUpdatedTenderGoodsGroup = new TenderGoodsGroup();
        partialUpdatedTenderGoodsGroup.setId(tenderGoodsGroup.getId());

        partialUpdatedTenderGoodsGroup
            .groupName(UPDATED_GROUP_NAME)
            .bidItemsMandatoryYn(UPDATED_BID_ITEMS_MANDATORY_YN)
            .groupMandatoryYn(UPDATED_GROUP_MANDATORY_YN);

        restTenderGoodsGroupMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderGoodsGroup.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderGoodsGroup))
            )
            .andExpect(status().isOk());

        // Validate the TenderGoodsGroup in the database
        List<TenderGoodsGroup> tenderGoodsGroupList = tenderGoodsGroupRepository.findAll();
        assertThat(tenderGoodsGroupList).hasSize(databaseSizeBeforeUpdate);
        TenderGoodsGroup testTenderGoodsGroup = tenderGoodsGroupList.get(tenderGoodsGroupList.size() - 1);
        assertThat(testTenderGoodsGroup.getGroupName()).isEqualTo(UPDATED_GROUP_NAME);
        assertThat(testTenderGoodsGroup.getBidItemsMandatoryYn()).isEqualTo(UPDATED_BID_ITEMS_MANDATORY_YN);
        assertThat(testTenderGoodsGroup.getGroupMandatoryYn()).isEqualTo(UPDATED_GROUP_MANDATORY_YN);
    }

    @Test
    @Transactional
    void patchNonExistingTenderGoodsGroup() throws Exception {
        int databaseSizeBeforeUpdate = tenderGoodsGroupRepository.findAll().size();
        tenderGoodsGroup.setId(count.incrementAndGet());

        // Create the TenderGoodsGroup
        TenderGoodsGroupDTO tenderGoodsGroupDTO = tenderGoodsGroupMapper.toDto(tenderGoodsGroup);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderGoodsGroupMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, tenderGoodsGroupDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderGoodsGroupDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderGoodsGroup in the database
        List<TenderGoodsGroup> tenderGoodsGroupList = tenderGoodsGroupRepository.findAll();
        assertThat(tenderGoodsGroupList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTenderGoodsGroup() throws Exception {
        int databaseSizeBeforeUpdate = tenderGoodsGroupRepository.findAll().size();
        tenderGoodsGroup.setId(count.incrementAndGet());

        // Create the TenderGoodsGroup
        TenderGoodsGroupDTO tenderGoodsGroupDTO = tenderGoodsGroupMapper.toDto(tenderGoodsGroup);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderGoodsGroupMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderGoodsGroupDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderGoodsGroup in the database
        List<TenderGoodsGroup> tenderGoodsGroupList = tenderGoodsGroupRepository.findAll();
        assertThat(tenderGoodsGroupList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTenderGoodsGroup() throws Exception {
        int databaseSizeBeforeUpdate = tenderGoodsGroupRepository.findAll().size();
        tenderGoodsGroup.setId(count.incrementAndGet());

        // Create the TenderGoodsGroup
        TenderGoodsGroupDTO tenderGoodsGroupDTO = tenderGoodsGroupMapper.toDto(tenderGoodsGroup);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderGoodsGroupMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderGoodsGroupDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderGoodsGroup in the database
        List<TenderGoodsGroup> tenderGoodsGroupList = tenderGoodsGroupRepository.findAll();
        assertThat(tenderGoodsGroupList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTenderGoodsGroup() throws Exception {
        // Initialize the database
        tenderGoodsGroupRepository.saveAndFlush(tenderGoodsGroup);

        int databaseSizeBeforeDelete = tenderGoodsGroupRepository.findAll().size();

        // Delete the tenderGoodsGroup
        restTenderGoodsGroupMockMvc
            .perform(delete(ENTITY_API_URL_ID, tenderGoodsGroup.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<TenderGoodsGroup> tenderGoodsGroupList = tenderGoodsGroupRepository.findAll();
        assertThat(tenderGoodsGroupList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
