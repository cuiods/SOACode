package edu.nju.soa.dao;

import edu.nju.soa.entity.ScoreEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure(ClassLoader.getSystemClassLoader().getResource("hibernate.cfg.xml")).build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
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
}
