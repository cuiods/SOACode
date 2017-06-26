package edu.nju.soa.handler;

import service.HelloServiceInterface;
import service.MyService;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

/**
 * Created by cuihao on 2017-06-26.
 * Auth handler
 */
public class AuthHandler implements SOAPHandler<SOAPMessageContext>{
    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        if ((Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY)) {
            SOAPMessage soapMessage = context.getMessage();
            try {
                SOAPHeader soapHeader = soapMessage.getSOAPHeader();
                if (soapHeader!=null) {
                    MyService service = new MyService();
                }
            } catch (SOAPException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }
}
