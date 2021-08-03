package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.CriterionMasterRepository;
import com.mycompany.myapp.service.CriterionMasterService;
import com.mycompany.myapp.service.dto.CriterionMasterDTO;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.CriterionMaster}.
 */
@RestController
@RequestMapping("/api")
public class CriterionMasterResource {

    private final Logger log = LoggerFactory.getLogger(CriterionMasterResource.class);

    private static final String ENTITY_NAME = "testAppCriterionMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CriterionMasterService criterionMasterService;

    private final CriterionMasterRepository criterionMasterRepository;

    public CriterionMasterResource(CriterionMasterService criterionMasterService, CriterionMasterRepository criterionMasterRepository) {
        this.criterionMasterService = criterionMasterService;
        this.criterionMasterRepository = criterionMasterRepository;
    }

    /**
     * {@code POST  /criterion-masters} : Create a new criterionMaster.
     *
     * @param criterionMasterDTO the criterionMasterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new criterionMasterDTO, or with status {@code 400 (Bad Request)} if the criterionMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/criterion-masters")
    public ResponseEntity<CriterionMasterDTO> createCriterionMaster(@RequestBody CriterionMasterDTO criterionMasterDTO)
        throws URISyntaxException {
        log.debug("REST request to save CriterionMaster : {}", criterionMasterDTO);
        if (criterionMasterDTO.getId() != null) {
            throw new BadRequestAlertException("A new criterionMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CriterionMasterDTO result = criterionMasterService.save(criterionMasterDTO);
        return ResponseEntity
            .created(new URI("/api/criterion-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /criterion-masters/:id} : Updates an existing criterionMaster.
     *
     * @param id the id of the criterionMasterDTO to save.
     * @param criterionMasterDTO the criterionMasterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated criterionMasterDTO,
     * or with status {@code 400 (Bad Request)} if the criterionMasterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the criterionMasterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/criterion-masters/{id}")
    public ResponseEntity<CriterionMasterDTO> updateCriterionMaster(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CriterionMasterDTO criterionMasterDTO
    ) throws URISyntaxException {
        log.debug("REST request to update CriterionMaster : {}, {}", id, criterionMasterDTO);
        if (criterionMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, criterionMasterDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!criterionMasterRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CriterionMasterDTO result = criterionMasterService.save(criterionMasterDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, criterionMasterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /criterion-masters/:id} : Partial updates given fields of an existing criterionMaster, field will ignore if it is null
     *
     * @param id the id of the criterionMasterDTO to save.
     * @param criterionMasterDTO the criterionMasterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated criterionMasterDTO,
     * or with status {@code 400 (Bad Request)} if the criterionMasterDTO is not valid,
     * or with status {@code 404 (Not Found)} if the criterionMasterDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the criterionMasterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/criterion-masters/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<CriterionMasterDTO> partialUpdateCriterionMaster(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CriterionMasterDTO criterionMasterDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update CriterionMaster partially : {}, {}", id, criterionMasterDTO);
        if (criterionMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, criterionMasterDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!criterionMasterRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CriterionMasterDTO> result = criterionMasterService.partialUpdate(criterionMasterDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, criterionMasterDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /criterion-masters} : get all the criterionMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of criterionMasters in body.
     */
    @GetMapping("/criterion-masters")
    public List<CriterionMasterDTO> getAllCriterionMasters() {
        log.debug("REST request to get all CriterionMasters");
        return criterionMasterService.findAll();
    }

    /**
     * {@code GET  /criterion-masters/:id} : get the "id" criterionMaster.
     *
     * @param id the id of the criterionMasterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the criterionMasterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/criterion-masters/{id}")
    public ResponseEntity<CriterionMasterDTO> getCriterionMaster(@PathVariable Long id) {
        log.debug("REST request to get CriterionMaster : {}", id);
        Optional<CriterionMasterDTO> criterionMasterDTO = criterionMasterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(criterionMasterDTO);
    }

    /**
     * {@code DELETE  /criterion-masters/:id} : delete the "id" criterionMaster.
     *
     * @param id the id of the criterionMasterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/criterion-masters/{id}")
    public ResponseEntity<Void> deleteCriterionMaster(@PathVariable Long id) {
        log.debug("REST request to delete CriterionMaster : {}", id);
        criterionMasterService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
