package br.com.bieniek.soap.webservices.customersadministration.constants;

public final class CustomersConstants {
    public static final String NAMESPACE_URI = "http://bieniek.com.br/soap/webservices/customersadministration";

    public static final String CUSTOMERS = "customers";
    public static final String GET_CUSTOMER_DETAILS_REQUEST = "GetCustomerDetailsRequest";
    public static final String GET_CUSTOMER_DETAILS_RESPONSE = "GetCustomerDetailsResponse";
    public static final String GET_ALL_CUSTOMER_DETAILS_REQUEST = "GetAllCustomerDetailsRequest";
    public static final String GET_ALL_CUSTOMER_DETAILS_RESPONSE = "GetAllCustomerDetailsResponse";

    public static final String CUSTOMER_DETAIL = "CustomerDetail";
    public static final String CUSTOMER_PORT = "CustomerPort";
    public static final String SCHEMAS_FOLDER = "/schemas/";
    public static final String CUSTOMER_INFORMATION_XSD = "customer-information.xsd";
    public static final String CUSTOMER_INFORMATION_XSD_PATH = SCHEMAS_FOLDER + "customer-information.xsd";

    public static final String CUSTOMER_INFORMATION_WSDL = "customer-information.wsdl";

    public static final String CUSTOMER_INFORMATION_WSDL_PATH = SCHEMAS_FOLDER + "customer-information.wsdl";

    public static final String LOCATION_URI = "/ws";

    public static final String LOCATION_URI_MAPPINGS = LOCATION_URI + "/*";





}
