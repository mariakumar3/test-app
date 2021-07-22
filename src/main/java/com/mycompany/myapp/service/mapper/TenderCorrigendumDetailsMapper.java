package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderCorrigendumDetailsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderCorrigendumDetails} and its DTO {@link TenderCorrigendumDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = { TenderCorrigendumMapper.class })
public interface TenderCorrigendumDetailsMapper extends EntityMapper<TenderCorrigendumDetailsDTO, TenderCorrigendumDetails> {
    @Mapping(target = "tenderCorrigendum", source = "tenderCorrigendum", qualifiedByName = "id")
    TenderCorrigendumDetailsDTO toDto(TenderCorrigendumDetails s);
}
