package edu.nju.soa.dao.impl;

import edu.nju.soa.dao.ScoreDao;
import edu.nju.soa.dao.StudentDao;
import edu.nju.soa.entity.*;
import edu.nju.soa.repository.AddressRepository;
import edu.nju.soa.repository.DepartmentRepository;
import edu.nju.soa.repository.PersonInfoRepository;
import edu.nju.soa.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cuihao on 2017-06-13.
 * Student dao impl
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private AddressRepository addressRepository;

    @Resource
    private DepartmentRepository departmentRepository;

    @Resource
    private PersonInfoRepository personInfoRepository;

    @Resource
    private ScoreDao scoreDao;

    @Override
    public StudentEntity findById(int id) {
        return studentRepository.findOne(id);
    }

    @Override
    public StudentEntity findBySid(String sid) {
        return studentRepository.findBySid(sid);
    }

    @Override
    @Transactional
    public StudentEntity save(StudentEntity studentEntity) {
        PersonInfoEntity personInfo = studentEntity.getPersonInfo();
        DepartmentEntity departmentEntity = personInfo.getDepartment();
        departmentEntity.setAddress(addressRepository.save(departmentEntity.getAddress()));
        personInfo.setDepartment(departmentRepository.save(departmentEntity));
        personInfo.setAddress(addressRepository.save(personInfo.getAddress()));
        studentEntity.setPersonInfo(personInfoRepository.save(personInfo));
        List<ScoreListEntity> scoreListEntities = studentEntity.getScoreList();
        if (scoreListEntities!=null && !scoreListEntities.isEmpty()) {
            studentEntity.setScoreList(scoreListEntities.stream().map(s->scoreDao.save(s)).collect(Collectors.toList()));
        }
        return studentRepository.save(studentEntity);
    }

    @Override
    public StudentEntity update(StudentEntity studentEntity) {
        StudentEntity entity = findBySid(studentEntity.getSid());
        deleteById(entity.getId());
        return save(studentEntity);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.delete(id);
    }

    @Override
    public void deleteBySid(String sid) {
        StudentEntity studentEntity = studentRepository.findBySid(sid);
        if (sid!=null) {
            studentRepository.delete(studentEntity);
        }
    }
}
