package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TenderObjectStoreMapperTest {

    private TenderObjectStoreMapper tenderObjectStoreMapper;

    @BeforeEach
    public void setUp() {
        tenderObjectStoreMapper = new TenderObjectStoreMapperImpl();
    }
}
