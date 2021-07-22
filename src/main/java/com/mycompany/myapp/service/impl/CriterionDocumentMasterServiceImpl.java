package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.CriterionDocumentMaster;
import com.mycompany.myapp.repository.CriterionDocumentMasterRepository;
import com.mycompany.myapp.service.CriterionDocumentMasterService;
import com.mycompany.myapp.service.dto.CriterionDocumentMasterDTO;
import com.mycompany.myapp.service.mapper.CriterionDocumentMasterMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CriterionDocumentMaster}.
 */
@Service
@Transactional
public class CriterionDocumentMasterServiceImpl implements CriterionDocumentMasterService {

    private final Logger log = LoggerFactory.getLogger(CriterionDocumentMasterServiceImpl.class);

    private final CriterionDocumentMasterRepository criterionDocumentMasterRepository;

    private final CriterionDocumentMasterMapper criterionDocumentMasterMapper;

    public CriterionDocumentMasterServiceImpl(
        CriterionDocumentMasterRepository criterionDocumentMasterRepository,
        CriterionDocumentMasterMapper criterionDocumentMasterMapper
    ) {
        this.criterionDocumentMasterRepository = criterionDocumentMasterRepository;
        this.criterionDocumentMasterMapper = criterionDocumentMasterMapper;
    }

    @Override
    public CriterionDocumentMasterDTO save(CriterionDocumentMasterDTO criterionDocumentMasterDTO) {
        log.debug("Request to save CriterionDocumentMaster : {}", criterionDocumentMasterDTO);
        CriterionDocumentMaster criterionDocumentMaster = criterionDocumentMasterMapper.toEntity(criterionDocumentMasterDTO);
        criterionDocumentMaster = criterionDocumentMasterRepository.save(criterionDocumentMaster);
        return criterionDocumentMasterMapper.toDto(criterionDocumentMaster);
    }

    @Override
    public Optional<CriterionDocumentMasterDTO> partialUpdate(CriterionDocumentMasterDTO criterionDocumentMasterDTO) {
        log.debug("Request to partially update CriterionDocumentMaster : {}", criterionDocumentMasterDTO);

        return criterionDocumentMasterRepository
            .findById(criterionDocumentMasterDTO.getId())
            .map(
                existingCriterionDocumentMaster -> {
                    criterionDocumentMasterMapper.partialUpdate(existingCriterionDocumentMaster, criterionDocumentMasterDTO);

                    return existingCriterionDocumentMaster;
                }
            )
            .map(criterionDocumentMasterRepository::save)
            .map(criterionDocumentMasterMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CriterionDocumentMasterDTO> findAll() {
        log.debug("Request to get all CriterionDocumentMasters");
        return criterionDocumentMasterRepository
            .findAll()
            .stream()
            .map(criterionDocumentMasterMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CriterionDocumentMasterDTO> findOne(Long id) {
        log.debug("Request to get CriterionDocumentMaster : {}", id);
        return criterionDocumentMasterRepository.findById(id).map(criterionDocumentMasterMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CriterionDocumentMaster : {}", id);
        criterionDocumentMasterRepository.deleteById(id);
    }
}
