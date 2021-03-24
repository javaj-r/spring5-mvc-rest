package com.javid.spring5.mvc.rest.api.v1.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Javid on 3/24/2021.
 */

@Data
@Accessors(chain = true)
public class CategoryDTO {
    private Long id;
    private String name;
}
