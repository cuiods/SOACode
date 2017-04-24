package edu.nju.soa.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sam on 2017/4/23.
 */
public class Course {
    private String id;
    private String type;
    private List<Score> scores;

    public Course(String Id, String Type){
        this.id = Id;
        this.type = Type;
        scores = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public void addScore(Score score){
        this.scores.add(score);
    }

    public int getScoreSize(){
        return scores.size();
    }
}
