package com.javid.spring5.mvc.rest.api.v1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Javid on 3/24/2021.
 */

@ApiModel(value = "Category", description = "Category of product")
@Data
@Accessors(chain = true)
public class CategoryDTO {

    @ApiModelProperty(value = "Id of the category")
    private Long id;

    @ApiModelProperty(required = true, value = "Name of the category")
    private String name;
}
