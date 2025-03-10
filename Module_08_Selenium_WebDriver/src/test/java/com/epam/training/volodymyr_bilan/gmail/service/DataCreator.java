package com.epam.training.volodymyr_bilan.gmail.service;

import com.epam.training.volodymyr_bilan.gmail.model.LoginData;
import com.epam.training.volodymyr_bilan.gmail.model.MessageData;
import com.epam.training.volodymyr_bilan.infrastructure.test.TestDataReader;

public class DataCreator {

    public static final String TESTDATA_GMAIL_EMAIL = "testdata.gmail.email";
    public static final String TESTDATA_GMAIL_PASSWORD = "testdata.gmail.password";

    public static final String TESTDATA_GMAIL_RECIPIENT = "testdata.gmail.recipient";
    public static final String TESTDATA_GMAIL_SUBJECT = "testdata.gmail.subject";
    public static final String TESTDATA_GMAIL_MESSAGE = "testdata.gmail.message";

    public static LoginData getLoginData() {
        return new LoginData(
                TestDataReader.getTestData(TESTDATA_GMAIL_EMAIL),
                TestDataReader.getTestData(TESTDATA_GMAIL_PASSWORD)
        );
    }

    public static MessageData getMessageData() {
        return new MessageData(
                TestDataReader.getTestData(TESTDATA_GMAIL_RECIPIENT),
                TestDataReader.getTestData(TESTDATA_GMAIL_SUBJECT),
                TestDataReader.getTestData(TESTDATA_GMAIL_MESSAGE)
        );
    }
}
