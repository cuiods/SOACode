package edu.nju.soa.dao;

import edu.nju.soa.entity.CourseScoreEntity;
import edu.nju.soa.entity.ScoreEntity;
import edu.nju.soa.enums.ScoreType;
import edu.nju.soa.tool.EditScore;
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

    @Test
    public void save1() throws Exception {
        ScoreDao scoreDao = ScoreDao.instance();
        CourseScoreEntity courseScoreEntity = new CourseScoreEntity();
        courseScoreEntity.setCid(852290);
        courseScoreEntity.setType("平时成绩");
        System.out.println(scoreDao.save(courseScoreEntity).getType());
    }

    @Test
    public void save2() throws Exception {
        ScoreDao scoreDao = ScoreDao.instance();
        CourseScoreEntity courseScoreEntity = new CourseScoreEntity();
        courseScoreEntity.setCid(852290);
        courseScoreEntity.setType("平时成绩");
        CourseScoreEntity entity = scoreDao.save(courseScoreEntity);
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setEntity(entity);
        scoreEntity.setScore(97);
        scoreEntity.setSid(141250204);
        System.out.println(scoreDao.save(scoreEntity).getId());
    }

    @Test
    public void update() throws Exception {
        ScoreDao scoreDao = ScoreDao.instance();
        EditScore editScore = new EditScore(141250205,309716,"平时成绩",21);
        String result = scoreDao.update(editScore);
        System.out.println("test result:"+result);
    }

}