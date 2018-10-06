package menu;

import hibernate.RatingRepositoryH;
import hibernate.StudentRepositoryH;
import hibernate.SubjectRepositoryH;
import hibernate_session.HibernateUtilsI;

import java.util.Scanner;

public class MainMenu {

    private Scanner sc = new Scanner(System.in);
    StudentRepositoryH studentRepositoryH = new StudentRepositoryH();
    RatingRepositoryH ratingRepositoryH = new RatingRepositoryH();
    SubjectRepositoryH subjectRepositoryH = new SubjectRepositoryH();

    public void showMainMenu() {

        System.out.println();
        System.out.println();
        System.out.println("Select desired option from below by inserting the number: ");
        System.out.println("1 : Actions related to Students");
        System.out.println("2 : Actions related to Ratings");
        System.out.println("3 : Actions related to Subjects");
        System.out.println("4 : Exit the program");

        switch (sc.nextInt()) {
            case 1:
                StudentMenu studentMenu = new StudentMenu(sc, studentRepositoryH);
                studentMenu.showMenu();
            case 2:
                RatingMenu ratingMenu = new RatingMenu(sc, ratingRepositoryH);
                ratingMenu.showRatingMenu();
            case 3:
                SubjectMenu subjectMenu = new SubjectMenu(sc, subjectRepositoryH);
                subjectMenu.showMenu();
            case 4:
                System.exit(0);
                HibernateUtilsI.closeEmFactory();
            default:
                System.out.println("Option is not supported, please select correct one");
        }

    }


}
