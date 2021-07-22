package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderScrutinyCommitteeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderScrutinyCommittee} and its DTO {@link TenderScrutinyCommitteeDTO}.
 */
@Mapper(componentModel = "spring", uses = { NoticeInvitingTenderMapper.class })
public interface TenderScrutinyCommitteeMapper extends EntityMapper<TenderScrutinyCommitteeDTO, TenderScrutinyCommittee> {
    @Mapping(target = "noticeInvitingTender", source = "noticeInvitingTender", qualifiedByName = "id")
    TenderScrutinyCommitteeDTO toDto(TenderScrutinyCommittee s);
}
