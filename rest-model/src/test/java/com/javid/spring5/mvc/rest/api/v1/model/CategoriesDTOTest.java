package com.javid.spring5.mvc.rest.api.v1.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Javid on 3/27/2021.
 */

class CategoriesDTOTest {

    @Test
    void allArgsConstructor() {
        assertEquals(1, new CategoriesDTO(List.of(new CategoryDTO())).getCategories().size());
    }

    @Test
    void gettersAndSetters() {
        new BeanTester().testBean(CategoriesDTO.class);
    }

    @Test
    void equalsAndHashCode() {
        EqualsVerifier.simple().forClass(CategoriesDTO.class).verify();
    }

}