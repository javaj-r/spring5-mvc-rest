package com.javid.spring5.mvc.rest.api.v2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Javid on 3/27/2021.
 */

class CategoriesDTOTest {

    @Test
    void gettersAndSetters() {
        var categories = new CategoriesDTO();
        assertNotNull(categories.getCategories());
        categories.getCategories().add(new CategoryDTO());
        assertEquals(1, categories.getCategories().size());
    }

}