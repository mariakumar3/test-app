package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderQueryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderQuery} and its DTO {@link TenderQueryDTO}.
 */
@Mapper(componentModel = "spring", uses = { NoticeInvitingTenderMapper.class })
public interface TenderQueryMapper extends EntityMapper<TenderQueryDTO, TenderQuery> {
    @Mapping(target = "noticeInvitingTender", source = "noticeInvitingTender", qualifiedByName = "id")
    TenderQueryDTO toDto(TenderQuery s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TenderQueryDTO toDtoId(TenderQuery tenderQuery);
}
