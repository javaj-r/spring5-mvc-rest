package com.javid.spring5.mvc.rest.api.v2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Javid on 3/29/2021.
 */

class VendorsDTOTest {

    @Test
    void gettersAndSetters() {
        var vendors = new VendorsDTO();
        assertNotNull(vendors.getVendors());
        vendors.getVendors().add(new VendorDTO());
        assertEquals(1, vendors.getVendors().size());
    }

}