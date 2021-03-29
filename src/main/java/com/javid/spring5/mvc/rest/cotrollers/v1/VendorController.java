package com.javid.spring5.mvc.rest.cotrollers.v1;

import com.javid.spring5.mvc.rest.api.v1.model.VendorsDTO;
import com.javid.spring5.mvc.rest.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Javid on 3/29/2021.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(VendorService.URL)
public class VendorController {

    private final VendorService vendorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorsDTO getVendors() {
        return new VendorsDTO(vendorService.findAll());
    }
}
