package hibernate;

import dto.Rating;
import dto.StudentH;
import hibernate_session.HibernateUtilsI;
import jdbc.student.AbstractRepositoryII;
import jdbc.student.AbstractRepsitoryI;
import jdbc.student.Student;
import org.hibernate.Session;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class StudentRepositoryH implements AbstractRepositoryII<StudentH> {

    @Override
    public StudentH get(int id) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();

        StudentH studentH = (StudentH) em.createQuery("FROM StudentH WHERE student_id =: p")
                .setParameter("p", id)
                .getSingleResult();

        em.getTransaction().commit();
//        em.close();

        return studentH;
    }

    @Override
    public List<StudentH> getAll() {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();
        List<StudentH> students = null;
        students = em.createQuery("FROM StudentH")
                .getResultList();

        for (StudentH studentos : students) {
            System.out.println(studentos);
            for (Rating ratingos : studentos.getRatings()) {

            }

        }
        em.getTransaction().commit();
//        em.close();
        return null;
    }

    @Override
        public boolean delete(StudentH object) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();

        StudentH studentH = (StudentH) em.createQuery("FROM StudentH WHERE student_id = : p1")
                .setParameter("p1", object.getStudent_id())
                .getSingleResult();

        em.remove(studentH);
        em.getTransaction().commit();
//        em.close();

        return true;
    }

    @Override
    public boolean insert(StudentH studentH) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();

        em.persist(studentH);

        em.getTransaction().commit();
//        em.close();

        return true;
    }

    @Override
    public boolean update(int id, StudentH studentH) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("UPDATE StudentH SET first_name =:p" + " WHERE student_id =:p2")
                .setParameter("p", studentH.getFirst_name())
                .setParameter("p2", id);

        int result = query.executeUpdate();
        em.getTransaction().commit();
//        em.close();
        if (result == 0) {
            System.out.println("Update failed");
            return false;
        } else {
            System.out.println("Object first_name has been updated successfully");
            return true;
        }


    }

    public boolean updateLastName(int id, StudentH studentH) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("UPDATE StudentH SET last_name =:p" + " WHERE student_id =:p2")
                .setParameter("p", studentH.getLast_name())
                .setParameter("p2", id);

        int result = query.executeUpdate();
        em.getTransaction().commit();
//        em.close();
        if (result == 0) {
            System.out.println("Update failed");
            return false;
        } else {
            System.out.println("Object last_name has been updated successfully");
            return true;
        }


    }

}
