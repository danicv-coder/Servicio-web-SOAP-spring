package com.springboot.invokingservicioweb.api.configuration;

import com.springboot.invokingservicioweb.api.utils.Constants;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.transport.HeadersAwareSenderWebServiceConnection;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public class SoapHeaders implements WebServiceMessageCallback {
    private String cabeceraHttp = Constants.CABECERA_HTTP;
    private String dato = Constants.DATO;

    //Setear cabeceras HTTP adicionales
    @Override
    public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
        TransportContext context = TransportContextHolder.getTransportContext();
        HeadersAwareSenderWebServiceConnection connection = (HeadersAwareSenderWebServiceConnection) context.getConnection();
        connection.addRequestHeader(cabeceraHttp, dato);
    }
}
