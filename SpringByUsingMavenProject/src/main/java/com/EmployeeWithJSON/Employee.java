package com.EmployeeWithJSON;

public class Employee 
{
	private int id;
    private String name;
    private String designation;
    private String department;
    private String email;
    private String phone;
    private double salary;
    private Address address;

    public Employee() {
    	
    }

    public Employee(int id, String name, String designation, String department, 
                    String email, String phone, double salary, Address address) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.address = address;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", designation=" + designation +
                ", department=" + department + ", email=" + email + ", phone=" + phone +
                ", salary=" + salary + ", address=" + address + "]";
    }
}
