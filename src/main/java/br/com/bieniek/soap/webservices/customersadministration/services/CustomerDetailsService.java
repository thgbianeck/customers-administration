package br.com.bieniek.soap.webservices.customersadministration.services;

import br.com.bieniek.soap.webservices.customersadministration.beans.Customer;
import br.com.bieniek.soap.webservices.customersadministration.enums.Status;

import java.util.List;

public interface CustomerDetailsService {

    Customer findById(int id);
    List<Customer> findAll();
    Status deleteById(int id);

}
