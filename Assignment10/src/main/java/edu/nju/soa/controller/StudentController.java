package edu.nju.soa.controller;

import edu.nju.soa.dao.ScoreDao;
import edu.nju.soa.dao.StudentDao;
import edu.nju.soa.definition.StudentPort;
import edu.nju.soa.entity.TScoreEntity;
import edu.nju.soa.entity.TStudentEntity;
import edu.nju.soa.repository.ScoreRepo;
import edu.nju.soa.schema.tns.*;
import edu.nju.soa.tools.Transfer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.transaction.Transactional;
import java.util.List;

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

    @Resource
    private ScoreDao scoreDao;

    @Resource
    private ScoreRepo scoreRepo;

    /**
     * get student info
     *
     * @param parameters sid
     * @return returns cn.edu.nju.jw.schema.StudentType
     * @throws IdNotFoundException cannot find id
     */
    @Override
    public StudentType getInfoById(GetInfoByIdType parameters) throws IdNotFoundException {
        TStudentEntity studentEntity = studentDao.findBySid(parameters.getSid());
        if (studentEntity == null)
            throw new IdNotFoundException(NotFoundReasonType.学号不存在,parameters.getSid(),"");
        StudentType studentType = Transfer.transferEntityToStudent(studentEntity);
        CourseScoreListType courseScoreListType = new CourseScoreListType();
        courseScoreListType.setCourseScores(Transfer.transferEntityToScoreVo(scoreDao.findBySid(parameters.getSid())));
        studentType.setCourseScoreListType(courseScoreListType);
        return studentType;
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
        GetInfoByIdType getInfoByIdType = new GetInfoByIdType();
        getInfoByIdType.setSid(parameters.getSid());
        StudentType studentType = getInfoById(getInfoByIdType);
        scoreRepo.delete(scoreDao.findBySid(parameters.getSid()));
        studentDao.deleteBySid(parameters.getSid());
        return studentType;
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
        TStudentEntity studentEntity = Transfer.transferStudentToEntity(parameters.getStudent());
        studentDao.save(studentEntity);
        List<TScoreEntity> tScoreEntities = Transfer.transferScoreVoToEntity(parameters.getStudent().getCourseScoreListType().getCourseScores());
        tScoreEntities.forEach(scoreEntity -> scoreDao.save(scoreEntity));
        return parameters.getStudent();
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
        TStudentEntity studentEntity = Transfer.transferStudentToEntity(parameters);
        studentDao.save(studentEntity);
        List<TScoreEntity> tScoreEntities = Transfer.transferScoreVoToEntity(parameters.getCourseScoreListType().getCourseScores());
        tScoreEntities.forEach(scoreEntity -> scoreDao.save(scoreEntity));
        return parameters;
    }
}
