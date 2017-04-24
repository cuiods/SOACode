package edu.nju.soa.entity;

/**
 * Created by sam on 2017/4/23.
 */
public class Score {
    private String number;
    private String score;

    public Score(String n,String s){
        this.number = n;
        this.score = s;
    }
    public Score(){
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
