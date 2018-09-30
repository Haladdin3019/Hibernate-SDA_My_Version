package dto;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rating_id;

    private float rating;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentH studentH;

    public Rating() {
    }
    public StudentH getStudentH() {
        return studentH;
    }

    public void setStudentH(StudentH studentH) {
        this.studentH = studentH;
    }

    public Rating(float rating) {

        this.rating = rating;
    }

    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }


    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ID: " + rating_id +  " | " + "Rating:" + rating + "\n";
    }
}
