import java.io.*;
import java.util.ArrayList;

public class Analyzer {
    private ArrayList<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.txt";

    public Analyzer() {
        loadFromFile();
    }

    public void addStudent(String name, int grade) {
        students.add(new Student(name, grade));
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public double calculateAverage() {
        if (students.isEmpty()) return 0;
        int total = 0;
        for (Student s : students) {
            total += s.getGrade();
        }
        return (double) total / students.size();
    }

    public Student getTopStudent() {
        if (students.isEmpty()) return null;
        Student top = students.get(0);
        for (Student s : students) {
            if (s.getGrade() > top.getGrade()) {
                top = s;
            }
        }
        return top;
    }

    public Student getMiddleStudent() {
        if (students.isEmpty()) return null;
        int middleIndex = students.size() / 2;
        return students.get(middleIndex);
    }

    public Student searchStudent(String keyword) {
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(keyword.toLowerCase())) {
                return s;
            }
        }
        return null;
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.getName() + "," + s.getGrade());
                writer.newLine();
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int grade = Integer.parseInt(parts[1]);
                    students.add(new Student(name, grade));
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
