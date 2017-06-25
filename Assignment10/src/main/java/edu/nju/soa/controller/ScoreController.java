package edu.nju.soa.controller;

import edu.nju.soa.dao.ScoreDao;
import edu.nju.soa.definition.Score;
import edu.nju.soa.entity.TScoreEntity;
import edu.nju.soa.schema.tns.*;
import edu.nju.soa.tools.Transfer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.transaction.Transactional;
import javax.xml.ws.Holder;
import java.util.List;

/**
 * Created by cuihao on 2017-06-12.
 * Score controller
 */
@WebService(name = "Score", targetNamespace = "http://jw.nju.edu.cn/schema")
@Component
public class ScoreController implements Score {

    @Resource
    private ScoreDao scoreDao;

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
        validate(courseScoreListTypeHolder.value.getCourseScores());
        TScoreEntity scoreEntityCurrent = null;
        try {
            List<TScoreEntity> scoreEntities = Transfer.transferScoreVoToEntity(courseScoreListTypeHolder.value.getCourseScores());
            for (TScoreEntity scoreEntity: scoreEntities) {
                scoreEntityCurrent = scoreEntity;
                scoreDao.save(scoreEntity);
            }
        } catch (Exception e) {
            throw new IdNotFoundException(NotFoundReasonType.学号不存在,scoreEntityCurrent==null?"null":scoreEntityCurrent.getSid(),"");
        }
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
        List<TScoreEntity> scoreEntities = scoreDao.findBySid(parameters);
        if (scoreEntities == null || scoreEntities.isEmpty())
            throw new IdNotFoundException(NotFoundReasonType.未找到输入学号的成绩, parameters,"");
        courseScoreListType.setCourseScores(Transfer.transferEntityToScoreVo(scoreEntities));
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
    @Transactional
    public void modifyScore(Holder<CourseScoreListType> parameters)
            throws AuthorityException, IdNotFoundException, ScoreModifyException, ScoreTypeException {
        validate(parameters.value.getCourseScores());
        TScoreEntity scoreEntityCurrent = null;
        try {
            List<TScoreEntity> scoreEntities = Transfer.transferScoreVoToEntity(parameters.value.getCourseScores());
            for (TScoreEntity scoreEntity: scoreEntities) {
                scoreEntityCurrent = scoreEntity;
                scoreDao.save(scoreEntity);
            }
        } catch (Exception e) {
            throw new IdNotFoundException(NotFoundReasonType.未找到输入学号的成绩,scoreEntityCurrent==null?"null":scoreEntityCurrent.getSid(),"");
        }
    }

    /**
     * delete score
     *
     * @param parameters score list
     * @throws IdNotFoundException  cannot find id
     * @throws ScoreTypeException   score type error
     * @throws ScoreModifyException score modify error
     * @throws AuthorityException   do not have authority
     */
    @Override
    @Transactional
    public void deleteScore(Holder<CourseScoreListType> parameters)
            throws AuthorityException, IdNotFoundException, ScoreModifyException, ScoreTypeException {
        validate(parameters.value.getCourseScores());
        TScoreEntity scoreEntityCurrent = null;
        try {
            List<TScoreEntity> scoreEntities = Transfer.transferScoreVoToEntity(parameters.value.getCourseScores());
            for (TScoreEntity scoreEntity: scoreEntities) {
                scoreEntityCurrent = scoreEntity;
                scoreDao.delete(scoreEntity);
            }
        } catch (Exception e) {
            throw new IdNotFoundException(NotFoundReasonType.未找到输入课程的成绩,scoreEntityCurrent==null?"null":scoreEntityCurrent.getSid(),"");
        }
    }

    private void validate(List<CourseScore> courseScores) throws ScoreModifyException {
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
