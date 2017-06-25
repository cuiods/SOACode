package edu.nju.soa.dao.impl;

import edu.nju.soa.dao.ScoreDao;
import edu.nju.soa.entity.TScoreEntity;
import edu.nju.soa.repository.ScoreRepo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cuihao on 2017-06-25.
 *
 */
@Repository
public class ScoreDaoImpl implements ScoreDao {

    @Resource
    private ScoreRepo scoreRepo;

    @Override
    public TScoreEntity save(TScoreEntity scoreEntity) {
        return scoreRepo.save(scoreEntity);
    }

    @Override
    public void delete(TScoreEntity scoreEntity) {
        scoreRepo.delete(scoreEntity);
    }

    @Override
    public List<TScoreEntity> findBySid(String sid) {
        return scoreRepo.findBySid(sid);
    }
}
