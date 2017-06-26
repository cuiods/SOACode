
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>个人基本信息类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="个人基本信息类型"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="姓名" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="性别" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="教育背景" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="婚姻状况" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="手机号码" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="部门" type="{http://www.nju.edu.cn/schema}部门类型"/&gt;
 *         &lt;element name="地址" type="{http://www.nju.edu.cn/schema}地址类型"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u4e2a\u4eba\u57fa\u672c\u4fe1\u606f\u7c7b\u578b", propOrder = {
    "\u59d3\u540d",
    "\u6027\u522b",
    "\u6559\u80b2\u80cc\u666f",
    "\u5a5a\u59fb\u72b6\u51b5",
    "\u624b\u673a\u53f7\u7801",
    "\u90e8\u95e8",
    "\u5730\u5740"
})
@XmlSeeAlso({
    个人信息类型.class
})
public class 个人基本信息类型 {

    @XmlElement(required = true)
    protected String 姓名;
    @XmlElement(required = true)
    protected String 性别;
    @XmlElement(required = true)
    protected String 教育背景;
    @XmlElement(required = true)
    protected String 婚姻状况;
    @XmlElement(required = true)
    protected String 手机号码;
    @XmlElement(required = true)
    protected 部门类型 部门;
    @XmlElement(required = true)
    protected 地址类型 地址;

    /**
     * 获取姓名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get姓名() {
        return 姓名;
    }

    /**
     * 设置姓名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set姓名(String value) {
        this.姓名 = value;
    }

    /**
     * 获取性别属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get性别() {
        return 性别;
    }

    /**
     * 设置性别属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set性别(String value) {
        this.性别 = value;
    }

    /**
     * 获取教育背景属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get教育背景() {
        return 教育背景;
    }

    /**
     * 设置教育背景属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set教育背景(String value) {
        this.教育背景 = value;
    }

    /**
     * 获取婚姻状况属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get婚姻状况() {
        return 婚姻状况;
    }

    /**
     * 设置婚姻状况属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set婚姻状况(String value) {
        this.婚姻状况 = value;
    }

    /**
     * 获取手机号码属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get手机号码() {
        return 手机号码;
    }

    /**
     * 设置手机号码属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set手机号码(String value) {
        this.手机号码 = value;
    }

    /**
     * 获取部门属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 部门类型 }
     *     
     */
    public 部门类型 get部门() {
        return 部门;
    }

    /**
     * 设置部门属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 部门类型 }
     *     
     */
    public void set部门(部门类型 value) {
        this.部门 = value;
    }

    /**
     * 获取地址属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 地址类型 }
     *     
     */
    public 地址类型 get地址() {
        return 地址;
    }

    /**
     * 设置地址属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 地址类型 }
     *     
     */
    public void set地址(地址类型 value) {
        this.地址 = value;
    }

}
