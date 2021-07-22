package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderGoodsGroupDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderGoodsGroup} and its DTO {@link TenderGoodsGroupDTO}.
 */
@Mapper(componentModel = "spring", uses = { NoticeInvitingTenderMapper.class })
public interface TenderGoodsGroupMapper extends EntityMapper<TenderGoodsGroupDTO, TenderGoodsGroup> {
    @Mapping(target = "noticeInvitingTender", source = "noticeInvitingTender", qualifiedByName = "id")
    TenderGoodsGroupDTO toDto(TenderGoodsGroup s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TenderGoodsGroupDTO toDtoId(TenderGoodsGroup tenderGoodsGroup);
}
