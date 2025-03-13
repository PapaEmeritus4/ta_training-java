package com.epam.training.volodymyr_bilan.ui.model;

public class DataCreator {
    public static final String TESTDATA_GMAIL_EMAIL = "testdata.gmail.email";
    public static final String TESTDATA_GMAIL_PASSWORD = "testdata.gmail.password";


    public static LoginData getLoginData() {
        return new LoginData(
                TestDataReader.getTestData(TESTDATA_GMAIL_EMAIL),
                TestDataReader.getTestData(TESTDATA_GMAIL_PASSWORD)
        );
    }
}
