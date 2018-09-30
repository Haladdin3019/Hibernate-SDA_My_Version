package hibernate;

import dto.StudentH;
import jdbc.student.AbstractRepsitoryI;
import jdbc.student.Student;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class StudentRepositoryH implements AbstractRepsitoryI<StudentH> {

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

        em.close();
        return students;
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
    public boolean insert(Map<String, String> map) {
        initEntityManager();
        em.getTransaction().begin();

        String first_nameH = map.get("first_name");
        String last_nameH = map.get("last_name");

        StudentH studentH = new StudentH();
        studentH.setFirst_name(first_nameH);
        studentH.setLast_name(last_nameH);
        studentH.setStudent_id(10);

        em.persist(studentH);

        em.getTransaction().commit();
        em.close();

        return true;
    }

    @Override
    public boolean update(int id, Map<String, String> map) {
        initEntityManager();
        em.getTransaction().begin();
        String first_nameH = map.get("first_name");
        String last_nameH = map.get("last_name");


        Query query = em.createQuery("UPDATE StudentH SET first_name =:p" + " WHERE student_id =:p2")
                .setParameter("p", first_nameH)
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
