package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderScheduleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderSchedule} and its DTO {@link TenderScheduleDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TenderScheduleMapper extends EntityMapper<TenderScheduleDTO, TenderSchedule> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TenderScheduleDTO toDtoId(TenderSchedule tenderSchedule);
}
