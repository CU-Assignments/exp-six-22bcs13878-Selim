import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ", " + age + ", $" + salary;
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Miles", 30, 50000),
            new Employee("Selim", 25, 70000),
            new Employee("Purwa", 35, 60000),
            new Employee("Ram", 28, 80000)
        );

        // Sorting by name
        employees.sort(Comparator.comparing(emp -> emp.name));
        System.out.println("Sorted by Name: " + employees);

        // Sorting by age
        employees.sort(Comparator.comparingInt(emp -> emp.age));
        System.out.println("Sorted by Age: " + employees);

        // Sorting by salary (Descending)
        employees.sort(Comparator.comparingDouble(emp -> -emp.salary));
        System.out.println("Sorted by Salary (Descending): " + employees);
    }
}
