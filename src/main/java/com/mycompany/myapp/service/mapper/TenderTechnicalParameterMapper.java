package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderTechnicalParameterDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderTechnicalParameter} and its DTO {@link TenderTechnicalParameterDTO}.
 */
@Mapper(componentModel = "spring", uses = { NoticeInvitingTenderMapper.class })
public interface TenderTechnicalParameterMapper extends EntityMapper<TenderTechnicalParameterDTO, TenderTechnicalParameter> {
    @Mapping(target = "noticeInvitingTender", source = "noticeInvitingTender", qualifiedByName = "id")
    TenderTechnicalParameterDTO toDto(TenderTechnicalParameter s);
}
