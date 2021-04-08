package com.javid.spring5.mvc.rest.repositories;

import com.javid.spring5.mvc.rest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Javid on 3/25/2021.
 */

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
