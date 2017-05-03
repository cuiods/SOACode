package edu.nju.soa.entity;

import javax.persistence.*;

/**
 * score entity
 */
@Entity
@Table(name = "score")
public class ScoreEntity {
    private int sid;
    private Integer score;
    private int id;
    private CourseScoreEntity entity;

    @Basic
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cid", referencedColumnName = "id")
    public CourseScoreEntity getEntity() {
        return entity;
    }

    public void setEntity(CourseScoreEntity entity) {
        this.entity = entity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreEntity that = (ScoreEntity) o;

        return sid == that.sid && id == that.id && (score != null ? score.equals(that.score) : that.score == null);
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

}
