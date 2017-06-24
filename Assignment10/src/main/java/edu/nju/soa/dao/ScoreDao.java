package edu.nju.soa.dao;

import edu.nju.soa.entity.CourseScoreEntity;
import edu.nju.soa.entity.ScoreListEntity;
import edu.nju.soa.schema.tns.ScoreType;

import java.util.List;

/**
 * Created by cuihao on 2017-06-13.
 * Score management dao
 */
public interface ScoreDao {

    ScoreListEntity findById(int id);

    ScoreListEntity save(ScoreListEntity scoreListEntity);

    ScoreListEntity update(ScoreListEntity scoreListEntity);

    void delete(int id);

    ScoreListEntity findByCidAndType(String cid, ScoreType type);

    List<CourseScoreEntity> findByEntityAndSid(ScoreListEntity scoreListEntity, int sid);

    void delete(ScoreListEntity scoreListEntity);

}
