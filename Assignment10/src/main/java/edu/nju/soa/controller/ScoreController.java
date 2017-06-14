package edu.nju.soa.controller;

import edu.nju.soa.dao.ScoreDao;
import edu.nju.soa.dao.StudentDao;
import edu.nju.soa.definition.Score;
import edu.nju.soa.entity.CourseScoreEntity;
import edu.nju.soa.entity.ScoreListEntity;
import edu.nju.soa.schema.tns.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.transaction.Transactional;
import javax.xml.ws.Holder;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cuihao on 2017-06-12.
 * Score controller
 */
@WebService(name = "Score", targetNamespace = "http://jw.nju.edu.cn/schema")
@Component
public class ScoreController implements Score {

    @Resource
    private ScoreDao scoreDao;

    @Resource
    private StudentDao studentDao;

    /**
     * Add score
     *
     * @param courseScoreListTypeHolder Mode: in and out
     * @throws IdNotFoundException  cannot find id
     * @throws ScoreTypeException   score type error
     * @throws ScoreModifyException score modify error
     * @throws AuthorityException   do not have authority
     */
    @Override
    @Transactional
    public void addScore(Holder<CourseScoreListType> courseScoreListTypeHolder)
            throws AuthorityException, IdNotFoundException, ScoreModifyException, ScoreTypeException {
        List<CourseScore> courseScores = courseScoreListTypeHolder.value.getCourseScores();
        validate(courseScores);
        courseScoreListTypeHolder.value.setCourseScores(courseScores.stream()
                .map(ScoreListEntity::new)
                .map(scoreListEntity -> scoreDao.save(scoreListEntity))
                .map(CourseScore::new).collect(Collectors.toList()));
    }

    /**
     * Get score
     *
     * @param parameters student id
     * @return returns cn.edu.nju.jw.schema.CourseScoreListType
     * @throws IdNotFoundException cannot find id
     */
    @Override
    @Transactional
    public CourseScoreListType getScore(String parameters) throws IdNotFoundException {
        CourseScoreListType courseScoreListType = new CourseScoreListType();
        List<ScoreListEntity> courseScoreEntities = studentDao.findById(Integer.parseInt(parameters)).getScoreList();
        if (courseScoreEntities==null || courseScoreEntities.size()==0)
            throw new IdNotFoundException(NotFoundReasonType.未找到输入学号的成绩,parameters,"No scores found");
        courseScoreListType.setCourseScores(courseScoreEntities.stream().map(CourseScore::new)
                .collect(Collectors.toList()));
        return courseScoreListType;
    }

    /**
     * update score
     *
     * @param parameters score list
     * @throws IdNotFoundException  cannot find id
     * @throws ScoreTypeException   score type error
     * @throws ScoreModifyException score modify error
     * @throws AuthorityException   do not have authority
     */
    @Override
    public void modifyScore(Holder<CourseScoreListType> parameters)
            throws AuthorityException, IdNotFoundException, ScoreModifyException, ScoreTypeException {
        List<CourseScore> courseScores = parameters.value.getCourseScores();
        validate(courseScores);
        parameters.value.setCourseScores(courseScores.stream()
                .map(ScoreListEntity::new)
                .map(scoreListEntity -> scoreDao.update(scoreListEntity))
                .map(CourseScore::new).collect(Collectors.toList()));
    }

    private void validate(List<CourseScore> courseScores) throws ScoreModifyException,ScoreModifyException {
        for (CourseScore courseScore : courseScores) {
            for (CourseScoreType courseScoreType : courseScore.getCourseScoreTypes()) {
                if (courseScoreType.getScore() > 100 || courseScoreType.getScore() < 0)
                    throw new ScoreModifyException(0,"score range error(acccept 0-100)","score");
                if (courseScoreType.getSid().length()!=9)
                    throw new ScoreModifyException(1,"student id length must be 9","sid");
            }
        }
    }
}
