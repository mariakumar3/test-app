package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.TenderCorrigendumDetails;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TenderCorrigendumDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TenderCorrigendumDetailsRepository extends JpaRepository<TenderCorrigendumDetails, Long> {}
