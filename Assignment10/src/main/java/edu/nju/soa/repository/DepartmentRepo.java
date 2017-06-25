package edu.nju.soa.repository;

import edu.nju.soa.entity.TDepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuihao on 2017-06-25.
 *
 */
public interface DepartmentRepo extends JpaRepository<TDepartmentEntity,String> {
}
