package com.javid.spring5.mvc.rest.bootstrap;

import com.javid.spring5.mvc.rest.domain.Category;
import com.javid.spring5.mvc.rest.domain.Customer;
import com.javid.spring5.mvc.rest.domain.Vendor;
import com.javid.spring5.mvc.rest.repositories.CategoryRepository;
import com.javid.spring5.mvc.rest.repositories.CustomerRepository;
import com.javid.spring5.mvc.rest.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Javid on 3/24/2021.
 */

@Slf4j
@RequiredArgsConstructor
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;
    private final String DATA_INSERTED = "Data inserted = ";

    @Override
    public void run(String... args) throws Exception {
        insertCategories("Fruits", "Dried", "Fresh", "Exotic", "Nuts");

        insertVendors("Home Fruits",
                "Fun Fresh Fruits Ltd",
                "Exotic Fruits Company",
                "Nuts for Nuts Company",
                "Western Tasty Fruits Ltd",
                "Franks Fresh Fruits from France Ltd."
        );

        insertCustomers(
                List.of(),
                List.of("Sam", "Axe"),
                List.of("Ken", "West"),
                List.of("Joe", "Buck"),
                List.of("John", "Thompson"),
                List.of("Micheal", "Weston")
        );

    }

    private void insertCategories(String... names) {
        for (var name : names) {
            categoryRepository.save(new Category().setName(name));
        }
        log.debug(DATA_INSERTED + categoryRepository.count() + " Categories");
    }

    private void insertVendors(String... names) {
        for (var name : names) {
            vendorRepository.save(new Vendor().setName(name));
        }
        log.debug(DATA_INSERTED + vendorRepository.count() + " Vendors");
    }

    private void insertCustomers(List<String>... names) {
        for (List<String> name : names) {
            if (name.size() == 2) {
                customerRepository.save(new Customer().setFirstName(name.get(0)).setLastName(name.get(1)));
            }
        }
        log.debug(DATA_INSERTED + customerRepository.count() + " Customers");
    }

}
