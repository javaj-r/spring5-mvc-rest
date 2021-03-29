package com.javid.spring5.mvc.rest.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Javid on 3/29/2021.
 */

@Data
@AllArgsConstructor
public class VendorsDTO {

    private List<VendorDTO> vendors;

}
