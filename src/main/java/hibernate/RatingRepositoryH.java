package hibernate;

import dto.Rating;
import jdbc.student.AbstractRepositoryII;
import jdbc.student.AbstractRepsitoryI;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class RatingRepositoryH implements AbstractRepositoryII<Rating> {

    EntityManager em = null;

    private void initEntityManager() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            em = emf.createEntityManager();
        }
    }

    @Override
    public Rating get(int id) {
        initEntityManager();
        em.getTransaction().begin();

        Rating rating = (Rating) em.createQuery("FROM Rating WHERE rating_id =: p")
                .setParameter("p", id)
                .getSingleResult();

        em.close();
        return rating;
    }

    @Override
    public List<Rating> getAll() {
        initEntityManager();
        em.getTransaction().begin();
        List<Rating> ratings = null;
        ratings = em.createQuery("FROM Rating ")
                .getResultList();

        em.close();
        return ratings;
    }

    @Override
    public boolean delete(int id) {
        initEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE Rating WHERE rating_id =:p")
                .setParameter("p", id);

        int result = query.executeUpdate();
        em.getTransaction().commit();
        em.close();

        if (result == 0) {
            System.out.println("Object has not been deleted ");
            return false;
        } else {
            System.out.println("Object has been deleted successfully");
            return true;
        }
    }

    @Override
    public boolean insert(Rating rating) {
        initEntityManager();
        em.getTransaction().begin();

        em.persist(rating);

        em.getTransaction().commit();
        em.close();

        return true;
    }

    @Override
    public boolean update(int id, Rating rating) {
        initEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("UPDATE Rating SET rating =:p" + " WHERE rating_id =:p2")
                .setParameter("p", rating.getRating())
                .setParameter("p2", id);

        int result = query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        if (result == 0) {
            System.out.println("Update failed ");
            return false;
        } else {
            System.out.println("Object has been updated successfully");
            return true;
        }
    }
}
