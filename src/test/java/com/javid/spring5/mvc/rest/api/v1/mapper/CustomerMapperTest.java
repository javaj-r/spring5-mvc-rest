package com.javid.spring5.mvc.rest.api.v1.mapper;

import com.javid.spring5.mvc.rest.domain.Customer;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Javid on 3/26/2021.
 */

class CustomerMapperTest {

    private static final String FIRST_NAME = new RandomString().nextString();
    private static final String LAST_NAME = new RandomString().nextString();
    private static final Long ID = Math.abs(new Random().nextLong());

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
    }
}