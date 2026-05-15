package com.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvReader {
    private static final char SEPARATOR = ';'; // разобраться, почему не работает!!!

    public List<Person> readData(String csvFilePath) {
        List<Person> persons = new ArrayList<>();
        
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);
            CSVReader reader = in == null ? null : new CSVReader(new InputStreamReader(in, "UTF-8"), SEPARATOR)) {
            
            if (reader == null) {
                throw new FileNotFoundException("Файл не найден: " + csvFilePath);
            }

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Person person = parsePerson(nextLine);
                if (person != null) {
                    persons.add(person);
                }
            }
            
        } catch (IOException | CsvException e) {
            System.err.println("Ошибка при чтении CSV: " + e.getMessage());
            e.printStackTrace();
        }
        
        return persons;
    }

    private Person parsePerson(String[] line) {
        if (line == null || line.length < 6) {
            System.err.println("Некорректная строка: " + Arrays.toString(line));
            return null;
        }
        
        try {
            int id = Integer.parseInt(line[0].trim());
            String name = line[1].trim();
            String gender = line[2].trim();
            String birthDate = line[3].trim();
            String departmentName = line[4].trim();
            int salary = Integer.parseInt(line[5].trim());
            
            // добавить функцию, которая будет проверять и возвращать подразделение новое или уже созданное
            Department department;

            return new Person(id, name, gender, department, salary, birthDate);
            
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка парсинга строки: " + Arrays.toString(line));
            return null;
        }
    }
}
