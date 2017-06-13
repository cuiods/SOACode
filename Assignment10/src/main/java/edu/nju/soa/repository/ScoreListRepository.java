package edu.nju.soa.repository;

import edu.nju.soa.entity.ScoreListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuihao on 2017-06-13.
 * couse score list repo definition
 */
public interface ScoreListRepository extends JpaRepository<ScoreListEntity,Integer> {
}
