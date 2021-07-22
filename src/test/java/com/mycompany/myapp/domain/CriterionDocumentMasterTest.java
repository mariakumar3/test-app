package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CriterionDocumentMasterTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CriterionDocumentMaster.class);
        CriterionDocumentMaster criterionDocumentMaster1 = new CriterionDocumentMaster();
        criterionDocumentMaster1.setId(1L);
        CriterionDocumentMaster criterionDocumentMaster2 = new CriterionDocumentMaster();
        criterionDocumentMaster2.setId(criterionDocumentMaster1.getId());
        assertThat(criterionDocumentMaster1).isEqualTo(criterionDocumentMaster2);
        criterionDocumentMaster2.setId(2L);
        assertThat(criterionDocumentMaster1).isNotEqualTo(criterionDocumentMaster2);
        criterionDocumentMaster1.setId(null);
        assertThat(criterionDocumentMaster1).isNotEqualTo(criterionDocumentMaster2);
    }
}
