package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CriterionMasterDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CriterionMasterDTO.class);
        CriterionMasterDTO criterionMasterDTO1 = new CriterionMasterDTO();
        criterionMasterDTO1.setId(1L);
        CriterionMasterDTO criterionMasterDTO2 = new CriterionMasterDTO();
        assertThat(criterionMasterDTO1).isNotEqualTo(criterionMasterDTO2);
        criterionMasterDTO2.setId(criterionMasterDTO1.getId());
        assertThat(criterionMasterDTO1).isEqualTo(criterionMasterDTO2);
        criterionMasterDTO2.setId(2L);
        assertThat(criterionMasterDTO1).isNotEqualTo(criterionMasterDTO2);
        criterionMasterDTO1.setId(null);
        assertThat(criterionMasterDTO1).isNotEqualTo(criterionMasterDTO2);
    }
}
