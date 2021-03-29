package com.javid.spring5.mvc.rest.services;

import com.javid.spring5.mvc.rest.api.v1.mapper.VendorMapper;
import com.javid.spring5.mvc.rest.domain.Vendor;
import com.javid.spring5.mvc.rest.repositories.VendorRepository;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by Javid on 3/29/2021.
 */

@ExtendWith(MockitoExtension.class)
class VendorServiceTest {

    private static final String NAME = new RandomString().nextString();
    private static final Long ID = Math.abs(new Random().nextLong());
    private static final String CUSTOMER_URL = VendorService.URL + "/" + ID;
    private static final String NAME2 = new RandomString().nextString();
    private static final Long ID2 = Math.abs(new Random().nextLong());

    private VendorService vendorService;

    @Mock
    private VendorRepository vendorRepository;

    @BeforeEach
    void setUp() {
        vendorService = new VendorServiceImpl(vendorRepository, VendorMapper.INSTANCE);
    }

    @Test
    void findAll() {
        // given
        var vendorList = List.of(new Vendor().setId(ID).setName(NAME),
                new Vendor().setId(ID2).setName(NAME2));
        when(vendorRepository.findAll()).thenReturn(vendorList);
        // when
        var vendorDTOList = vendorService.findAll();
        // then
        assertNotNull(vendorDTOList);
        assertEquals(vendorList.size(), vendorDTOList.size());
    }
}