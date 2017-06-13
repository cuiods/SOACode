package edu.nju.soa.dao.impl;

import edu.nju.soa.dao.UserDao;
import edu.nju.soa.entity.UserEntity;
import edu.nju.soa.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by cuihao on 2017-06-13.
 * user dao impl
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserEntity findById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
