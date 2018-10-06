package hibernate_session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtilsI {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private static EntityManager entityManager = null;


    public static EntityManager getEntityManager() {
        if(entityManager == null)
            entityManager = emf.createEntityManager();

        return entityManager;
    }


    public static void closeEm() {
        entityManager.close();

    }
    public static void closeEmFactory() {
        emf.close();
    }

}
