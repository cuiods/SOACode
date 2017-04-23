package edu.nju.soa;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sam on 2017/4/23.
 */
public class ReadValueHandle extends DefaultHandler{

    private List<Class> list = new ArrayList<Class>();

    private Class tempClass;

    private Score tempScore;

    private String preTag;

    private boolean fail = false;
    public List<Class> getList() {
        return list;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //super.startElement(uri, localName, qName, attributes);
        preTag = qName;
        if(preTag.equals("课程成绩")){
            tempClass = new Class(attributes.getValue("成绩性质"),attributes.getValue("课程编号"));
        }else if(preTag.equals("成绩")){
            tempScore = new Score();
        }

    }



    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        super.characters(ch, start, length);
        if(preTag!=null){
            String theString = new String(ch, start, length);
            //System.out.println(preTag +"12312312");
            if(preTag.equals("学号")){
                tempScore.setNumber(theString);
            }else if(preTag.equals("得分")){
                tempScore.setScore(theString);
                if(Integer.parseInt(theString)<60){
                    fail = true;
                }
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        super.endElement(uri, localName, qName);
        if(qName.equals("成绩")){
            if(fail){
                tempClass.addScore(tempScore);
                fail = false;
            }
            tempScore = null;
        }else if(qName.equals("课程成绩")){
            int size = tempClass.getScoreSize();
            if(size>0){
                list.add(tempClass);
            }
            tempClass = null;
        }
        preTag = null;//注意！！避免换行空格的影响
    }

}
