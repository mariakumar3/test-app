package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.TenderScrutinyMasterDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.TenderScrutinyMaster}.
 */
public interface TenderScrutinyMasterService {
    /**
     * Save a tenderScrutinyMaster.
     *
     * @param tenderScrutinyMasterDTO the entity to save.
     * @return the persisted entity.
     */
    TenderScrutinyMasterDTO save(TenderScrutinyMasterDTO tenderScrutinyMasterDTO);

    /**
     * Partially updates a tenderScrutinyMaster.
     *
     * @param tenderScrutinyMasterDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TenderScrutinyMasterDTO> partialUpdate(TenderScrutinyMasterDTO tenderScrutinyMasterDTO);

    /**
     * Get all the tenderScrutinyMasters.
     *
     * @return the list of entities.
     */
    List<TenderScrutinyMasterDTO> findAll();

    /**
     * Get the "id" tenderScrutinyMaster.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TenderScrutinyMasterDTO> findOne(Long id);

    /**
     * Delete the "id" tenderScrutinyMaster.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
