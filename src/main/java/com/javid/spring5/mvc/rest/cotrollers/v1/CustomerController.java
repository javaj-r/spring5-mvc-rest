package com.javid.spring5.mvc.rest.cotrollers.v1;

import com.javid.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.javid.spring5.mvc.rest.api.v1.model.CustomersDTO;
import com.javid.spring5.mvc.rest.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Javid on 3/26/2021.
 */

@RequiredArgsConstructor
@RequestMapping(CustomerService.URL)
@Controller
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomersDTO> getCustomers() {
        return new ResponseEntity<>(new CustomersDTO(customerService.findAll()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable String id) {
        return new ResponseEntity<>(customerService.findById(Long.valueOf(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> postNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.sve(customerDTO), HttpStatus.CREATED);
    }
}
