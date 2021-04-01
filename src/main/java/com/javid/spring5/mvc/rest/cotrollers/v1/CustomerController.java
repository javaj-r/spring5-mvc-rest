package com.javid.spring5.mvc.rest.cotrollers.v1;

import com.javid.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.javid.spring5.mvc.rest.api.v1.model.CustomersDTO;
import com.javid.spring5.mvc.rest.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Javid on 3/26/2021.
 */

@Api(tags = "Customers")
@Tag(name = "Customers", description = "Customers api")
@RequiredArgsConstructor
@RequestMapping(CustomerService.URL)
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @ApiOperation(value = "Lists of all the customers", notes = "<b>Response Class (Status 200)</b><br>Collection of customers")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomersDTO getCustomers() {
        return new CustomersDTO(customerService.findAll());
    }

    @ApiOperation(value = "Get a customer by id", notes = "<b>Response Class (Status 200)</b><br>Existing customer details")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomer(@PathVariable String id) {
        return customerService.findById(Long.valueOf(id));
    }

    @ApiOperation(value = "Create a new customer", notes = "<b>Response Class (Status 200)</b><br>New customer details")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO postNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }

    @ApiOperation(value = "Replace a customer by new data", notes = "<b>Response Class (Status 200)</b><br>Updated customer details")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO, Long.valueOf(id));
    }

    @ApiOperation(value = "Update an existing customer", notes = "<b>Response Class (Status 200)</b><br>Updated customer details")
    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
        return customerService.patch(customerDTO, Long.valueOf(id));
    }

    @ApiOperation(value = "Delete a customer", notes = "<b>Response Class (Status 200)</b><br>no details")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable String id) {
        customerService.deleteById(Long.valueOf(id));
    }

}
