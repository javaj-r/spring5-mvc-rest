package com.javid.spring5.mvc.rest.api.v1.model;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 3/27/2021.
 */

class CategoryDTOTest {

    CategoryDTO categoryDTO;
    CategoryDTO categoryDTO1;

    @BeforeEach
    void setUp() {
        var id = new Random().nextLong();
        var name = new RandomString().nextString();

        categoryDTO = new CategoryDTO().setId(id).setName(name);
        categoryDTO1 = new CategoryDTO().setId(id).setName(name);
    }

    @Test
    void testEquals() {
        assertEquals(categoryDTO, categoryDTO);
        assertEquals(categoryDTO1, categoryDTO);
        assertNotEquals(categoryDTO,new CategoryDTO());
        assertNotEquals(categoryDTO,new Object());
    }

    @Test
    void canEqual() {
        assertTrue(new CategoryDTO().canEqual(new CategoryDTO()));
        assertFalse(new CategoryDTO().canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        assertEquals(categoryDTO.hashCode(), categoryDTO1.hashCode());
        assertNotEquals(categoryDTO.hashCode(), new CategoryDTO().hashCode());
    }

    @Test
    void testToString() {
        assertEquals(categoryDTO.toString(), categoryDTO1.toString());
        assertNotEquals(categoryDTO.toString(), new CategoryDTO().toString());
    }
}