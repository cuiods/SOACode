package edu.nju.soa;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XSLTMain {

    public static void main(String[] args) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Templates templates = transformerFactory.newTemplates(new StreamSource(new File("xsl/scoreList.xsl")));
            Transformer transformer = templates.newTransformer();
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            Source source = new StreamSource(new FileInputStream("xsl/文档2.xml"));
            Result result = new StreamResult(new FileOutputStream("文档3.xml"));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            System.out.println("An error occurred in the xml file.");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Can not find file!");
            e.printStackTrace();
        } catch (TransformerException e) {
            System.out.println("An error occurred while applying the xml file.");
            e.printStackTrace();
        }



    }
}
