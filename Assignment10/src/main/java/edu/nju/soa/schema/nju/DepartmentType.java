
package edu.nju.soa.schema.nju;

import javax.xml.bind.annotation.*;


/**
 * <p>DepartmentType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DepartmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="部门性质" type="{http://www.nju.edu.cn/schema}DepartmentTypeType"/>
 *         &lt;element name="部门介绍" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="部门地址" type="{http://www.nju.edu.cn/schema}AddressType"/>
 *       &lt;/all>
 *       &lt;attribute name="部门编号" type="{http://www.nju.edu.cn/schema}部门编号类型" />
 *       &lt;attribute name="部门名称" type="{http://www.nju.edu.cn/schema}部门名称类型" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u90e8\u95e8\u7c7b\u578b", propOrder = {

})
public class DepartmentType {

    @XmlElement(required = true)
    protected DepartmentTypeType 部门性质;
    @XmlElement(required = true)
    protected String 部门介绍;
    @XmlElement(required = true)
    protected AddressType 部门地址;
    @XmlAttribute
    protected String 部门编号;
    @XmlAttribute
    protected String 部门名称;

    /**
     * 获取部门性质属性的值。
     *
     * @return
     *     possible object is
     *     {@link DepartmentTypeType }
     *
     */
    public DepartmentTypeType get部门性质() {
        return 部门性质;
    }

    /**
     * 设置部门性质属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link DepartmentTypeType }
     *
     */
    public void set部门性质(DepartmentTypeType value) {
        this.部门性质 = value;
    }

    /**
     * 获取部门介绍属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String get部门介绍() {
        return 部门介绍;
    }

    /**
     * 设置部门介绍属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void set部门介绍(String value) {
        this.部门介绍 = value;
    }

    /**
     * 获取部门地址属性的值。
     *
     * @return
     *     possible object is
     *     {@link AddressType }
     *
     */
    public AddressType get部门地址() {
        return 部门地址;
    }

    /**
     * 设置部门地址属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void set部门地址(AddressType value) {
        this.部门地址 = value;
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
