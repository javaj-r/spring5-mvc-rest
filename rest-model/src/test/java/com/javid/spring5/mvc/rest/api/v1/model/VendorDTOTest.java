package com.javid.spring5.mvc.rest.api.v1.model;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 3/29/2021.
 */

class VendorDTOTest {

    VendorDTO vendorDTO;
    VendorDTO vendorDTO1;

    @BeforeEach
    void setUp() {
        var name = new RandomString().nextString();
        var url = new RandomString().nextString();

        vendorDTO = new VendorDTO().setName(name).setVendorUrl(url);
        vendorDTO1 = new VendorDTO().setName(name).setVendorUrl(url);
    }

    @Test
    void testEquals() {
        assertEquals(vendorDTO, vendorDTO);
        assertEquals(vendorDTO1, vendorDTO);
        assertNotEquals(vendorDTO,new VendorDTO());
        assertNotEquals(vendorDTO,new Object());
    }

    @Test
    void canEqual() {
        assertTrue(new VendorDTO().canEqual(new VendorDTO()));
        assertFalse(new VendorDTO().canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        assertEquals(vendorDTO.hashCode(), vendorDTO1.hashCode());
        assertNotEquals(vendorDTO.hashCode(), new VendorDTO().hashCode());
    }

    @Test
    void testToString() {
        assertEquals(vendorDTO.toString(), vendorDTO1.toString());
        assertNotEquals(vendorDTO.toString(), new VendorDTO().toString());
    }
}