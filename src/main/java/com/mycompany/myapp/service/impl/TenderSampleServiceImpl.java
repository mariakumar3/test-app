package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.TenderSample;
import com.mycompany.myapp.repository.TenderSampleRepository;
import com.mycompany.myapp.service.TenderSampleService;
import com.mycompany.myapp.service.dto.TenderSampleDTO;
import com.mycompany.myapp.service.mapper.TenderSampleMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link TenderSample}.
 */
@Service
@Transactional
public class TenderSampleServiceImpl implements TenderSampleService {

    private final Logger log = LoggerFactory.getLogger(TenderSampleServiceImpl.class);

    private final TenderSampleRepository tenderSampleRepository;

    private final TenderSampleMapper tenderSampleMapper;

    public TenderSampleServiceImpl(TenderSampleRepository tenderSampleRepository, TenderSampleMapper tenderSampleMapper) {
        this.tenderSampleRepository = tenderSampleRepository;
        this.tenderSampleMapper = tenderSampleMapper;
    }

    @Override
    public TenderSampleDTO save(TenderSampleDTO tenderSampleDTO) {
        log.debug("Request to save TenderSample : {}", tenderSampleDTO);
        TenderSample tenderSample = tenderSampleMapper.toEntity(tenderSampleDTO);
        tenderSample = tenderSampleRepository.save(tenderSample);
        return tenderSampleMapper.toDto(tenderSample);
    }

    @Override
    public Optional<TenderSampleDTO> partialUpdate(TenderSampleDTO tenderSampleDTO) {
        log.debug("Request to partially update TenderSample : {}", tenderSampleDTO);

        return tenderSampleRepository
            .findById(tenderSampleDTO.getId())
            .map(
                existingTenderSample -> {
                    tenderSampleMapper.partialUpdate(existingTenderSample, tenderSampleDTO);

                    return existingTenderSample;
                }
            )
            .map(tenderSampleRepository::save)
            .map(tenderSampleMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TenderSampleDTO> findAll() {
        log.debug("Request to get all TenderSamples");
        return tenderSampleRepository.findAll().stream().map(tenderSampleMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TenderSampleDTO> findOne(Long id) {
        log.debug("Request to get TenderSample : {}", id);
        return tenderSampleRepository.findById(id).map(tenderSampleMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete TenderSample : {}", id);
        tenderSampleRepository.deleteById(id);
    }
}
