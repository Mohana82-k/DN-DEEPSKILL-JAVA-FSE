package com.mohana.test;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AAATest {

    private int num1;
    private int num2;

    @Before
    public void setUp() {
        num1 = 10;
        num2 = 5;
        System.out.println("Setup Executed");
    }

    @After
    public void tearDown() {
        System.out.println("Teardown Executed");
    }

    @Test
    public void testAddition() {

        // Arrange
        int expected = 15;

        // Act
        int result = num1 + num2;

        // Assert
        assertEquals(expected, result);
    }
}