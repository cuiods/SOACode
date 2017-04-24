package edu.nju.soa;

import edu.nju.soa.entity.Course;
import edu.nju.soa.handler.ReadValueHandler;
import edu.nju.soa.sax.SaxTransform;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Entrance of SAX parser
 */
public class SaxMain {

    public static void main(String[] args) {
        SAXParser parser;
        try{
            parser = SAXParserFactory.newInstance().newSAXParser();
            ReadValueHandler handle = new ReadValueHandler();

            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handle);
            reader.parse(new InputSource(new FileInputStream("文档3.xml")));
            List<Course> courses = handle.getList();
            SaxTransform saxTransform = new SaxTransform();
            saxTransform.transfer("文档4.xml", courses);

        }catch (SAXException | ParserConfigurationException | IOException e){
            e.printStackTrace();
        }
    }
}
