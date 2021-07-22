package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.TenderObjectStore;
import com.mycompany.myapp.repository.TenderObjectStoreRepository;
import com.mycompany.myapp.service.TenderObjectStoreService;
import com.mycompany.myapp.service.dto.TenderObjectStoreDTO;
import com.mycompany.myapp.service.mapper.TenderObjectStoreMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link TenderObjectStore}.
 */
@Service
@Transactional
public class TenderObjectStoreServiceImpl implements TenderObjectStoreService {

    private final Logger log = LoggerFactory.getLogger(TenderObjectStoreServiceImpl.class);

    private final TenderObjectStoreRepository tenderObjectStoreRepository;

    private final TenderObjectStoreMapper tenderObjectStoreMapper;

    public TenderObjectStoreServiceImpl(
        TenderObjectStoreRepository tenderObjectStoreRepository,
        TenderObjectStoreMapper tenderObjectStoreMapper
    ) {
        this.tenderObjectStoreRepository = tenderObjectStoreRepository;
        this.tenderObjectStoreMapper = tenderObjectStoreMapper;
    }

    @Override
    public TenderObjectStoreDTO save(TenderObjectStoreDTO tenderObjectStoreDTO) {
        log.debug("Request to save TenderObjectStore : {}", tenderObjectStoreDTO);
        TenderObjectStore tenderObjectStore = tenderObjectStoreMapper.toEntity(tenderObjectStoreDTO);
        tenderObjectStore = tenderObjectStoreRepository.save(tenderObjectStore);
        return tenderObjectStoreMapper.toDto(tenderObjectStore);
    }

    @Override
    public Optional<TenderObjectStoreDTO> partialUpdate(TenderObjectStoreDTO tenderObjectStoreDTO) {
        log.debug("Request to partially update TenderObjectStore : {}", tenderObjectStoreDTO);

        return tenderObjectStoreRepository
            .findById(tenderObjectStoreDTO.getId())
            .map(
                existingTenderObjectStore -> {
                    tenderObjectStoreMapper.partialUpdate(existingTenderObjectStore, tenderObjectStoreDTO);

                    return existingTenderObjectStore;
                }
            )
            .map(tenderObjectStoreRepository::save)
            .map(tenderObjectStoreMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TenderObjectStoreDTO> findAll() {
        log.debug("Request to get all TenderObjectStores");
        return tenderObjectStoreRepository
            .findAll()
            .stream()
            .map(tenderObjectStoreMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TenderObjectStoreDTO> findOne(Long id) {
        log.debug("Request to get TenderObjectStore : {}", id);
        return tenderObjectStoreRepository.findById(id).map(tenderObjectStoreMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete TenderObjectStore : {}", id);
        tenderObjectStoreRepository.deleteById(id);
    }
}
