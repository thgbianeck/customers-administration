package br.com.bieniek.soap.webservices.customersadministration.endpoints;

import br.com.bieniek.soap.webservices.customersadministration.beans.Customer;
import br.com.bieniek.soap.webservices.customersadministration.domain.*;
import br.com.bieniek.soap.webservices.customersadministration.services.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.bieniek.soap.webservices.customersadministration.constants.CustomersConstants.*;

@Endpoint
@RequiredArgsConstructor
public class CustomerDetailEndPoint {

    private final CustomerDetailsService customerDetailsService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = GET_CUSTOMER_DETAILS_REQUEST)
    @ResponsePayload
    public GetCustomerDetailsResponse processCustomerDetailsRequest(@RequestPayload GetCustomerDetailsRequest request){ // The @RequestPayload annotation is used to map the request to the method.
        Customer customer = customerDetailsService.findById(request.getId());
        return convertToGetCustomerDetailsResponse(customer);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = GET_ALL_CUSTOMER_DETAILS_REQUEST)
    @ResponsePayload
    public GetAllCustomerDetailsResponse processAllCustomerDetailsRequest(@RequestPayload GetAllCustomerDetailsRequest request){ // The @RequestPayload annotation is used to map the request to the method.
        List<Customer> customerList = customerDetailsService.findAll();
        return convertToGetAllCustomerDetailsResponse(customerList);
    }

    private GetAllCustomerDetailsResponse convertToGetAllCustomerDetailsResponse(List<Customer> customers) {
        List<CustomerDetail> customerDetails = customers.stream()
                .map(customer -> new ModelMapper().map(customer, CustomerDetail.class))
                .collect(Collectors.toList());
        GetAllCustomerDetailsResponse response = new GetAllCustomerDetailsResponse();
        response.getCustomerDetail().addAll(customerDetails);
        return response;
    }

    private GetCustomerDetailsResponse convertToGetCustomerDetailsResponse(Customer customer) {
        CustomerDetail customerDetail = new ModelMapper().map(customer, CustomerDetail.class); // The ModelMapper is used to map the Customer to the CustomerDetail.
        GetCustomerDetailsResponse response = new GetCustomerDetailsResponse();
        response.setCustomerDetail(customerDetail);
        return response;
    }
}
