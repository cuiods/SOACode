
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>地址类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="地址类型"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="省份" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="城市" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="区" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="街道" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="号" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u5730\u5740\u7c7b\u578b", propOrder = {
    "\u7701\u4efd",
    "\u57ce\u5e02",
    "\u533a",
    "\u8857\u9053",
    "\u53f7"
})
public class 地址类型 {

    protected String 省份;
    @XmlElement(required = true)
    protected String 城市;
    @XmlElement(required = true)
    protected String 区;
    @XmlElement(required = true)
    protected String 街道;
    @XmlElement(required = true)
    protected String 号;

    /**
     * 获取省份属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get省份() {
        return 省份;
    }

    /**
     * 设置省份属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set省份(String value) {
        this.省份 = value;
    }

    /**
     * 获取城市属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get城市() {
        return 城市;
    }

    /**
     * 设置城市属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set城市(String value) {
        this.城市 = value;
    }

    /**
     * 获取区属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get区() {
        return 区;
    }

    /**
     * 设置区属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set区(String value) {
        this.区 = value;
    }

    /**
     * 获取街道属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get街道() {
        return 街道;
    }

    /**
     * 设置街道属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set街道(String value) {
        this.街道 = value;
    }

    /**
     * 获取号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get号() {
        return 号;
    }

    /**
     * 设置号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set号(String value) {
        this.号 = value;
    }

}
