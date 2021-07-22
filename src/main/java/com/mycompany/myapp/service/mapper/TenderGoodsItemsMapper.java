package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderGoodsItemsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderGoodsItems} and its DTO {@link TenderGoodsItemsDTO}.
 */
@Mapper(componentModel = "spring", uses = { NoticeInvitingTenderMapper.class, TenderGoodsGroupMapper.class })
public interface TenderGoodsItemsMapper extends EntityMapper<TenderGoodsItemsDTO, TenderGoodsItems> {
    @Mapping(target = "noticeInvitingTender", source = "noticeInvitingTender", qualifiedByName = "id")
    @Mapping(target = "tenderGoodsGroup", source = "tenderGoodsGroup", qualifiedByName = "id")
    TenderGoodsItemsDTO toDto(TenderGoodsItems s);
}
