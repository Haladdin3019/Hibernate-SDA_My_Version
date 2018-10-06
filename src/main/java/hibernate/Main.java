package hibernate;

import dto.Dog;
import dto.Person;
import dto.Rating;
import dto.StudentH;
import hibernate_session.HibernateUtilsI;
import menu.MainMenu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();

        while (true) {
            mainMenu.showMainMenu();

        }

//        StudentRepositoryH studentRepositoryH = new StudentRepositoryH();
//
//        Rating rating = new Rating((float) 9.6);
//        Collection<Rating> ratings = new ArrayList<>();
//        ((ArrayList<Rating>) ratings).add(rating);
//
//        StudentH studentH = new StudentH("Agnieszka", "Marszalek", ratings);
//        rating.setStudentH(studentH);
//        studentRepositoryH.insert(studentH);


//        Rating rating = new Rating(4,5);
//        Collection<Rating> ratings = new ArrayList<>();
//        ((ArrayList<Rating>) ratings).add(rating);


//        Map<String, String> map = new HashMap<>();
//        map.put("first_name", "Tomek");
//        map.put("last_name", "Darowski");


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


}
