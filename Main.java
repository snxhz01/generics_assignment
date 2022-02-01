import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Iterator;



// TODO: first create your Student class

public class Main {
    public static void main(String[] args) {

        // TODO: make an ArrayList of type Double (for the constants)
        // TODO: make a LinkedList of type Student (for the students)
        List<Double> constants; // = new ArrayList<Double>();
        List<Student> students; // = new LinkedList<String>();

        // TODO: call a method to load constants, returning an ArrayList of Doubles
        // TODO: call a method to load students, returning a LinkedList of Students
        // String[] students = new students [10];
        students = loadStudents();
        constants = loadConstants();

        // TODO: call the printStuff method with the list of constants
        // TODO: call the printStuff method with the list of students
        System.out.println("Constants: ");
        printStuff(constants);
        System.out.println("Unsorted Students :");
        printStuff(students);

        // TODO: sort the list of students with Collections.sort()
        // TODO: call the printStuff method again with the list of students
        Collections.sort(students);
        System.out.println("Sorted Students:  ");
        printStuff(students);

        // TODO: call the trimStudents() method
        trimStudents(students, 90.0);
        // TODO: call the printStuff method again with the list of students
        System.out.println("'A' Students: ");
        printStuff(students);

    }
    // TODO: create a method loadConstants() which returns an ArrayList of Doubles

    // TODO: uncomment this method below
    private static LinkedList<Student> loadStudents() {
        File file = new File("res/roster.csv");
        Scanner reader;

        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file: " + file.toPath());
            return null;
        }

        LinkedList<Student> students = new LinkedList<Student>();

        reader.nextLine(); // eat header
        while (reader.hasNext()) {
            String line = reader.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",\n");

            String last = tokenizer.nextToken();
            String first = tokenizer.nextToken();
            float grade = Float.valueOf(tokenizer.nextToken());

            Student s = new Student(first, last, (double) grade);
            students.add(s);
        }

        return students;
    }

    private static List<Double> loadConstants() {
        File file = new File("res/constants.txt");
        Scanner reader;

        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file: " + file.toPath());
            return null;
        }

        ArrayList<Double> constants = new ArrayList<>();

        while (reader.hasNext()) {
            String line = reader.nextLine();

            double x = Double.valueOf(line);
            constants.add(x);
        }
        return constants;
    }

    // TODO: create a printStuff() method that takes a List of anything and prints it
    private static <T> void printStuff(List<T> list) {
        for (T element : list)
            System.out.println(element);
        System.out.println();
    }

    // TODO: create a trimStudents() method that takes a LinkedList of Students
    // and a double for the filter amount, which then iterates through the
    // LinkedList of Students with an Iterator and removes any Student with
    // a grade less than 90

    public static void trimStudents(List<Student> students, double filter) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext())
        {
            Student s = iterator.next();
            if (s.getGrade() < filter)
                iterator.remove();
        }
    }

}
