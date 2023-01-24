package com.springboot.invokingservicioweb.api.configuration;

import com.springboot.invokingservicioweb.api.service.impl.SoapClientServiceImpl;
import com.springboot.invokingservicioweb.api.utils.Constants;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class SoapConfiguration {
    @Autowired
    private SoapClientServiceImpl client;
    private String wsdlSoap = Constants.WSDL_SOAP;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(wsdlSoap);
        return marshaller;
    }

    @Bean
    public SoapClientServiceImpl soaClient(Jaxb2Marshaller marshaller) {
        client.setMessageSender(getMessageSender());
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    //metodo para setear autenticacion para un wsdl
    public HttpComponentsMessageSender getMessageSender() {
        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
        messageSender.setCredentials(new UsernamePasswordCredentials("username", "password"));
        return messageSender;
    }
}
