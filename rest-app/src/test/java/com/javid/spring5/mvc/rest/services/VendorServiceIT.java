package com.javid.spring5.mvc.rest.services;

import com.javid.spring5.mvc.rest.api.v1.mapper.VendorMapper;
import com.javid.spring5.mvc.rest.api.v1.model.VendorDTO;
import com.javid.spring5.mvc.rest.domain.Vendor;
import com.javid.spring5.mvc.rest.repositories.VendorRepository;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 3/30/2021.
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest
class VendorServiceIT {

    private final VendorRepository vendorRepository;
    private final VendorService vendorService;
    private final RandomString random = new RandomString();

    private String name;
    private String updateName;

    @Autowired
    VendorServiceIT(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
        this.vendorService = new VendorServiceImpl(vendorRepository, VendorMapper.INSTANCE);
    }

    @BeforeEach
    void setUp() {
        name = random.nextString();
        updateName = random.nextString();
    }

    @RepeatedTest(value = 5, name = "patch name {currentRepetition} of {totalRepetitions}")
    void patchName() {
        // given
        var id = vendorRepository.save(new Vendor().setName(name)).getId();
        // when
        var vendorDTO = vendorService.patch(new VendorDTO().setName(updateName), id);
        var updatedVendor = vendorRepository.findById(id).orElseThrow(RuntimeException::new);
        // then
        assertNotNull(updatedVendor);
        assertNotEquals(name, updatedVendor.getName());
        assertEquals(updateName, updatedVendor.getName());
        assertEquals(updateName, vendorDTO.getName());
        assertEquals(VendorService.URL + "/" + id, vendorDTO.getVendorUrl());
    }

    @Test
    void patchNotFoundException() {
        // given
        var id = vendorRepository.save(new Vendor().setName(name)).getId();
        var notExistingId = id * 2;
        // when
        Executable executable =()-> vendorService.patch(new VendorDTO().setName(updateName), notExistingId);
        // then
        assertThrows(ResourceNotFoundException.class, executable);
    }

}