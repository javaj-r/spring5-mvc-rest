package com.javid.spring5.mvc.rest.api.v2.model;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

/**
 * Created by Javid on 3/27/2021.
 */

class CategoryDTOTest {

    @Test
    void gettersAndSetters() {
        new BeanTester().testBean(CategoryDTO.class);
    }

}