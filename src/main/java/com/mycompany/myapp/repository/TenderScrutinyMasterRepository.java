package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.TenderScrutinyMaster;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TenderScrutinyMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TenderScrutinyMasterRepository extends JpaRepository<TenderScrutinyMaster, Long> {}
