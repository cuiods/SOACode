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

    @XmlAttribute(name = "部门编号", namespace = NameSpace.NJU_URI)
    private String did;

    @XmlAttribute(name = "部门名称", namespace = NameSpace.NJU_URI)
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

    @XmlTransient
    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    @XmlTransient
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @XmlTransient
    public DepartmentType getDtype() {
        return dtype;
    }

    public void setDtype(DepartmentType dtype) {
        this.dtype = dtype;
    }

    @XmlTransient
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
