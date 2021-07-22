package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.TenderSample;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TenderSample entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TenderSampleRepository extends JpaRepository<TenderSample, Long> {}
