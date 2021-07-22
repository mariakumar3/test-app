package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.TenderGoodsGroup;
import com.mycompany.myapp.repository.TenderGoodsGroupRepository;
import com.mycompany.myapp.service.TenderGoodsGroupService;
import com.mycompany.myapp.service.dto.TenderGoodsGroupDTO;
import com.mycompany.myapp.service.mapper.TenderGoodsGroupMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link TenderGoodsGroup}.
 */
@Service
@Transactional
public class TenderGoodsGroupServiceImpl implements TenderGoodsGroupService {

    private final Logger log = LoggerFactory.getLogger(TenderGoodsGroupServiceImpl.class);

    private final TenderGoodsGroupRepository tenderGoodsGroupRepository;

    private final TenderGoodsGroupMapper tenderGoodsGroupMapper;

    public TenderGoodsGroupServiceImpl(
        TenderGoodsGroupRepository tenderGoodsGroupRepository,
        TenderGoodsGroupMapper tenderGoodsGroupMapper
    ) {
        this.tenderGoodsGroupRepository = tenderGoodsGroupRepository;
        this.tenderGoodsGroupMapper = tenderGoodsGroupMapper;
    }

    @Override
    public TenderGoodsGroupDTO save(TenderGoodsGroupDTO tenderGoodsGroupDTO) {
        log.debug("Request to save TenderGoodsGroup : {}", tenderGoodsGroupDTO);
        TenderGoodsGroup tenderGoodsGroup = tenderGoodsGroupMapper.toEntity(tenderGoodsGroupDTO);
        tenderGoodsGroup = tenderGoodsGroupRepository.save(tenderGoodsGroup);
        return tenderGoodsGroupMapper.toDto(tenderGoodsGroup);
    }

    @Override
    public Optional<TenderGoodsGroupDTO> partialUpdate(TenderGoodsGroupDTO tenderGoodsGroupDTO) {
        log.debug("Request to partially update TenderGoodsGroup : {}", tenderGoodsGroupDTO);

        return tenderGoodsGroupRepository
            .findById(tenderGoodsGroupDTO.getId())
            .map(
                existingTenderGoodsGroup -> {
                    tenderGoodsGroupMapper.partialUpdate(existingTenderGoodsGroup, tenderGoodsGroupDTO);

                    return existingTenderGoodsGroup;
                }
            )
            .map(tenderGoodsGroupRepository::save)
            .map(tenderGoodsGroupMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TenderGoodsGroupDTO> findAll() {
        log.debug("Request to get all TenderGoodsGroups");
        return tenderGoodsGroupRepository
            .findAll()
            .stream()
            .map(tenderGoodsGroupMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TenderGoodsGroupDTO> findOne(Long id) {
        log.debug("Request to get TenderGoodsGroup : {}", id);
        return tenderGoodsGroupRepository.findById(id).map(tenderGoodsGroupMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete TenderGoodsGroup : {}", id);
        tenderGoodsGroupRepository.deleteById(id);
    }
}
