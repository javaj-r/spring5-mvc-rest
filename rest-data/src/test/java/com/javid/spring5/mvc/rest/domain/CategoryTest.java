package com.javid.spring5.mvc.rest.domain;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 4/8/2021.
 */

class CategoryTest {

    Category category;
    Category category1;

    @BeforeEach
    void setUp() {
        var id = new Random().nextLong();
        var name = new RandomString().nextString();

        category = new Category().setId(id).setName(name);
        category1 = new Category().setId(id).setName(name);
    }

    @Test
    void testEquals() {
        assertEquals(category, category);
        assertEquals(category1, category);
        assertNotEquals(category, new Category());
        assertNotEquals(category, new Object());
    }

    @Test
    void canEqual() {
        assertTrue(new Category().canEqual(new Category()));
        assertFalse(new Category().canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        assertEquals(category.hashCode(), category1.hashCode());
        assertNotEquals(category.hashCode(), new Category().hashCode());
    }

    @Test
    void testToString() {
        assertEquals(category.toString(), category1.toString());
        assertNotEquals(category.toString(), new Category().toString());
    }
}