package com.javid.spring5.mvc.rest.api.v1.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 3/27/2021.
 */

class CustomersDTOTest {

    CustomersDTO customersDTO;
    CustomersDTO customersDTO1;

    private List<CustomerDTO> customerDTOList;

    @BeforeEach
    void setUp() {
        customerDTOList = List.of(new CustomerDTO().setFirstName("fName1").setLastName("lName1").setCustomerUrl("url1"),
                new CustomerDTO().setFirstName("fName2").setLastName("lName2").setCustomerUrl("url2"));

        customersDTO = new CustomersDTO(customerDTOList);
        customersDTO1 = new CustomersDTO(customerDTOList);
    }

    @Test
    void testEquals() {
        assertEquals(customersDTO, customersDTO);
        assertEquals(customersDTO1, customersDTO);
        assertNotEquals(customersDTO,new CustomersDTO(List.of()));
        assertNotEquals(customersDTO,new Object());
    }

    @Test
    void canEqual() {
        assertTrue(new CustomersDTO(customerDTOList).canEqual(new CustomersDTO(List.of())));
        assertFalse(new CustomersDTO(customerDTOList).canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        assertEquals(customersDTO.hashCode(), customersDTO1.hashCode());
        assertNotEquals(customersDTO.hashCode(), new CustomersDTO(List.of()).hashCode());
    }

    @Test
    void testToString() {
        assertEquals(customersDTO.toString(), customersDTO1.toString());
        assertNotEquals(customersDTO.toString(), new CustomersDTO(List.of()).toString());
    }
}