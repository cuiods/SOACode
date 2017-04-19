package edu.nju.soa.parser;

import edu.nju.soa.entity.*;
import edu.nju.soa.enums.DepartmentType;
import edu.nju.soa.enums.ScoreType;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Dom parser used to update or create xml file
 */
public class DomParser {
	/**
	 * Document对象代表了一个XML文档的模型树
	 * 所有的其他Node都以一定的顺序包含在Document对象之内
	 */
    private Document document;

    public DomParser() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public DomParser(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(filePath);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用dom生成xml
     * @param path xml路径
     */
    public void createStudentsXML(String path) {
        if (document==null) return;
        //添加xml元素
        document.appendChild(addData());
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            Source xmlSource = new DOMSource(document);
            Result xmlResult = new StreamResult(new File(path));
            transformer.transform(xmlSource,xmlResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成xml的element
     * @return
     */
    private Element addData() {
        if (document==null) return null;
        Element root = document.createElement("学生列表");
        //设置命名空间
        root.setAttribute("xmlns","http://jw.nju.edu.cn/schema");
        String idList[] = new String[]{"141250204","141250019","141250002","141250104","141250210","141250173",
                                        "141250123","141250120","141250116","141250179","141250060","141250017"};
        String nameList[] = new String[]{"周聪","崔浩","白国风","阮威威","周颖婷","殷乾恩","潘凌伟","郑韵芝","孙婧","袁阳阳",
                                        "赖斌","陈自强"};
        assert idList.length == nameList.length;
        //生成多个学生element，添加到root中
        for (int i = 0; i < idList.length; i++) {
            Student student = new Student(idList[i],
                    new PersonInfo(nameList[i], new Department("141250","软件学院", DepartmentType.院,"专注于培养软件人才",
                            new Location("中国","江苏","南京市鼓楼区","汉口路","22号")),
                            new Location("中国","江苏","南京市鼓楼区","汉口路","22号"),
                            "优秀的软院学生！"),randomScore(idList[i]));
            //保证有成绩小于60
            Score score=student.getScoreList().get(0);
            score.setScore("59");
            root.appendChild(student.parseElement(document,"学生"));
        }
        return root;
    }

    
    /**
     * 生成学生的五门课程成绩
     * @param studentId
     * @return
     */
    private List<Score> randomScore(String studentId) {
        Random random = new Random();
        List<Score> scoreList = new ArrayList<>(15);
        for (int i = 0; i < 5; i++) {
        	//生成课程编号
            StringBuilder course = new StringBuilder(random.nextInt(999999)+"");
            while (course.length()<6) {
                course = course.insert(0,"0");
            }
            //生成成绩
            int pass = random.nextInt(10);
            int score1 = pass>2?random.nextInt(20)+80:random.nextInt(60)+10;
            int score2 = pass>2?random.nextInt(20)+80:random.nextInt(60)+40;
            int score3 = random.nextInt(10)+90;
            scoreList.add(new Score(studentId,score1+"",course.toString(), ScoreType.平时成绩));
            scoreList.add(new Score(studentId,score2+"",course.toString(), ScoreType.期末成绩));
            scoreList.add(new Score(studentId,score3+"",course.toString(), ScoreType.总评成绩));
        }
        return scoreList;
    }
}
