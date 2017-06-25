package edu.nju.soa.repository;

import edu.nju.soa.entity.TStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuihao on 2017-06-25.
 * student repo
 */
public interface StudentRepo extends JpaRepository<TStudentEntity,String> {
}
