package com.javid.spring5.mvc.rest.services;

import com.javid.spring5.mvc.rest.api.v1.mapper.CategoryMapper;
import com.javid.spring5.mvc.rest.domain.Category;
import com.javid.spring5.mvc.rest.repositories.CategoryRepository;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Javid on 3/25/2021.
 */

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    private static final String NAME = new RandomString().nextString();
    private static final Long ID = Math.abs(new Random().nextLong());
    private static final String NAME2 = new RandomString().nextString();
    private static final Long ID2 = Math.abs(new Random().nextLong());

    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryService = new CategoryServiceImpl(categoryRepository, CategoryMapper.INSTANCE);
    }

    @Test
    void findAll() {
        // given
        var categories = List.of(new Category().setId(ID).setName(NAME), new Category().setId(ID2).setName(NAME));
        when(categoryRepository.findAll()).thenReturn(categories);
        // when
        var categoryDTOs = categoryService.findAll();
        // then
        assertNotNull(categoryDTOs);
        assertEquals(categories.size(), categoryDTOs.size());
    }

    @Test
    void findByName() {
        // given
        var category = new Category().setId(ID).setName(NAME);
        when(categoryRepository.findByName(anyString())).thenReturn(Optional.of(category));
        // when
        var categoryDTO = categoryService.findByName(NAME);
        // then
        assertNotNull(categoryDTO);
        assertEquals(ID, categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }

    @Test
    void findByNameWhenNull() {
        // given
        when(categoryRepository.findByName(anyString())).thenReturn(Optional.empty());
        // when
        var categoryDTO = categoryService.findByName(NAME);
        // then
        assertNull(categoryDTO);
    }
}