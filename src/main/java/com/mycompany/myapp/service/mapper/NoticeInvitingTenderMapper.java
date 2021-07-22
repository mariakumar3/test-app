package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.NoticeInvitingTenderDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link NoticeInvitingTender} and its DTO {@link NoticeInvitingTenderDTO}.
 */
@Mapper(componentModel = "spring", uses = { TenderScheduleMapper.class })
public interface NoticeInvitingTenderMapper extends EntityMapper<NoticeInvitingTenderDTO, NoticeInvitingTender> {
    @Mapping(target = "tenderSchedule", source = "tenderSchedule", qualifiedByName = "id")
    NoticeInvitingTenderDTO toDto(NoticeInvitingTender s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    NoticeInvitingTenderDTO toDtoId(NoticeInvitingTender noticeInvitingTender);
}
