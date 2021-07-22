package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CriterionDocumentMasterDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CriterionDocumentMasterDTO.class);
        CriterionDocumentMasterDTO criterionDocumentMasterDTO1 = new CriterionDocumentMasterDTO();
        criterionDocumentMasterDTO1.setId(1L);
        CriterionDocumentMasterDTO criterionDocumentMasterDTO2 = new CriterionDocumentMasterDTO();
        assertThat(criterionDocumentMasterDTO1).isNotEqualTo(criterionDocumentMasterDTO2);
        criterionDocumentMasterDTO2.setId(criterionDocumentMasterDTO1.getId());
        assertThat(criterionDocumentMasterDTO1).isEqualTo(criterionDocumentMasterDTO2);
        criterionDocumentMasterDTO2.setId(2L);
        assertThat(criterionDocumentMasterDTO1).isNotEqualTo(criterionDocumentMasterDTO2);
        criterionDocumentMasterDTO1.setId(null);
        assertThat(criterionDocumentMasterDTO1).isNotEqualTo(criterionDocumentMasterDTO2);
    }
}
