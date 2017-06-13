package edu.nju.soa.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by cuihao on 2017-06-13.
 * Student entity
 */
@Entity
@Table(name = "student")
public class StudentEntity {
    private int id;
    private String sid;
    private PersonInfoEntity personInfo;
    private List<ScoreListEntity> scoreList;

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
    @JoinColumn(name = "info_id",referencedColumnName = "id")
    public PersonInfoEntity getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfoEntity personInfo) {
        this.personInfo = personInfo;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "stu_course", schema = "soa",
            joinColumns = @JoinColumn(name = "sid", referencedColumnName = "id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "cid", referencedColumnName = "id",nullable = false))
    public List<ScoreListEntity> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<ScoreListEntity> scoreList) {
        this.scoreList = scoreList;
    }

    @Basic
    @Column(name = "sid", nullable = false, length = 50)
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != that.id) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        return result;
    }
}
