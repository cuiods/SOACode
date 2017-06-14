package edu.nju.soa.dao.impl;

import com.google.common.collect.Lists;
import edu.nju.soa.BaseTest;
import edu.nju.soa.dao.StudentDao;
import edu.nju.soa.entity.*;
import edu.nju.soa.schema.nju.DepartmentTypeType;
import edu.nju.soa.schema.tns.ScoreType;
import org.junit.Test;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2017-06-14.
 * Student dao test
 */
public class StudentDaoImplTest extends BaseTest {

    @Resource
    private StudentDao studentDao;

    @Test
    @Transactional
    public void findById() throws Exception {
        StudentEntity studentEntity = studentDao.findById(1);
        System.out.println(studentEntity.getScoreList().get(0).getScoreType());
        System.out.println(studentEntity.getPersonInfo().getAddress().getCountry());
    }

    @Test
    public void findBySid() throws Exception {
        StudentEntity studentEntity = studentDao.findBySid("141250019");
        assertNotNull(studentEntity);
    }

    @Test
    public void save() throws Exception {
        List<ScoreListEntity> scoreListEntities = Lists.newArrayList();
        ScoreListEntity scoreListEntity = new ScoreListEntity();
        scoreListEntity.setCid("000001");
        scoreListEntity.setScoreType(ScoreType.作业成绩);
        CourseScoreEntity courseScoreEntity = new CourseScoreEntity();
        courseScoreEntity.setSid(141250019);
        courseScoreEntity.setScore(100);
        List<CourseScoreEntity> entities = Lists.newArrayList();
        entities.add(courseScoreEntity);
        scoreListEntity.setCourseScoreEntities(entities);
        scoreListEntities.add(scoreListEntity);
        StudentEntity studentEntity = new StudentEntity(
                0,
                "141250019",
                new PersonInfoEntity(
                        0,"崔浩","描述",
                        new DepartmentEntity(0, DepartmentTypeType.院,"软件","141250","南京大学软件学院",
                                new AddressEntity(0,"中国","江苏","南京鼓楼","汉口路","22")),
                        new AddressEntity(0,"中国","江苏","南京鼓楼","汉口路","22")
                ),
                scoreListEntities
        );
        StudentEntity entity = studentDao.save(studentEntity);
        System.out.println(entity.getId());
        System.out.println(entity.getPersonInfo().getName());
        System.out.println(entity.getScoreList().size());
    }

    @Test
    public void deleteById() throws Exception {
        studentDao.deleteById(1);
    }

    @Test
    public void deleteBySid() throws Exception {
    }

}