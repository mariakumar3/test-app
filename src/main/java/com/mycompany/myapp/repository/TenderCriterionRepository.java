package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.TenderCriterion;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TenderCriterion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TenderCriterionRepository extends JpaRepository<TenderCriterion, Long> {}
