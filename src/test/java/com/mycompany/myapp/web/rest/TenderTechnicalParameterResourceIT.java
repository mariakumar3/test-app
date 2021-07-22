package com.mycompany.myapp.web.rest;

import static com.mycompany.myapp.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.TenderTechnicalParameter;
import com.mycompany.myapp.repository.TenderTechnicalParameterRepository;
import com.mycompany.myapp.service.dto.TenderTechnicalParameterDTO;
import com.mycompany.myapp.service.mapper.TenderTechnicalParameterMapper;
import java.math.BigDecimal;
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
 * Integration tests for the {@link TenderTechnicalParameterResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TenderTechnicalParameterResourceIT {

    private static final Long DEFAULT_TENDER_CRITERION_ID = 1L;
    private static final Long UPDATED_TENDER_CRITERION_ID = 2L;

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_MIN_VALUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_MIN_VALUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MAX_VALUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_MAX_VALUE = new BigDecimal(2);

    private static final String DEFAULT_OPERATOR = "AAAAAAAAAA";
    private static final String UPDATED_OPERATOR = "BBBBBBBBBB";

    private static final String DEFAULT_DATA_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_DATA_TYPE = "BBBBBBBBBB";

    private static final Boolean DEFAULT_OPTIONAL_YN = false;
    private static final Boolean UPDATED_OPTIONAL_YN = true;

    private static final String ENTITY_API_URL = "/api/tender-technical-parameters";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private TenderTechnicalParameterRepository tenderTechnicalParameterRepository;

    @Autowired
    private TenderTechnicalParameterMapper tenderTechnicalParameterMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTenderTechnicalParameterMockMvc;

    private TenderTechnicalParameter tenderTechnicalParameter;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderTechnicalParameter createEntity(EntityManager em) {
        TenderTechnicalParameter tenderTechnicalParameter = new TenderTechnicalParameter()
            .tenderCriterionId(DEFAULT_TENDER_CRITERION_ID)
            .name(DEFAULT_NAME)
            .description(DEFAULT_DESCRIPTION)
            .minValue(DEFAULT_MIN_VALUE)
            .maxValue(DEFAULT_MAX_VALUE)
            .operator(DEFAULT_OPERATOR)
            .dataType(DEFAULT_DATA_TYPE)
            .optionalYn(DEFAULT_OPTIONAL_YN);
        return tenderTechnicalParameter;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TenderTechnicalParameter createUpdatedEntity(EntityManager em) {
        TenderTechnicalParameter tenderTechnicalParameter = new TenderTechnicalParameter()
            .tenderCriterionId(UPDATED_TENDER_CRITERION_ID)
            .name(UPDATED_NAME)
            .description(UPDATED_DESCRIPTION)
            .minValue(UPDATED_MIN_VALUE)
            .maxValue(UPDATED_MAX_VALUE)
            .operator(UPDATED_OPERATOR)
            .dataType(UPDATED_DATA_TYPE)
            .optionalYn(UPDATED_OPTIONAL_YN);
        return tenderTechnicalParameter;
    }

    @BeforeEach
    public void initTest() {
        tenderTechnicalParameter = createEntity(em);
    }

    @Test
    @Transactional
    void createTenderTechnicalParameter() throws Exception {
        int databaseSizeBeforeCreate = tenderTechnicalParameterRepository.findAll().size();
        // Create the TenderTechnicalParameter
        TenderTechnicalParameterDTO tenderTechnicalParameterDTO = tenderTechnicalParameterMapper.toDto(tenderTechnicalParameter);
        restTenderTechnicalParameterMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderTechnicalParameterDTO))
            )
            .andExpect(status().isCreated());

        // Validate the TenderTechnicalParameter in the database
        List<TenderTechnicalParameter> tenderTechnicalParameterList = tenderTechnicalParameterRepository.findAll();
        assertThat(tenderTechnicalParameterList).hasSize(databaseSizeBeforeCreate + 1);
        TenderTechnicalParameter testTenderTechnicalParameter = tenderTechnicalParameterList.get(tenderTechnicalParameterList.size() - 1);
        assertThat(testTenderTechnicalParameter.getTenderCriterionId()).isEqualTo(DEFAULT_TENDER_CRITERION_ID);
        assertThat(testTenderTechnicalParameter.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testTenderTechnicalParameter.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testTenderTechnicalParameter.getMinValue()).isEqualByComparingTo(DEFAULT_MIN_VALUE);
        assertThat(testTenderTechnicalParameter.getMaxValue()).isEqualByComparingTo(DEFAULT_MAX_VALUE);
        assertThat(testTenderTechnicalParameter.getOperator()).isEqualTo(DEFAULT_OPERATOR);
        assertThat(testTenderTechnicalParameter.getDataType()).isEqualTo(DEFAULT_DATA_TYPE);
        assertThat(testTenderTechnicalParameter.getOptionalYn()).isEqualTo(DEFAULT_OPTIONAL_YN);
    }

    @Test
    @Transactional
    void createTenderTechnicalParameterWithExistingId() throws Exception {
        // Create the TenderTechnicalParameter with an existing ID
        tenderTechnicalParameter.setId(1L);
        TenderTechnicalParameterDTO tenderTechnicalParameterDTO = tenderTechnicalParameterMapper.toDto(tenderTechnicalParameter);

        int databaseSizeBeforeCreate = tenderTechnicalParameterRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTenderTechnicalParameterMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderTechnicalParameterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderTechnicalParameter in the database
        List<TenderTechnicalParameter> tenderTechnicalParameterList = tenderTechnicalParameterRepository.findAll();
        assertThat(tenderTechnicalParameterList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllTenderTechnicalParameters() throws Exception {
        // Initialize the database
        tenderTechnicalParameterRepository.saveAndFlush(tenderTechnicalParameter);

        // Get all the tenderTechnicalParameterList
        restTenderTechnicalParameterMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tenderTechnicalParameter.getId().intValue())))
            .andExpect(jsonPath("$.[*].tenderCriterionId").value(hasItem(DEFAULT_TENDER_CRITERION_ID.intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].minValue").value(hasItem(sameNumber(DEFAULT_MIN_VALUE))))
            .andExpect(jsonPath("$.[*].maxValue").value(hasItem(sameNumber(DEFAULT_MAX_VALUE))))
            .andExpect(jsonPath("$.[*].operator").value(hasItem(DEFAULT_OPERATOR)))
            .andExpect(jsonPath("$.[*].dataType").value(hasItem(DEFAULT_DATA_TYPE)))
            .andExpect(jsonPath("$.[*].optionalYn").value(hasItem(DEFAULT_OPTIONAL_YN.booleanValue())));
    }

    @Test
    @Transactional
    void getTenderTechnicalParameter() throws Exception {
        // Initialize the database
        tenderTechnicalParameterRepository.saveAndFlush(tenderTechnicalParameter);

        // Get the tenderTechnicalParameter
        restTenderTechnicalParameterMockMvc
            .perform(get(ENTITY_API_URL_ID, tenderTechnicalParameter.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(tenderTechnicalParameter.getId().intValue()))
            .andExpect(jsonPath("$.tenderCriterionId").value(DEFAULT_TENDER_CRITERION_ID.intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.minValue").value(sameNumber(DEFAULT_MIN_VALUE)))
            .andExpect(jsonPath("$.maxValue").value(sameNumber(DEFAULT_MAX_VALUE)))
            .andExpect(jsonPath("$.operator").value(DEFAULT_OPERATOR))
            .andExpect(jsonPath("$.dataType").value(DEFAULT_DATA_TYPE))
            .andExpect(jsonPath("$.optionalYn").value(DEFAULT_OPTIONAL_YN.booleanValue()));
    }

    @Test
    @Transactional
    void getNonExistingTenderTechnicalParameter() throws Exception {
        // Get the tenderTechnicalParameter
        restTenderTechnicalParameterMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewTenderTechnicalParameter() throws Exception {
        // Initialize the database
        tenderTechnicalParameterRepository.saveAndFlush(tenderTechnicalParameter);

        int databaseSizeBeforeUpdate = tenderTechnicalParameterRepository.findAll().size();

        // Update the tenderTechnicalParameter
        TenderTechnicalParameter updatedTenderTechnicalParameter = tenderTechnicalParameterRepository
            .findById(tenderTechnicalParameter.getId())
            .get();
        // Disconnect from session so that the updates on updatedTenderTechnicalParameter are not directly saved in db
        em.detach(updatedTenderTechnicalParameter);
        updatedTenderTechnicalParameter
            .tenderCriterionId(UPDATED_TENDER_CRITERION_ID)
            .name(UPDATED_NAME)
            .description(UPDATED_DESCRIPTION)
            .minValue(UPDATED_MIN_VALUE)
            .maxValue(UPDATED_MAX_VALUE)
            .operator(UPDATED_OPERATOR)
            .dataType(UPDATED_DATA_TYPE)
            .optionalYn(UPDATED_OPTIONAL_YN);
        TenderTechnicalParameterDTO tenderTechnicalParameterDTO = tenderTechnicalParameterMapper.toDto(updatedTenderTechnicalParameter);

        restTenderTechnicalParameterMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderTechnicalParameterDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderTechnicalParameterDTO))
            )
            .andExpect(status().isOk());

        // Validate the TenderTechnicalParameter in the database
        List<TenderTechnicalParameter> tenderTechnicalParameterList = tenderTechnicalParameterRepository.findAll();
        assertThat(tenderTechnicalParameterList).hasSize(databaseSizeBeforeUpdate);
        TenderTechnicalParameter testTenderTechnicalParameter = tenderTechnicalParameterList.get(tenderTechnicalParameterList.size() - 1);
        assertThat(testTenderTechnicalParameter.getTenderCriterionId()).isEqualTo(UPDATED_TENDER_CRITERION_ID);
        assertThat(testTenderTechnicalParameter.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testTenderTechnicalParameter.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testTenderTechnicalParameter.getMinValue()).isEqualTo(UPDATED_MIN_VALUE);
        assertThat(testTenderTechnicalParameter.getMaxValue()).isEqualTo(UPDATED_MAX_VALUE);
        assertThat(testTenderTechnicalParameter.getOperator()).isEqualTo(UPDATED_OPERATOR);
        assertThat(testTenderTechnicalParameter.getDataType()).isEqualTo(UPDATED_DATA_TYPE);
        assertThat(testTenderTechnicalParameter.getOptionalYn()).isEqualTo(UPDATED_OPTIONAL_YN);
    }

    @Test
    @Transactional
    void putNonExistingTenderTechnicalParameter() throws Exception {
        int databaseSizeBeforeUpdate = tenderTechnicalParameterRepository.findAll().size();
        tenderTechnicalParameter.setId(count.incrementAndGet());

        // Create the TenderTechnicalParameter
        TenderTechnicalParameterDTO tenderTechnicalParameterDTO = tenderTechnicalParameterMapper.toDto(tenderTechnicalParameter);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderTechnicalParameterMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tenderTechnicalParameterDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderTechnicalParameterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderTechnicalParameter in the database
        List<TenderTechnicalParameter> tenderTechnicalParameterList = tenderTechnicalParameterRepository.findAll();
        assertThat(tenderTechnicalParameterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTenderTechnicalParameter() throws Exception {
        int databaseSizeBeforeUpdate = tenderTechnicalParameterRepository.findAll().size();
        tenderTechnicalParameter.setId(count.incrementAndGet());

        // Create the TenderTechnicalParameter
        TenderTechnicalParameterDTO tenderTechnicalParameterDTO = tenderTechnicalParameterMapper.toDto(tenderTechnicalParameter);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderTechnicalParameterMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderTechnicalParameterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderTechnicalParameter in the database
        List<TenderTechnicalParameter> tenderTechnicalParameterList = tenderTechnicalParameterRepository.findAll();
        assertThat(tenderTechnicalParameterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTenderTechnicalParameter() throws Exception {
        int databaseSizeBeforeUpdate = tenderTechnicalParameterRepository.findAll().size();
        tenderTechnicalParameter.setId(count.incrementAndGet());

        // Create the TenderTechnicalParameter
        TenderTechnicalParameterDTO tenderTechnicalParameterDTO = tenderTechnicalParameterMapper.toDto(tenderTechnicalParameter);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderTechnicalParameterMockMvc
            .perform(
                put(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(tenderTechnicalParameterDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderTechnicalParameter in the database
        List<TenderTechnicalParameter> tenderTechnicalParameterList = tenderTechnicalParameterRepository.findAll();
        assertThat(tenderTechnicalParameterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTenderTechnicalParameterWithPatch() throws Exception {
        // Initialize the database
        tenderTechnicalParameterRepository.saveAndFlush(tenderTechnicalParameter);

        int databaseSizeBeforeUpdate = tenderTechnicalParameterRepository.findAll().size();

        // Update the tenderTechnicalParameter using partial update
        TenderTechnicalParameter partialUpdatedTenderTechnicalParameter = new TenderTechnicalParameter();
        partialUpdatedTenderTechnicalParameter.setId(tenderTechnicalParameter.getId());

        partialUpdatedTenderTechnicalParameter
            .name(UPDATED_NAME)
            .description(UPDATED_DESCRIPTION)
            .minValue(UPDATED_MIN_VALUE)
            .maxValue(UPDATED_MAX_VALUE)
            .operator(UPDATED_OPERATOR);

        restTenderTechnicalParameterMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderTechnicalParameter.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderTechnicalParameter))
            )
            .andExpect(status().isOk());

        // Validate the TenderTechnicalParameter in the database
        List<TenderTechnicalParameter> tenderTechnicalParameterList = tenderTechnicalParameterRepository.findAll();
        assertThat(tenderTechnicalParameterList).hasSize(databaseSizeBeforeUpdate);
        TenderTechnicalParameter testTenderTechnicalParameter = tenderTechnicalParameterList.get(tenderTechnicalParameterList.size() - 1);
        assertThat(testTenderTechnicalParameter.getTenderCriterionId()).isEqualTo(DEFAULT_TENDER_CRITERION_ID);
        assertThat(testTenderTechnicalParameter.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testTenderTechnicalParameter.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testTenderTechnicalParameter.getMinValue()).isEqualByComparingTo(UPDATED_MIN_VALUE);
        assertThat(testTenderTechnicalParameter.getMaxValue()).isEqualByComparingTo(UPDATED_MAX_VALUE);
        assertThat(testTenderTechnicalParameter.getOperator()).isEqualTo(UPDATED_OPERATOR);
        assertThat(testTenderTechnicalParameter.getDataType()).isEqualTo(DEFAULT_DATA_TYPE);
        assertThat(testTenderTechnicalParameter.getOptionalYn()).isEqualTo(DEFAULT_OPTIONAL_YN);
    }

    @Test
    @Transactional
    void fullUpdateTenderTechnicalParameterWithPatch() throws Exception {
        // Initialize the database
        tenderTechnicalParameterRepository.saveAndFlush(tenderTechnicalParameter);

        int databaseSizeBeforeUpdate = tenderTechnicalParameterRepository.findAll().size();

        // Update the tenderTechnicalParameter using partial update
        TenderTechnicalParameter partialUpdatedTenderTechnicalParameter = new TenderTechnicalParameter();
        partialUpdatedTenderTechnicalParameter.setId(tenderTechnicalParameter.getId());

        partialUpdatedTenderTechnicalParameter
            .tenderCriterionId(UPDATED_TENDER_CRITERION_ID)
            .name(UPDATED_NAME)
            .description(UPDATED_DESCRIPTION)
            .minValue(UPDATED_MIN_VALUE)
            .maxValue(UPDATED_MAX_VALUE)
            .operator(UPDATED_OPERATOR)
            .dataType(UPDATED_DATA_TYPE)
            .optionalYn(UPDATED_OPTIONAL_YN);

        restTenderTechnicalParameterMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTenderTechnicalParameter.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTenderTechnicalParameter))
            )
            .andExpect(status().isOk());

        // Validate the TenderTechnicalParameter in the database
        List<TenderTechnicalParameter> tenderTechnicalParameterList = tenderTechnicalParameterRepository.findAll();
        assertThat(tenderTechnicalParameterList).hasSize(databaseSizeBeforeUpdate);
        TenderTechnicalParameter testTenderTechnicalParameter = tenderTechnicalParameterList.get(tenderTechnicalParameterList.size() - 1);
        assertThat(testTenderTechnicalParameter.getTenderCriterionId()).isEqualTo(UPDATED_TENDER_CRITERION_ID);
        assertThat(testTenderTechnicalParameter.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testTenderTechnicalParameter.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testTenderTechnicalParameter.getMinValue()).isEqualByComparingTo(UPDATED_MIN_VALUE);
        assertThat(testTenderTechnicalParameter.getMaxValue()).isEqualByComparingTo(UPDATED_MAX_VALUE);
        assertThat(testTenderTechnicalParameter.getOperator()).isEqualTo(UPDATED_OPERATOR);
        assertThat(testTenderTechnicalParameter.getDataType()).isEqualTo(UPDATED_DATA_TYPE);
        assertThat(testTenderTechnicalParameter.getOptionalYn()).isEqualTo(UPDATED_OPTIONAL_YN);
    }

    @Test
    @Transactional
    void patchNonExistingTenderTechnicalParameter() throws Exception {
        int databaseSizeBeforeUpdate = tenderTechnicalParameterRepository.findAll().size();
        tenderTechnicalParameter.setId(count.incrementAndGet());

        // Create the TenderTechnicalParameter
        TenderTechnicalParameterDTO tenderTechnicalParameterDTO = tenderTechnicalParameterMapper.toDto(tenderTechnicalParameter);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTenderTechnicalParameterMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, tenderTechnicalParameterDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderTechnicalParameterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderTechnicalParameter in the database
        List<TenderTechnicalParameter> tenderTechnicalParameterList = tenderTechnicalParameterRepository.findAll();
        assertThat(tenderTechnicalParameterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTenderTechnicalParameter() throws Exception {
        int databaseSizeBeforeUpdate = tenderTechnicalParameterRepository.findAll().size();
        tenderTechnicalParameter.setId(count.incrementAndGet());

        // Create the TenderTechnicalParameter
        TenderTechnicalParameterDTO tenderTechnicalParameterDTO = tenderTechnicalParameterMapper.toDto(tenderTechnicalParameter);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderTechnicalParameterMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderTechnicalParameterDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TenderTechnicalParameter in the database
        List<TenderTechnicalParameter> tenderTechnicalParameterList = tenderTechnicalParameterRepository.findAll();
        assertThat(tenderTechnicalParameterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTenderTechnicalParameter() throws Exception {
        int databaseSizeBeforeUpdate = tenderTechnicalParameterRepository.findAll().size();
        tenderTechnicalParameter.setId(count.incrementAndGet());

        // Create the TenderTechnicalParameter
        TenderTechnicalParameterDTO tenderTechnicalParameterDTO = tenderTechnicalParameterMapper.toDto(tenderTechnicalParameter);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTenderTechnicalParameterMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(tenderTechnicalParameterDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TenderTechnicalParameter in the database
        List<TenderTechnicalParameter> tenderTechnicalParameterList = tenderTechnicalParameterRepository.findAll();
        assertThat(tenderTechnicalParameterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTenderTechnicalParameter() throws Exception {
        // Initialize the database
        tenderTechnicalParameterRepository.saveAndFlush(tenderTechnicalParameter);

        int databaseSizeBeforeDelete = tenderTechnicalParameterRepository.findAll().size();

        // Delete the tenderTechnicalParameter
        restTenderTechnicalParameterMockMvc
            .perform(delete(ENTITY_API_URL_ID, tenderTechnicalParameter.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<TenderTechnicalParameter> tenderTechnicalParameterList = tenderTechnicalParameterRepository.findAll();
        assertThat(tenderTechnicalParameterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
