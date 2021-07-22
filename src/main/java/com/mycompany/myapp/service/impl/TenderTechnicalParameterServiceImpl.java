package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.TenderTechnicalParameter;
import com.mycompany.myapp.repository.TenderTechnicalParameterRepository;
import com.mycompany.myapp.service.TenderTechnicalParameterService;
import com.mycompany.myapp.service.dto.TenderTechnicalParameterDTO;
import com.mycompany.myapp.service.mapper.TenderTechnicalParameterMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link TenderTechnicalParameter}.
 */
@Service
@Transactional
public class TenderTechnicalParameterServiceImpl implements TenderTechnicalParameterService {

    private final Logger log = LoggerFactory.getLogger(TenderTechnicalParameterServiceImpl.class);

    private final TenderTechnicalParameterRepository tenderTechnicalParameterRepository;

    private final TenderTechnicalParameterMapper tenderTechnicalParameterMapper;

    public TenderTechnicalParameterServiceImpl(
        TenderTechnicalParameterRepository tenderTechnicalParameterRepository,
        TenderTechnicalParameterMapper tenderTechnicalParameterMapper
    ) {
        this.tenderTechnicalParameterRepository = tenderTechnicalParameterRepository;
        this.tenderTechnicalParameterMapper = tenderTechnicalParameterMapper;
    }

    @Override
    public TenderTechnicalParameterDTO save(TenderTechnicalParameterDTO tenderTechnicalParameterDTO) {
        log.debug("Request to save TenderTechnicalParameter : {}", tenderTechnicalParameterDTO);
        TenderTechnicalParameter tenderTechnicalParameter = tenderTechnicalParameterMapper.toEntity(tenderTechnicalParameterDTO);
        tenderTechnicalParameter = tenderTechnicalParameterRepository.save(tenderTechnicalParameter);
        return tenderTechnicalParameterMapper.toDto(tenderTechnicalParameter);
    }

    @Override
    public Optional<TenderTechnicalParameterDTO> partialUpdate(TenderTechnicalParameterDTO tenderTechnicalParameterDTO) {
        log.debug("Request to partially update TenderTechnicalParameter : {}", tenderTechnicalParameterDTO);

        return tenderTechnicalParameterRepository
            .findById(tenderTechnicalParameterDTO.getId())
            .map(
                existingTenderTechnicalParameter -> {
                    tenderTechnicalParameterMapper.partialUpdate(existingTenderTechnicalParameter, tenderTechnicalParameterDTO);

                    return existingTenderTechnicalParameter;
                }
            )
            .map(tenderTechnicalParameterRepository::save)
            .map(tenderTechnicalParameterMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TenderTechnicalParameterDTO> findAll() {
        log.debug("Request to get all TenderTechnicalParameters");
        return tenderTechnicalParameterRepository
            .findAll()
            .stream()
            .map(tenderTechnicalParameterMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TenderTechnicalParameterDTO> findOne(Long id) {
        log.debug("Request to get TenderTechnicalParameter : {}", id);
        return tenderTechnicalParameterRepository.findById(id).map(tenderTechnicalParameterMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete TenderTechnicalParameter : {}", id);
        tenderTechnicalParameterRepository.deleteById(id);
    }
}
