package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CriterionDocumentMasterDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CriterionDocumentMaster} and its DTO {@link CriterionDocumentMasterDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CriterionDocumentMasterMapper extends EntityMapper<CriterionDocumentMasterDTO, CriterionDocumentMaster> {}
