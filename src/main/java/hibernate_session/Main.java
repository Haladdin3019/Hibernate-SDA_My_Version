package hibernate_session;

import dto.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {



        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Person person = new Person();
        person.setAge(99);
        person.setFirst_name("sid");
        person.setLast_name("sidsurname");
        person.setPerson_id(99);
        session.save(person);

        //System.out.println("Employee ID=" + person.getPerson_id());

//        List<Person> idperson = session.createQuery("from Person p where p.idperson = :idperson").setParameter("idperson", 99).getResultList();
//
//
//        for (Person p : idperson ) {
//            for (Dog dog : p.getDogs()) {
//                System.out.println(dog);
//            }
//
//        }


//        Person person1 = (Person) session.createQuery("FROM Person WHERE idperson = 99").getSingleResult();
//        System.out.println(person1.getFirst_name());


//
//        String person2 = (String) session.createQuery("SELECT surname FROM Person WHERE idperson = 99").getSingleResult();
//        System.out.println(person2);
//        session.getTransaction().commit();



        sessionFactory.close();
    }
}
