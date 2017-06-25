package edu.nju.soa.dao;

import edu.nju.soa.entity.TScoreEntity;

import java.util.List;

/**
 * Created by cuihao on 2017-06-25.
 *
 */
public interface ScoreDao {
    TScoreEntity save(TScoreEntity scoreEntity);
    void delete(TScoreEntity scoreEntity);
    List<TScoreEntity> findBySid(String sid);
}
