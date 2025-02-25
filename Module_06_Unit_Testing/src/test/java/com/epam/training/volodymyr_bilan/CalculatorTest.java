package com.epam.training.volodymyr_bilan;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    void setup() {
        calculator = new Calculator();
    }

    @AfterAll
    void tearDown() {
        calculator = null;
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 8",
            "-5, -3, -8",
            "0, 0, 0",
            "100, 200, 300"
    })
    void testAddition(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b), () -> a + " + " + b + " should equal " + expected);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 2",
            "-5, -3, -2",
            "0, 5, -5",
            "100, 50, 50"
    })
    void testSubtraction(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b), () -> a + " - " + b + " should equal " + expected);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 15",
            "-5, -3, 15",
            "0, 5, 0",
            "7, 7, 49"
    })
    void testMultiplication(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b), () -> a + " * " + b + " should equal " + expected);
    }

    @ParameterizedTest
    @CsvSource({
            "6, 3, 2.0",
            "7, 2, 3.5",
            "-10, -2, 5.0"
    })
    void testDivision(int a, int b, double expected) {
        assertEquals(expected, calculator.divide(a, b), 0.001, () -> a + " / " + b + " should equal " + expected);
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0), "Division by zero should throw an exception");
    }

    @ParameterizedTest
    @CsvSource({
            "7, 3, 1",
            "10, 5, 0",
            "9, 2, 1"
    })
    void testModulus(int a, int b, int expected) {
        assertEquals(expected, calculator.modulus(a, b), () -> a + " % " + b + " should equal " + expected);
    }

    @Test
    void testModulusByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.modulus(5, 0), "Modulus by zero should throw an exception");
    }
}

