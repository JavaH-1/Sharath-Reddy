package com.model;

public class Person {
    private String name;
    private int age;
    private String phoneNumber;
    private String emailId;
    private String bloodGroup;

    public Person() {}

    public Person(String name, int age, String phoneNumber, String emailId, String bloodGroup) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.bloodGroup = bloodGroup;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
}
