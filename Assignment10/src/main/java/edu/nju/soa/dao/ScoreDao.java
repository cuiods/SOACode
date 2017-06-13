package edu.nju.soa.dao;

import edu.nju.soa.entity.CourseScoreEntity;
import edu.nju.soa.entity.ScoreListEntity;
import edu.nju.soa.schema.tns.CourseScoreType;

import java.util.List;

/**
 * Created by cuihao on 2017-06-13.
 * Score management dao
 */
public interface ScoreDao {

    ScoreListEntity findById(int id);

    ScoreListEntity save(ScoreListEntity scoreListEntity);

    void delete(int id);

    ScoreListEntity findByCidAndType(String cid, CourseScoreType type);

    List<CourseScoreEntity> findByEntityAndSid(ScoreListEntity scoreListEntity, int sid);
}
