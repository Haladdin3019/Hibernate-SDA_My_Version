package hibernate_session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtilsI {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");



    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public static void closeEmFactory() {
        emf.close();
    }

}
