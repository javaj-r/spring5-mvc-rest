package com.javid.spring5.mvc.rest.cotrollers.v1;

import com.javid.spring5.mvc.rest.api.v1.model.VendorDTO;
import com.javid.spring5.mvc.rest.api.v1.model.VendorsDTO;
import com.javid.spring5.mvc.rest.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendor(@PathVariable String id) {
        return vendorService.findById(Long.valueOf(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO postNewVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.save(vendorDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable String id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.save(vendorDTO, Long.valueOf(id));
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@PathVariable String id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.patch(vendorDTO, Long.valueOf(id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable String id) {
        vendorService.deleteById(Long.valueOf(id));
    }

}
