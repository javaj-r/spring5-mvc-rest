package com.javid.spring5.mvc.rest.cotrollers.v1;

import com.javid.spring5.mvc.rest.api.v1.model.VendorDTO;
import com.javid.spring5.mvc.rest.cotrollers.RestResponseEntityExceptionHandler;
import com.javid.spring5.mvc.rest.services.ResourceNotFoundException;
import com.javid.spring5.mvc.rest.services.VendorService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Javid on 3/29/2021.
 */

@ExtendWith(MockitoExtension.class)
class VendorControllerTest {

    public static final String NAME = "Dalton Group";
    public static final String VENDOR_URL = "/api/v1/vendors/1";

    @Mock
    VendorService vendorService;

    @InjectMocks
    VendorController vendorController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(vendorController)
                .setControllerAdvice(RestResponseEntityExceptionHandler.class)
                .build();
    }

    @Test
    void getVendors() throws Exception {
        // given
        var vendorDTOS = List.of(new VendorDTO().setName(NAME).setVendorUrl(VENDOR_URL),
                new VendorDTO().setName("Lucky Look").setVendorUrl("/api/v1/vendors/2"));
        when(vendorService.findAll()).thenReturn(vendorDTOS);
        // when
        mockMvc.perform(get("/api/v1/vendors").contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vendors", hasSize(2)));
    }

    @Test
    void getVendor() throws Exception {
        // given
        var vendorDTO = new VendorDTO().setName(NAME).setVendorUrl(VENDOR_URL);
        when(vendorService.findById(anyLong())).thenReturn(vendorDTO);
        // when
        mockMvc.perform(get(VENDOR_URL).contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(NAME)))
                .andExpect(jsonPath("$.vendor_url", equalTo(VENDOR_URL)));
    }

    @Test
    void getVendorNotFoundException() throws Exception {
        // given
        when(vendorService.findById(anyLong())).thenThrow(ResourceNotFoundException.class);
        // when
        mockMvc.perform(get(VENDOR_URL).contentType(MediaType.APPLICATION_JSON))
                // then
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status_code", equalTo(404)))
                .andExpect(jsonPath("$.error", equalTo(RestResponseEntityExceptionHandler.RESOURCE_NOTFOUND)));
    }

    @Test
    void postNewVendor() throws Exception {
        // given
        var vendorDTO = new VendorDTO().setName(NAME);
        var savedVendorDTO = new VendorDTO().setName(NAME).setVendorUrl(VENDOR_URL);

        when(vendorService.save(vendorDTO)).thenReturn(savedVendorDTO);
        // when
        mockMvc.perform(post("/api/v1/vendors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(vendorDTO))
        )
                // then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", equalTo(NAME)))
                .andExpect(jsonPath("$.vendor_url", equalTo(VENDOR_URL)));
    }

    @Test
    void updateVendor() throws Exception {
        // given
        var vendorDTO = new VendorDTO().setName(NAME);
        var savedVendorDTO = new VendorDTO().setName(NAME).setVendorUrl(VENDOR_URL);

        when(vendorService.save(any(VendorDTO.class), anyLong())).thenReturn(savedVendorDTO);
        // when
        mockMvc.perform(put(VENDOR_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(vendorDTO))
        )
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(NAME)))
                .andExpect(jsonPath("$.vendor_url", equalTo(VENDOR_URL)));
    }

    @Test
    void patchVendor() throws Exception {
        // given
        var vendorDTO = new VendorDTO().setName(NAME);
        var savedVendorDTO = new VendorDTO().setName(NAME).setVendorUrl(VENDOR_URL);

        when(vendorService.patch(any(VendorDTO.class), anyLong())).thenReturn(savedVendorDTO);
        // when
        mockMvc.perform(patch(VENDOR_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(vendorDTO))
        )
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(NAME)))
                .andExpect(jsonPath("$.vendor_url", equalTo(VENDOR_URL)));
    }

    @Test
    void patchVendorNotFoundException() throws Exception {
        // given
        var vendorDTO = new VendorDTO().setName(NAME);
        when(vendorService.patch(any(VendorDTO.class), anyLong())).thenThrow(ResourceNotFoundException.class);
        // when
        mockMvc.perform(patch(VENDOR_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(vendorDTO))
        )
                // then
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status_code", equalTo(404)))
                .andExpect(jsonPath("$.error", equalTo(RestResponseEntityExceptionHandler.RESOURCE_NOTFOUND)));
    }

}