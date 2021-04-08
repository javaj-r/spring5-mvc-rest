package com.javid.spring5.mvc.rest.api.v1.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 3/27/2021.
 */

class CategoriesDTOTest {

    CategoriesDTO categoriesDTO;
    CategoriesDTO categoriesDTO1;
    private List<CategoryDTO> categoryDTOList;

    @BeforeEach
    void setUp() {
         categoryDTOList = List.of(new CategoryDTO().setId(1L), new CategoryDTO().setId(2L));

        categoriesDTO = new CategoriesDTO(categoryDTOList);
        categoriesDTO1 = new CategoriesDTO(categoryDTOList);
    }

    @Test
    void testEquals() {
        assertEquals(categoriesDTO, categoriesDTO);
        assertEquals(categoriesDTO1, categoriesDTO);
        assertNotEquals(categoriesDTO,new CategoriesDTO(List.of()));
        assertNotEquals(categoriesDTO,new Object());
    }

    @Test
    void canEqual() {
        assertTrue(new CategoriesDTO(categoryDTOList).canEqual(new CategoriesDTO(List.of())));
        assertFalse(new CategoriesDTO(categoryDTOList).canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        assertEquals(categoriesDTO.hashCode(), categoriesDTO1.hashCode());
        assertNotEquals(categoriesDTO.hashCode(), new CategoriesDTO(List.of()).hashCode());
    }

    @Test
    void testToString() {
        assertEquals(categoriesDTO.toString(), categoriesDTO1.toString());
        assertNotEquals(categoriesDTO.toString(), new CategoriesDTO(List.of()).toString());
    }
}