package edu.nju.soa.translate;

import edu.nju.soa.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cuihao on 2017-05-30.
 * Generate document2 data
 */
public final class Generator {

    public static StudentList generateData() {
        StudentList studentList = new StudentList();

        String idList[] = new String[]{"141250204","141250019","141250002","141250104","141250210","141250173",
                "141250123","141250120","141250116","141250179","141250060","141250017"};
        String nameList[] = new String[]{"周聪","崔浩","白国风","阮威威","周颖婷","殷乾恩","潘凌伟","郑韵芝","孙婧","袁阳阳",
                "赖斌","陈自强"};

        for (int i = 0; i < idList.length; i++) {
            studentList.addStudent(new Student(
                    idList[i],
                    new PersonInfo(
                            nameList[i],
                            new Department(
                                    "141250","软件学院", DepartmentType.院,"专注于培养软件人才",
                                    new Address("中国","江苏","南京市鼓楼区","汉口路","22号")
                            ),
                            new Address("中国","江苏","南京市鼓楼区","汉口路","22号"),
                            "优秀的软院学生！"
                    ),
                    generateRandomScore(idList[i])
            ));
        }

        return studentList;
    }

    private static List<CourseScore> generateRandomScore(String sid) {
        Random random = new Random();
        List<CourseScore> scoreList = new ArrayList<>(15);
        boolean isPass = true;
        String[] types = new String[]{"平时成绩","期末成绩","总评成绩"};
        for (int i = 0; i < 5; i++) {

            StringBuilder courseId = new StringBuilder(random.nextInt(999999)+"");
            while (courseId.length()<6) {
                courseId = courseId.insert(0,"0");
            }

            for (int j = 0; j < 3; j++) {
                int score = random.nextInt(100)%(100-50+1) + 50;
                if (score < 60) {
                    isPass = false;
                }
                scoreList.add(new CourseScore(courseId.toString(),types[j],sid,score));
            }
        }
        if (isPass) {
            scoreList.get(0).getScoreList().get(0).setScore(59);
        }
        return scoreList;
    }

}
