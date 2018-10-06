package dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subject_id;

    private String subject_name;


    @ManyToMany
    @JoinTable(name = "students_and_subjects",
            joinColumns = {@JoinColumn(name = "subject_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private Set<StudentH> students = new HashSet<>();

    public Subject() {
    }

    public Subject(String subject_name, Set<StudentH> studentHS) {
        this.subject_name = subject_name;
            }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public Set<StudentH> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentH> students) {
        this.students = students;
    }


}
