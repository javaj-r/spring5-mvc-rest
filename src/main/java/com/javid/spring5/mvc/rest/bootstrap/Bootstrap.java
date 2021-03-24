package com.javid.spring5.mvc.rest.bootstrap;

import com.javid.spring5.mvc.rest.domain.Category;
import com.javid.spring5.mvc.rest.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Javid on 3/24/2021.
 */

@Slf4j
@RequiredArgsConstructor
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        insertCategories("Fruits", "Dried", "Fresh", "Exotic", "Nuts");
        log.debug("Data inserted = " + categoryRepository.count() + " Categories");
    }

    private void insertCategories(String... names) {
        for (var name : names) {
            categoryRepository.save(new Category().setName(name));
        }
    }
}
