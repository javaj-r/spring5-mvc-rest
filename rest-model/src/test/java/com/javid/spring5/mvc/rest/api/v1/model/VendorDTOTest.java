package com.javid.spring5.mvc.rest.api.v1.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Javid on 3/29/2021.
 */

class VendorDTOTest {

    @Test
    void chainingSetters() {
        assertEquals("j", new VendorDTO().setName("j").getName());
        assertEquals("j", new VendorDTO().setVendorUrl("j").getVendorUrl());
    }

    @Test
    void gettersAndSetters() {
        new BeanTester().testBean(VendorDTO.class);
    }

    @Test
    void equalsAndHashCode() {
        EqualsVerifier.simple().forClass(VendorDTO.class).verify();
    }

}