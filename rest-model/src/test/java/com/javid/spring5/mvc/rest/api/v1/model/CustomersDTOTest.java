package com.javid.spring5.mvc.rest.api.v1.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Javid on 3/27/2021.
 */

class CustomersDTOTest {

    @Test
    void allArgsConstructor() {
        assertEquals(1, new CustomersDTO(List.of(new CustomerDTO())).getCustomers().size());
    }

    @Test
    void gettersAndSetters() {
        new BeanTester().testBean(CustomersDTO.class);
    }

    @Test
    void equalsAndHashCode() {
        EqualsVerifier.simple().forClass(CustomersDTO.class).verify();
    }

}