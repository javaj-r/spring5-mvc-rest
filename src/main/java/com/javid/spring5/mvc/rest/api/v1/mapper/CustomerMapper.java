package com.javid.spring5.mvc.rest.api.v1.mapper;

import com.javid.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.javid.spring5.mvc.rest.domain.Customer;
import com.javid.spring5.mvc.rest.services.CustomerService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by Javid on 3/26/2021.
 */

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    default CustomerDTO customerToCustomerDtoWithUrl(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        return customerToCustomerDto(customer)
                .setCustomerUrl(CustomerService.URL + "/" + customer.getId());
    }

    CustomerDTO customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
