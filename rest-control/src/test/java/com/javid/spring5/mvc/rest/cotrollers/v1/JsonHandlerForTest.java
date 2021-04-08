package com.javid.spring5.mvc.rest.cotrollers.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Javid on 3/28/2021.
 */

final class JsonHandlerForTest {

    static String asJsonString(final Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }

}
