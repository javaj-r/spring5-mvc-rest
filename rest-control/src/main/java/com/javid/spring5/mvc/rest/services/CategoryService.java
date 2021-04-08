package com.javid.spring5.mvc.rest.services;

import com.javid.spring5.mvc.rest.api.v1.model.CategoryDTO;

import java.util.List;

/**
 * Created by Javid on 3/25/2021.
 */

public interface CategoryService {

    List<CategoryDTO> findAll();

    CategoryDTO findByName(String name);
}
