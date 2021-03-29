package com.javid.spring5.mvc.rest.api.v1.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 3/29/2021.
 */

class VendorsDTOTest {

    VendorsDTO vendorsDTO;
    VendorsDTO vendorsDTO1;
    private List<VendorDTO> vendorList;

    @BeforeEach
    void setUp() {
        vendorList = List.of(new VendorDTO().setName("name1").setVendorUrl("url1"),
                new VendorDTO().setName("name2").setVendorUrl("url2"));

        vendorsDTO = new VendorsDTO(vendorList);
        vendorsDTO1 = new VendorsDTO(vendorList);
    }

    @Test
    void testEquals() {
        assertEquals(vendorsDTO, vendorsDTO);
        assertEquals(vendorsDTO1, vendorsDTO);
        assertNotEquals(vendorsDTO,new VendorsDTO(List.of()));
        assertNotEquals(vendorsDTO,new Object());
    }

    @Test
    void canEqual() {
        assertTrue(new VendorsDTO(vendorList).canEqual(new VendorsDTO(List.of())));
        assertFalse(new VendorsDTO(vendorList).canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        assertEquals(vendorsDTO.hashCode(), vendorsDTO1.hashCode());
        assertNotEquals(vendorsDTO.hashCode(), new VendorsDTO(List.of()).hashCode());
    }

    @Test
    void testToString() {
        assertEquals(vendorsDTO.toString(), vendorsDTO1.toString());
        assertNotEquals(vendorsDTO.toString(), new VendorsDTO(List.of()).toString());
    }
}