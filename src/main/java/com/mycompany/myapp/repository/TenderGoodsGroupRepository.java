package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.TenderGoodsGroup;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TenderGoodsGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TenderGoodsGroupRepository extends JpaRepository<TenderGoodsGroup, Long> {}
