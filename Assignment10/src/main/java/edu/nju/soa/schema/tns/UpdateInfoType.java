
package edu.nju.soa.schema.tns;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>updateInfoType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="updateInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://jw.nju.edu.cn/schema}student"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateInfoType", propOrder = {
    "studentType"
})
public class UpdateInfoType {

    @XmlElement(name = "学生",required = true)
    protected StudentType studentType;

    /**
     * 获取学生属性的值。
     *
     * @return
     *     possible object is
     *     {@link StudentType }
     *
     */
    public StudentType getStudentType() {
        return studentType;
    }

    /**
     * 设置学生属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link StudentType }
     *
     */
    public void setStudentType(StudentType value) {
        this.studentType = value;
    }

}
