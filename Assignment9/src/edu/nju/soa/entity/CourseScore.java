package edu.nju.soa.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for 课程成绩类型 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="课程成绩类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="成绩" type="{http://jw.nju.edu.cn/schema}成绩类型"/>
 *       &lt;/sequence>
 *       &lt;attribute name="课程编号" type="{http://jw.nju.edu.cn/schema}课程编号类型" />
 *       &lt;attribute name="成绩性质" type="{http://jw.nju.edu.cn/schema}成绩性质类型" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "课程成绩类型", namespace = NameSpace.JW_URI, propOrder = {"cid","type","scoreList"})
public class CourseScore {

    @XmlAttribute(name = "课程编号")
    private String cid;

    @XmlAttribute(name = "成绩性质")
    private ScoreType type;

    @XmlElement(name = "成绩", namespace = NameSpace.JW_URI)
    private List<Score> scoreList;

    public CourseScore() {
        scoreList = new ArrayList<>();
    }

    public CourseScore(String cid, ScoreType type, List<Score> scoreList) {
        this.cid = cid;
        this.type = type;
        this.scoreList = scoreList;
    }

    public CourseScore(String cid, ScoreType type, String sid, int score) {
        Score scoreEntity = new Score(sid,score);
        scoreList = new ArrayList<>(1);
        scoreList.add(scoreEntity);
        this.cid = cid;
        this.type = type;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public ScoreType getType() {
        return type;
    }

    public void setType(ScoreType type) {
        this.type = type;
    }

    /**
     * Gets the value of the 成绩 property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the 成绩 property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get成绩().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Score }
     *
     *
     */
    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public void addScore(Score score) {
        scoreList.add(score);
    }
}
