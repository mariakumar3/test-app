package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TenderObjectStoreTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TenderObjectStore.class);
        TenderObjectStore tenderObjectStore1 = new TenderObjectStore();
        tenderObjectStore1.setId(1L);
        TenderObjectStore tenderObjectStore2 = new TenderObjectStore();
        tenderObjectStore2.setId(tenderObjectStore1.getId());
        assertThat(tenderObjectStore1).isEqualTo(tenderObjectStore2);
        tenderObjectStore2.setId(2L);
        assertThat(tenderObjectStore1).isNotEqualTo(tenderObjectStore2);
        tenderObjectStore1.setId(null);
        assertThat(tenderObjectStore1).isNotEqualTo(tenderObjectStore2);
    }
}
