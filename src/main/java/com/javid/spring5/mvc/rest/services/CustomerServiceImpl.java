package com.javid.spring5.mvc.rest.services;

import com.javid.spring5.mvc.rest.api.v1.mapper.CustomerMapper;
import com.javid.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.javid.spring5.mvc.rest.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Javid on 3/26/2021.
 */

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository
                .findAll()
                .stream()
                .map(customerMapper::customerToCustomerDtoWithUrl)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        return customerRepository
                .findById(id)
                .map(customerMapper::customerToCustomerDtoWithUrl)
                .orElse(null);
    }
}
