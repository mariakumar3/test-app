package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.TenderGoodsGroupDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.TenderGoodsGroup}.
 */
public interface TenderGoodsGroupService {
    /**
     * Save a tenderGoodsGroup.
     *
     * @param tenderGoodsGroupDTO the entity to save.
     * @return the persisted entity.
     */
    TenderGoodsGroupDTO save(TenderGoodsGroupDTO tenderGoodsGroupDTO);

    /**
     * Partially updates a tenderGoodsGroup.
     *
     * @param tenderGoodsGroupDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TenderGoodsGroupDTO> partialUpdate(TenderGoodsGroupDTO tenderGoodsGroupDTO);

    /**
     * Get all the tenderGoodsGroups.
     *
     * @return the list of entities.
     */
    List<TenderGoodsGroupDTO> findAll();

    /**
     * Get the "id" tenderGoodsGroup.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TenderGoodsGroupDTO> findOne(Long id);

    /**
     * Delete the "id" tenderGoodsGroup.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
