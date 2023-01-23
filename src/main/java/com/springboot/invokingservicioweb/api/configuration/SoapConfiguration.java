package com.springboot.invokingservicioweb.api.configuration;

import com.springboot.invokingservicioweb.api.service.SoapClientService;
import com.springboot.invokingservicioweb.api.service.impl.SoapClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfiguration {
    @Autowired
    private SoapClientService client;
    @Value("WSDL.SOAP")
    private String wsdl;

    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(wsdl);
        return marshaller;
    }
}
