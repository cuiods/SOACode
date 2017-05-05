package edu.nju.soa.dao;

import edu.nju.soa.entity.CourseScoreEntity;
import edu.nju.soa.entity.ScoreEntity;
import edu.nju.soa.tool.EditScore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Query;
import java.util.List;

/**
 * Score data methods
 */
public class ScoreDao {

    private SessionFactory sessionFactory;

    private static class DaoClassHolder {
        private static ScoreDao INSTANCE = new ScoreDao();
    }

    public static ScoreDao instance() {
        return DaoClassHolder.INSTANCE;
    }

    private ScoreDao() {
        Configuration config = new Configuration().configure();
        config.addAnnotatedClass(CourseScoreEntity.class);
        config.addAnnotatedClass(ScoreEntity.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    /**
     * Get score entities by student id
     * @param sid id
     *            student id
     * @return list of {@link ScoreEntity}
     */
    @SuppressWarnings("unchecked")
    public List<ScoreEntity> getScoresByStudentId(int sid) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from ScoreEntity where sid=:sid");
        query.setParameter("sid",sid);
        List<ScoreEntity> scoreEntities = query.getResultList();
        session.close();
        return scoreEntities;
    }

    public ScoreEntity save(ScoreEntity entity) {
        if (entity!=null) {
            if (entity.getEntity()==null || entity.getEntity().getId() == 0)
                return null;
        } else return null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (Integer) session.save(entity);
        Query query = session.createQuery("from ScoreEntity where id=:id ");
        query.setParameter("id",id);
        ScoreEntity entity1 = (ScoreEntity) query.getSingleResult();
        transaction.commit();
        session.close();
        return entity1;
    }

    public CourseScoreEntity save(CourseScoreEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        Query query = session.createQuery("from CourseScoreEntity where cid=:cid and type=:ctype ");
        query.setParameter("cid",entity.getCid());
        query.setParameter("ctype",entity.getType());
        CourseScoreEntity entity1 = (CourseScoreEntity) query.getSingleResult();
        transaction.commit();
        session.close();
        return entity1;
    }

    public String update(EditScore editScore) {
        String msg = "";
        Session session = sessionFactory.openSession();
        Query courseQuery = session.createQuery("from CourseScoreEntity where cid=:cid and type=:ctype ");
        courseQuery.setParameter("cid",editScore.getCid());
        courseQuery.setParameter("ctype",editScore.getCourseType());
        List objectList = courseQuery.getResultList();
        if (objectList.size()>0) {
            CourseScoreEntity courseScoreEntity = (CourseScoreEntity) objectList.get(0);
            Transaction transaction = session.beginTransaction();
            Query scoreQuery = session.createQuery("update ScoreEntity score set score.score=:score " +
                    "where score.sid=:sid and score.entity.id=:cid ");
            scoreQuery.setParameter("score", editScore.getScore());
            scoreQuery.setParameter("sid", editScore.getSid());
            scoreQuery.setParameter("cid",courseScoreEntity.getId());
            int num = scoreQuery.executeUpdate();
            transaction.commit();
            if (num==0) {
                msg = "找不到编号为"+editScore.getSid()+"的学生";
            }
        } else {
            msg = "找不到编号为"+editScore.getCid()+"的课程.";
        }
        session.close();
        return msg;
    }
}
