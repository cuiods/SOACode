
package edu.nju.soa.schema.tns;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>CourseScore complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CourseScore">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="courseScoreTypes" type="{http://jw.nju.edu.cn/schema}CourseScoreType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="cid" type="{http://jw.nju.edu.cn/schema}课程编号类型" />
 *       &lt;attribute name="scoreType" type="{http://jw.nju.edu.cn/schema}ScoreType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "课程成绩类型", propOrder = {
    "courseScoreTypes"
})
@NoArgsConstructor
@AllArgsConstructor
public class CourseScore {

    @XmlElement(name = "成绩")
    protected List<CourseScoreType> courseScoreTypes;
    @XmlAttribute(name = "课程编号")
    protected String cid;
    @XmlAttribute(name = "成绩性质")
    protected ScoreType scoreType;

    /**
     * Gets the value of the courseScoreTypes property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the courseScoreTypes property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourseScoreTypes().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourseScoreType }
     *
     *
     */
    public List<CourseScoreType> getCourseScoreTypes() {
        if (courseScoreTypes == null) {
            courseScoreTypes = new ArrayList<CourseScoreType>();
        }
        return this.courseScoreTypes;
    }

    /**
     * 获取课程编号属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCid() {
        return cid;
    }

    /**
     * 设置课程编号属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCid(String value) {
        this.cid = value;
    }

    /**
     * 获取成绩性质属性的值。
     *
     * @return
     *     possible object is
     *     {@link ScoreType }
     *
     */
    public ScoreType getScoreType() {
        return scoreType;
    }

    /**
     * 设置成绩性质属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link ScoreType }
     *
     */
    public void setScoreType(ScoreType value) {
        this.scoreType = value;
    }

    public void setCourseScoreTypes(List<CourseScoreType> courseScoreTypes) {
        this.courseScoreTypes = courseScoreTypes;
    }
}
