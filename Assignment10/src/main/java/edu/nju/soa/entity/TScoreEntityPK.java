package edu.nju.soa.entity;

import edu.nju.soa.schema.tns.ScoreType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by cuihao on 2017-06-25.
 * score pk
 */
public class TScoreEntityPK implements Serializable {
    private String cid;
    private ScoreType scoreType;
    private String sid;

    @Column(name = "cid", nullable = false, length = 6)
    @Id
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Column(name = "scoreType", nullable = false)
    @Enumerated(EnumType.STRING)
    @Id
    public ScoreType getScoreType() {
        return scoreType;
    }

    public void setScoreType(ScoreType scoreType) {
        this.scoreType = scoreType;
    }

    @Column(name = "sid", nullable = false, length = 9)
    @Id
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

        TScoreEntityPK that = (TScoreEntityPK) o;

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
        return result;
    }
}
