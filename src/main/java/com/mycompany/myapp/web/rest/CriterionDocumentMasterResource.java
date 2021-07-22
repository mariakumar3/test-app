package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.CriterionDocumentMasterRepository;
import com.mycompany.myapp.service.CriterionDocumentMasterService;
import com.mycompany.myapp.service.dto.CriterionDocumentMasterDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.CriterionDocumentMaster}.
 */
@RestController
@RequestMapping("/api")
public class CriterionDocumentMasterResource {

    private final Logger log = LoggerFactory.getLogger(CriterionDocumentMasterResource.class);

    private static final String ENTITY_NAME = "testAppCriterionDocumentMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CriterionDocumentMasterService criterionDocumentMasterService;

    private final CriterionDocumentMasterRepository criterionDocumentMasterRepository;

    public CriterionDocumentMasterResource(
        CriterionDocumentMasterService criterionDocumentMasterService,
        CriterionDocumentMasterRepository criterionDocumentMasterRepository
    ) {
        this.criterionDocumentMasterService = criterionDocumentMasterService;
        this.criterionDocumentMasterRepository = criterionDocumentMasterRepository;
    }

    /**
     * {@code POST  /criterion-document-masters} : Create a new criterionDocumentMaster.
     *
     * @param criterionDocumentMasterDTO the criterionDocumentMasterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new criterionDocumentMasterDTO, or with status {@code 400 (Bad Request)} if the criterionDocumentMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/criterion-document-masters")
    public ResponseEntity<CriterionDocumentMasterDTO> createCriterionDocumentMaster(
        @RequestBody CriterionDocumentMasterDTO criterionDocumentMasterDTO
    ) throws URISyntaxException {
        log.debug("REST request to save CriterionDocumentMaster : {}", criterionDocumentMasterDTO);
        if (criterionDocumentMasterDTO.getId() != null) {
            throw new BadRequestAlertException("A new criterionDocumentMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CriterionDocumentMasterDTO result = criterionDocumentMasterService.save(criterionDocumentMasterDTO);
        return ResponseEntity
            .created(new URI("/api/criterion-document-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /criterion-document-masters/:id} : Updates an existing criterionDocumentMaster.
     *
     * @param id the id of the criterionDocumentMasterDTO to save.
     * @param criterionDocumentMasterDTO the criterionDocumentMasterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated criterionDocumentMasterDTO,
     * or with status {@code 400 (Bad Request)} if the criterionDocumentMasterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the criterionDocumentMasterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/criterion-document-masters/{id}")
    public ResponseEntity<CriterionDocumentMasterDTO> updateCriterionDocumentMaster(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CriterionDocumentMasterDTO criterionDocumentMasterDTO
    ) throws URISyntaxException {
        log.debug("REST request to update CriterionDocumentMaster : {}, {}", id, criterionDocumentMasterDTO);
        if (criterionDocumentMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, criterionDocumentMasterDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!criterionDocumentMasterRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CriterionDocumentMasterDTO result = criterionDocumentMasterService.save(criterionDocumentMasterDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, criterionDocumentMasterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /criterion-document-masters/:id} : Partial updates given fields of an existing criterionDocumentMaster, field will ignore if it is null
     *
     * @param id the id of the criterionDocumentMasterDTO to save.
     * @param criterionDocumentMasterDTO the criterionDocumentMasterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated criterionDocumentMasterDTO,
     * or with status {@code 400 (Bad Request)} if the criterionDocumentMasterDTO is not valid,
     * or with status {@code 404 (Not Found)} if the criterionDocumentMasterDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the criterionDocumentMasterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/criterion-document-masters/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<CriterionDocumentMasterDTO> partialUpdateCriterionDocumentMaster(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CriterionDocumentMasterDTO criterionDocumentMasterDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update CriterionDocumentMaster partially : {}, {}", id, criterionDocumentMasterDTO);
        if (criterionDocumentMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, criterionDocumentMasterDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!criterionDocumentMasterRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CriterionDocumentMasterDTO> result = criterionDocumentMasterService.partialUpdate(criterionDocumentMasterDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, criterionDocumentMasterDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /criterion-document-masters} : get all the criterionDocumentMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of criterionDocumentMasters in body.
     */
    @GetMapping("/criterion-document-masters")
    public List<CriterionDocumentMasterDTO> getAllCriterionDocumentMasters() {
        log.debug("REST request to get all CriterionDocumentMasters");
        return criterionDocumentMasterService.findAll();
    }

    /**
     * {@code GET  /criterion-document-masters/:id} : get the "id" criterionDocumentMaster.
     *
     * @param id the id of the criterionDocumentMasterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the criterionDocumentMasterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/criterion-document-masters/{id}")
    public ResponseEntity<CriterionDocumentMasterDTO> getCriterionDocumentMaster(@PathVariable Long id) {
        log.debug("REST request to get CriterionDocumentMaster : {}", id);
        Optional<CriterionDocumentMasterDTO> criterionDocumentMasterDTO = criterionDocumentMasterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(criterionDocumentMasterDTO);
    }

    /**
     * {@code DELETE  /criterion-document-masters/:id} : delete the "id" criterionDocumentMaster.
     *
     * @param id the id of the criterionDocumentMasterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/criterion-document-masters/{id}")
    public ResponseEntity<Void> deleteCriterionDocumentMaster(@PathVariable Long id) {
        log.debug("REST request to delete CriterionDocumentMaster : {}", id);
        criterionDocumentMasterService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
