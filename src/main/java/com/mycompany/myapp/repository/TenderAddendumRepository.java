package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.TenderAddendum;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TenderAddendum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TenderAddendumRepository extends JpaRepository<TenderAddendum, Long> {}
