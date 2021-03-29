package com.javid.spring5.mvc.rest.services;

import com.javid.spring5.mvc.rest.api.v1.mapper.CategoryMapper;
import com.javid.spring5.mvc.rest.api.v1.model.CategoryDTO;
import com.javid.spring5.mvc.rest.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Javid on 3/25/2021.
 */

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findByName(String name) {
        return categoryRepository
                .findByName(name)
                .map(categoryMapper::categoryToCategoryDto)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
