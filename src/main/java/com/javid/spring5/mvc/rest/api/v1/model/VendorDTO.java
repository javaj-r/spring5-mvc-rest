package com.javid.spring5.mvc.rest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Javid on 3/29/2021.
 */

@ApiModel(value = "Vendor", description = "Vendor store or supermarket")
@Data
@Accessors(chain = true)
public class VendorDTO {

    @ApiModelProperty(required = true, value = "Name of the vendor")
    private String name;

    @ApiModelProperty(example = "http://loclahost:8080/vendors/1", value = "Vendor url")
    @JsonProperty("vendor_url")
    private String vendorUrl;
}
