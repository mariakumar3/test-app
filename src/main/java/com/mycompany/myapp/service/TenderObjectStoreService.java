package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.TenderObjectStoreDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.TenderObjectStore}.
 */
public interface TenderObjectStoreService {
    /**
     * Save a tenderObjectStore.
     *
     * @param tenderObjectStoreDTO the entity to save.
     * @return the persisted entity.
     */
    TenderObjectStoreDTO save(TenderObjectStoreDTO tenderObjectStoreDTO);

    /**
     * Partially updates a tenderObjectStore.
     *
     * @param tenderObjectStoreDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TenderObjectStoreDTO> partialUpdate(TenderObjectStoreDTO tenderObjectStoreDTO);

    /**
     * Get all the tenderObjectStores.
     *
     * @return the list of entities.
     */
    List<TenderObjectStoreDTO> findAll();

    /**
     * Get the "id" tenderObjectStore.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TenderObjectStoreDTO> findOne(Long id);

    /**
     * Delete the "id" tenderObjectStore.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
