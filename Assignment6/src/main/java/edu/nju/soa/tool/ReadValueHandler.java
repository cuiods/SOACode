package edu.nju.soa.tool;

import edu.nju.soa.entity.CourseScoreEntity;
import edu.nju.soa.entity.ScoreEntity;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Customized handler
 */
public class ReadValueHandler extends DefaultHandler{

    private List<ScoreEntity> list = new ArrayList<ScoreEntity>();

    private CourseScoreEntity tempCourse;

    private ScoreEntity tempScore;

    private String preTag;

    private boolean fail = false;
    public List<ScoreEntity> getList() {
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
            tempCourse = new CourseScoreEntity();
        
            tempCourse.setCid(Integer.parseInt(attributes.getValue("课程编号")));
            tempCourse.setType(attributes.getValue("成绩性质"));
        }else if(preTag.equals("成绩")){
            tempScore = new ScoreEntity();
        }

    }



    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        super.characters(ch, start, length);
        if(preTag!=null){
            String theString = new String(ch, start, length);
            //System.out.println(preTag +"12312312");
            if(preTag.equals("学号")){
                tempScore.setSid(Integer.parseInt(theString));
            }else if(preTag.equals("得分")){
                tempScore.setScore(Integer.parseInt(theString));
                if(Integer.parseInt(theString)<60){
                    fail = true;
                }
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        super.endElement(uri, localName, qName);
        if(qName.equals("课程成绩")){
        	tempScore.setEntity(tempCourse);
            list.add(tempScore);
            
            tempCourse = null;
        }
        preTag = null;
    }

}
