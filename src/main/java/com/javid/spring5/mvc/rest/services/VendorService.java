package com.javid.spring5.mvc.rest.services;

import com.javid.spring5.mvc.rest.api.v1.model.VendorDTO;

import java.util.List;

/**
 * Created by Javid on 3/29/2021.
 */

public interface VendorService {

    String URL = "/api/v1/vendors";

    List<VendorDTO> findAll();

    VendorDTO findById(Long id);

    VendorDTO save(VendorDTO vendorDTO);

    VendorDTO save(VendorDTO vendorDTO, Long id);

    VendorDTO patch(VendorDTO vendorDTO, Long id);

}
