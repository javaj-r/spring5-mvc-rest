package com.javid.spring5.mvc.rest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Javid on 3/25/2021.
 */

@Data
@Accessors(chain = true)
public class CustomerDTO {

//    private Long id;
    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("customer_url")
    private String customerUrl;
}
