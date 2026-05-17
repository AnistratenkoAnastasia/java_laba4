package com.example;

public class Person {
    private final int id;
    private String name;
    private String gender;
    private Department department;
    private int salary;
    private String birthDate;

    public Person(int ID, String name, String gender, Department department,
        int salary, String birthDate) {
        this.id = ID;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public int getID() {return id;}
    public String getName() {return name;}
    public String getGender() {return gender;}
    public Department getDepartment() {return department;}
    public int getSalary() {return salary;}
    public String getBirthDate() {return birthDate;}

    public void setName(String name) {this.name = name;}
    public void setGender(String gender) {this.gender = gender;}
    public void setDepartment(Department department) {this.department = department;}
    public void setSalary(int salary) {this.salary = salary;}
    public void setBirthDate(String birthDate) {this.birthDate = birthDate;}

    @Override
    public String toString() {
        return "Person{" + id + " " + name + " " + gender + " " + department + " " + salary + " " + birthDate + "}";
    }
}
