
package cn.edu.nju.jw.wsdl;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>课程信息 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="课程信息"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="课程编号" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="课程名称" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="任课教师" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="学分" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="选课人数" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *         &lt;element name="课程描述" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="参考教材" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="开始时间" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="结束时间" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u8bfe\u7a0b\u4fe1\u606f", propOrder = {

})
public class 课程信息 {

    @XmlElement(required = true)
    protected String 课程编号;
    @XmlElement(required = true)
    protected String 课程名称;
    @XmlElement(required = true)
    protected String 任课教师;
    @XmlElement(required = true)
    protected BigInteger 学分;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger 选课人数;
    @XmlElement(required = true)
    protected String 课程描述;
    @XmlElement(required = true)
    protected String 参考教材;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar 开始时间;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar 结束时间;

    /**
     * 获取课程编号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get课程编号() {
        return 课程编号;
    }

    /**
     * 设置课程编号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set课程编号(String value) {
        this.课程编号 = value;
    }

    /**
     * 获取课程名称属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get课程名称() {
        return 课程名称;
    }

    /**
     * 设置课程名称属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set课程名称(String value) {
        this.课程名称 = value;
    }

    /**
     * 获取任课教师属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get任课教师() {
        return 任课教师;
    }

    /**
     * 设置任课教师属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set任课教师(String value) {
        this.任课教师 = value;
    }

    /**
     * 获取学分属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger get学分() {
        return 学分;
    }

    /**
     * 设置学分属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void set学分(BigInteger value) {
        this.学分 = value;
    }

    /**
     * 获取选课人数属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger get选课人数() {
        return 选课人数;
    }

    /**
     * 设置选课人数属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void set选课人数(BigInteger value) {
        this.选课人数 = value;
    }

    /**
     * 获取课程描述属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get课程描述() {
        return 课程描述;
    }

    /**
     * 设置课程描述属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set课程描述(String value) {
        this.课程描述 = value;
    }

    /**
     * 获取参考教材属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get参考教材() {
        return 参考教材;
    }

    /**
     * 设置参考教材属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set参考教材(String value) {
        this.参考教材 = value;
    }

    /**
     * 获取开始时间属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get开始时间() {
        return 开始时间;
    }

    /**
     * 设置开始时间属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set开始时间(XMLGregorianCalendar value) {
        this.开始时间 = value;
    }

    /**
     * 获取结束时间属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get结束时间() {
        return 结束时间;
    }

    /**
     * 设置结束时间属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set结束时间(XMLGregorianCalendar value) {
        this.结束时间 = value;
    }

}
