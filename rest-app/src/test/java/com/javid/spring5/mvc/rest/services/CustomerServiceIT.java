package com.javid.spring5.mvc.rest.services;

import com.javid.spring5.mvc.rest.api.v1.mapper.CustomerMapper;
import com.javid.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.javid.spring5.mvc.rest.domain.Customer;
import com.javid.spring5.mvc.rest.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 3/28/2021.
 */

@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomerServiceIT {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    private final RandomString random = new RandomString();

    private String firstname;
    private String lastname;
    private String updateFirstname;
    private String updateLastname;
    private Long id;

    @Autowired
    public CustomerServiceIT(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @BeforeEach
    void setUp() {
        firstname = random.nextString();
        lastname = random.nextString();
        updateFirstname = random.nextString();
        updateLastname = random.nextString();

        // given
        id = customerRepository.save(new Customer().setFirstName(firstname).setLastName(lastname)).getId();
    }

    @RepeatedTest(value = 5, name = "patch firstname {currentRepetition} of {totalRepetitions}")
    void patchFirstName() {
        // when
        var customerDTO = customerService.patch(new CustomerDTO().setFirstName(updateFirstname), id);

        var updatedCustomer = customerRepository.findById(id).orElseThrow(RuntimeException::new);

        // then
        assertNotNull(updatedCustomer);
        assertNotEquals(firstname, updatedCustomer.getFirstName());
        assertEquals(updateFirstname, updatedCustomer.getFirstName());
        assertEquals(lastname, updatedCustomer.getLastName());
        assertEquals(updateFirstname, customerDTO.getFirstName());
        assertEquals(lastname, customerDTO.getLastName());
        assertEquals(CustomerService.URL + "/" + id, customerDTO.getCustomerUrl());
    }

    @RepeatedTest(value = 5, name = "patch lastname {currentRepetition} of {totalRepetitions}")
    void patchLastName() {
        // when
        var customerDTO = customerService.patch(new CustomerDTO().setLastName(updateLastname), id);

        var updatedCustomer = customerRepository.findById(id).orElseThrow(RuntimeException::new);

        // then
        assertNotNull(updatedCustomer);
        assertNotEquals(lastname, updatedCustomer.getLastName());
        assertEquals(updateLastname, updatedCustomer.getLastName());
        assertEquals(firstname, updatedCustomer.getFirstName());
        assertEquals(firstname, customerDTO.getFirstName());
        assertEquals(updateLastname, customerDTO.getLastName());
        assertEquals(CustomerService.URL + "/" + id, customerDTO.getCustomerUrl());
    }

    @Test
    void patchNotFoundException() {
        // given
        var notExistingId = id * 2;
        // when
        Executable executable = () -> customerService.patch(new CustomerDTO(), notExistingId);
        // then
        assertThrows(ResourceNotFoundException.class, executable);
    }

}