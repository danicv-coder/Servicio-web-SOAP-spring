package com.springboot.invokingservicioweb.api.service.impl;

import com.dataaccess.webservicesserver.NumberToWords;
import com.dataaccess.webservicesserver.NumberToWordsResponse;
import com.springboot.invokingservicioweb.api.service.SoapClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigInteger;

@Service
public class SoapClientServiceImpl extends WebServiceGatewaySupport implements SoapClientService {
    @Value("WSDL.SOAPClient")
    private String endpoint;

    @Override
    public String convertWordNumber(Long number) {
        NumberToWords request = new NumberToWords();
        request.setUbiNum(BigInteger.valueOf(number));

        NumberToWordsResponse response = (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request);
        return response.getNumberToWordsResult();
    }
}
