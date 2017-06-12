package edu.nju.soa.controller;

import edu.nju.soa.definition.Score;
import edu.nju.soa.schema.tns.*;

import javax.jws.WebService;
import javax.xml.ws.Holder;

/**
 * Created by cuihao on 2017-06-12.
 * Score controller
 */
@WebService(name = "Score", targetNamespace = "http://jw.nju.edu.cn/schema")
public class ScoreController implements Score {
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
    public void addScore(Holder<CourseScoreListType> courseScoreListTypeHolder) throws AuthorityException, IdNotFoundException, ScoreModifyException, ScoreTypeException {

    }

    /**
     * Get score
     *
     * @param parameters student id
     * @return returns cn.edu.nju.jw.schema.CourseScoreListType
     * @throws IdNotFoundException cannot find id
     */
    @Override
    public CourseScoreListType getScore(String parameters) throws IdNotFoundException {
        return null;
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
    public void modifyScore(Holder<CourseScoreListType> parameters) throws AuthorityException, IdNotFoundException, ScoreModifyException, ScoreTypeException {

    }
}
