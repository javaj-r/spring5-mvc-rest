package com.javid.spring5.mvc.rest.api.v1.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Javid on 3/27/2021.
 */

class CategoryDTOTest {

    @Test
    void chainingSetters() {
        assertEquals(1L, new CategoryDTO().setId(1L).getId());
        assertEquals("j", new CategoryDTO().setName("j").getName());
    }

    @Test
    void gettersAndSetters() {
        new BeanTester().testBean(CategoryDTO.class);
    }

    @Test
    void equalsAndHashCode() {
        EqualsVerifier.simple().forClass(CategoryDTO.class).verify();
    }

}