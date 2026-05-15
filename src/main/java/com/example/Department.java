package com.example;

public class Department {
    private static int count = 1;

    private final int id;
    private String name;

    public Department(String name) {
        this.id = count++;
        this.name = name;
    }

    public int getID() {return id;}
    public String getName() {return name;}

    public void setName(String newName) {this.name = newName;}
}
