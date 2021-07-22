package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.CriterionDocumentMaster;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the CriterionDocumentMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CriterionDocumentMasterRepository extends JpaRepository<CriterionDocumentMaster, Long> {}
