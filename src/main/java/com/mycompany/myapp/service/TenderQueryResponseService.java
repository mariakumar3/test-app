package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.TenderQueryResponseDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.TenderQueryResponse}.
 */
public interface TenderQueryResponseService {
    /**
     * Save a tenderQueryResponse.
     *
     * @param tenderQueryResponseDTO the entity to save.
     * @return the persisted entity.
     */
    TenderQueryResponseDTO save(TenderQueryResponseDTO tenderQueryResponseDTO);

    /**
     * Partially updates a tenderQueryResponse.
     *
     * @param tenderQueryResponseDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TenderQueryResponseDTO> partialUpdate(TenderQueryResponseDTO tenderQueryResponseDTO);

    /**
     * Get all the tenderQueryResponses.
     *
     * @return the list of entities.
     */
    List<TenderQueryResponseDTO> findAll();

    /**
     * Get the "id" tenderQueryResponse.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TenderQueryResponseDTO> findOne(Long id);

    /**
     * Delete the "id" tenderQueryResponse.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
