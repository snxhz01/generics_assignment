public class Student implements Comparable<Student>{

    private double grade;
    private String firstName;
    private String lastName;
    //private final Double grade;
    // public double getGrade;

    public Student(String first, String last, double grade){
        this.firstName = first;
        this.lastName = last;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGrade() {
        return grade;
    }

    public int compareTo(Student students) {
        return (this.lastName.compareTo(students.lastName));
    }
    @Override
    public String toString() {
        return firstName +
                " " + lastName +
                " - " + grade;
    }
}
