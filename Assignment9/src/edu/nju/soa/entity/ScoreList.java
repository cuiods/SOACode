
package edu.nju.soa.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for 课程成绩列表类型 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="课程成绩列表类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="课程成绩" type="{http://jw.nju.edu.cn/schema}课程成绩类型"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlRootElement(name = "课程成绩列表", namespace = NameSpace.JW_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class ScoreList {

    @XmlElement(name = "课程成绩", namespace = NameSpace.JW_URI)
    private List<CourseScore> courseScoreList;

    public ScoreList() {
        courseScoreList = new ArrayList<>();
    }

    /**
     * Gets the value of the 课程成绩 property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the 课程成绩 property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourseScoreList().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourseScore }
     *
     *
     */
    public List<CourseScore> getCourseScoreList() {
        return courseScoreList;
    }

    public void setCourseScoreList(List<CourseScore> courseScoreList) {
        this.courseScoreList = courseScoreList;
    }

    public void addCourseScore(CourseScore courseScore) {
        courseScoreList.add(courseScore);
    }
}
