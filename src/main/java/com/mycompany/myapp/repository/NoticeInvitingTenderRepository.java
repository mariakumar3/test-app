package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.NoticeInvitingTender;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the NoticeInvitingTender entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NoticeInvitingTenderRepository extends JpaRepository<NoticeInvitingTender, Long> {}
