package com.emp;

public class Employee {

    private int id;
    private String fullName;
    private String email;
    private String phone;
    private String department;
    private String designation;
    private double salary;
    private String dateOfJoining;

    public Employee() {}

    public Employee(String fullName, String email, String phone,
                    String department, String designation,
                    double salary, String dateOfJoining) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getDateOfJoining() { return dateOfJoining; }
    public void setDateOfJoining(String dateOfJoining) { this.dateOfJoining = dateOfJoining; }
}
