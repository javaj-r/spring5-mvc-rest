package com.javid.spring5.mvc.rest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Javid on 3/29/2021.
 */

@Data
@Accessors(chain = true)
public class VendorDTO {

    private String name;

    @JsonProperty("vendor_url")
    private String vendorUrl;
}
