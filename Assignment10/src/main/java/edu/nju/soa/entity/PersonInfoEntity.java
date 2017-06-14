package edu.nju.soa.entity;

import edu.nju.soa.schema.nju.PersonInfoType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

/**
 * Created by cuihao on 2017-06-13.
 * PersonInfo entity
 */
@Entity
@Table(name = "personInfo")
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfoEntity {
    private int id;
    private String name;
    private String description;
    private DepartmentEntity department;
    private AddressEntity address;

    public PersonInfoEntity(PersonInfoType personInfoType) {
        if (personInfoType==null) return;
        BeanUtils.copyProperties(personInfoType,this,"department","address");
        department = new DepartmentEntity(personInfoType.getDepartment());
        address = new AddressEntity(personInfoType.getAddress());
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
    @JoinColumn(name = "dep_id",referencedColumnName = "id")
    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addr_id",referencedColumnName = "id")
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
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

        PersonInfoEntity that = (PersonInfoEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
