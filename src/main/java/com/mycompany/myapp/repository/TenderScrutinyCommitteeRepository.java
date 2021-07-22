package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.TenderScrutinyCommittee;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TenderScrutinyCommittee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TenderScrutinyCommitteeRepository extends JpaRepository<TenderScrutinyCommittee, Long> {}
