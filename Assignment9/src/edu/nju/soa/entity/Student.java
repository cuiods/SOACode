package edu.nju.soa.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * <p>Java class for 学生类型 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="学生类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://jw.nju.edu.cn/schema}学号"/>
 *         &lt;element ref="{http://www.nju.edu.cn/schema}个人信息"/>
 *         &lt;element ref="{http://jw.nju.edu.cn/schema}课程成绩列表"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "学生", namespace = NameSpace.JW_URI, propOrder = {
        "sid",
        "personInfo",
        "courseScores"
})
public class Student {

    @XmlElement(name = "学号", namespace = NameSpace.JW_URI)
    private String sid;

    @XmlElement(name = "个人信息", namespace = NameSpace.NJU_URI)
    private PersonInfo personInfo;

    @XmlElementWrapper(name = "课程成绩列表", namespace = NameSpace.JW_URI)
    @XmlElements(value = {@XmlElement(name = "课程成绩", namespace = NameSpace.JW_URI)})
    private List<CourseScore> courseScores;

    public Student() {
    }

    public Student(String sid, PersonInfo personInfo, List<CourseScore> courseScores) {
        this.sid = sid;
        this.personInfo = personInfo;
        this.courseScores = courseScores;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public List<CourseScore> getCourseScores() {
        return courseScores;
    }

    public void setCourseScores(List<CourseScore> courseScores) {
        this.courseScores = courseScores;
    }
}
