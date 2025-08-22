public class Student {

    //Declaring
    private String name;
    private int grade;

    //Constructor
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String toString() {
        return String.format("Name: %s | Grade: %d", name, grade);
    }
}
