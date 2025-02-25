package com.epam.training.volodymyr_bilan;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return (double) a / b;
    }

    public int modulus(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Modulus by zero is not allowed");
        }
        return a % b;
    }
}

