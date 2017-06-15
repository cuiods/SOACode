package edu.nju.soa.dao.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import edu.nju.soa.dao.ScoreDao;
import edu.nju.soa.dao.StudentDao;
import edu.nju.soa.entity.CourseScoreEntity;
import edu.nju.soa.entity.ScoreListEntity;
import edu.nju.soa.entity.StudentEntity;
import edu.nju.soa.repository.CourseScoreRepository;
import edu.nju.soa.repository.ScoreListRepository;
import edu.nju.soa.schema.tns.ScoreType;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by cuihao on 2017-06-13.
 * Score dao impl
 */
@Repository
public class ScoreDaoImpl implements ScoreDao {

    @Resource
    private ScoreListRepository scoreListRepository;

    @Resource
    private CourseScoreRepository courseScoreRepository;

    @Override
    public ScoreListEntity findById(int id) {
        return scoreListRepository.findOne(id);
    }

    @Override
    public ScoreListEntity save(ScoreListEntity scoreListEntity) {
        if (scoreListEntity == null) return null;
        List<CourseScoreEntity> courseScoreEntities = scoreListEntity.getCourseScoreEntities();
        scoreListEntity.setCourseScoreEntities(null);
        ScoreListEntity result = findByCidAndType(scoreListEntity.getCid(), scoreListEntity.getScoreType());
        if (result==null) {
            result = scoreListRepository.save(scoreListEntity);
        }
        List<CourseScoreEntity> courseScoreEntityList = Lists.newArrayList();
        if (courseScoreEntities!=null && !courseScoreEntities.isEmpty()) {
            for (CourseScoreEntity entity :
                    courseScoreEntities) {
                entity.setScoreListEntity(result);
                courseScoreEntityList.add(courseScoreRepository.save(entity));
            }
        }
        result.setCourseScoreEntities(courseScoreEntityList);
        return result;
    }

    @Override
    public ScoreListEntity update(ScoreListEntity scoreListEntity) {
        Preconditions.checkArgument(scoreListEntity!=null);
        ScoreListEntity entity = findByCidAndType(scoreListEntity.getCid(), scoreListEntity.getScoreType());
        delete(entity.getId());
        return save(scoreListEntity);
    }

    @Override
    @Transactional
    public void delete(int id) {
        ScoreListEntity entity = findById(id);
        if (entity!=null) {
            List<CourseScoreEntity> courseScoreEntities = entity.getCourseScoreEntities();
            courseScoreRepository.delete(courseScoreEntities);
            scoreListRepository.delete(id);
        }
    }

    @Override
    public ScoreListEntity findByCidAndType(String cid, ScoreType type) {
        List<ScoreListEntity> entities = scoreListRepository.findByCidAndScoreType(cid,type);
        if (entities!=null && entities.size()>0) {
            return entities.get(0);
        }
        return null;
    }

    @Override
    public List<CourseScoreEntity> findByEntityAndSid(ScoreListEntity scoreListEntity, int sid) {
        return courseScoreRepository.findByScoreListEntityAndSid(scoreListEntity,sid);
    }
}
