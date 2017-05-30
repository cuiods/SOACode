package edu.nju.soa.entity;

import javax.xml.bind.annotation.*;

/**
 * <p>Java class for 成绩类型 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="成绩类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="学号" type="{http://jw.nju.edu.cn/schema}学号类型"/>
 *         &lt;element name="得分" type="{http://jw.nju.edu.cn/schema}得分类型"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "成绩类型", namespace = NameSpace.JW_URI)
public class Score {

    @XmlElement(name = "学号", namespace = NameSpace.JW_URI)
    private String sid;

    @XmlElement(name = "得分", namespace = NameSpace.JW_URI)
    private int score;

    public Score() {
    }

    public Score(String sid, int score) {
        this.sid = sid;
        this.score = score;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
