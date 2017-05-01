package edu.nju.soa.dao;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * score dao test
 */
public class ScoreDaoTest {

    @Test
    public void getScoresByStudentId() throws Exception {
        ScoreDao scoreDao = ScoreDao.instance();
        System.out.println(scoreDao.getScoresByStudentId(141250204));
    }

}