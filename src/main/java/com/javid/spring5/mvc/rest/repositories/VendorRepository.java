package com.javid.spring5.mvc.rest.repositories;

import com.javid.spring5.mvc.rest.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Javid on 3/29/2021.
 */

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
