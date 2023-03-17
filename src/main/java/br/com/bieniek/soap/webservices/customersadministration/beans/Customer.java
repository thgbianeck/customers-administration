package br.com.bieniek.soap.webservices.customersadministration.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private int id;
    private String name;
    private String phone;
    private String email;
}
