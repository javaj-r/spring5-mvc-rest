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

class CategoryTest {

    @Test
    void chainingSetters() {
        assertEquals(1L, new Category().setId(1L).getId());
        assertEquals("j", new Category().setName("j").getName());
    }

    @Test
    void gettersAndSetters() {
        new BeanTester().testBean(Category.class);
    }

    @Test
    void equalsAndHashCode() {
        new EqualsMethodTester().testEqualsMethod(Category.class);
        new HashCodeMethodTester().testHashCodeMethod(Category.class);
    }

    @Test
    void testHashCode() {
        assertEquals(new Category().setId(1L).setName("N").hashCode(),
                new Category().setId(1L).setName("N").hashCode());
        assertNotEquals(new Category().setId(1L).setName("N").hashCode(), new Category().hashCode());
    }
}