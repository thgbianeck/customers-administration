package br.com.bieniek.soap.webservices.customersadministration.services.impl;

import br.com.bieniek.soap.webservices.customersadministration.beans.Customer;
import br.com.bieniek.soap.webservices.customersadministration.enums.Status;
import br.com.bieniek.soap.webservices.customersadministration.services.CustomerDetailsService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static br.com.bieniek.soap.webservices.customersadministration.enums.Status.*;

@Service
@Primary // this is the default implementation (if there are more than one implementation
public class FakeCustomerDetailsServiceImpl implements CustomerDetailsService {

    private static final List<Customer> customers = new ArrayList<>();

    static {
        Customer customer1 = new Customer(1, "John", "1234567890", "john@mail.com");
        Customer customer2 = new Customer(2, "Mary", "1234567890", "mary@mail.com");
        Customer customer3 = new Customer(3, "Peter", "1234567890", "peter@mails.com");
        Customer customer4 = new Customer(4, "Sam", "1234567890", "sama@mail.com");
        Customer customer5 = new Customer(5, "Tom", "1234567890", "tom@mail.com");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
    }

    @Override
    public Customer findById(int id) {
        return customers.stream()
                .filter(customer -> customer.getId() == id) // filter by id
                .findAny() // if 'findAny' then return found
                .orElseThrow(() -> new RuntimeException("Invalid customer id: " + id)); // if not found, throw an exception
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Status deleteById(int id) {
        return customers.removeIf(customer -> customer.getId() == id) // remove by id
                ? SUCCESS // if removed, return SUCCESS
                : FAILURE; // if not removed, return FAILURE
    }
}
