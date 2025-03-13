package com.epam.training.volodymyr_bilan.ui.model;

import java.util.ResourceBundle;

public class TestDataReader {

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("env"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}

