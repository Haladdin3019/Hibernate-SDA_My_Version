package menu;

import dto.StudentH;
import dto.Subject;
import hibernate.SubjectRepositoryH;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubjectMenu {

    private final Scanner scanner;
    private final SubjectRepositoryH subjectRepositoryH;

    public SubjectMenu(Scanner scanner, SubjectRepositoryH subjectRepositoryH) {
        this.scanner = scanner;
        this.subjectRepositoryH = subjectRepositoryH;
    }

    public void showMenu() {

        System.out.println();
        System.out.println();
        System.out.println("Select desired option from below by inserting the number: ");
        System.out.println("1 : Insert a new subject");
        System.out.println("2 : Display all subjects");
        System.out.println("3 : Display particular subject by ID");
        System.out.println("4 : Update subject name");
        System.out.println("5 : Delete particular subject by ID");
        System.out.println("6 : Back to main menu");


        switch(scanner.nextInt()){

            case 1:
                System.out.println("Please insert the subject name:");
                String subjectName = scanner.next();
                System.out.println("Please enter the ID of student to who rating should be assigned:");
                int student_id = scanner.nextInt();
                StudentH studentH = new StudentH();
                studentH.setStudent_id(student_id);
                Set<StudentH> students = new HashSet<>();
                students.add(studentH);
                Subject subject = new Subject(subjectName, students);
                subjectRepositoryH.insert(subject);
                showMenu();
            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            default:
                System.out.println("Option is not supported");
        }

    }

}
