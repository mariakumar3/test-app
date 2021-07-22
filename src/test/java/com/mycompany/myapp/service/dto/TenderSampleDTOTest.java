package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TenderSampleDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TenderSampleDTO.class);
        TenderSampleDTO tenderSampleDTO1 = new TenderSampleDTO();
        tenderSampleDTO1.setId(1L);
        TenderSampleDTO tenderSampleDTO2 = new TenderSampleDTO();
        assertThat(tenderSampleDTO1).isNotEqualTo(tenderSampleDTO2);
        tenderSampleDTO2.setId(tenderSampleDTO1.getId());
        assertThat(tenderSampleDTO1).isEqualTo(tenderSampleDTO2);
        tenderSampleDTO2.setId(2L);
        assertThat(tenderSampleDTO1).isNotEqualTo(tenderSampleDTO2);
        tenderSampleDTO1.setId(null);
        assertThat(tenderSampleDTO1).isNotEqualTo(tenderSampleDTO2);
    }
}
