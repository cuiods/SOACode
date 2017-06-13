package edu.nju.soa.dao.impl;

import edu.nju.soa.BaseTest;
import edu.nju.soa.dao.UserDao;
import edu.nju.soa.entity.UserEntity;
import edu.nju.soa.schema.tns.AuthType;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2017-06-13.
 * user dao test
 */
public class UserDaoImplTest extends BaseTest {

    @Resource
    private UserDao userDao;

    @Test
    public void findById() throws Exception {
        System.out.println(userDao.findById(1));
    }

    @Test
    public void findByEmail() throws Exception {
        System.out.println(userDao.findByEmail("141250019@smail.nju.edu.cn").getEmail());
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    @Transactional
    @Rollback
    public void save() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("141250019@smail.nju.edu.cn");
        userEntity.setPassword("141250019");
        userEntity.setAuthType(AuthType.本科生);
        UserEntity entity = userDao.save(userEntity);
        System.out.println("Success"+entity.getId());
    }

}