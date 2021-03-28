package com.javid.spring5.mvc.rest.services;

import com.javid.spring5.mvc.rest.api.v1.model.CustomerDTO;

import java.util.List;

/**
 * Created by Javid on 3/26/2021.
 */

public interface CustomerService {

    String URL = "/api/v1/customers";

    List<CustomerDTO> findAll();

    CustomerDTO findById(Long id);

    CustomerDTO save(CustomerDTO customerDTO);

    CustomerDTO save(CustomerDTO customerDTO, Long id);
}
