package dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

public class Person {
    @Id
    @GeneratedValue
    @Column(name="person_id", nullable=false, unique=true)
    private int person_id;

    private String first_name;

    private String last_name;

    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", dogs=" + dogs +
                '}';
    }

    @OneToMany
    @JoinColumn(name = "person_id")
    private Collection<Dog> dogs = new ArrayList<>();

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int idperson) {
        this.person_id = idperson;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String name) {
        this.first_name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String surname) {
        this.last_name = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Collection<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Collection<Dog> dogs) {
        this.dogs = dogs;
    }
}
