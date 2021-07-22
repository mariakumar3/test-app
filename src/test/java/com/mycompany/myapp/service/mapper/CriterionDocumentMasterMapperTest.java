package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CriterionDocumentMasterMapperTest {

    private CriterionDocumentMasterMapper criterionDocumentMasterMapper;

    @BeforeEach
    public void setUp() {
        criterionDocumentMasterMapper = new CriterionDocumentMasterMapperImpl();
    }
}
