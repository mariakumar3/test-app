package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.TenderTechnicalParameter;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TenderTechnicalParameter entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TenderTechnicalParameterRepository extends JpaRepository<TenderTechnicalParameter, Long> {}
