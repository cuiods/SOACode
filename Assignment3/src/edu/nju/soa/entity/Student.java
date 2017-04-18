package edu.nju.soa.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

/**
 * Student entity
 */
public class Student extends Entity {
    private String id;
    private PersonInfo personInfo;
    private List<Score> scoreList;

    public Student(String id, PersonInfo personInfo, List<Score> scoreList) {
        if (id.length()!=9) throw new IllegalArgumentException();
        this.id = id;
        this.personInfo = personInfo;
        this.scoreList = scoreList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    @Override
    public Element parseElement(Document document, String tagName) {
        Element root = document.createElement(tagName);
        Element sidE = document.createElement("学号");
        sidE.setTextContent(id);
        root.appendChild(sidE);
        Element personInfoE = personInfo.parseElement(document,"个人信息");
        root.appendChild(personInfoE);
        Element scoreListE = document.createElement("课程成绩列表");
        scoreList.forEach(score -> scoreListE.appendChild(score.parseElement(document,"课程成绩")));
        root.appendChild(scoreListE);
        return root;
    }
}
