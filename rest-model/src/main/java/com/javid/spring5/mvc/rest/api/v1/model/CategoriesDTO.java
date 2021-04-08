package com.javid.spring5.mvc.rest.api.v1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Javid on 3/25/2021.
 */

@ApiModel(value = "Categories", description = "List of all categories")
@AllArgsConstructor
@Data
public class CategoriesDTO {

    @ApiModelProperty(required = true, notes = "A list of all categories", value = "Categories list")
    private List<CategoryDTO> categories;

}
