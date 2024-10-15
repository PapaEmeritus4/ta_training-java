package com.epam.training.volodymyr_bilan.web_driver.optional_task1.service;

import com.epam.training.volodymyr_bilan.infrastructure.util.TestDataReader;
import com.epam.training.volodymyr_bilan.web_driver.optional_task1.model.Paste;

public class PasteCreator {

    public static final String TESTDATA_PASTE_CODE = "testdata.paste.code";
    public static final String TESTDATA_PASTE_EXPIRATION = "testdata.paste.expiration";
    public static final String TESTDATA_PASTE_NAME = "testdata.paste.name";

    public static Paste getPasteWithCredentialsFromProperty() {
        return new Paste(
                TestDataReader.getTestData(TESTDATA_PASTE_CODE),
                TestDataReader.getTestData(TESTDATA_PASTE_EXPIRATION),
                TestDataReader.getTestData(TESTDATA_PASTE_NAME)
        );
    }
}