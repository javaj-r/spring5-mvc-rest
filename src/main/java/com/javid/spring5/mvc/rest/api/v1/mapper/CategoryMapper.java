package com.javid.spring5.mvc.rest.api.v1.mapper;

import com.javid.spring5.mvc.rest.api.v1.model.CategoryDTO;
import com.javid.spring5.mvc.rest.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by Javid on 3/24/2021.
 */

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDto(Category category);
}
