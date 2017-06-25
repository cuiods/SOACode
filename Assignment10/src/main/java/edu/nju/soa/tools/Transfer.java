package edu.nju.soa.tools;

import com.google.common.collect.Lists;
import edu.nju.soa.entity.TDepartmentEntity;
import edu.nju.soa.entity.TScoreEntity;
import edu.nju.soa.entity.TStudentEntity;
import edu.nju.soa.schema.nju.AddressType;
import edu.nju.soa.schema.nju.DepartmentType;
import edu.nju.soa.schema.nju.PersonInfoType;
import edu.nju.soa.schema.tns.CourseScore;
import edu.nju.soa.schema.tns.CourseScoreListType;
import edu.nju.soa.schema.tns.CourseScoreType;
import edu.nju.soa.schema.tns.StudentType;

import java.util.List;

/**
 * Created by cuihao on 2017-06-25.
 * score transfer tools
 */
public class Transfer {

    public static List<TScoreEntity> transferScoreVoToEntity(List<CourseScore> courseScores) {
        List<TScoreEntity> scoreEntities = Lists.newArrayList();
        courseScores.forEach(courseScore -> courseScore.getCourseScoreTypes().forEach(courseScoreType -> {
            TScoreEntity scoreEntity = new TScoreEntity();
            scoreEntity.setCid(courseScore.getCid());
            scoreEntity.setScoreType(courseScore.getScoreType());
            scoreEntity.setSid(courseScoreType.getSid());
            scoreEntity.setScore(courseScoreType.getScore());
            scoreEntities.add(scoreEntity);
        }));
        return scoreEntities;
    }

    public static List<CourseScore> transferEntityToScoreVo(List<TScoreEntity> scoreEntities) {
        List<CourseScore> courseScores = Lists.newArrayList();
        out:for (TScoreEntity tScoreEntity: scoreEntities) {
            for (CourseScore courseScore: courseScores) {
                if (courseScore.getCid().equals(tScoreEntity.getCid())
                        && courseScore.getScoreType().equals(tScoreEntity.getScoreType())) {
                    courseScore.getCourseScoreTypes().add(new CourseScoreType(tScoreEntity.getSid(),tScoreEntity.getScore()));
                    continue out;
                }
            }
            CourseScore courseScore = new CourseScore(Lists.newArrayList(new CourseScoreType(tScoreEntity.getSid(),tScoreEntity.getScore())),
                    tScoreEntity.getCid(),tScoreEntity.getScoreType());
            courseScores.add(courseScore);
        };
        return courseScores;
    }

    //谁敢吐槽这段代码我和谁急
    //年度最佳代码
    //谁爱重构谁重构去吧
    public static TStudentEntity transferStudentToEntity(StudentType studentType) {
        TStudentEntity studentEntity = new TStudentEntity();
        studentEntity.setSid(studentType.getSid());
        studentEntity.setName(studentType.getPersonInfo().getName());
        studentEntity.setCountry(studentType.getPersonInfo().getAddress().getCountry());
        studentEntity.setProvince(studentType.getPersonInfo().getAddress().getProvince());
        studentEntity.setDistrict(studentType.getPersonInfo().getAddress().getDistrict());
        studentEntity.setBlock(studentType.getPersonInfo().getAddress().getBlock());
        studentEntity.setNumber(studentType.getPersonInfo().getAddress().getNumber());
        studentEntity.setDescription(studentType.getPersonInfo().getDescription());
        TDepartmentEntity departmentEntity = new TDepartmentEntity();
        departmentEntity.setDid(studentType.getPersonInfo().getDepartment().getDid());
        departmentEntity.setType(studentType.getPersonInfo().getDepartment().getType());
        departmentEntity.setCountry(studentType.getPersonInfo().getDepartment().getAddress().getCountry());
        departmentEntity.setProvince(studentType.getPersonInfo().getDepartment().getAddress().getProvince());
        departmentEntity.setDistrict(studentType.getPersonInfo().getDepartment().getAddress().getDistrict());
        departmentEntity.setBlock(studentType.getPersonInfo().getDepartment().getAddress().getBlock());
        departmentEntity.setNumber(studentType.getPersonInfo().getDepartment().getAddress().getNumber());
        departmentEntity.setDescription(studentType.getPersonInfo().getDepartment().getDescription());
        departmentEntity.setDname(studentType.getPersonInfo().getDepartment().getDname());
        studentEntity.setDepartmentEntity(departmentEntity);
        return studentEntity;
    }

    public static StudentType transferEntityToStudent(TStudentEntity studentEntity) {
        AddressType studentAddress = new AddressType(studentEntity.getCountry(),studentEntity.getProvince(),
                studentEntity.getDistrict(),studentEntity.getBlock(),studentEntity.getNumber());
        TDepartmentEntity departmentEntity = studentEntity.getDepartmentEntity();
        AddressType departmentAddress = new AddressType(departmentEntity.getCountry(),departmentEntity.getProvince(),
                departmentEntity.getDistrict(),departmentEntity.getBlock(),departmentEntity.getNumber());
        DepartmentType departmentType = new DepartmentType(departmentEntity.getType(),departmentEntity.getDescription(),
                departmentAddress,departmentEntity.getDid(),departmentEntity.getDname());
        PersonInfoType personInfoType = new PersonInfoType(studentEntity.getName(),departmentType,studentAddress,
                studentEntity.getDescription());
        CourseScoreListType courseScoreListType = new CourseScoreListType();
        return new StudentType(studentEntity.getSid(),personInfoType,courseScoreListType);
    }
}
