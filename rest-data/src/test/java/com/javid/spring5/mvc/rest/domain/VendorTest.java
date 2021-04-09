package com.javid.spring5.mvc.rest.domain;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by Javid on 4/8/2021.
 */

class VendorTest {

    @Test
    void chainingSetters() {
        assertEquals(1L, new Vendor().setId(1L).getId());
        assertEquals("j", new Vendor().setName("j").getName());
    }

    @Test
    void gettersAndSetters() {
        new BeanTester().testBean(Vendor.class);
    }

    @Test
    void equalsAndHashCode() {
        new EqualsMethodTester().testEqualsMethod(Vendor.class);
//        new HashCodeMethodTester().testHashCodeMethod(Vendor.class);
    }

    @Test
    void testHashCode() {
        assertEquals(new Vendor().setId(1L).setName("name").hashCode(),
                new Vendor().setId(1L).setName("name").hashCode());
        assertNotEquals(new Vendor().setId(1L).setName("name").hashCode(),
                new Vendor().hashCode());
    }

}