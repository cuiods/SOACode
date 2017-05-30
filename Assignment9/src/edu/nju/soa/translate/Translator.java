package edu.nju.soa.translate;

import edu.nju.soa.entity.CourseScore;
import edu.nju.soa.entity.Score;
import edu.nju.soa.entity.ScoreList;
import edu.nju.soa.entity.StudentList;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cuihao on 2017-05-30.
 * Document translator
 */
public class Translator {

    public static ScoreList convert(StudentList studentList) {
        ScoreList scoreList = new ScoreList();

        List<CourseScore> tempList = studentList.getStudents().stream()
                .flatMap(student -> student.getCourseScores().stream()).collect(Collectors.toList());

        List<CourseScore> resultList = new LinkedList<>();
        for (CourseScore courseScore: tempList) {
            boolean isRepeat = false;
            int repeatIndex = 0;
            for (; repeatIndex < resultList.size(); repeatIndex++) {
                CourseScore testScore = resultList.get(repeatIndex);
                if (testScore.getCid().equals(courseScore.getCid())
                        && testScore.getType().equals(courseScore.getType())) {
                    isRepeat = true;
                    break;
                }
            }
            if (isRepeat) {
                List<Score> scores = resultList.get(repeatIndex).getScoreList();
                scores.addAll(courseScore.getScoreList());
                scores.sort(Comparator.comparingInt(Score::getScore));
            } else {
                resultList.add(courseScore);
            }
        }
        resultList.sort(Comparator.comparingInt(c -> Integer.parseInt(c.getCid())));
        scoreList.setCourseScoreList(resultList);
        return scoreList;
    }

    public static ScoreList convert(ScoreList scoreList) {
        for (CourseScore courseScore: scoreList.getCourseScoreList()) {
            courseScore.setScoreList(courseScore.getScoreList().stream()
                    .filter(score -> score.getScore() < 60).collect(Collectors.toList()));
        }
        scoreList.setCourseScoreList(scoreList.getCourseScoreList().stream()
                .filter(courseScore -> courseScore.getScoreList().size()>0).collect(Collectors.toList()));
        return scoreList;
    }

}
