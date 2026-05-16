package com.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class CsvReader {
    private static final char SEPARATOR = ';';
    private Map<String, Department> departmentMap = new HashMap<>();

    public List<Person> readData(String csvFilePath) {
        List<Person> persons = new ArrayList<>();
        
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);
            CSVReader reader = in == null ? null : 
            new CSVReaderBuilder(new InputStreamReader(in, "UTF-8"))
            .withCSVParser(new CSVParserBuilder().withSeparator(SEPARATOR).build()).build();) {
            
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
            
            Department department = checkDepartment(departmentName);

            return new Person(id, name, gender, department, salary, birthDate);
            
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка парсинга строки: " + Arrays.toString(line));
            return null;
        }
    }

    private Department checkDepartment(String departmentName) {
        return departmentMap.computeIfAbsent(departmentName, Department::new);
    }
}
