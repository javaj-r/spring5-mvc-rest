package com.javid.spring5.mvc.rest.api.v1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Javid on 3/25/2021.
 */

@ApiModel(value = "Customers", description = "List of all customers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomersDTO {

    @ApiModelProperty(required = true, notes = "A list of customers", value = "Customers list")
    private List<CustomerDTO> customers;
}
