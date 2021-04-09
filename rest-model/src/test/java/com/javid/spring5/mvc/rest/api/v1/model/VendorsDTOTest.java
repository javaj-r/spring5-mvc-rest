package com.javid.spring5.mvc.rest.api.v1.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Javid on 3/29/2021.
 */

class VendorsDTOTest {

    @Test
    void allArgsConstructor() {
        assertEquals(1, new VendorsDTO(List.of(new VendorDTO())).getVendors().size());
    }

    @Test
    void gettersAndSetters() {
        new BeanTester().testBean(VendorsDTO.class);
    }

    @Test
    void equalsAndHashCode() {
        EqualsVerifier.simple().forClass(VendorsDTO.class).verify();
    }

}