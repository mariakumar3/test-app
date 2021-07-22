package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.TenderTechnicalParameterDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.TenderTechnicalParameter}.
 */
public interface TenderTechnicalParameterService {
    /**
     * Save a tenderTechnicalParameter.
     *
     * @param tenderTechnicalParameterDTO the entity to save.
     * @return the persisted entity.
     */
    TenderTechnicalParameterDTO save(TenderTechnicalParameterDTO tenderTechnicalParameterDTO);

    /**
     * Partially updates a tenderTechnicalParameter.
     *
     * @param tenderTechnicalParameterDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TenderTechnicalParameterDTO> partialUpdate(TenderTechnicalParameterDTO tenderTechnicalParameterDTO);

    /**
     * Get all the tenderTechnicalParameters.
     *
     * @return the list of entities.
     */
    List<TenderTechnicalParameterDTO> findAll();

    /**
     * Get the "id" tenderTechnicalParameter.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TenderTechnicalParameterDTO> findOne(Long id);

    /**
     * Delete the "id" tenderTechnicalParameter.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
