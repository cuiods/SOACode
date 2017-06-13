package edu.nju.soa.repository;

import edu.nju.soa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuihao on 2017-06-13.
 * Auth repo definition
 */
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    UserEntity findByEmail(String email);

}
