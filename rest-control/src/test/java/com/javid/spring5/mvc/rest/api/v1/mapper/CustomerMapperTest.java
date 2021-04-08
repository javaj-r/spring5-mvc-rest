package com.javid.spring5.mvc.rest.api.v1.mapper;

import com.javid.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.javid.spring5.mvc.rest.domain.Customer;
import com.javid.spring5.mvc.rest.services.CustomerService;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 3/26/2021.
 */

class CustomerMapperTest {

    private static final String FIRST_NAME = new RandomString().nextString();
    private static final String LAST_NAME = new RandomString().nextString();
    private static final Long ID = Math.abs(new Random().nextLong());
    private static final String CUSTOMER_URL = CustomerService.URL + "/" + ID;

    private CustomerMapper customerMapper;

    @BeforeEach
    void setUp() {
        customerMapper = CustomerMapper.INSTANCE;
    }

    @Test
    void customerToCustomerDto() {
        // given
        var customer = new Customer().setId(ID).setFirstName(FIRST_NAME).setLastName(LAST_NAME);
        // when
        var customerDTO = customerMapper.customerToCustomerDto(customer);
        // then
        assertNotNull(customerDTO);
        assertEquals(FIRST_NAME, customerDTO.getFirstName());
        assertEquals(LAST_NAME, customerDTO.getLastName());
        assertNull(customerDTO.getCustomerUrl());
    }

    @Test
    void customerToCustomerDtoWhenNull() {
        // given
        // when
        var customerDTO = customerMapper.customerToCustomerDto(null);
        // then
        assertNull(customerDTO);
    }

    @Test
    void customerToCustomerDtoWithUrl() {
        // given
        var customer = new Customer().setId(ID).setFirstName(FIRST_NAME).setLastName(LAST_NAME);
        // when
        var customerDTO = customerMapper.customerToCustomerDtoWithUrl(customer);
        // then
        assertNotNull(customerDTO);
        assertEquals(FIRST_NAME, customerDTO.getFirstName());
        assertEquals(LAST_NAME, customerDTO.getLastName());
        assertEquals(CUSTOMER_URL, customerDTO.getCustomerUrl());
    }

    @Test
    void customerToCustomerDtoWithUrlWhenNull() {
        // given
        // when
        var customerDTO = customerMapper.customerToCustomerDtoWithUrl(null);
        // then
        assertNull(customerDTO);
    }

    @Test
    void customerDtoToCustomer() {
        // given
        var customerDTO = new CustomerDTO().setFirstName(FIRST_NAME).setLastName(LAST_NAME);
        // when
        var customer = customerMapper.customerDtoToCustomer(customerDTO);
        // then
        assertNotNull(customer);
        assertEquals(FIRST_NAME, customer.getFirstName());
        assertEquals(LAST_NAME, customer.getLastName());
    }

    @Test
    void customerDtoToCustomerWhenNull() {
        // given
        // when
        var customer = customerMapper.customerDtoToCustomer(null);
        // then
        assertNull(customer);
    }

}