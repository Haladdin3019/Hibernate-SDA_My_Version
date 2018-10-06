package menu;

import dto.Rating;
import dto.StudentH;
import hibernate.StudentRepositoryH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    MainMenu mainMenu = new MainMenu();
    private final Scanner scanner;
    private final StudentRepositoryH studentRepositoryH;

    public StudentMenu(Scanner scanner, StudentRepositoryH studentRepositoryH) {
        this.scanner = scanner;
        this.studentRepositoryH = studentRepositoryH;
    }

    public void showMenu() {
        System.out.println();
        System.out.println();
        System.out.println("Select desired option from below by inserting the number: ");
        System.out.println("1 : Show all students with rating");
        System.out.println("2 : Show particular student with his rating");
        System.out.println("3 : Insert a new student, with his rating");
        System.out.println("4 : Update student first name by ID");
        System.out.println("5 : Update student last name by ID");
        System.out.println("6 : Delete student by ID");
        System.out.println("7 : Back to Main Menu ->");


        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Please see below list of all students with rating:");
                studentRepositoryH.getAll();
                showMenu();
            case 2:
                System.out.println("To display particular student, please pass his id number:");
                System.out.println(studentRepositoryH.get(scanner.nextInt()));
                showMenu();
            case 3:
                System.out.println("Please insert student first name:");
                String firstName = scanner.next();
                System.out.println("Please insert student last name:");
                String lastName = scanner.next();
                System.out.println("Please insert student rating:");
                double ratingFromScanner = scanner.nextDouble();
                Rating rating = new Rating(ratingFromScanner);
                List<Rating> list = new ArrayList<>();
                list.add(rating);
                StudentH studentH = new StudentH(firstName, lastName, list);
                rating.setStudentH(studentH);
                studentRepositoryH.insert(studentH);
                System.out.println("Student has been successfully added!\n");
                showMenu();
            case 4:
                StudentH studentH1 = new StudentH();
                System.out.println("Please provide new first name:");
                studentH1.setFirst_name(scanner.next());
                System.out.println("Please provide the student id: ");
                int student_id = scanner.nextInt();
                studentRepositoryH.update(student_id, studentH1);
                showMenu();
            case 5:
                StudentH studentH2 = new StudentH();
                System.out.println("Please provide new last name:");
                studentH2.setLast_name(scanner.next());
                System.out.println("Please provide the student id: ");
                int student_id2 = scanner.nextInt();
                studentRepositoryH.updateLastName(student_id2, studentH2);
                showMenu();
            case 6:
                System.out.println("To delete student, please provide ID:");
                int student_id1 = scanner.nextInt();
                StudentH studentH3 = new StudentH();
                studentH3.setStudent_id(student_id1);
                studentRepositoryH.delete(studentH3);
                showMenu();
            case 7:
                mainMenu.showMainMenu();
            default:
                System.out.println("Option not supported");
        }


    }

}
