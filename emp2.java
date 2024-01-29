import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Employee {
    String empId;
    String name;
    int age;
    int salary;

    public Employee(String empId, String name, int age, int salary) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + empId + ", Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}

class EmployeeDatabase {
    List<Employee> employees;

    public EmployeeDatabase(List<Employee> employees) {
        this.employees = employees;
    }

    public void printData() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void sortData(int sortParameter) {
        switch (sortParameter) {
            case 1:
                Collections.sort(employees, Comparator.comparingInt(employee -> employee.age));
                break;
            case 2:
                Collections.sort(employees, Comparator.comparing(employee -> employee.name));
                break;
            case 3:
                Collections.sort(employees, Comparator.comparingInt(employee -> employee.salary));
                break;
            default:
                System.out.println("Invalid sorting parameter. Please choose 1 for Age, 2 for Name, or 3 for Salary.");
        }
    }
}

public class emp2 {
    public static void main(String[] args) {
        List<Employee> employeeData = new ArrayList<>();
        employeeData.add(new Employee("161E90", "Ramu", 35, 59000));
        employeeData.add(new Employee("171E22", "Tejas", 30, 82100));
        employeeData.add(new Employee("171G55", "Abhi", 25, 100000));
        employeeData.add(new Employee("152K46", "Jaya", 32, 85000));

        EmployeeDatabase database = new EmployeeDatabase(employeeData);

        System.out.println("Original data:");
        database.printData();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the sorting parameter (1. Age, 2. Name, 3. Salary): ");
        int sortingParameter = scanner.nextInt();

        database.sortData(sortingParameter);

        System.out.println("\nSorted data:");
        database.printData();
    }
}
