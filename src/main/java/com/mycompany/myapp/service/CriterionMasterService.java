package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.CriterionMasterDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.CriterionMaster}.
 */
public interface CriterionMasterService {
    /**
     * Save a criterionMaster.
     *
     * @param criterionMasterDTO the entity to save.
     * @return the persisted entity.
     */
    CriterionMasterDTO save(CriterionMasterDTO criterionMasterDTO);

    /**
     * Partially updates a criterionMaster.
     *
     * @param criterionMasterDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CriterionMasterDTO> partialUpdate(CriterionMasterDTO criterionMasterDTO);

    /**
     * Get all the criterionMasters.
     *
     * @return the list of entities.
     */
    List<CriterionMasterDTO> findAll();

    /**
     * Get the "id" criterionMaster.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CriterionMasterDTO> findOne(Long id);

    /**
     * Delete the "id" criterionMaster.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
