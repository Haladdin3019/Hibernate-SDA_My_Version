package dto;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rating_id;

    private double rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private StudentH studentH;

    public Rating() {
    }

    public Rating(double rating, StudentH studentH) {
        this.rating = rating;
        this.studentH = studentH;
    }

    public StudentH getStudentH() {
        return studentH;
    }

    public void setStudentH(StudentH studentH) {
        this.studentH = studentH;
    }

    public Rating(double rating) {

        this.rating = rating;
    }



    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }


    public double getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Rating{");
        sb.append("rating_id=").append(rating_id);
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}
