package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderObjectStoreDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderObjectStore} and its DTO {@link TenderObjectStoreDTO}.
 */
@Mapper(componentModel = "spring", uses = { NoticeInvitingTenderMapper.class })
public interface TenderObjectStoreMapper extends EntityMapper<TenderObjectStoreDTO, TenderObjectStore> {
    @Mapping(target = "noticeInvitingTender", source = "noticeInvitingTender", qualifiedByName = "id")
    TenderObjectStoreDTO toDto(TenderObjectStore s);
}
