package LAB02;
import java.lang.*;

class Employee {
    double salary;
    void displaySalary() {
        System.out.println("Salary: " + salary);
    }
}

class FullTimeEmployee extends Employee {
    void calculateSalary() {
    System.out.println("Full Time Employee Salary Details");
    System.out.print("Before Hike: ");
    displaySalary();
    salary = salary + (salary * 0.50);
    System.out.print("After Hike: ");
    displaySalary();
    System.out.println();
 }
}

class InternEmployee extends Employee {
    void calculateSalary() {
    System.out.println("Intern Employee Salary Details");
    System.out.print("Before Hike: ");
    displaySalary();
    salary = salary + (salary * 0.25); 
    System.out.print("After Hike: ");
    displaySalary();
    System.out.println();
    }
}

public class Inheritance_lab2 {
    public static void main(String[] args) {
        FullTimeEmployee fte = new FullTimeEmployee();
        fte.salary = 20000;
        fte.calculateSalary();
        InternEmployee intern = new InternEmployee();
        intern.salary = 10000;
        intern.calculateSalary();
    }
    
}
