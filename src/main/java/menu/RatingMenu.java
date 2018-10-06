package menu;

import dto.Rating;
import dto.StudentH;
import hibernate.RatingRepositoryH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RatingMenu {

    private final Scanner scanner;
    private final RatingRepositoryH ratingRepositoryH;

    public RatingMenu(Scanner scanner, RatingRepositoryH ratingRepositoryH) {
        this.scanner = scanner;
        this.ratingRepositoryH = ratingRepositoryH;
    }

    public void showRatingMenu() {
        System.out.println();
        System.out.println();
        System.out.println("Select desired option from below by inserting the number: ");
        System.out.println("1 : Add a new rating and assign it to particular student");
        System.out.println("2 : Show all ratings");
        System.out.println("7 : Back to main menu");


        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Please enter the rating: ");
                double rating_score = scanner.nextDouble();
                System.out.println("Please enter the ID of student to who rating should be assigned:");
                int student_id = scanner.nextInt();
                StudentH studentH = new StudentH();
                studentH.setStudent_id(student_id);
                Rating rating = new Rating(rating_score, studentH);
                List<Rating> ratings = new ArrayList<>();
                ratings.add(rating);
                ratingRepositoryH.insert(rating);
                showRatingMenu();
            case 2:
                System.out.println("Please see below list of all ratings:");
                ratingRepositoryH.getAll();
                showRatingMenu();
            case 7:
                MainMenu mainMenu = new MainMenu();
                mainMenu.showMainMenu();
        }

    }

}
