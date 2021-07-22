package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.TenderGoodsGroupRepository;
import com.mycompany.myapp.service.TenderGoodsGroupService;
import com.mycompany.myapp.service.dto.TenderGoodsGroupDTO;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.TenderGoodsGroup}.
 */
@RestController
@RequestMapping("/api")
public class TenderGoodsGroupResource {

    private final Logger log = LoggerFactory.getLogger(TenderGoodsGroupResource.class);

    private static final String ENTITY_NAME = "testAppTenderGoodsGroup";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TenderGoodsGroupService tenderGoodsGroupService;

    private final TenderGoodsGroupRepository tenderGoodsGroupRepository;

    public TenderGoodsGroupResource(
        TenderGoodsGroupService tenderGoodsGroupService,
        TenderGoodsGroupRepository tenderGoodsGroupRepository
    ) {
        this.tenderGoodsGroupService = tenderGoodsGroupService;
        this.tenderGoodsGroupRepository = tenderGoodsGroupRepository;
    }

    /**
     * {@code POST  /tender-goods-groups} : Create a new tenderGoodsGroup.
     *
     * @param tenderGoodsGroupDTO the tenderGoodsGroupDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tenderGoodsGroupDTO, or with status {@code 400 (Bad Request)} if the tenderGoodsGroup has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/tender-goods-groups")
    public ResponseEntity<TenderGoodsGroupDTO> createTenderGoodsGroup(@RequestBody TenderGoodsGroupDTO tenderGoodsGroupDTO)
        throws URISyntaxException {
        log.debug("REST request to save TenderGoodsGroup : {}", tenderGoodsGroupDTO);
        if (tenderGoodsGroupDTO.getId() != null) {
            throw new BadRequestAlertException("A new tenderGoodsGroup cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TenderGoodsGroupDTO result = tenderGoodsGroupService.save(tenderGoodsGroupDTO);
        return ResponseEntity
            .created(new URI("/api/tender-goods-groups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /tender-goods-groups/:id} : Updates an existing tenderGoodsGroup.
     *
     * @param id the id of the tenderGoodsGroupDTO to save.
     * @param tenderGoodsGroupDTO the tenderGoodsGroupDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tenderGoodsGroupDTO,
     * or with status {@code 400 (Bad Request)} if the tenderGoodsGroupDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tenderGoodsGroupDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/tender-goods-groups/{id}")
    public ResponseEntity<TenderGoodsGroupDTO> updateTenderGoodsGroup(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody TenderGoodsGroupDTO tenderGoodsGroupDTO
    ) throws URISyntaxException {
        log.debug("REST request to update TenderGoodsGroup : {}, {}", id, tenderGoodsGroupDTO);
        if (tenderGoodsGroupDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tenderGoodsGroupDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tenderGoodsGroupRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        TenderGoodsGroupDTO result = tenderGoodsGroupService.save(tenderGoodsGroupDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tenderGoodsGroupDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /tender-goods-groups/:id} : Partial updates given fields of an existing tenderGoodsGroup, field will ignore if it is null
     *
     * @param id the id of the tenderGoodsGroupDTO to save.
     * @param tenderGoodsGroupDTO the tenderGoodsGroupDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tenderGoodsGroupDTO,
     * or with status {@code 400 (Bad Request)} if the tenderGoodsGroupDTO is not valid,
     * or with status {@code 404 (Not Found)} if the tenderGoodsGroupDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the tenderGoodsGroupDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/tender-goods-groups/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<TenderGoodsGroupDTO> partialUpdateTenderGoodsGroup(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody TenderGoodsGroupDTO tenderGoodsGroupDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update TenderGoodsGroup partially : {}, {}", id, tenderGoodsGroupDTO);
        if (tenderGoodsGroupDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tenderGoodsGroupDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tenderGoodsGroupRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<TenderGoodsGroupDTO> result = tenderGoodsGroupService.partialUpdate(tenderGoodsGroupDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tenderGoodsGroupDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /tender-goods-groups} : get all the tenderGoodsGroups.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tenderGoodsGroups in body.
     */
    @GetMapping("/tender-goods-groups")
    public List<TenderGoodsGroupDTO> getAllTenderGoodsGroups() {
        log.debug("REST request to get all TenderGoodsGroups");
        return tenderGoodsGroupService.findAll();
    }

    /**
     * {@code GET  /tender-goods-groups/:id} : get the "id" tenderGoodsGroup.
     *
     * @param id the id of the tenderGoodsGroupDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tenderGoodsGroupDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/tender-goods-groups/{id}")
    public ResponseEntity<TenderGoodsGroupDTO> getTenderGoodsGroup(@PathVariable Long id) {
        log.debug("REST request to get TenderGoodsGroup : {}", id);
        Optional<TenderGoodsGroupDTO> tenderGoodsGroupDTO = tenderGoodsGroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tenderGoodsGroupDTO);
    }

    /**
     * {@code DELETE  /tender-goods-groups/:id} : delete the "id" tenderGoodsGroup.
     *
     * @param id the id of the tenderGoodsGroupDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/tender-goods-groups/{id}")
    public ResponseEntity<Void> deleteTenderGoodsGroup(@PathVariable Long id) {
        log.debug("REST request to delete TenderGoodsGroup : {}", id);
        tenderGoodsGroupService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
