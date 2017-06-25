package edu.nju.soa.entity;

import edu.nju.soa.schema.nju.DepartmentTypeType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cuihao on 2017-06-25.
 * DepartmentRepo entity
 */
@Entity
@Table(name = "t_department")
public class TDepartmentEntity {
    private String did;
    private DepartmentTypeType type;
    private String country;
    private String province;
    private String district;
    private String block;
    private String number;
    private String description;
    private String dname;

    @Id
    @Column(name = "did", nullable = false, length = 6)
    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    public DepartmentTypeType getType() {
        return type;
    }

    public void setType(DepartmentTypeType type) {
        this.type = type;
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

    @Basic
    @Column(name = "dname", nullable = false, length = 255)
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TDepartmentEntity that = (TDepartmentEntity) o;

        if (did != null ? !did.equals(that.did) : that.did != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (district != null ? !district.equals(that.district) : that.district != null) return false;
        if (block != null ? !block.equals(that.block) : that.block != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (dname != null ? !dname.equals(that.dname) : that.dname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = did != null ? did.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (block != null ? block.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        return result;
    }
}
