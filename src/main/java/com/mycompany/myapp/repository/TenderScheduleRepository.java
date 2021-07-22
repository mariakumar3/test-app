package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.TenderSchedule;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TenderSchedule entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TenderScheduleRepository extends JpaRepository<TenderSchedule, Long> {}
