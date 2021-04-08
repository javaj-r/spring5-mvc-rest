package com.javid.spring5.mvc.rest.services;

import com.javid.spring5.mvc.rest.api.v1.mapper.VendorMapper;
import com.javid.spring5.mvc.rest.api.v1.model.VendorDTO;
import com.javid.spring5.mvc.rest.domain.Vendor;
import com.javid.spring5.mvc.rest.repositories.VendorRepository;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Created by Javid on 3/29/2021.
 */

@ExtendWith(MockitoExtension.class)
class VendorServiceTest {

    private static final String NAME = new RandomString().nextString();
    private static final Long ID = Math.abs(new Random().nextLong());
    private static final String VENDOR_URL = VendorService.URL + "/" + ID;
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

    @Test
    void findById() {
        // given
        var vendor = new Vendor().setId(ID).setName(NAME);
        when(vendorRepository.findById(anyLong())).thenReturn(Optional.of(vendor));
        // when
        var vendorDTO = vendorService.findById(ID);
        // then
        assertNotNull(vendorDTO);
        assertEquals(NAME, vendorDTO.getName());
        assertEquals(VENDOR_URL, vendorDTO.getVendorUrl());
    }

    @Test
    void findByIdNotFoundException() {
        // given
        when(vendorRepository.findById(anyLong())).thenReturn(Optional.empty());
        // when
        Executable executable = () -> vendorService.findById(ID);
        // then
        assertThrows(ResourceNotFoundException.class, executable);
    }

    @Test
    void save() {
        // given
        var vendorDTO = new VendorDTO().setName(NAME);
        var vendor = new Vendor().setId(ID).setName(NAME);
        when(vendorRepository.save(any(Vendor.class))).thenReturn(vendor);
        // when
        var savedVendor = vendorService.save(vendorDTO);
        // then
        assertNotNull(savedVendor);
        assertEquals(NAME, savedVendor.getName());
        assertEquals(VENDOR_URL, savedVendor.getVendorUrl());
    }

    @Test
    void saveById() {
        // given
        var vendorDTO = new VendorDTO().setName(NAME);
        var vendor = new Vendor().setId(ID).setName(NAME);
        when(vendorRepository.save(any(Vendor.class))).thenReturn(vendor);
        // when
        var savedVendor = vendorService.save(vendorDTO, ID);
        // then
        assertNotNull(savedVendor);
        assertEquals(NAME, savedVendor.getName());
        assertEquals(VENDOR_URL, savedVendor.getVendorUrl());
    }

    @Test
    void patchName() {
        // given
        var vendor = new Vendor().setId(ID).setName(NAME);
        var vendorDTO = new VendorDTO().setName(NAME2);
        when(vendorRepository.findById(ID)).thenReturn(Optional.of(vendor));
        when(vendorRepository.save(any(Vendor.class))).thenAnswer(invocation -> invocation.getArgument(0));
        // when
        var savedVendorDTO = vendorService.patch(vendorDTO, ID);
        // then
        assertNotNull(savedVendorDTO);
        assertEquals(NAME2, savedVendorDTO.getName());
        assertEquals(VENDOR_URL, savedVendorDTO.getVendorUrl());
    }

    @Test
    void patchNotFoundException() {
        // given
        when(vendorRepository.findById(ID)).thenReturn(Optional.empty());
        // when
        Executable executable = () -> vendorService.patch(new VendorDTO(), ID);
        // then
        assertThrows(ResourceNotFoundException.class, executable);
    }

    @Test
    void deleteById() {
        // given
        // when
        vendorService.deleteById(ID);
        // then
        verify(vendorRepository).deleteById(anyLong());
    }

    @Test
    void deleteByIdNotFoundException() {
        // given
        doThrow(EmptyResultDataAccessException.class).when(vendorRepository).deleteById(anyLong());
        // when
        Executable executable = () -> vendorService.deleteById(ID);
        // then
        assertThrows(ResourceNotFoundException.class, executable);
    }

}