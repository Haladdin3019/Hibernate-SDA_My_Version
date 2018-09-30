package dto;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue
    @Column(name="dog_id", nullable=false, unique=true)
    private int dog_id;

    private String person_id;

    private String name;

    public int getDog_id() {
        return dog_id;
    }

    public void setDog_id(int dog_id) {
        this.dog_id = dog_id;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dog_id=" + dog_id +
                ", person_id='" + person_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
