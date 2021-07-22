package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TenderGoodsGroupMapperTest {

    private TenderGoodsGroupMapper tenderGoodsGroupMapper;

    @BeforeEach
    public void setUp() {
        tenderGoodsGroupMapper = new TenderGoodsGroupMapperImpl();
    }
}
