package com.javid.spring5.mvc.rest.repositories;

import com.javid.spring5.mvc.rest.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Javid on 3/24/2021.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
