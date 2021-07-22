package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderAddendumDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderAddendum} and its DTO {@link TenderAddendumDTO}.
 */
@Mapper(componentModel = "spring", uses = { NoticeInvitingTenderMapper.class })
public interface TenderAddendumMapper extends EntityMapper<TenderAddendumDTO, TenderAddendum> {
    @Mapping(target = "noticeInvitingTender", source = "noticeInvitingTender", qualifiedByName = "id")
    TenderAddendumDTO toDto(TenderAddendum s);
}
