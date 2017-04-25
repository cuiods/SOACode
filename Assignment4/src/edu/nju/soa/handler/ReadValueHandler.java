package edu.nju.soa.handler;

import edu.nju.soa.entity.Course;
import edu.nju.soa.entity.Score;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Customized handler
 */
public class ReadValueHandler extends DefaultHandler{

    private List<Course> list = new ArrayList<>();

    private Course tempCourse;

    private Score tempScore;

    private String preTag;

    private boolean fail = false;
    public List<Course> getList() {
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
            tempCourse = new Course(attributes.getValue("课程编号"),attributes.getValue("成绩性质"));
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
                tempCourse.addScore(tempScore);
                fail = false;
            }
            tempScore = null;
        }else if(qName.equals("课程成绩")){
            int size = tempCourse.getScoreSize();
            if(size>0){
                list.add(tempCourse);
            }
            tempCourse = null;
        }
        preTag = null;
    }

}
