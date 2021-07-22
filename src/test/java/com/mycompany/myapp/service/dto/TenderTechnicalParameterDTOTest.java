package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TenderTechnicalParameterDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TenderTechnicalParameterDTO.class);
        TenderTechnicalParameterDTO tenderTechnicalParameterDTO1 = new TenderTechnicalParameterDTO();
        tenderTechnicalParameterDTO1.setId(1L);
        TenderTechnicalParameterDTO tenderTechnicalParameterDTO2 = new TenderTechnicalParameterDTO();
        assertThat(tenderTechnicalParameterDTO1).isNotEqualTo(tenderTechnicalParameterDTO2);
        tenderTechnicalParameterDTO2.setId(tenderTechnicalParameterDTO1.getId());
        assertThat(tenderTechnicalParameterDTO1).isEqualTo(tenderTechnicalParameterDTO2);
        tenderTechnicalParameterDTO2.setId(2L);
        assertThat(tenderTechnicalParameterDTO1).isNotEqualTo(tenderTechnicalParameterDTO2);
        tenderTechnicalParameterDTO1.setId(null);
        assertThat(tenderTechnicalParameterDTO1).isNotEqualTo(tenderTechnicalParameterDTO2);
    }
}
