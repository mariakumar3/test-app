package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TenderGoodsGroupDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TenderGoodsGroupDTO.class);
        TenderGoodsGroupDTO tenderGoodsGroupDTO1 = new TenderGoodsGroupDTO();
        tenderGoodsGroupDTO1.setId(1L);
        TenderGoodsGroupDTO tenderGoodsGroupDTO2 = new TenderGoodsGroupDTO();
        assertThat(tenderGoodsGroupDTO1).isNotEqualTo(tenderGoodsGroupDTO2);
        tenderGoodsGroupDTO2.setId(tenderGoodsGroupDTO1.getId());
        assertThat(tenderGoodsGroupDTO1).isEqualTo(tenderGoodsGroupDTO2);
        tenderGoodsGroupDTO2.setId(2L);
        assertThat(tenderGoodsGroupDTO1).isNotEqualTo(tenderGoodsGroupDTO2);
        tenderGoodsGroupDTO1.setId(null);
        assertThat(tenderGoodsGroupDTO1).isNotEqualTo(tenderGoodsGroupDTO2);
    }
}
