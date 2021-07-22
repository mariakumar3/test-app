package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TenderScrutinyCommitteeDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TenderScrutinyCommitteeDTO.class);
        TenderScrutinyCommitteeDTO tenderScrutinyCommitteeDTO1 = new TenderScrutinyCommitteeDTO();
        tenderScrutinyCommitteeDTO1.setId(1L);
        TenderScrutinyCommitteeDTO tenderScrutinyCommitteeDTO2 = new TenderScrutinyCommitteeDTO();
        assertThat(tenderScrutinyCommitteeDTO1).isNotEqualTo(tenderScrutinyCommitteeDTO2);
        tenderScrutinyCommitteeDTO2.setId(tenderScrutinyCommitteeDTO1.getId());
        assertThat(tenderScrutinyCommitteeDTO1).isEqualTo(tenderScrutinyCommitteeDTO2);
        tenderScrutinyCommitteeDTO2.setId(2L);
        assertThat(tenderScrutinyCommitteeDTO1).isNotEqualTo(tenderScrutinyCommitteeDTO2);
        tenderScrutinyCommitteeDTO1.setId(null);
        assertThat(tenderScrutinyCommitteeDTO1).isNotEqualTo(tenderScrutinyCommitteeDTO2);
    }
}
