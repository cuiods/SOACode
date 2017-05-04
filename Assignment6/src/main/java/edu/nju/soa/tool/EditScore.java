package edu.nju.soa.tool;

public class EditScore {
    private int sid;
    private int cid;
    private String courseType;
    private int score;

    public EditScore(int sid, int cid, String courseType, int score) {
        this.sid = sid;
        this.cid = cid;
        this.courseType = courseType;
        this.score = score;
    }

    @Override
    public String toString() {
        return "EditScore{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", courseType='" + courseType + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EditScore editScore = (EditScore) o;

        if (sid != editScore.sid) return false;
        if (cid != editScore.cid) return false;
        if (score != editScore.score) return false;
        return courseType != null ? courseType.equals(editScore.courseType) : editScore.courseType == null;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + cid;
        result = 31 * result + (courseType != null ? courseType.hashCode() : 0);
        result = 31 * result + score;
        return result;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
