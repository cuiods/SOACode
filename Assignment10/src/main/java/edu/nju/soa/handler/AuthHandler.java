package edu.nju.soa.handler;

import edu.nju.soa.dao.UserDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by cuihao on 2017-06-21.
 * Auth verify
 */
@Component
public class AuthHandler implements SOAPHandler<SOAPMessageContext> {

    @Resource
    private UserDao userDao;

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean handleMessage(SOAPMessageContext context) {
        if (!(Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY)) {
            SOAPMessage soapMessage = context.getMessage();
            try {
                SOAPHeader soapHeader = soapMessage.getSOAPHeader();
                if (soapHeader!=null) {
                    System.out.println("Get header");
                }
            } catch (SOAPException e) {
                e.printStackTrace();
                return true;
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
