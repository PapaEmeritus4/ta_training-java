package com.epam.training.volodymyr_bilan.assertions;

import static org.testng.Assert.*;

public class SwagLabsAssertions {

    public static void verifyErrorMessage(String actualErrorMessage, String expectedMessage) {
        assertTrue(actualErrorMessage.contains(expectedMessage),
                String.format("Expected error message to contain: '%s', but was: '%s'", expectedMessage, actualErrorMessage));
    }

    public static void verifyPageTitle(String actualTitle, String expectedTitle) {
        assertEquals(expectedTitle, actualTitle,
                String.format("Expected page title: '%s', but was: '%s'", expectedTitle, actualTitle));
    }
}
