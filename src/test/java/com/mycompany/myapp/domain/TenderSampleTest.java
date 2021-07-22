package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TenderSampleTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TenderSample.class);
        TenderSample tenderSample1 = new TenderSample();
        tenderSample1.setId(1L);
        TenderSample tenderSample2 = new TenderSample();
        tenderSample2.setId(tenderSample1.getId());
        assertThat(tenderSample1).isEqualTo(tenderSample2);
        tenderSample2.setId(2L);
        assertThat(tenderSample1).isNotEqualTo(tenderSample2);
        tenderSample1.setId(null);
        assertThat(tenderSample1).isNotEqualTo(tenderSample2);
    }
}
