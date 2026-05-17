package com.example;

import java.util.List;

/**
 * Запускает чтение данных из CSV и вывод результатов в консоль.
 */
public class App 
{
    /**
     * Основной метод приложения.
     *
     * @param args аргументы командной строки (не используются)
     */
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