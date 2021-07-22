package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TenderGoodsGroupTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TenderGoodsGroup.class);
        TenderGoodsGroup tenderGoodsGroup1 = new TenderGoodsGroup();
        tenderGoodsGroup1.setId(1L);
        TenderGoodsGroup tenderGoodsGroup2 = new TenderGoodsGroup();
        tenderGoodsGroup2.setId(tenderGoodsGroup1.getId());
        assertThat(tenderGoodsGroup1).isEqualTo(tenderGoodsGroup2);
        tenderGoodsGroup2.setId(2L);
        assertThat(tenderGoodsGroup1).isNotEqualTo(tenderGoodsGroup2);
        tenderGoodsGroup1.setId(null);
        assertThat(tenderGoodsGroup1).isNotEqualTo(tenderGoodsGroup2);
    }
}
