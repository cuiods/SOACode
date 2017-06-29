package edu.nju.soa.client;

import cn.edu.nju.jw.wsdl.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuihao on 2017-06-26.
 * Client
 */
public class SoaClient {

    public static void main(String[] args) {

        ScoreService service = new ScoreService();

        //添加成绩
        课程成绩列表类型 listType = new 课程成绩列表类型();
        课程成绩类型 courseScore = new 课程成绩类型();
        成绩类型 score = new 成绩类型();
        score.set学号("141250179");
        score.set得分(100);
        courseScore.set成绩性质(成绩性质类型.总评成绩);
        courseScore.set课程编号("10001");
        List<成绩类型> scores = new ArrayList<>();
        scores.add(score);
        courseScore.set成绩(scores);
        List<课程成绩类型> courseTypes = new ArrayList<>();
        courseTypes.add(courseScore);
        listType.set课程成绩(courseTypes);
        service.addScore(listType,"141250019@smail.nju.edu.cn","123456789");
        service.addScore(listType,"teacher@nju.edu.cn","12345");

        //删除成绩
        学号课程号类型 sidCid = new 学号课程号类型();
        sidCid.set学号("141250179");
        sidCid.set课程编号("10001");
        service.deleteScore(sidCid,"141250019@smail.nju.edu.cn","0194");
        service.deleteScore(sidCid,"teacher@nju.edu.cn","123456");

        //查询成绩
        service.queryScore("141250179","141250019@smail.nju.edu.cn","123456");
        service.queryScore("141250029","teacher@nju.edu.cn","123456");
        service.queryScore("141250179","teacher@nju.edu.cn","123456");

        //修改成绩
        课程成绩类型 courseScore1 = new 课程成绩类型();
        成绩类型 score1 = new 成绩类型();
        score1.set学号("141250179");
        score1.set得分(90);
        courseScore1.set成绩性质(成绩性质类型.总评成绩);
        courseScore1.set课程编号("10002");
        List<成绩类型> scores1 = new ArrayList<>();
        scores1.add(score1);
        courseScore1.set成绩(scores1);
        service.modifyScore(courseScore1,"141250019@smail.nju.edu.cn","123456");
        service.modifyScore(courseScore1,"teacher@nju.edu.cn","123456");
    }

}
