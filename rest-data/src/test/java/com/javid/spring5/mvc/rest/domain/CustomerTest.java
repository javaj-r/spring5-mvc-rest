package com.javid.spring5.mvc.rest.domain;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by Javid on 4/8/2021.
 */

class CustomerTest {

    @Test
    void chainingSetters() {
        assertEquals(1L, new Customer().setId(1L).getId());
        assertEquals("j", new Customer().setFirstName("j").getFirstName());
        assertEquals("j", new Customer().setLastName("j").getLastName());
    }

    @Test
    void gettersAndSetters() {
        new BeanTester().testBean(Customer.class);
    }

    @Test
    void equalsAndHashCode() {
        new EqualsMethodTester().testEqualsMethod(Customer.class);
        new HashCodeMethodTester().testHashCodeMethod(Customer.class);
    }

    @Test
    void testHashCode() {
        assertEquals(new Customer().setId(1L).setFirstName("F").setLastName("L").hashCode(),
                new Customer().setId(1L).setFirstName("F").setLastName("L").hashCode());
        assertNotEquals(new Customer().setId(1L).setFirstName("F").setLastName("L").hashCode(),
                new Customer().hashCode());
    }

}