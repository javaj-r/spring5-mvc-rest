package com.javid.spring5.mvc.rest.cotrollers.v1;

import com.javid.spring5.mvc.rest.api.v1.model.CategoriesDTO;
import com.javid.spring5.mvc.rest.api.v1.model.CategoryDTO;
import com.javid.spring5.mvc.rest.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Javid on 3/25/2021.
 */

@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
@Controller
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<CategoriesDTO> getCategories() {
        return new ResponseEntity<>(new CategoriesDTO(categoryService.findAll()), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable String name) {
        return new ResponseEntity<>(categoryService.findByName(name), HttpStatus.OK);
    }

}
