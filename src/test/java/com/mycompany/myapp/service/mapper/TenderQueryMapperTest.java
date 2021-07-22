package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TenderQueryMapperTest {

    private TenderQueryMapper tenderQueryMapper;

    @BeforeEach
    public void setUp() {
        tenderQueryMapper = new TenderQueryMapperImpl();
    }
}
