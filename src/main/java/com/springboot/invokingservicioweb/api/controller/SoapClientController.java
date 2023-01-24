package com.springboot.invokingservicioweb.api.controller;

import com.springboot.invokingservicioweb.api.service.impl.SoapClientServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/word")
public class SoapClientController {

    private final SoapClientServiceImpl soapClientService;

    public SoapClientController(@Qualifier("soapClientServiceImpl") SoapClientServiceImpl soapClientService) {
        this.soapClientService = soapClientService;
    }

    @GetMapping("/{number}")
    public String convertNumberToWord(@PathVariable("number") Long number) {
        return soapClientService.convertWordNumber(number);
    }
}
