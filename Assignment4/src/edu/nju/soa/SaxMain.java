package edu.nju.soa;

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
 * Created by sam on 2017/4/23.
 */
public class SaxMain {

    public static void main(String[] args) {
        SAXParser parser = null;
        try{
            parser = SAXParserFactory.newInstance().newSAXParser();
            ReadValueHandle handle = new ReadValueHandle();

            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handle);
            reader.parse(new InputSource(new FileInputStream("文档3.xml")));
            List<Class> classes = handle.getList();
//            for(Class c:classes){
//                System.out.println(c.getId()+"|"+c.getType()+"|");
//            }
            SaxTransform saxTransform = new SaxTransform();
            saxTransform.transfer("文档4.xml",classes);

        }catch (SAXException e){

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
