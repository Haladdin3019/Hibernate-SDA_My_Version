package hibernate;

import dto.Dog;
import dto.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        StudentRepositoryH studentRepositoryH = new StudentRepositoryH();

        Map<String, String> map = new HashMap<>();
        map.put("first_name", "Tomek");
        map.put("last_name", "Darowski");

        studentRepositoryH.insert(map);


//        Person person = new Person();
//        person.setAge(919);
//        person.setFirst_name("sidAAA");
//        person.setLast_name("sidsurnameAAA");
//        person.setPerson_id(199);
//
//        em.persist(person);
//
//
//        List<Person> person_id = em.createQuery
//                ("FROM Person p WHERE p.person_id = :t")
//                .setParameter("t", 4)
//                .getResultList();
//
//
//        for (Person p : person_id ) {
//            System.out.println(p);
//            for (Dog dog : p.getDogs()) {
//                System.out.println(dog);
//            }
//
//        }


//        Person person1 = (Person) em.createQuery
// ("FROM Person WHERE idperson = 99").getSingleResult();
//        System.out.println(person1.getFirst_name());


//
//        String person2 = (String) em.createQuery("SELECT last_name FROM Person WHERE person_id = 1").getSingleResult();
//        System.out.println(person2);
//
//        em.getTransaction().commit();
//        em.close();

    }

    private static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        return emf.createEntityManager();
    }
}
