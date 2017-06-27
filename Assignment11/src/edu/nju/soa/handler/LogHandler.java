package edu.nju.soa.handler;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.*;
import java.util.Set;

/**
 * Created by cuihao on 2017-06-26.
 * save request and response
 */
public class LogHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        recordMsg(context);
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        recordMsg(context);
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }

    private void recordMsg(SOAPMessageContext context) {
        SOAPMessage soapMessage = context.getMessage();
        try {
            File file = new File("msg.log");
            if (!file.exists()) {
                boolean result = file.createNewFile();
                if (!result)
                    throw new IOException("Cannot create file");
            }
            FileOutputStream outputStream = new FileOutputStream(file,true);
            if (!(Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY)) {
                outputStream.write("====================RESPONSE=====================\n".getBytes());
            } else {
                outputStream.write("====================REQUEST=====================\n".getBytes());
            }
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            // Set formatting

            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount",
                    "2");

            Source sc = soapMessage.getSOAPPart().getContent();

            ByteArrayOutputStream streamOut = new ByteArrayOutputStream();
            StreamResult result = new StreamResult(streamOut);
            tf.transform(sc, result);

            String strMessage = streamOut.toString();
            outputStream.write(strMessage.getBytes());
            outputStream.write('\n');
        } catch (SOAPException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
