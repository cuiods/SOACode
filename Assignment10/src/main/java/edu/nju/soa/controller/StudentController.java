package edu.nju.soa.controller;

import edu.nju.soa.definition.StudentPort;
import edu.nju.soa.schema.tns.*;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by cuihao on 2017-06-12.
 * Student controller
 */
@WebService(name = "StudentPort", targetNamespace = "http://jw.nju.edu.cn/schema")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class StudentController implements StudentPort {
    /**
     * get student info
     *
     * @param parameters sid
     * @return returns cn.edu.nju.jw.schema.StudentType
     * @throws IdNotFoundException cannot find id
     */
    @Override
    public StudentType getInfoById(GetInfoByIdType parameters) throws IdNotFoundException {
        return null;
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
        return null;
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
        return null;
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
    public StudentType updateInfo(StudentType parameters) throws AuthorityException, IdNotFoundException, ScoreModifyException, ScoreTypeException {
        return null;
    }
}
