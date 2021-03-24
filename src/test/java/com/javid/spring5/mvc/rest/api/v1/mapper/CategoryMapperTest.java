package com.javid.spring5.mvc.rest.api.v1.mapper;

import com.javid.spring5.mvc.rest.domain.Category;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Javid on 3/24/2021.
 */

class CategoryMapperTest {

    private static final String NAME = new RandomString().nextString();
    private static final Long ID = Math.abs(new Random().nextLong());

    private CategoryMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = CategoryMapper.INSTANCE;
    }

    @Test
    void categoryToCategoryDto() {
        // given
        var category = new Category().setId(ID).setName(NAME);
        // when
        var categoryDTO = mapper.categoryToCategoryDto(category);
        // then
        assertNotNull(categoryDTO);
        assertEquals(ID, categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }
}