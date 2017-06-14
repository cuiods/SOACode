package edu.nju.soa.dao;

import edu.nju.soa.entity.StudentEntity;

/**
 * Created by cuihao on 2017-06-13.
 * Student management dao
 */
public interface StudentDao {

    StudentEntity findById(int id);

    StudentEntity findBySid(String sid);

    StudentEntity save(StudentEntity studentEntity);

    StudentEntity update(StudentEntity studentEntity);

    void deleteById(int id);

    void deleteBySid(String sid);
}
