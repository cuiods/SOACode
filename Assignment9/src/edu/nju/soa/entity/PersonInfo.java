package edu.nju.soa.entity;

import javax.xml.bind.annotation.*;

/**
 * <p>Java class for 个人信息类型 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="个人信息类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="个人姓名" type="{http://www.nju.edu.cn/schema}个人姓名类型"/>
 *         &lt;element name="所在部门" type="{http://www.nju.edu.cn/schema}部门类型"/>
 *         &lt;element name="家庭住址" type="{http://www.nju.edu.cn/schema}地址类型"/>
 *         &lt;element name="个人简介" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "个人信息类型", propOrder = {

})
public class PersonInfo {

    @XmlElement(name = "个人姓名", namespace = NameSpace.NJU_URI)
    private String name;

    @XmlElement(name = "所在部门", namespace = NameSpace.NJU_URI)
    private Department department;

    @XmlElement(name = "家庭住址", namespace = NameSpace.NJU_URI)
    private Address address;

    @XmlElement(name = "个人简介", namespace = NameSpace.NJU_URI)
    private String description;

    public PersonInfo() {
    }

    public PersonInfo(String name, Department department, Address address, String description) {
        this.name = name;
        this.department = department;
        this.address = address;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
