package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.TenderObjectStoreRepository;
import com.mycompany.myapp.service.TenderObjectStoreService;
import com.mycompany.myapp.service.dto.TenderObjectStoreDTO;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.TenderObjectStore}.
 */
@RestController
@RequestMapping("/api")
public class TenderObjectStoreResource {

    private final Logger log = LoggerFactory.getLogger(TenderObjectStoreResource.class);

    private static final String ENTITY_NAME = "testAppTenderObjectStore";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TenderObjectStoreService tenderObjectStoreService;

    private final TenderObjectStoreRepository tenderObjectStoreRepository;

    public TenderObjectStoreResource(
        TenderObjectStoreService tenderObjectStoreService,
        TenderObjectStoreRepository tenderObjectStoreRepository
    ) {
        this.tenderObjectStoreService = tenderObjectStoreService;
        this.tenderObjectStoreRepository = tenderObjectStoreRepository;
    }

    /**
     * {@code POST  /tender-object-stores} : Create a new tenderObjectStore.
     *
     * @param tenderObjectStoreDTO the tenderObjectStoreDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tenderObjectStoreDTO, or with status {@code 400 (Bad Request)} if the tenderObjectStore has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/tender-object-stores")
    public ResponseEntity<TenderObjectStoreDTO> createTenderObjectStore(@RequestBody TenderObjectStoreDTO tenderObjectStoreDTO)
        throws URISyntaxException {
        log.debug("REST request to save TenderObjectStore : {}", tenderObjectStoreDTO);
        if (tenderObjectStoreDTO.getId() != null) {
            throw new BadRequestAlertException("A new tenderObjectStore cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TenderObjectStoreDTO result = tenderObjectStoreService.save(tenderObjectStoreDTO);
        return ResponseEntity
            .created(new URI("/api/tender-object-stores/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /tender-object-stores/:id} : Updates an existing tenderObjectStore.
     *
     * @param id the id of the tenderObjectStoreDTO to save.
     * @param tenderObjectStoreDTO the tenderObjectStoreDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tenderObjectStoreDTO,
     * or with status {@code 400 (Bad Request)} if the tenderObjectStoreDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tenderObjectStoreDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/tender-object-stores/{id}")
    public ResponseEntity<TenderObjectStoreDTO> updateTenderObjectStore(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody TenderObjectStoreDTO tenderObjectStoreDTO
    ) throws URISyntaxException {
        log.debug("REST request to update TenderObjectStore : {}, {}", id, tenderObjectStoreDTO);
        if (tenderObjectStoreDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tenderObjectStoreDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tenderObjectStoreRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        TenderObjectStoreDTO result = tenderObjectStoreService.save(tenderObjectStoreDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tenderObjectStoreDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /tender-object-stores/:id} : Partial updates given fields of an existing tenderObjectStore, field will ignore if it is null
     *
     * @param id the id of the tenderObjectStoreDTO to save.
     * @param tenderObjectStoreDTO the tenderObjectStoreDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tenderObjectStoreDTO,
     * or with status {@code 400 (Bad Request)} if the tenderObjectStoreDTO is not valid,
     * or with status {@code 404 (Not Found)} if the tenderObjectStoreDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the tenderObjectStoreDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/tender-object-stores/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<TenderObjectStoreDTO> partialUpdateTenderObjectStore(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody TenderObjectStoreDTO tenderObjectStoreDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update TenderObjectStore partially : {}, {}", id, tenderObjectStoreDTO);
        if (tenderObjectStoreDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tenderObjectStoreDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tenderObjectStoreRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<TenderObjectStoreDTO> result = tenderObjectStoreService.partialUpdate(tenderObjectStoreDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tenderObjectStoreDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /tender-object-stores} : get all the tenderObjectStores.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tenderObjectStores in body.
     */
    @GetMapping("/tender-object-stores")
    public List<TenderObjectStoreDTO> getAllTenderObjectStores() {
        log.debug("REST request to get all TenderObjectStores");
        return tenderObjectStoreService.findAll();
    }

    /**
     * {@code GET  /tender-object-stores/:id} : get the "id" tenderObjectStore.
     *
     * @param id the id of the tenderObjectStoreDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tenderObjectStoreDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/tender-object-stores/{id}")
    public ResponseEntity<TenderObjectStoreDTO> getTenderObjectStore(@PathVariable Long id) {
        log.debug("REST request to get TenderObjectStore : {}", id);
        Optional<TenderObjectStoreDTO> tenderObjectStoreDTO = tenderObjectStoreService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tenderObjectStoreDTO);
    }

    /**
     * {@code DELETE  /tender-object-stores/:id} : delete the "id" tenderObjectStore.
     *
     * @param id the id of the tenderObjectStoreDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/tender-object-stores/{id}")
    public ResponseEntity<Void> deleteTenderObjectStore(@PathVariable Long id) {
        log.debug("REST request to delete TenderObjectStore : {}", id);
        tenderObjectStoreService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
