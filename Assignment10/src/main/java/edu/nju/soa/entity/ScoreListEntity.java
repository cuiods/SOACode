package edu.nju.soa.entity;

import edu.nju.soa.schema.tns.CourseScore;
import edu.nju.soa.schema.tns.ScoreType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cuihao on 2017-06-13.
 * Course score container entity
 */
@Entity
@Table(name = "scoreList")
@NoArgsConstructor
@AllArgsConstructor
public class ScoreListEntity {
    private int id;
    private String cid;
    private ScoreType scoreType;
    private List<CourseScoreEntity> courseScoreEntities;

    public ScoreListEntity(CourseScore courseScore) {
        if (courseScore==null) return;
        BeanUtils.copyProperties(courseScore,this,"courseScoreEntities");
        if (courseScore.getCourseScoreTypes()!=null) {
            courseScoreEntities = courseScore.getCourseScoreTypes().stream()
                    .map(CourseScoreEntity::new).collect(Collectors.toList());
        }
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

    @OneToMany
    @JoinColumn(name = "course_id")
    public List<CourseScoreEntity> getCourseScoreEntities() {
        return courseScoreEntities;
    }

    public void setCourseScoreEntities(List<CourseScoreEntity> courseScoreEntities) {
        this.courseScoreEntities = courseScoreEntities;
    }

    @Basic
    @Column(name = "cid", nullable = false, length = 50)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "scoreType", nullable = false)
    public ScoreType getScoreType() {
        return scoreType;
    }

    public void setScoreType(ScoreType scoreType) {
        this.scoreType = scoreType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreListEntity that = (ScoreListEntity) o;

        if (id != that.id) return false;
        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (scoreType != null ? !scoreType.equals(that.scoreType) : that.scoreType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (scoreType != null ? scoreType.hashCode() : 0);
        return result;
    }
}
