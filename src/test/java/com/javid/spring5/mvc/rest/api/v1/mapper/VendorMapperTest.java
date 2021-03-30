package com.javid.spring5.mvc.rest.api.v1.mapper;

import com.javid.spring5.mvc.rest.api.v1.model.VendorDTO;
import com.javid.spring5.mvc.rest.domain.Vendor;
import com.javid.spring5.mvc.rest.services.VendorService;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 3/29/2021.
 */

class VendorMapperTest {

    private static final String NAME = new RandomString().nextString();
    private static final Long ID = Math.abs(new Random().nextLong());
    private static final String VENDOR_URL = VendorService.URL + "/" + ID;

    private VendorMapper vendorMapper;

    @BeforeEach
    void setUp() {
        vendorMapper = VendorMapper.INSTANCE;
    }

    @Test
    void vendorToVendorDtoWithUrlWhenNull() {
        // given
        // when
        var vendorDTO = vendorMapper.vendorToVendorDtoWithUrl(null);
        // then
        assertNull(vendorDTO);
    }

    @Test
    void vendorToVendorDtoWithUrl() {
        // given
        var vendor = new Vendor().setId(ID).setName(NAME);
        // when
        var vendorDTO = vendorMapper.vendorToVendorDtoWithUrl(vendor);
        // then
        assertNotNull(vendorDTO);
        assertEquals(NAME, vendorDTO.getName());
        assertEquals(VENDOR_URL, vendorDTO.getVendorUrl());
    }

    @Test
    void vendorToVendorDtoWhenNull() {
        // given
        // when
        var vendorDTO = vendorMapper.vendorToVendorDto(null);
        // then
        assertNull(vendorDTO);
    }

    @Test
    void vendorToVendorDto() {
        // given
        var vendor = new Vendor().setId(ID).setName(NAME);
        // when
        var vendorDTO = vendorMapper.vendorToVendorDto(vendor);
        // then
        assertNotNull(vendorDTO);
        assertEquals(NAME, vendorDTO.getName());
    }

    @Test
    void vendorDtoToVendorWhenNull() {
        // given
        // when
        var vendor = vendorMapper.vendorDtoToVendor(null);
        // then
        assertNull(vendor);
    }

    @Test
    void vendorDtoToVendor() {
        // given
        var vendorDTO = new VendorDTO().setName(NAME);
        // when
        var vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        // then
        assertNotNull(vendor);
        assertEquals(NAME, vendor.getName());
    }
}
