package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DepartmentTest {

    @Test
    public void testConstructorAndGetters() {
        Department d = new Department("J");
        assertEquals(1, d.getID());
        assertEquals("J", d.getName());
    }

    @Test
    public void testSetterAndToString() {
        Department d = new Department("N");
        d.setName("O");
        assertEquals("O", d.getName());
        assertEquals("O", d.toString());
    }
}