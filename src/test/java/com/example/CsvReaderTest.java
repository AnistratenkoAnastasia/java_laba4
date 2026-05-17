package com.example;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CsvReaderTest {
    
    @Test
    public void testReadData_BasicFlow() {
        CsvReader reader = new CsvReader();
        List<Person> result = reader.readData("test_data.csv");
        
        assertNotNull(result);
        assertTrue(result instanceof List);
    }

    @Test
    public void testReadData_ParseSample() {
        CsvReader reader = new CsvReader();
        List<Person> persons = reader.readData("test_data.csv");
        
        assertNotNull(persons);
        assertEquals(10, persons.size());
        
        Person p = persons.get(0);
        assertEquals(28281, p.getID());
        assertEquals("Aahan", p.getName());
        assertEquals("Male", p.getGender());
        assertEquals("15.05.1970", p.getBirthDate());
        assertEquals(4800, p.getSalary());
        assertEquals("I", p.getDepartment().getName());
    }

    @Test
    public void testDepartmentCaching() {
        CsvReader reader = new CsvReader();
        List<Person> persons = reader.readData("test_data.csv");
        
        Person p1 = persons.stream().filter(p -> "G".equals(p.getDepartment().getName())).findFirst().orElse(null);
        Person p2 = persons.stream().filter(p -> "G".equals(p.getDepartment().getName())).skip(1).findFirst().orElse(null);
        
        assertNotNull(p1);
        assertNotNull(p2);
        assertSame(p1.getDepartment(), p2.getDepartment());
    }
}