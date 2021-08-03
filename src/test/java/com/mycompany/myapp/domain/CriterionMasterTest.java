package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CriterionMasterTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CriterionMaster.class);
        CriterionMaster criterionMaster1 = new CriterionMaster();
        criterionMaster1.setId(1L);
        CriterionMaster criterionMaster2 = new CriterionMaster();
        criterionMaster2.setId(criterionMaster1.getId());
        assertThat(criterionMaster1).isEqualTo(criterionMaster2);
        criterionMaster2.setId(2L);
        assertThat(criterionMaster1).isNotEqualTo(criterionMaster2);
        criterionMaster1.setId(null);
        assertThat(criterionMaster1).isNotEqualTo(criterionMaster2);
    }
}
