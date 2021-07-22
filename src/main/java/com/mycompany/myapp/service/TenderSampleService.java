package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.TenderSampleDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.TenderSample}.
 */
public interface TenderSampleService {
    /**
     * Save a tenderSample.
     *
     * @param tenderSampleDTO the entity to save.
     * @return the persisted entity.
     */
    TenderSampleDTO save(TenderSampleDTO tenderSampleDTO);

    /**
     * Partially updates a tenderSample.
     *
     * @param tenderSampleDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TenderSampleDTO> partialUpdate(TenderSampleDTO tenderSampleDTO);

    /**
     * Get all the tenderSamples.
     *
     * @return the list of entities.
     */
    List<TenderSampleDTO> findAll();

    /**
     * Get the "id" tenderSample.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TenderSampleDTO> findOne(Long id);

    /**
     * Delete the "id" tenderSample.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
