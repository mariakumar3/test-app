package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderCorrigendumDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderCorrigendum} and its DTO {@link TenderCorrigendumDTO}.
 */
@Mapper(componentModel = "spring", uses = { NoticeInvitingTenderMapper.class })
public interface TenderCorrigendumMapper extends EntityMapper<TenderCorrigendumDTO, TenderCorrigendum> {
    @Mapping(target = "noticeInvitingTender", source = "noticeInvitingTender", qualifiedByName = "id")
    TenderCorrigendumDTO toDto(TenderCorrigendum s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TenderCorrigendumDTO toDtoId(TenderCorrigendum tenderCorrigendum);
}
