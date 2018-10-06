package dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class StudentH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;
    private String first_name;
    private String last_name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "studentH")
    private Collection<Rating> ratings = new ArrayList<>();

    @ManyToMany(mappedBy = "students")
    private Set<Subject> subjects;



    public Collection<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Collection<Rating> ratings) {
        this.ratings = ratings;
    }

    public StudentH() {
    }

    public StudentH(String first_name, String last_name, Collection<Rating> ratings) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.ratings = ratings;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }



    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentH{");
        sb.append("student_id=").append(student_id);
        sb.append(", first_name='").append(first_name).append('\'');
        sb.append(", last_name='").append(last_name).append('\'');
        sb.append(", ratings=").append(ratings);
        sb.append('}');
        return sb.toString();
    }

}
