package com.example;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        CsvReader reader = new CsvReader();
        List<Person> people = reader.readData("foreign_names.csv");

        System.out.println("List of people:");

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
