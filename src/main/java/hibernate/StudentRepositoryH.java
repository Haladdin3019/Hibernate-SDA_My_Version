package hibernate;

import dto.Rating;
import dto.StudentH;
import hibernate_session.HibernateUtilsI;
import jdbc.student.AbstractRepositoryII;
import jdbc.student.AbstractRepsitoryI;
import jdbc.student.Student;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class StudentRepositoryH implements AbstractRepositoryII<StudentH> {

    EntityManager em = null;

    private void initEntityManager() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            em = emf.createEntityManager();
        }
    }

    @Override
    public StudentH get(int id) {
        initEntityManager();
        em.getTransaction().begin();

        StudentH studentH = (StudentH) em.createQuery("FROM StudentH WHERE student_id =: p")
                .setParameter("p", id)
                .getSingleResult();



        em.close();
        return studentH;
    }

    @Override
    public List<StudentH> getAll() {
        initEntityManager();
        em.getTransaction().begin();
        List<StudentH> students = null;
        students = em.createQuery("FROM StudentH")
                .getResultList();

        for (StudentH studentos : students) {
            System.out.println(studentos);
            for (Rating ratingos : studentos.getRatings()) {
                System.out.println(ratingos);

            }

        }


        em.close();
        return null;
    }

    @Override
    public boolean delete(int id) {
        initEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE StudentH WHERE student_id =:p")
                .setParameter("p", id);

        int result = query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        if (result == 0) {
            System.out.println("Object has not been deleted");
            return false;
        } else {
            System.out.println("Object has been deleted successfully");
            return true;
        }

    }

    @Override
    public boolean insert(StudentH studentH) {
        initEntityManager();
        em.getTransaction().begin();

        em.persist(studentH);

        em.getTransaction().commit();
        em.close();

        return true;
    }

    @Override
    public boolean update(int id, StudentH studentH) {
        initEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("UPDATE StudentH SET first_name =:p" + " WHERE student_id =:p2")
                .setParameter("p", studentH.getFirst_name())
                .setParameter("p2", id);

        int result = query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        if (result == 0) {
            System.out.println("Update failed");
            return false;
        } else {
            System.out.println("Object has been updated successfully");
            return true;
        }

    }
}
