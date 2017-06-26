
package cn.edu.nju.jw.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>排序类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="排序类型"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="排序方式" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="学号" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u6392\u5e8f\u7c7b\u578b", propOrder = {

})
public class 排序类型 {

    @XmlElement(required = true)
    protected String 排序方式;
    @XmlElement(required = true)
    protected String 学号;

    /**
     * 获取排序方式属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get排序方式() {
        return 排序方式;
    }

    /**
     * 设置排序方式属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set排序方式(String value) {
        this.排序方式 = value;
    }

    /**
     * 获取学号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get学号() {
        return 学号;
    }

    /**
     * 设置学号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set学号(String value) {
        this.学号 = value;
    }

}
