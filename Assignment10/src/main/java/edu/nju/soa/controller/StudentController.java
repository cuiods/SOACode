package edu.nju.soa.controller;

import edu.nju.soa.dao.StudentDao;
import edu.nju.soa.definition.StudentPort;
import edu.nju.soa.entity.StudentEntity;
import edu.nju.soa.schema.tns.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.transaction.Transactional;

/**
 * Created by cuihao on 2017-06-12.
 * Student controller
 */
@WebService(name = "StudentPort", targetNamespace = "http://jw.nju.edu.cn/schema")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@Component
@Transactional
public class StudentController implements StudentPort {

    @Resource
    private StudentDao studentDao;

    /**
     * get student info
     *
     * @param parameters sid
     * @return returns cn.edu.nju.jw.schema.StudentType
     * @throws IdNotFoundException cannot find id
     */
    @Override
    public StudentType getInfoById(GetInfoByIdType parameters) throws IdNotFoundException {
        StudentEntity studentEntity = studentDao.findBySid(parameters.getSid());
        if (studentEntity == null)
            throw new IdNotFoundException(NotFoundReasonType.学号不存在,parameters.getSid(),"Cannot find student");
        return new StudentType(studentEntity);
    }

    /**
     * delete student info
     *
     * @param parameters sid
     * @return returns cn.edu.nju.jw.schema.StudentType
     * @throws IdNotFoundException cannot find id
     * @throws AuthorityException  do not have authority
     */
    @Override
    public StudentType deleteInfoById(DeleteInfoByIdType parameters) throws AuthorityException, IdNotFoundException {
        StudentEntity studentEntity = studentDao.findBySid(parameters.getSid());
        if (studentEntity == null)
            throw new IdNotFoundException(NotFoundReasonType.学号不存在,parameters.getSid(),"Cannot find student");
        studentDao.deleteById(studentEntity.getId());
        return new StudentType(studentEntity);
    }

    /**
     * add student info
     *
     * @param parameters student info
     * @return returns cn.edu.nju.jw.schema.StudentType
     * @throws IdNotFoundException cannot find id
     */
    @Override
    public StudentType addInfo(AddInfoType parameters) throws IdNotFoundException {
        return new StudentType(studentDao.save(new StudentEntity(parameters.getStudent())));
    }

    /**
     * update student info
     *
     * @param parameters student info
     * @return returns cn.edu.nju.jw.schema.StudentType
     * @throws IdNotFoundException  cannot find student
     * @throws ScoreTypeException   score type error
     * @throws AuthorityException   do not have authority
     * @throws ScoreModifyException score modify error
     */
    @Override
    public StudentType updateInfo(StudentType parameters)
            throws AuthorityException, IdNotFoundException, ScoreModifyException, ScoreTypeException {
        StudentEntity studentEntity = studentDao.findBySid(parameters.getSid());
        if (studentEntity == null)
            throw new IdNotFoundException(NotFoundReasonType.学号不存在,parameters.getSid(),"Cannot find student");
        return new StudentType(studentDao.update(new StudentEntity(parameters)));
    }
}
