package edu.nju.soa.tool;

import edu.nju.soa.entity.ScoreEntity;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Entrance of SAX parser
 */
public class SaxMain {

	private static final String FILE_NAME="文档3.xml";
	
    public static void main(String[] args) {
        
    }
    
    /**
     * 从xml中获取entity列表
     * @return
     */
    public static List<ScoreEntity> getEntities(){
    	SAXParser parser;
    	List<ScoreEntity> scores=new ArrayList<ScoreEntity>();
        try{
            parser = SAXParserFactory.newInstance().newSAXParser();
            ReadValueHandler handle = new ReadValueHandler();

            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handle);
            reader.parse(new InputSource(new FileInputStream(FILE_NAME)));
            scores = handle.getList();
           
        }catch (SAXException e){
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }
}
