package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CriterionMasterDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CriterionMaster} and its DTO {@link CriterionMasterDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CriterionMasterMapper extends EntityMapper<CriterionMasterDTO, CriterionMaster> {}
