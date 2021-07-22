package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.TenderTechnicalParameterRepository;
import com.mycompany.myapp.service.TenderTechnicalParameterService;
import com.mycompany.myapp.service.dto.TenderTechnicalParameterDTO;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.TenderTechnicalParameter}.
 */
@RestController
@RequestMapping("/api")
public class TenderTechnicalParameterResource {

    private final Logger log = LoggerFactory.getLogger(TenderTechnicalParameterResource.class);

    private static final String ENTITY_NAME = "testAppTenderTechnicalParameter";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TenderTechnicalParameterService tenderTechnicalParameterService;

    private final TenderTechnicalParameterRepository tenderTechnicalParameterRepository;

    public TenderTechnicalParameterResource(
        TenderTechnicalParameterService tenderTechnicalParameterService,
        TenderTechnicalParameterRepository tenderTechnicalParameterRepository
    ) {
        this.tenderTechnicalParameterService = tenderTechnicalParameterService;
        this.tenderTechnicalParameterRepository = tenderTechnicalParameterRepository;
    }

    /**
     * {@code POST  /tender-technical-parameters} : Create a new tenderTechnicalParameter.
     *
     * @param tenderTechnicalParameterDTO the tenderTechnicalParameterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tenderTechnicalParameterDTO, or with status {@code 400 (Bad Request)} if the tenderTechnicalParameter has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/tender-technical-parameters")
    public ResponseEntity<TenderTechnicalParameterDTO> createTenderTechnicalParameter(
        @Valid @RequestBody TenderTechnicalParameterDTO tenderTechnicalParameterDTO
    ) throws URISyntaxException {
        log.debug("REST request to save TenderTechnicalParameter : {}", tenderTechnicalParameterDTO);
        if (tenderTechnicalParameterDTO.getId() != null) {
            throw new BadRequestAlertException("A new tenderTechnicalParameter cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TenderTechnicalParameterDTO result = tenderTechnicalParameterService.save(tenderTechnicalParameterDTO);
        return ResponseEntity
            .created(new URI("/api/tender-technical-parameters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /tender-technical-parameters/:id} : Updates an existing tenderTechnicalParameter.
     *
     * @param id the id of the tenderTechnicalParameterDTO to save.
     * @param tenderTechnicalParameterDTO the tenderTechnicalParameterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tenderTechnicalParameterDTO,
     * or with status {@code 400 (Bad Request)} if the tenderTechnicalParameterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tenderTechnicalParameterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/tender-technical-parameters/{id}")
    public ResponseEntity<TenderTechnicalParameterDTO> updateTenderTechnicalParameter(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody TenderTechnicalParameterDTO tenderTechnicalParameterDTO
    ) throws URISyntaxException {
        log.debug("REST request to update TenderTechnicalParameter : {}, {}", id, tenderTechnicalParameterDTO);
        if (tenderTechnicalParameterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tenderTechnicalParameterDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tenderTechnicalParameterRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        TenderTechnicalParameterDTO result = tenderTechnicalParameterService.save(tenderTechnicalParameterDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tenderTechnicalParameterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /tender-technical-parameters/:id} : Partial updates given fields of an existing tenderTechnicalParameter, field will ignore if it is null
     *
     * @param id the id of the tenderTechnicalParameterDTO to save.
     * @param tenderTechnicalParameterDTO the tenderTechnicalParameterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tenderTechnicalParameterDTO,
     * or with status {@code 400 (Bad Request)} if the tenderTechnicalParameterDTO is not valid,
     * or with status {@code 404 (Not Found)} if the tenderTechnicalParameterDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the tenderTechnicalParameterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/tender-technical-parameters/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<TenderTechnicalParameterDTO> partialUpdateTenderTechnicalParameter(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody TenderTechnicalParameterDTO tenderTechnicalParameterDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update TenderTechnicalParameter partially : {}, {}", id, tenderTechnicalParameterDTO);
        if (tenderTechnicalParameterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tenderTechnicalParameterDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tenderTechnicalParameterRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<TenderTechnicalParameterDTO> result = tenderTechnicalParameterService.partialUpdate(tenderTechnicalParameterDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tenderTechnicalParameterDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /tender-technical-parameters} : get all the tenderTechnicalParameters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tenderTechnicalParameters in body.
     */
    @GetMapping("/tender-technical-parameters")
    public List<TenderTechnicalParameterDTO> getAllTenderTechnicalParameters() {
        log.debug("REST request to get all TenderTechnicalParameters");
        return tenderTechnicalParameterService.findAll();
    }

    /**
     * {@code GET  /tender-technical-parameters/:id} : get the "id" tenderTechnicalParameter.
     *
     * @param id the id of the tenderTechnicalParameterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tenderTechnicalParameterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/tender-technical-parameters/{id}")
    public ResponseEntity<TenderTechnicalParameterDTO> getTenderTechnicalParameter(@PathVariable Long id) {
        log.debug("REST request to get TenderTechnicalParameter : {}", id);
        Optional<TenderTechnicalParameterDTO> tenderTechnicalParameterDTO = tenderTechnicalParameterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tenderTechnicalParameterDTO);
    }

    /**
     * {@code DELETE  /tender-technical-parameters/:id} : delete the "id" tenderTechnicalParameter.
     *
     * @param id the id of the tenderTechnicalParameterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/tender-technical-parameters/{id}")
    public ResponseEntity<Void> deleteTenderTechnicalParameter(@PathVariable Long id) {
        log.debug("REST request to delete TenderTechnicalParameter : {}", id);
        tenderTechnicalParameterService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
