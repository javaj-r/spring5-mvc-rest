package com.javid.spring5.mvc.rest.cotrollers.v1;

import com.javid.spring5.mvc.rest.api.v1.model.CategoriesDTO;
import com.javid.spring5.mvc.rest.api.v1.model.CategoryDTO;
import com.javid.spring5.mvc.rest.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Javid on 3/25/2021.
 */

@Api(tags = {"Categories"})
@Tag(name = "Categories", description = "Product categories api")
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @ApiOperation(value = "Lists of all the categories", notes = "<b>Response Class (Status 200)</b><br>Collection of categories")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoriesDTO getCategories() {
        return new CategoriesDTO(categoryService.findAll());
    }

    @ApiOperation(value = "Get a category by name", notes = "<b>Response Class (Status 200)</b><br>Existing category details")
    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategory(@PathVariable String name) {
        return categoryService.findByName(name);
    }

}
