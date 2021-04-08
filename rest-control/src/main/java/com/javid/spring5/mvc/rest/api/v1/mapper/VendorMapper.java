package com.javid.spring5.mvc.rest.api.v1.mapper;

import com.javid.spring5.mvc.rest.api.v1.model.VendorDTO;
import com.javid.spring5.mvc.rest.domain.Vendor;
import com.javid.spring5.mvc.rest.services.VendorService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by Javid on 3/29/2021.
 */

@Mapper
public interface VendorMapper {
    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    default VendorDTO vendorToVendorDtoWithUrl(Vendor vendor) {
        if (vendor == null) {
            return null;
        }
        return vendorToVendorDto(vendor).setVendorUrl(VendorService.URL + "/" + vendor.getId());
    }

    VendorDTO vendorToVendorDto(Vendor vendor);

    Vendor vendorDtoToVendor(VendorDTO vendorDTO);

}
