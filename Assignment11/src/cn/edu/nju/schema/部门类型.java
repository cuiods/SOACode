
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>部门类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="部门类型"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="部门主管" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="部门描述" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/all&gt;
 *       &lt;attribute name="部门属性" type="{http://www.nju.edu.cn/schema}部门属性类型" /&gt;
 *       &lt;attribute name="部门编号" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="部门名称" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u90e8\u95e8\u7c7b\u578b", propOrder = {

})
public class 部门类型 {

    @XmlElement(required = true)
    protected String 部门主管;
    @XmlElement(required = true)
    protected String 部门描述;
    @XmlAttribute
    protected 部门属性类型 部门属性;
    @XmlAttribute
    protected String 部门编号;
    @XmlAttribute
    protected String 部门名称;

    /**
     * 获取部门主管属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get部门主管() {
        return 部门主管;
    }

    /**
     * 设置部门主管属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set部门主管(String value) {
        this.部门主管 = value;
    }

    /**
     * 获取部门描述属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get部门描述() {
        return 部门描述;
    }

    /**
     * 设置部门描述属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set部门描述(String value) {
        this.部门描述 = value;
    }

    /**
     * 获取部门属性属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 部门属性类型 }
     *     
     */
    public 部门属性类型 get部门属性() {
        return 部门属性;
    }

    /**
     * 设置部门属性属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 部门属性类型 }
     *     
     */
    public void set部门属性(部门属性类型 value) {
        this.部门属性 = value;
    }

    /**
     * 获取部门编号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get部门编号() {
        return 部门编号;
    }

    /**
     * 设置部门编号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set部门编号(String value) {
        this.部门编号 = value;
    }

    /**
     * 获取部门名称属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get部门名称() {
        return 部门名称;
    }

    /**
     * 设置部门名称属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set部门名称(String value) {
        this.部门名称 = value;
    }

}
