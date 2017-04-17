package edu.nju.soa.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Course score info
 */
public class Score extends Entity {
    private String studentId;
    private String score;
    private String courseId;
    private String type;

    public Score(String studentId, String score, String courseId, String type) {
        this.studentId = studentId;
        this.score = score;
        this.courseId = courseId;
        this.type = type;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Element parseElement(Document document, String tagName) {
        Element root = document.createElement(tagName);
        root.setAttribute("课程编号",courseId);
        root.setAttribute("成绩性质",type);
        Element scoreNode = document.createElement("成绩");
        Element sid = document.createElement("学号");
        sid.setTextContent(studentId);
        Element finalScore = document.createElement("得分");
        finalScore.setTextContent(score);
        scoreNode.appendChild(sid);
        scoreNode.appendChild(finalScore);
        root.appendChild(scoreNode);
        return root;
    }
}
