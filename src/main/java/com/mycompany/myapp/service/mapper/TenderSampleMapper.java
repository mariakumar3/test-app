package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderSampleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderSample} and its DTO {@link TenderSampleDTO}.
 */
@Mapper(componentModel = "spring", uses = { NoticeInvitingTenderMapper.class })
public interface TenderSampleMapper extends EntityMapper<TenderSampleDTO, TenderSample> {
    @Mapping(target = "noticeInvitingTender", source = "noticeInvitingTender", qualifiedByName = "id")
    TenderSampleDTO toDto(TenderSample s);
}
