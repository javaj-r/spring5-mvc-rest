package com.javid.spring5.mvc.rest.cotrollers.v1;

import com.javid.spring5.mvc.rest.api.v1.model.CategoriesDTO;
import com.javid.spring5.mvc.rest.api.v1.model.CategoryDTO;
import com.javid.spring5.mvc.rest.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Javid on 3/25/2021.
 */

@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoriesDTO getCategories() {
        return new CategoriesDTO(categoryService.findAll());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategory(@PathVariable String name) {
        return categoryService.findByName(name);
    }

}
