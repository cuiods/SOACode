package edu.nju.soa.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by cuihao on 2017-06-25.
 * Student entity
 */
@Entity
@Table(name = "t_student")
public class TStudentEntity {
    private String sid;
    private String name;
    private String country;
    private String province;
    private String district;
    private String block;
    private String number;
    private String description;
    private TDepartmentEntity departmentEntity;

    @Id
    @Column(name = "sid", nullable = false, length = 9)
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "did", referencedColumnName = "did")
    public TDepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(TDepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 255)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "province", nullable = false, length = 255)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "district", nullable = false, length = 255)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "block", nullable = false, length = 255)
    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 255)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TStudentEntity that = (TStudentEntity) o;

        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (district != null ? !district.equals(that.district) : that.district != null) return false;
        if (block != null ? !block.equals(that.block) : that.block != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (block != null ? block.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
