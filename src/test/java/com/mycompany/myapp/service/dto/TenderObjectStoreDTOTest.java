package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TenderObjectStoreDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TenderObjectStoreDTO.class);
        TenderObjectStoreDTO tenderObjectStoreDTO1 = new TenderObjectStoreDTO();
        tenderObjectStoreDTO1.setId(1L);
        TenderObjectStoreDTO tenderObjectStoreDTO2 = new TenderObjectStoreDTO();
        assertThat(tenderObjectStoreDTO1).isNotEqualTo(tenderObjectStoreDTO2);
        tenderObjectStoreDTO2.setId(tenderObjectStoreDTO1.getId());
        assertThat(tenderObjectStoreDTO1).isEqualTo(tenderObjectStoreDTO2);
        tenderObjectStoreDTO2.setId(2L);
        assertThat(tenderObjectStoreDTO1).isNotEqualTo(tenderObjectStoreDTO2);
        tenderObjectStoreDTO1.setId(null);
        assertThat(tenderObjectStoreDTO1).isNotEqualTo(tenderObjectStoreDTO2);
    }
}
