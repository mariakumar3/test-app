package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TenderTechnicalParameterTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TenderTechnicalParameter.class);
        TenderTechnicalParameter tenderTechnicalParameter1 = new TenderTechnicalParameter();
        tenderTechnicalParameter1.setId(1L);
        TenderTechnicalParameter tenderTechnicalParameter2 = new TenderTechnicalParameter();
        tenderTechnicalParameter2.setId(tenderTechnicalParameter1.getId());
        assertThat(tenderTechnicalParameter1).isEqualTo(tenderTechnicalParameter2);
        tenderTechnicalParameter2.setId(2L);
        assertThat(tenderTechnicalParameter1).isNotEqualTo(tenderTechnicalParameter2);
        tenderTechnicalParameter1.setId(null);
        assertThat(tenderTechnicalParameter1).isNotEqualTo(tenderTechnicalParameter2);
    }
}
