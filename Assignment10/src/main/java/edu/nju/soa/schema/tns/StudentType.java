
package edu.nju.soa.schema.tns;

import edu.nju.soa.schema.nju.PersonInfoType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>StudentType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="StudentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://jw.nju.edu.cn/schema}sid"/>
 *         &lt;element ref="{http://www.nju.edu.cn/schema}personInfo"/>
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
@XmlType(name = "学生类型", propOrder = {
    "sid",
    "personInfo",
    "courseScoreListType"
})
@NoArgsConstructor
@AllArgsConstructor
public class StudentType {

    @XmlElement(name = "学号" ,required = true)
    protected String sid;
    @XmlElement(name = "个人信息",namespace = "http://www.nju.edu.cn/schema", required = true)
    protected PersonInfoType personInfo;
    @XmlElement(name = "课程成绩列表",required = true)
    protected CourseScoreListType courseScoreListType;

    /**
     * 获取学号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSid() {
        return sid;
    }

    /**
     * 设置学号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSid(String value) {
        this.sid = value;
    }

    /**
     * 获取个人信息属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PersonInfoType }
     *     
     */
    public PersonInfoType getPersonInfo() {
        return personInfo;
    }

    /**
     * 设置个人信息属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PersonInfoType }
     *     
     */
    public void setPersonInfo(PersonInfoType value) {
        this.personInfo = value;
    }

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
