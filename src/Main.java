import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Analyzer analyzer = new Analyzer();

        while (true) {
            System.out.println("\nStudent Grade Analyzer");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Average Grade");
            System.out.println("4. Find Top Student");
            System.out.println("5. Search Student");
            System.out.println("6. Get Middle Student");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    int grade = scanner.nextInt();
                    analyzer.addStudent(name, grade);
                    break;
                case 2:
                    for (Student s : analyzer.getAllStudents()) {
                        System.out.println(s);
                    }
                    break;
                case 3:
                    System.out.printf("Average Grade: %.2f\n", analyzer.calculateAverage());
                    break;
                case 4:
                    Student top = analyzer.getTopStudent();
                    if (top != null) System.out.println("Top Student: " + top);
                    break;
                case 5:
                    System.out.print("Enter name to search: ");
                    String keyword = scanner.nextLine();
                    Student found = analyzer.searchStudent(keyword);
                    if (found != null) System.out.println("Found: " + found);
                    else System.out.println("Student not found.");
                    break;
                case 6:
                    Student middle = analyzer.getMiddleStudent();
                    if (middle != null) System.out.println("Middle Student: " + middle);
                    break;
                case 7:
                    analyzer.saveToFile(); // Save before exiting
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
