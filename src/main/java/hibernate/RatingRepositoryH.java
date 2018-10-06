package hibernate;

import dto.Rating;
import dto.StudentH;
import hibernate_session.HibernateUtilsI;
import jdbc.student.AbstractRepositoryII;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RatingRepositoryH implements AbstractRepositoryII<Rating> {

    @Override
    public Rating get(int id) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();

        Rating rating = (Rating) em.createQuery("FROM Rating WHERE rating_id =: p")
                .setParameter("p", id)
                .getSingleResult();

        em.close();


        return rating;
    }

    @Override
    public List<Rating> getAll() {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();
        List<Rating> ratings = null;
        ratings = em.createQuery("FROM Rating ")
                .getResultList();

        for (Rating rating1 : ratings) {
            System.out.println(rating1);
        }


//        em.close();
        return ratings;
    }

    @Override
    public boolean delete(Rating object) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();

        Rating rating = (Rating) em.createQuery("FROM Rating WHERE rating_id = : p1")
                .setParameter("p1", object.getRating_id())
                .getSingleResult();

        em.remove(rating);
        em.getTransaction().commit();
//        em.close();

        return true;
    }

    @Override
    public boolean insert(Rating rating) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();

        rating.setStudentH(em.find(StudentH.class, rating.getStudentH().getStudent_id()));
        em.persist(rating);

        em.getTransaction().commit();
//        em.close();

        return true;
    }

    @Override
    public boolean update(int id, Rating rating) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("UPDATE Rating SET rating =:p" + " WHERE rating_id =:p2")
                .setParameter("p", rating.getRating())
                .setParameter("p2", id);

        int result = query.executeUpdate();
        em.getTransaction().commit();
//        em.close();
        if (result == 0) {
            System.out.println("Update failed ");
            return false;
        } else {
            System.out.println("Object has been updated successfully");
            return true;
        }
    }

}
