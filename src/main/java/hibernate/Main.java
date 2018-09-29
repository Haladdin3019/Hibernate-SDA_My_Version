package hibernate;

import dto.Dog;
import dto.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

//
//
//        Person person = new Person();
//        person.setAge(919);
//        person.setName("sidAAA");
//        person.setSurname("sidsurnameAAA");
//        person.setIdperson(199);
//
//        em.persist(person);
////

        List<Person> idperson = em.createQuery
                ("from Person p where p.idperson = :t")
                .setParameter("t", 99)
                .getResultList();
//
//
        for (Person p : idperson ) {
            System.out.println(p);
            for (Dog dog : p.getDogs()) {
                System.out.println(dog);
            }

        }


//        Person person1 = (Person) em.createQuery
// ("FROM Person WHERE idperson = 99").getSingleResult();
//        System.out.println(person1.getName());


//
//        String person2 = (String) em.createQuery("SELECT surname FROM Person WHERE idperson = 99").getSingleResult();
//        System.out.println(person2);
//        session.getTransaction().commit();

        em.getTransaction().commit();
        em.close();

}

    private static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        return emf.createEntityManager();
    }
}
