package com.javid.spring5.mvc.rest.api.v1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Javid on 3/29/2021.
 */

@ApiModel(value = "Vendors", description = "List of all vendors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendorsDTO {

    @ApiModelProperty(required = true, notes = "A list of vendors", value = "Vendors list")
    private List<VendorDTO> vendors;

}
