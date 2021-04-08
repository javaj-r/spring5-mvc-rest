package com.javid.spring5.mvc.rest.api.v1.model;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 3/27/2021.
 */

class CustomerDTOTest {

    CustomerDTO customerDTO;
    CustomerDTO customerDTO1;

    @BeforeEach
    void setUp() {
        var fName = new RandomString().nextString();
        var lName = new RandomString().nextString();
        var url = new RandomString().nextString();

        customerDTO = new CustomerDTO().setFirstName(fName).setLastName(lName).setCustomerUrl(url);
        customerDTO1 = new CustomerDTO().setFirstName(fName).setLastName(lName).setCustomerUrl(url);
    }

    @Test
    void testEquals() {
        assertEquals(customerDTO, customerDTO);
        assertEquals(customerDTO1, customerDTO);
        assertNotEquals(customerDTO,new CustomerDTO());
        assertNotEquals(customerDTO,new Object());
    }

    @Test
    void canEqual() {
        assertTrue(new CustomerDTO().setFirstName("f").canEqual(new CustomerDTO()));
        assertFalse(new CustomerDTO().canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        assertEquals(customerDTO.hashCode(), customerDTO1.hashCode());
        assertNotEquals(customerDTO.hashCode(), new CustomerDTO().hashCode());
    }

    @Test
    void testToString() {
        assertEquals(customerDTO.toString(), customerDTO1.toString());
        assertNotEquals(customerDTO.toString(), new CustomerDTO().toString());
    }
}