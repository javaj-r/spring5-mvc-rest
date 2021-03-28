package com.javid.spring5.mvc.rest.services;

import com.javid.spring5.mvc.rest.api.v1.mapper.CustomerMapper;
import com.javid.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.javid.spring5.mvc.rest.domain.Customer;
import com.javid.spring5.mvc.rest.repositories.CustomerRepository;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Javid on 3/26/2021.
 */

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    private static final String FIRST_NAME = new RandomString().nextString();
    private static final String LAST_NAME = new RandomString().nextString();
    private static final Long ID = Math.abs(new Random().nextLong());
    private static final String CUSTOMER_URL = CustomerService.URL + "/" + ID;
    private static final String FIRST_NAME2 = new RandomString().nextString();
    private static final String LAST_NAME2 = new RandomString().nextString();
    private static final Long ID2 = Math.abs(new Random().nextLong());

    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    void findAll() {
        // given
        var customerList = List.of(new Customer().setId(ID).setFirstName(FIRST_NAME).setLastName(LAST_NAME),
                new Customer().setId(ID2).setFirstName(FIRST_NAME2).setLastName(LAST_NAME2));
        when(customerRepository.findAll()).thenReturn(customerList);
        // when
        var customerDTOList = customerService.findAll();
        // then
        assertNotNull(customerDTOList);
        assertEquals(customerList.size(), customerDTOList.size());
    }

    @Test
    void findById() {
        // given
        var customer = new Customer().setId(ID).setFirstName(FIRST_NAME).setLastName(LAST_NAME);
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));
        // when
        var customerDTO = customerService.findById(ID);
        // then
        assertNotNull(customerDTO);
        assertEquals(FIRST_NAME, customerDTO.getFirstName());
        assertEquals(LAST_NAME, customerDTO.getLastName());
        assertEquals(CUSTOMER_URL, customerDTO.getCustomerUrl());
    }

    @Test
    void findByIdWhenNotExists() {
        // given
        when(customerRepository.findById(anyLong())).thenReturn(Optional.empty());
        // when
        var customerDTO = customerService.findById(ID);
        // then
        assertNull(customerDTO);
    }

    @Test
    void save() {
        // given
        var customerDTO = new CustomerDTO().setFirstName(FIRST_NAME).setLastName(LAST_NAME);
        var customer = new Customer().setId(ID).setFirstName(FIRST_NAME).setLastName(LAST_NAME);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        // when
        var savedCustomerDTO = customerService.save(customerDTO);
        // then
        assertNotNull(savedCustomerDTO);
        assertEquals(FIRST_NAME, savedCustomerDTO.getFirstName());
        assertEquals(LAST_NAME, savedCustomerDTO.getLastName());
        assertEquals(CUSTOMER_URL, savedCustomerDTO.getCustomerUrl());
    }

    @Test
    void saveById() {
        // given
        var customerDTO = new CustomerDTO().setFirstName(FIRST_NAME).setLastName(LAST_NAME);
        var customer = new Customer().setId(ID).setFirstName(FIRST_NAME).setLastName(LAST_NAME);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        // when
        var savedCustomerDTO = customerService.save(customerDTO, ID);
        // then
        assertNotNull(savedCustomerDTO);
        assertEquals(FIRST_NAME, savedCustomerDTO.getFirstName());
        assertEquals(LAST_NAME, savedCustomerDTO.getLastName());
        assertEquals(CUSTOMER_URL, savedCustomerDTO.getCustomerUrl());
    }

    @Test
    void deleteById() {
        // given
        // when
        customerService.deleteById(ID);
        // then
        verify(customerRepository).deleteById(anyLong());
    }
}