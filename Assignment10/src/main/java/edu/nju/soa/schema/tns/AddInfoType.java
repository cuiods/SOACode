
package edu.nju.soa.schema.tns;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>addInfoType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="addInfoType">
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
@XmlType(name = "addInfoType", propOrder = {
    "student"
})
public class AddInfoType {

    @XmlElement(name = "studentType",required = true)
    protected StudentType student;

    /**
     * 获取学生属性的值。
     *
     * @return
     *     possible object is
     *     {@link StudentType }
     *
     */
    public StudentType getStudent() {
        return student;
    }

    /**
     * 设置学生属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link StudentType }
     *
     */
    public void setStudent(StudentType value) {
        this.student = value;
    }

}
