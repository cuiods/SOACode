package edu.nju.soa.repository;

import edu.nju.soa.entity.ScoreListEntity;
import edu.nju.soa.schema.tns.ScoreType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cuihao on 2017-06-13.
 * couse score list repo definition
 */
public interface ScoreListRepository extends JpaRepository<ScoreListEntity,Integer> {

    List<ScoreListEntity> findByCidAndScoreType(String cid, ScoreType scoreType);

}
