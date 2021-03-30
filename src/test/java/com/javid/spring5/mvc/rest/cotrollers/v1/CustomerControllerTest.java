package com.javid.spring5.mvc.rest.cotrollers.v1;

import com.javid.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.javid.spring5.mvc.rest.cotrollers.RestResponseEntityExceptionHandler;
import com.javid.spring5.mvc.rest.services.CustomerService;
import com.javid.spring5.mvc.rest.services.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static com.javid.spring5.mvc.rest.cotrollers.v1.JsonHandlerForTest.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Javid on 3/26/2021.
 */

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    public static final String FIRST_NAME = "Joe";
    public static final String LAST_NAME = "Dalton";
    public static final String CUSTOMER_URL = "/api/v1/customers/1";

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController)
                .setControllerAdvice(RestResponseEntityExceptionHandler.class)
                .build();
    }

    @Test
    void getCustomers() throws Exception {
        // given
        var customerDTOS = List.of(new CustomerDTO().setFirstName(FIRST_NAME).setLastName(LAST_NAME),
                new CustomerDTO().setFirstName("Averell").setLastName(LAST_NAME));
        when(customerService.findAll()).thenReturn(customerDTOS);
        // when
        mockMvc.perform(get("/api/v1/customers").contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers", hasSize(2)));
    }

    @Test
    void getCustomer() throws Exception {
        // given
        var customerDTO = new CustomerDTO().setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME).setCustomerUrl(CUSTOMER_URL);
        when(customerService.findById(anyLong())).thenReturn(customerDTO);
        // when
        mockMvc.perform(get(CUSTOMER_URL).contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", equalTo(FIRST_NAME)))
                .andExpect(jsonPath("$.lastname", equalTo(LAST_NAME)))
                .andExpect(jsonPath("$.customer_url", equalTo(CUSTOMER_URL)));
    }

    @Test
    void getCustomerNotFoundException() throws Exception {
        // given
        when(customerService.findById(anyLong())).thenThrow(ResourceNotFoundException.class);
        // when
        mockMvc.perform(get(CUSTOMER_URL).contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status_code", equalTo(404)))
                .andExpect(jsonPath("$.error", equalTo(RestResponseEntityExceptionHandler.RESOURCE_NOTFOUND)));
    }

    @Test
    void postNewCustomer() throws Exception {
        // given
        var customerDTO = new CustomerDTO().setFirstName(FIRST_NAME).setLastName(LAST_NAME);
        var savedCustomerDTO = new CustomerDTO().setFirstName(FIRST_NAME).setLastName(LAST_NAME).setCustomerUrl(CUSTOMER_URL);

        when(customerService.save(customerDTO)).thenReturn(savedCustomerDTO);
        // when
        mockMvc.perform(post("/api/v1/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customerDTO))
        )
                // then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstname", equalTo(FIRST_NAME)))
                .andExpect(jsonPath("$.lastname", equalTo(LAST_NAME)))
                .andExpect(jsonPath("$.customer_url", equalTo(CUSTOMER_URL)));
    }

    @Test
    void updateCustomer() throws Exception {
        // given
        var customerDTO = new CustomerDTO().setFirstName(FIRST_NAME).setLastName(LAST_NAME);
        var savedCustomerDTO = new CustomerDTO().setFirstName(FIRST_NAME).setLastName(LAST_NAME).setCustomerUrl(CUSTOMER_URL);

        when(customerService.save(any(CustomerDTO.class), anyLong())).thenReturn(savedCustomerDTO);
        // when
        mockMvc.perform(put(CUSTOMER_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customerDTO))
        )
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", equalTo(FIRST_NAME)))
                .andExpect(jsonPath("$.lastname", equalTo(LAST_NAME)))
                .andExpect(jsonPath("$.customer_url", equalTo(CUSTOMER_URL)));
    }

    @Test
    void patchCustomer() throws Exception {
        // given
        var customerDTO = new CustomerDTO().setFirstName(FIRST_NAME);
        var savedCustomerDTO = new CustomerDTO().setFirstName(FIRST_NAME).setLastName(LAST_NAME).setCustomerUrl(CUSTOMER_URL);

        when(customerService.patch(any(CustomerDTO.class), anyLong())).thenReturn(savedCustomerDTO);
        // when
        mockMvc.perform(patch(CUSTOMER_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customerDTO))
        )
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", equalTo(FIRST_NAME)))
                .andExpect(jsonPath("$.lastname", equalTo(LAST_NAME)))
                .andExpect(jsonPath("$.customer_url", equalTo(CUSTOMER_URL)));
    }

    @Test
    void patchCustomerNotFoundException() throws Exception {
        // given
        var customerDTO = new CustomerDTO().setFirstName(FIRST_NAME);
        when(customerService.patch(any(CustomerDTO.class) ,anyLong())).thenThrow(ResourceNotFoundException.class);
        // when
        mockMvc.perform(patch(CUSTOMER_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customerDTO))
        )
                // then
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status_code", equalTo(404)))
                .andExpect(jsonPath("$.error", equalTo(RestResponseEntityExceptionHandler.RESOURCE_NOTFOUND)));
    }

    @Test
    void deleteById() throws Exception {
        // given
        // when
        mockMvc.perform(delete(CUSTOMER_URL))
                // then
                .andExpect(status().isOk());

        verify(customerService).deleteById(anyLong());
    }

    @Test
    void deleteByIdNotFoundException() throws Exception {
        // given
        doThrow(ResourceNotFoundException.class).when(customerService).deleteById(anyLong());
        // when
        mockMvc.perform(delete(CUSTOMER_URL))
                // then
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status_code", equalTo(404)))
                .andExpect(jsonPath("$.error", equalTo(RestResponseEntityExceptionHandler.RESOURCE_NOTFOUND)));
    }
}