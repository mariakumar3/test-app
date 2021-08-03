package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.CriterionMaster;
import com.mycompany.myapp.repository.CriterionMasterRepository;
import com.mycompany.myapp.service.CriterionMasterService;
import com.mycompany.myapp.service.dto.CriterionMasterDTO;
import com.mycompany.myapp.service.mapper.CriterionMasterMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CriterionMaster}.
 */
@Service
@Transactional
public class CriterionMasterServiceImpl implements CriterionMasterService {

    private final Logger log = LoggerFactory.getLogger(CriterionMasterServiceImpl.class);

    private final CriterionMasterRepository criterionMasterRepository;

    private final CriterionMasterMapper criterionMasterMapper;

    public CriterionMasterServiceImpl(CriterionMasterRepository criterionMasterRepository, CriterionMasterMapper criterionMasterMapper) {
        this.criterionMasterRepository = criterionMasterRepository;
        this.criterionMasterMapper = criterionMasterMapper;
    }

    @Override
    public CriterionMasterDTO save(CriterionMasterDTO criterionMasterDTO) {
        log.debug("Request to save CriterionMaster : {}", criterionMasterDTO);
        CriterionMaster criterionMaster = criterionMasterMapper.toEntity(criterionMasterDTO);
        criterionMaster = criterionMasterRepository.save(criterionMaster);
        return criterionMasterMapper.toDto(criterionMaster);
    }

    @Override
    public Optional<CriterionMasterDTO> partialUpdate(CriterionMasterDTO criterionMasterDTO) {
        log.debug("Request to partially update CriterionMaster : {}", criterionMasterDTO);

        return criterionMasterRepository
            .findById(criterionMasterDTO.getId())
            .map(
                existingCriterionMaster -> {
                    criterionMasterMapper.partialUpdate(existingCriterionMaster, criterionMasterDTO);

                    return existingCriterionMaster;
                }
            )
            .map(criterionMasterRepository::save)
            .map(criterionMasterMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CriterionMasterDTO> findAll() {
        log.debug("Request to get all CriterionMasters");
        return criterionMasterRepository
            .findAll()
            .stream()
            .map(criterionMasterMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CriterionMasterDTO> findOne(Long id) {
        log.debug("Request to get CriterionMaster : {}", id);
        return criterionMasterRepository.findById(id).map(criterionMasterMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CriterionMaster : {}", id);
        criterionMasterRepository.deleteById(id);
    }
}
