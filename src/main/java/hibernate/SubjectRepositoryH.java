package hibernate;

import dto.StudentH;
import dto.Subject;
import hibernate_session.HibernateUtilsI;
import jdbc.student.AbstractRepositoryII;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubjectRepositoryH implements AbstractRepositoryII<Subject> {

    @Override
    public Subject get(int id) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();

        Subject subject = (Subject) em.createQuery("FROM Subject WHERE subject_id =: p1")
                .setParameter("p1", id)
                .getSingleResult();

        em.getTransaction().commit();

        return null;
    }

    @Override
    public List<Subject> getAll() {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();

        List<Subject> subjects = null;
        subjects = em.createQuery("FROM Subject")
                .getResultList();

        for (Subject subject : subjects) {
            System.out.println(subject);

        }

        em.getTransaction().commit();
        return null;
    }

    @Override
    public boolean delete(Subject object) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();


        em.getTransaction().commit();
        return false;
    }


    @Override
    public boolean insert(Subject object) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();
        Set<StudentH> studentHS = new HashSet<>();
        for (StudentH studentH : object.getStudents()) {

            studentHS.add(em.find(StudentH.class, studentH.getStudent_id()));

        }
        object.setStudents(studentHS);
        em.persist(object);

        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(int id, Subject object) {
        EntityManager em = HibernateUtilsI.getEntityManager();
        em.getTransaction().begin();


        em.getTransaction().commit();
        return false;
    }
}
