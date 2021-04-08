package com.javid.spring5.mvc.rest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Javid on 3/25/2021.
 */

@ApiModel(value = "Customer", description = "Customer person")
@Data
@Accessors(chain = true)
public class CustomerDTO {

    @ApiModelProperty(required = true, value = "First Name of the customer")
    @JsonProperty("firstname")
    private String firstName;

    @ApiModelProperty(required = true, value = "Last Name of the customer")
    @JsonProperty("lastname")
    private String lastName;

    @ApiModelProperty(example = "http://loclahost:8080/customers/1", value = "Customer url")
    @JsonProperty("customer_url")
    private String customerUrl;
}
