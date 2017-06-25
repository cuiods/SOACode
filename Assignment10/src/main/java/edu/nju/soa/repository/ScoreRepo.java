package edu.nju.soa.repository;

import edu.nju.soa.entity.TScoreEntity;
import edu.nju.soa.entity.TScoreEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cuihao on 2017-06-25.
 *
 */
public interface ScoreRepo extends JpaRepository<TScoreEntity, TScoreEntityPK> {
    List<TScoreEntity> findBySid(String sid);
}
