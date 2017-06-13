package edu.nju.soa.dao;

import edu.nju.soa.entity.UserEntity;

/**
 * Created by cuihao on 2017-06-13.
 * user dao
 */
public interface UserDao {

    UserEntity findById(int id);

    UserEntity findByEmail(String email);

    void delete(int id);

    UserEntity save(UserEntity userEntity);
}
