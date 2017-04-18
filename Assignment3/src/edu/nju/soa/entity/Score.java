package edu.nju.soa.entity;

import edu.nju.soa.enums.ScoreType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Course score info
 */
public class Score extends Entity {
    private String studentId;
    private String score;
    private String courseId;
    private ScoreType type;

    public Score(String studentId, String score, String courseId, ScoreType type) {
        try {
            int scoreInt = Integer.parseInt(score);
            if (scoreInt<0 || scoreInt>100 || studentId.length()!=9 || courseId.length()!=6)
                throw new IllegalArgumentException();
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
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

    public ScoreType getType() {
        return type;
    }

    public void setType(ScoreType type) {
        this.type = type;
    }

    @Override
    public Element parseElement(Document document, String tagName) {
        Element root = document.createElement(tagName);
        root.setAttribute("课程编号",courseId);
        root.setAttribute("成绩性质",type.toString());
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
