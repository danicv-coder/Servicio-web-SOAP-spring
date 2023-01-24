package com.springboot.invokingservicioweb.api.configuration;

import com.springboot.invokingservicioweb.api.service.impl.SoapClientServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class SoapConfiguration {

    private SoapClientServiceImpl client;
    @Value("WSDL.SOAP")
    private String wsdl;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(wsdl);
        return marshaller;
    }

    @Bean
    public SoapClientServiceImpl soaClient(Jaxb2Marshaller marshaller) {
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
