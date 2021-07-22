package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderQueryResponseDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderQueryResponse} and its DTO {@link TenderQueryResponseDTO}.
 */
@Mapper(componentModel = "spring", uses = { TenderQueryMapper.class })
public interface TenderQueryResponseMapper extends EntityMapper<TenderQueryResponseDTO, TenderQueryResponse> {
    @Mapping(target = "tenderQuery", source = "tenderQuery", qualifiedByName = "id")
    TenderQueryResponseDTO toDto(TenderQueryResponse s);
}
