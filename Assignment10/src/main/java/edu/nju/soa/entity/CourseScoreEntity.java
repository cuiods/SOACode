package edu.nju.soa.entity;

import edu.nju.soa.schema.tns.CourseScoreType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

/**
 * Created by cuihao on 2017-06-13.
 * Score entity
 */
@Entity
@Table(name = "courseScore")
@NoArgsConstructor
@AllArgsConstructor
public class CourseScoreEntity {
    private int id;
    private int sid;
    private int score;
    private ScoreListEntity scoreListEntity;

    public CourseScoreEntity(CourseScoreType courseScoreType) {
        if (courseScoreType == null) return;
        BeanUtils.copyProperties(courseScoreType,this);
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

    @ManyToOne
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    public ScoreListEntity getScoreListEntity() {
        return scoreListEntity;
    }

    public void setScoreListEntity(ScoreListEntity scoreListEntity) {
        this.scoreListEntity = scoreListEntity;
    }

    @Basic
    @Column(name = "sid", nullable = false)
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "score", nullable = false)
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseScoreEntity that = (CourseScoreEntity) o;

        if (id != that.id) return false;
        if (sid != that.sid) return false;
        if (score != that.score) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + sid;
        result = 31 * result + score;
        return result;
    }
}
