import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() { // Selim Jahangir 22bcs13878
        return marks;
    }
}

public class sortMarks {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Miles", 85),
            new Student("Selim", 72),
            new Student("Purwa", 90),
            new Student("Ram", 65)
        );

        List<String> topStudents = students.stream()
            .filter(student -> student.getMarks() > 75)
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
            .map(Student::getName)
            .collect(Collectors.toList());

        System.out.println("Students scoring above 75% sorted by marks: " + topStudents);
    }
}

