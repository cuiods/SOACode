package edu.nju.soa.repository;

import edu.nju.soa.entity.PersonInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuihao on 2017-06-13.
 * person info repository
 */
public interface PersonInfoRepository extends JpaRepository<PersonInfoEntity, Integer> {
}
