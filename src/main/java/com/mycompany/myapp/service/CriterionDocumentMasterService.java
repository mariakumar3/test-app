package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.CriterionDocumentMasterDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.CriterionDocumentMaster}.
 */
public interface CriterionDocumentMasterService {
    /**
     * Save a criterionDocumentMaster.
     *
     * @param criterionDocumentMasterDTO the entity to save.
     * @return the persisted entity.
     */
    CriterionDocumentMasterDTO save(CriterionDocumentMasterDTO criterionDocumentMasterDTO);

    /**
     * Partially updates a criterionDocumentMaster.
     *
     * @param criterionDocumentMasterDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CriterionDocumentMasterDTO> partialUpdate(CriterionDocumentMasterDTO criterionDocumentMasterDTO);

    /**
     * Get all the criterionDocumentMasters.
     *
     * @return the list of entities.
     */
    List<CriterionDocumentMasterDTO> findAll();

    /**
     * Get the "id" criterionDocumentMaster.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CriterionDocumentMasterDTO> findOne(Long id);

    /**
     * Delete the "id" criterionDocumentMaster.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
