package edu.nju.soa.entity;

import javax.xml.bind.annotation.*;

/**
 * Created by cuihao on 2017-05-30.
 * Department entity
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "部门类型", propOrder = {

})
public class Department {

    @XmlAttribute(name = "部门编号")
    private String did;

    @XmlAttribute(name = "部门名称")
    private String dname;

    @XmlElement(name = "部门性质", namespace = NameSpace.NJU_URI)
    private DepartmentType dtype;

    @XmlElement(name = "部门介绍", namespace = NameSpace.NJU_URI)
    private String description;

    @XmlElement(name = "部门地址", namespace = NameSpace.NJU_URI)
    private Address address;

    public Department() {
    }

    public Department(String did, String dname, DepartmentType dtype, String description, Address address) {
        this.did = did;
        this.dname = dname;
        this.dtype = dtype;
        this.description = description;
        this.address = address;
    }

    /**
     * Gets the value of the 部门编号 property.
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
     * Sets the value of the 部门编号 property.
     *
     * @param did
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDid(String did) {
        this.did = did;
    }

    /**
     * Gets the value of the 部门名称 property.
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
     * Sets the value of the 部门名称 property.
     *
     * @param dname
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDname(String dname) {
        this.dname = dname;
    }

    /**
     * Gets the value of the 部门性质 property.
     *
     * @return
     *     possible object is
     *     {@link DepartmentType }
     *
     */
    public DepartmentType getDtype() {
        return dtype;
    }

    /**
     * Sets the value of the 部门性质 property.
     *
     * @param dtype
     *     allowed object is
     *     {@link DepartmentType }
     *
     */
    public void setDtype(DepartmentType dtype) {
        this.dtype = dtype;
    }

    /**
     * Gets the value of the 部门介绍 property.
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
     * Sets the value of the 部门介绍 property.
     *
     * @param description
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the value of the 部门地址 property.
     *
     * @return
     *     possible object is
     *     {@link Address }
     *
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the 部门地址 property.
     *
     * @param address
     *     allowed object is
     *     {@link Address }
     *
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
