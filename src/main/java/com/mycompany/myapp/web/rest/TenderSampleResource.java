package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.TenderSampleRepository;
import com.mycompany.myapp.service.TenderSampleService;
import com.mycompany.myapp.service.dto.TenderSampleDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.TenderSample}.
 */
@RestController
@RequestMapping("/api")
public class TenderSampleResource {

    private final Logger log = LoggerFactory.getLogger(TenderSampleResource.class);

    private static final String ENTITY_NAME = "testAppTenderSample";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TenderSampleService tenderSampleService;

    private final TenderSampleRepository tenderSampleRepository;

    public TenderSampleResource(TenderSampleService tenderSampleService, TenderSampleRepository tenderSampleRepository) {
        this.tenderSampleService = tenderSampleService;
        this.tenderSampleRepository = tenderSampleRepository;
    }

    /**
     * {@code POST  /tender-samples} : Create a new tenderSample.
     *
     * @param tenderSampleDTO the tenderSampleDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tenderSampleDTO, or with status {@code 400 (Bad Request)} if the tenderSample has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/tender-samples")
    public ResponseEntity<TenderSampleDTO> createTenderSample(@Valid @RequestBody TenderSampleDTO tenderSampleDTO)
        throws URISyntaxException {
        log.debug("REST request to save TenderSample : {}", tenderSampleDTO);
        if (tenderSampleDTO.getId() != null) {
            throw new BadRequestAlertException("A new tenderSample cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TenderSampleDTO result = tenderSampleService.save(tenderSampleDTO);
        return ResponseEntity
            .created(new URI("/api/tender-samples/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /tender-samples/:id} : Updates an existing tenderSample.
     *
     * @param id the id of the tenderSampleDTO to save.
     * @param tenderSampleDTO the tenderSampleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tenderSampleDTO,
     * or with status {@code 400 (Bad Request)} if the tenderSampleDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tenderSampleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/tender-samples/{id}")
    public ResponseEntity<TenderSampleDTO> updateTenderSample(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody TenderSampleDTO tenderSampleDTO
    ) throws URISyntaxException {
        log.debug("REST request to update TenderSample : {}, {}", id, tenderSampleDTO);
        if (tenderSampleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tenderSampleDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tenderSampleRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        TenderSampleDTO result = tenderSampleService.save(tenderSampleDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tenderSampleDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /tender-samples/:id} : Partial updates given fields of an existing tenderSample, field will ignore if it is null
     *
     * @param id the id of the tenderSampleDTO to save.
     * @param tenderSampleDTO the tenderSampleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tenderSampleDTO,
     * or with status {@code 400 (Bad Request)} if the tenderSampleDTO is not valid,
     * or with status {@code 404 (Not Found)} if the tenderSampleDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the tenderSampleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/tender-samples/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<TenderSampleDTO> partialUpdateTenderSample(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody TenderSampleDTO tenderSampleDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update TenderSample partially : {}, {}", id, tenderSampleDTO);
        if (tenderSampleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tenderSampleDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tenderSampleRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<TenderSampleDTO> result = tenderSampleService.partialUpdate(tenderSampleDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tenderSampleDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /tender-samples} : get all the tenderSamples.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tenderSamples in body.
     */
    @GetMapping("/tender-samples")
    public List<TenderSampleDTO> getAllTenderSamples() {
        log.debug("REST request to get all TenderSamples");
        return tenderSampleService.findAll();
    }

    /**
     * {@code GET  /tender-samples/:id} : get the "id" tenderSample.
     *
     * @param id the id of the tenderSampleDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tenderSampleDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/tender-samples/{id}")
    public ResponseEntity<TenderSampleDTO> getTenderSample(@PathVariable Long id) {
        log.debug("REST request to get TenderSample : {}", id);
        Optional<TenderSampleDTO> tenderSampleDTO = tenderSampleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tenderSampleDTO);
    }

    /**
     * {@code DELETE  /tender-samples/:id} : delete the "id" tenderSample.
     *
     * @param id the id of the tenderSampleDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/tender-samples/{id}")
    public ResponseEntity<Void> deleteTenderSample(@PathVariable Long id) {
        log.debug("REST request to delete TenderSample : {}", id);
        tenderSampleService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
