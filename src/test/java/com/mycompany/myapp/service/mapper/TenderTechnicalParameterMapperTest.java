package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TenderTechnicalParameterMapperTest {

    private TenderTechnicalParameterMapper tenderTechnicalParameterMapper;

    @BeforeEach
    public void setUp() {
        tenderTechnicalParameterMapper = new TenderTechnicalParameterMapperImpl();
    }
}
