package com.javid.spring5.mvc.rest.cotrollers.v1;

import com.javid.spring5.mvc.rest.api.v1.model.CategoryDTO;
import com.javid.spring5.mvc.rest.cotrollers.RestResponseEntityExceptionHandler;
import com.javid.spring5.mvc.rest.services.CategoryService;
import com.javid.spring5.mvc.rest.services.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Javid on 3/25/2021.
 */

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    private static final String NAME = "Fruit";

    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .setControllerAdvice(RestResponseEntityExceptionHandler.class)
                .build();
    }

    @Test
    void getCategory() throws Exception {
        // given
        when(categoryService.findByName(anyString())).thenReturn(new CategoryDTO().setId(1L).setName(NAME));
        // when
        mockMvc.perform(get("/api/v1/categories/fruit")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(NAME)));
    }

    @Test
    void getCategoryNotFoundException() throws Exception {
        // given
        when(categoryService.findByName(anyString())).thenThrow(ResourceNotFoundException.class);
        // when
        mockMvc.perform(get("/api/v1/categories/fruit").contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status_code", equalTo(404)))
                .andExpect(jsonPath("$.error", equalTo(RestResponseEntityExceptionHandler.RESOURCE_NOTFOUND)));
    }

    @Test
    void getCategories() throws Exception {
        // given
        when(categoryService.findAll()).thenReturn(
                List.of(new CategoryDTO().setId(1L).setName(NAME), new CategoryDTO().setId(2L).setName("NUts")));
        // when
        mockMvc.perform(get("/api/v1/categories")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories", hasSize(2)));
    }

}