package com.springboot.invokingservicioweb.api.service.impl;

import com.dataaccess.webservicesserver.NumberToWords;
import com.dataaccess.webservicesserver.NumberToWordsResponse;
import com.springboot.invokingservicioweb.api.configuration.SoapHeaders;
import com.springboot.invokingservicioweb.api.service.SoapClientService;
import com.springboot.invokingservicioweb.api.utils.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigInteger;

@Service("soapClientServiceImpl")
public class SoapClientServiceImpl extends WebServiceGatewaySupport implements SoapClientService {

    private String endpoint = Constants.WSDL_SOAP_CLIENT;

    @Override
    public String convertWordNumber(Long number) {
        NumberToWords request = new NumberToWords();
        request.setUbiNum(BigInteger.valueOf(number));

        NumberToWordsResponse response = (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request, new SoapHeaders());
        return response.getNumberToWordsResult();
    }
}
