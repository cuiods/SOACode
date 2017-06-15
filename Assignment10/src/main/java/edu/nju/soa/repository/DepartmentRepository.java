package edu.nju.soa.repository;

import edu.nju.soa.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuihao on 2017-06-13.
 * Department repo definition
 */
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer>{
    DepartmentEntity findByDid(String did);
}
