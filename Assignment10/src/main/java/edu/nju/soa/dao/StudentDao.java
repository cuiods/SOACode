package edu.nju.soa.dao;

import edu.nju.soa.entity.TScoreEntity;
import edu.nju.soa.entity.TStudentEntity;

import java.util.List;

/**
 * Created by cuihao on 2017-06-25.
 *
 */
public interface StudentDao {
    TStudentEntity findBySid(String sid);
    TStudentEntity save(TStudentEntity studentEntity);
    void deleteBySid(String sid);
    void delete(TStudentEntity studentEntity);
}
