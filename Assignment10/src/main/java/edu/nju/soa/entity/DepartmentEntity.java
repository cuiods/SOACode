package edu.nju.soa.entity;

import edu.nju.soa.schema.nju.DepartmentType;
import edu.nju.soa.schema.nju.DepartmentTypeType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cuihao on 2017-06-13.
 * Department entity
 */
@Entity
@Table(name = "department")
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {
    private int id;
    private DepartmentTypeType type;
    private String description;
    private String did;
    private String dname;
    private AddressEntity address;

    public DepartmentEntity(DepartmentType department) {
        if (department == null) return;
        BeanUtils.copyProperties(department,this,"address");
        address = new AddressEntity(department.getAddress());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
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
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "did", nullable = false, length = 50)
    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    @Basic
    @Column(name = "dname", nullable = false, length = 50)
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

        DepartmentEntity that = (DepartmentEntity) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (did != null ? !did.equals(that.did) : that.did != null) return false;
        if (dname != null ? !dname.equals(that.dname) : that.dname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (did != null ? did.hashCode() : 0);
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        return result;
    }

}
