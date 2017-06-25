
package edu.nju.soa.schema.nju;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
 *         &lt;element name="type" type="{http://www.nju.edu.cn/schema}DepartmentTypeType"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="address" type="{http://www.nju.edu.cn/schema}AddressType"/>
 *       &lt;/all>
 *       &lt;attribute name="did" type="{http://www.nju.edu.cn/schema}部门编号类型" />
 *       &lt;attribute name="dname" type="{http://www.nju.edu.cn/schema}部门名称类型" />
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
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentType {

    @XmlElement(name = "部门性质",required = true)
    protected DepartmentTypeType type;
    @XmlElement(name = "部门介绍",required = true)
    protected String description;
    @XmlElement(name = "部门地址",required = true)
    protected AddressType address;
    @XmlAttribute(name = "部门编号")
    protected String did;
    @XmlAttribute(name = "部门名称")
    protected String dname;

    /**
     * 获取部门性质属性的值。
     *
     * @return
     *     possible object is
     *     {@link DepartmentTypeType }
     *
     */
    public DepartmentTypeType getType() {
        return type;
    }

    /**
     * 设置部门性质属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link DepartmentTypeType }
     *
     */
    public void setType(DepartmentTypeType value) {
        this.type = value;
    }

    /**
     * 获取部门介绍属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置部门介绍属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * 获取部门地址属性的值。
     *
     * @return
     *     possible object is
     *     {@link AddressType }
     *
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * 设置部门地址属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

    /**
     * 获取部门编号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDid() {
        return did;
    }

    /**
     * 设置部门编号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDid(String value) {
        this.did = value;
    }

    /**
     * 获取部门名称属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDname() {
        return dname;
    }

    /**
     * 设置部门名称属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDname(String value) {
        this.dname = value;
    }

}
