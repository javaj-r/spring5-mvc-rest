package com.javid.spring5.mvc.rest.domain;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 4/8/2021.
 */

class CustomerTest {

    Customer customer;
    Customer customer1;

    @BeforeEach
    void setUp() {
        var id = new Random().nextLong();
        var fName = new RandomString().nextString();
        var lName = new RandomString().nextString();

        customer = new Customer().setId(id).setFirstName(fName).setLastName(lName);
        customer1 = new Customer().setId(id).setFirstName(fName).setLastName(lName);
    }

    @Test
    void testEquals() {
        assertEquals(customer, customer);
        assertEquals(customer1, customer);
        assertNotEquals(customer, new Customer().setId(1L));
        assertNotEquals(customer, new Customer().setId(1L).setFirstName("som"));
        assertNotEquals(customer, new Customer().setId(1L).setFirstName("som").setLastName("a"));
        assertNotEquals(customer, new Object());
    }

    @Test
    void canEqual() {
        assertTrue(new Customer().setFirstName("f").canEqual(new Customer()));
        assertFalse(new Customer().canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        assertEquals(customer.hashCode(), customer1.hashCode());
        assertNotEquals(customer.hashCode(), new Customer().hashCode());
    }

    @Test
    void testToString() {
        assertEquals(customer.toString(), customer1.toString());
        assertNotEquals(customer.toString(), new Customer().toString());
    }
}