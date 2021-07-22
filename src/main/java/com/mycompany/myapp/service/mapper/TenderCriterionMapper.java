package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderCriterionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderCriterion} and its DTO {@link TenderCriterionDTO}.
 */
@Mapper(componentModel = "spring", uses = { NoticeInvitingTenderMapper.class })
public interface TenderCriterionMapper extends EntityMapper<TenderCriterionDTO, TenderCriterion> {
    @Mapping(target = "noticeInvitingTender", source = "noticeInvitingTender", qualifiedByName = "id")
    TenderCriterionDTO toDto(TenderCriterion s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TenderCriterionDTO toDtoId(TenderCriterion tenderCriterion);
}
