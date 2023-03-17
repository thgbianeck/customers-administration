package br.com.bieniek.soap.webservices.customersadministration.config;

import br.com.bieniek.soap.webservices.customersadministration.constants.CustomersConstants;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import static br.com.bieniek.soap.webservices.customersadministration.constants.CustomersConstants.*;

@Configuration // Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
@EnableWs // Enables Spring Web Services
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        // MessageDispatcherServlet is a Spring Web Servlet that handles SOAP messages.
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        // The ApplicationContext is set to the MessageDispatcherServlet.
        messageDispatcherServlet.setApplicationContext(context);
        // The MessageDispatcherServlet is registered with the Servlet container.
        messageDispatcherServlet.setTransformWsdlLocations(true);
        // The locationUri is set to /ws.
        return new ServletRegistrationBean(messageDispatcherServlet, LOCATION_URI_MAPPINGS);
    }

    @Bean
    public XsdSchema customersSchema() {
        // The XsdSchema is created with the customer-information.xsd file.
        return new SimpleXsdSchema(new ClassPathResource(CUSTOMER_INFORMATION_XSD_PATH));
    }

    @Bean(name = CUSTOMERS)
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema customersSchema) {
        // The DefaultWsdl11Definition is created with the XsdSchema.
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        // The portTypeName is set to CustomerPort.
        definition.setPortTypeName(CUSTOMER_PORT);
        // The locationUri is set to /ws.
        definition.setLocationUri(LOCATION_URI);
        // The targetNamespace is set to http://bieniek.com.br/soap/webservices/customersadministration.
        definition.setTargetNamespace(NAMESPACE_URI);
        // The XsdSchema is set to the DefaultWsdl11Definition.
        definition.setSchema(customersSchema);
        return definition;
    }
}
