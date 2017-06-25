package edu.nju.soa.dao.impl;

import edu.nju.soa.dao.StudentDao;
import edu.nju.soa.entity.TDepartmentEntity;
import edu.nju.soa.entity.TScoreEntity;
import edu.nju.soa.entity.TStudentEntity;
import edu.nju.soa.repository.DepartmentRepo;
import edu.nju.soa.repository.ScoreRepo;
import edu.nju.soa.repository.StudentRepo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by cuihao on 2017-06-25.
 *
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Resource
    private StudentRepo studentRepo;

    @Resource
    private DepartmentRepo departmentRepo;

    @Resource
    private ScoreRepo scoreRepo;

    @Override
    public TStudentEntity findBySid(String sid) {
        return studentRepo.findOne(sid);
    }

    @Override
    @Transactional
    public TStudentEntity save(TStudentEntity studentEntity) {
        TDepartmentEntity departmentEntity = departmentRepo.findOne(studentEntity.getDepartmentEntity().getDid());
        if (departmentEntity == null) {
            studentEntity.setDepartmentEntity(departmentRepo.save(studentEntity.getDepartmentEntity()));
        }
        studentRepo.save(studentEntity);
        return studentEntity;
    }

    @Override
    public void deleteBySid(String sid) {
        delete(findBySid(sid));
    }

    @Override
    public void delete(TStudentEntity studentEntity) {
        studentRepo.delete(studentEntity);
    }

}
