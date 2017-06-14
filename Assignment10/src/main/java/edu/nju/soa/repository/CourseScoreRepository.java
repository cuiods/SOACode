package edu.nju.soa.repository;

import edu.nju.soa.entity.CourseScoreEntity;
import edu.nju.soa.entity.ScoreListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cuihao on 2017-06-13.
 * course score repo definition
 */
public interface CourseScoreRepository extends JpaRepository<CourseScoreEntity,Integer> {

    List<CourseScoreEntity> findByScoreListEntityAndSid(ScoreListEntity scoreListEntity, int sid);

    List<CourseScoreEntity> findBySid(int sid);
}
