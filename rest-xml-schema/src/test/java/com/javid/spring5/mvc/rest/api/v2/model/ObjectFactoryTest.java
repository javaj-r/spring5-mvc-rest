package com.javid.spring5.mvc.rest.api.v2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 4/10/2021.
 */

class ObjectFactoryTest {

    private final ObjectFactory factory = new ObjectFactory();

    @Test
    void createCategoriesDTO() {
        assertNotNull(factory.createCategoriesDTO());
    }

    @Test
    void createCustomersDTO() {
        assertNotNull(factory.createCustomersDTO());
    }

    @Test
    void createVendorsDTO() {
        assertNotNull(factory.createVendorsDTO());
    }

    @Test
    void createCategoryDTO() {
        assertNotNull(factory.createCategoryDTO());
    }

    @Test
    void createCustomerDTO() {
        assertNotNull(factory.createCustomerDTO());
    }

    @Test
    void createVendorDTO() {
        assertNotNull(factory.createVendorDTO());
    }

    @Test
    void testCreateCategoriesDTO() {
        assertTrue(factory.createCategoriesDTO(null).isNil());
        assertFalse(factory.createCategoriesDTO(new CategoriesDTO()).isNil());
    }

    @Test
    void testCreateCustomersDTO() {
        assertTrue(factory.createCustomersDTO(null).isNil());
        assertFalse(factory.createCustomersDTO(new CustomersDTO()).isNil());
    }

    @Test
    void testCreateVendorsDTO() {
        assertTrue(factory.createVendorsDTO(null).isNil());
        assertFalse(factory.createVendorsDTO(new VendorsDTO()).isNil());
    }
}