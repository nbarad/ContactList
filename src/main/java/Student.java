public class Student extends Person {
    private int grade;
    // constructor
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }
    // getter
    public int getGrade() {
        return grade;
    }
    // toString
    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
