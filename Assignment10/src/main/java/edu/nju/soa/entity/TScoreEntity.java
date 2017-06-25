package edu.nju.soa.entity;

import edu.nju.soa.schema.tns.ScoreType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cuihao on 2017-06-25.
 * Score entity
 */
@Entity
@Table(name = "t_score")
@IdClass(TScoreEntityPK.class)
public class TScoreEntity {
    private String cid;
    private ScoreType scoreType;
    private String sid;
    private int score;

    @Id
    @Column(name = "cid", nullable = false, length = 6)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "scoreType", nullable = false)
    public ScoreType getScoreType() {
        return scoreType;
    }

    public void setScoreType(ScoreType scoreType) {
        this.scoreType = scoreType;
    }

    @Id
    @Column(name = "sid", nullable = false, length = 9)
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
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

        TScoreEntity that = (TScoreEntity) o;

        if (score != that.score) return false;
        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (scoreType != null ? !scoreType.equals(that.scoreType) : that.scoreType != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (scoreType != null ? scoreType.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + score;
        return result;
    }
}
