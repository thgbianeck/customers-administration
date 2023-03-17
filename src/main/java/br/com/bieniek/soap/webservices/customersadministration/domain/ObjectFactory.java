//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2023.03.16 às 11:44:01 PM BRT 
//


package br.com.bieniek.soap.webservices.customersadministration.domain;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.bieniek.soap.webservices.customersadministration.domain package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.bieniek.soap.webservices.customersadministration.domain
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCustomerDetailsRequest }
     * 
     */
    public GetCustomerDetailsRequest createGetCustomerDetailsRequest() {
        return new GetCustomerDetailsRequest();
    }

    /**
     * Create an instance of {@link GetAllCustomerDetailsResponse }
     * 
     */
    public GetAllCustomerDetailsResponse createGetAllCustomerDetailsResponse() {
        return new GetAllCustomerDetailsResponse();
    }

    /**
     * Create an instance of {@link CustomerDetail }
     * 
     */
    public CustomerDetail createCustomerDetail() {
        return new CustomerDetail();
    }

    /**
     * Create an instance of {@link GetCustomerDetailsResponse }
     * 
     */
    public GetCustomerDetailsResponse createGetCustomerDetailsResponse() {
        return new GetCustomerDetailsResponse();
    }

    /**
     * Create an instance of {@link GetAllCustomerDetailsRequest }
     * 
     */
    public GetAllCustomerDetailsRequest createGetAllCustomerDetailsRequest() {
        return new GetAllCustomerDetailsRequest();
    }

}
