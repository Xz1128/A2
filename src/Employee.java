public class Employee extends Person {
    // Employee-specific attributes
    private String employeeId;
    private String department;

    // Default constructor
    public Employee() {
        super();
        this.employeeId = "E000";
        this.department = "Unknown";
    }

    // Parameterized constructor
    public Employee(String name, int age, String id, String employeeId, String department) {
        super(name, age, id);
        this.employeeId = employeeId;
        this.department = department;
    }

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + ", Employee ID: " + employeeId + ", Department: " + department;
    }
}
