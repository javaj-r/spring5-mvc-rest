package com.javid.spring5.mvc.rest.api.v1.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Javid on 3/27/2021.
 */

class CustomerDTOTest {

    @Test
    void chainingSetters() {
        assertEquals("j", new CustomerDTO().setFirstName("j").getFirstName());
        assertEquals("j", new CustomerDTO().setLastName("j").getLastName());
        assertEquals("j", new CustomerDTO().setCustomerUrl("j").getCustomerUrl());
    }

    @Test
    void gettersAndSetters() {
        new BeanTester().testBean(CustomerDTO.class);
    }

    @Test
    void equalsAndHashCode() {
        EqualsVerifier.simple().forClass(CustomerDTO.class).verify();
    }

}