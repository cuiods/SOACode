package edu.nju.soa.translate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * Created by cuihao on 2017-05-30.
 * object to xml or xml to object translate
 */
public final class XmlParser {

    public static String marshal(Object object) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter stringWriter = new StringWriter();

            marshaller.marshal(object,stringWriter);

            result = stringWriter.toString();

        } catch (JAXBException e) {
            System.err.println("Can't marshal the XML file, error message:"+e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> T unmarshal(InputStream xml, Class<T> clazz) {
        T result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Object object =  unmarshaller.unmarshal(xml);
            if (object != null) {
                result = (T) object;
            }
        } catch (JAXBException e) {
            System.err.println("Can't unmarshal the XML file, error message: "+e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
