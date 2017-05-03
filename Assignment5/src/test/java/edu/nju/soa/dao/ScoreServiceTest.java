package edu.nju.soa.dao;

import edu.nju.soa.service.ScoreService;

/**
 * Created by baiguofeng on 2017/5/3.
 */
public class ScoreServiceTest {

    public static void main(String[] args){
        ScoreService scoreService = new ScoreService();
        System.out.println(scoreService.getScoresByStudentId(6));
    }
}
