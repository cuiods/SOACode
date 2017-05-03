package edu.nju.soa.entity;

import edu.nju.soa.enums.ScoreType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Course score entity
 */
@Entity
@Table(name = "course_score")
public class CourseScoreEntity {
    private int id;
    private int cid;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cid")
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseScoreEntity that = (CourseScoreEntity) o;

        if (cid != that.cid) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
