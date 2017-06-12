
package edu.nju.soa.schema.tns;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>modifyScoreType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="modifyScoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://jw.nju.edu.cn/schema}scoreList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyScoreType", propOrder = {
    "courseScoreListType"
})
public class ModifyScoreType {

    @XmlElement(name = "courseScoreListType",required = true)
    protected CourseScoreListType courseScoreListType;

    /**
     * 获取课程成绩列表属性的值。
     *
     * @return
     *     possible object is
     *     {@link CourseScoreListType }
     *
     */
    public CourseScoreListType getCourseScoreListType() {
        return courseScoreListType;
    }

    /**
     * 设置课程成绩列表属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link CourseScoreListType }
     *
     */
    public void setCourseScoreListType(CourseScoreListType value) {
        this.courseScoreListType = value;
    }

}
