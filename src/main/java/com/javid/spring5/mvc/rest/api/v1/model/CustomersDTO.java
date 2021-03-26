package com.javid.spring5.mvc.rest.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Javid on 3/25/2021.
 */

@AllArgsConstructor
@Data
public class CustomersDTO {

    private List<CustomerDTO> customers;
}
