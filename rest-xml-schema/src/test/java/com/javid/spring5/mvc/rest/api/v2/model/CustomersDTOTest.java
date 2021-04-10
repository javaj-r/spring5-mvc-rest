package com.javid.spring5.mvc.rest.api.v2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Javid on 3/27/2021.
 */

class CustomersDTOTest {

    @Test
    void gettersAndSetters() {
        var customers = new CustomersDTO();
        assertNotNull(customers.getCustomers());
        customers.getCustomers().add(new CustomerDTO());
        assertEquals(1, customers.getCustomers().size());
    }

}