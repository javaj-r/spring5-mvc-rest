package com.javid.spring5.mvc.rest.cotrollers.v1;

import com.javid.spring5.mvc.rest.api.v1.model.VendorDTO;
import com.javid.spring5.mvc.rest.api.v1.model.VendorsDTO;
import com.javid.spring5.mvc.rest.services.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Javid on 3/29/2021.
 */

@Api(tags = "Vendors")
@Tag(name = "Vendors", description = "Vendors api")
@RequiredArgsConstructor
@RestController
@RequestMapping(VendorService.URL)
public class VendorController {

    private final VendorService vendorService;

    @ApiOperation(value = "Lists of all the vendors", notes = "<b>Response Class (Status 200)</b><br>Collection of vendors")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorsDTO getVendors() {
        return new VendorsDTO(vendorService.findAll());
    }

    @ApiOperation(value = "Get a vendor by id", notes = "<b>Response Class (Status 200)</b><br>Existing vendor details")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendor(@PathVariable String id) {
        return vendorService.findById(Long.valueOf(id));
    }

    @ApiOperation(value = "Create a new vendor", notes = "<b>Response Class (Status 200)</b><br>New vendor details")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO postNewVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.save(vendorDTO);
    }

    @ApiOperation(value = "Replace a vendor by new data", notes = "<b>Response Class (Status 200)</b><br>Updated vendor details")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable String id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.save(vendorDTO, Long.valueOf(id));
    }

    @ApiOperation(value = "Update an existing vendor", notes = "<b>Response Class (Status 200)</b><br>Updated vendor details")
    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@PathVariable String id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.patch(vendorDTO, Long.valueOf(id));
    }

    @ApiOperation(value = "Delete a vendor", notes = "<b>Response Class (Status 200)</b><br>no details")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable String id) {
        vendorService.deleteById(Long.valueOf(id));
    }

}
