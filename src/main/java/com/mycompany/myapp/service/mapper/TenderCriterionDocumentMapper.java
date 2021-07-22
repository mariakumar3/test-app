package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderCriterionDocumentDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderCriterionDocument} and its DTO {@link TenderCriterionDocumentDTO}.
 */
@Mapper(componentModel = "spring", uses = { NoticeInvitingTenderMapper.class, TenderCriterionMapper.class })
public interface TenderCriterionDocumentMapper extends EntityMapper<TenderCriterionDocumentDTO, TenderCriterionDocument> {
    @Mapping(target = "noticeInvitingTender", source = "noticeInvitingTender", qualifiedByName = "id")
    @Mapping(target = "tenderCriterion", source = "tenderCriterion", qualifiedByName = "id")
    TenderCriterionDocumentDTO toDto(TenderCriterionDocument s);
}
