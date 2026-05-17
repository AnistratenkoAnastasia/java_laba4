package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PersonTest {

    @Test
    public void testConstructorAndGetters() {
        Person p = new Person(1, "Ivan", "Male", null, 5000, "01.01.2004");
        assertEquals(1, p.getID());
        assertEquals("Ivan", p.getName());
        assertEquals("Male", p.getGender());
        assertEquals(5000, p.getSalary());
        assertEquals("01.01.2004", p.getBirthDate());
    }

    @Test
    public void testSetters() {
        Person p = new Person(2, "Petr", "Female", null, 100, "01.01.2004");
        Department d = new Department("J");
        p.setName("Sveta");
        p.setGender("Male");
        p.setDepartment(d);
        p.setSalary(999);
        p.setBirthDate("02.01.2005");

        assertEquals("Sveta", p.getName());
        assertEquals("Male", p.getGender());
        assertEquals(999, p.getSalary());
        assertEquals("02.01.2005", p.getBirthDate());
    }

    @Test
    public void testToString() {
        Person p = new Person(3, "Test", "X", null, 10, "Y");
        assertEquals("Person{3 Test X null 10 Y}", p.toString());
    }
}