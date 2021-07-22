package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TenderScrutinyMasterDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TenderScrutinyMaster} and its DTO {@link TenderScrutinyMasterDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TenderScrutinyMasterMapper extends EntityMapper<TenderScrutinyMasterDTO, TenderScrutinyMaster> {}
