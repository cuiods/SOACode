package edu.nju.soa.repository;

import edu.nju.soa.entity.CourseScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuihao on 2017-06-13.
 * course score repo definition
 */
public interface CourseScoreRepository extends JpaRepository<CourseScoreEntity,Integer> {
}
