package edu.nju.soa.dao.impl;

import com.google.common.collect.Lists;
import edu.nju.soa.BaseTest;
import edu.nju.soa.dao.ScoreDao;
import edu.nju.soa.entity.CourseScoreEntity;
import edu.nju.soa.entity.ScoreListEntity;
import edu.nju.soa.schema.tns.ScoreType;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by cuihao on 2017-06-13.
 * Score dao impl
 */
public class ScoreDaoImplTest extends BaseTest {

    @Resource
    private ScoreDao scoreDao;

    @Test
    public void findById() throws Exception {
        System.out.println(scoreDao.findById(7));
    }

    @Test
    @Transactional
    @Rollback
    public void save() throws Exception {
        ScoreListEntity scoreListEntity = new ScoreListEntity();
        scoreListEntity.setCid("000001");
        scoreListEntity.setScoreType(ScoreType.作业成绩);
        CourseScoreEntity courseScoreEntity = new CourseScoreEntity();
        courseScoreEntity.setScore(100);
        List<CourseScoreEntity> entities = Lists.newArrayList();
        entities.add(courseScoreEntity);
        scoreListEntity.setCourseScoreEntities(entities);
        System.out.println(scoreDao.save(scoreListEntity));
    }

    @Test
    @Transactional
    @Rollback
    public void delete() throws Exception {
        scoreDao.delete(6);
    }

    @Test
    public void findByCidAndType() throws Exception {
        System.out.println(scoreDao.findByCidAndType("000001",ScoreType.作业成绩).getId());
    }

    @Test
    public void findByEntityAndSid() throws Exception {
        ScoreListEntity scoreListEntity = scoreDao.findById(7);
        System.out.println(scoreDao.findByEntityAndSid(scoreListEntity,0).size());
    }

}