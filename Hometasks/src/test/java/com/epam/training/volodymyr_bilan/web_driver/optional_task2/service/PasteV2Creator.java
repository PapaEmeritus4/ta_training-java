package com.epam.training.volodymyr_bilan.web_driver.optional_task2.service;

import com.epam.training.volodymyr_bilan.infrastructure.util.TestDataReader;
import com.epam.training.volodymyr_bilan.web_driver.optional_task2.model.PasteV2;

public class PasteV2Creator {

    public static final String TESTDATA_PASTE_CODE = "testdata.paste.v2.code";
    public static final String TESTDATA_PASTE_SYNTAX = "testdata.paste.v2.syntax";
    public static final String TESTDATA_PASTE_EXPIRATION = "testdata.paste.v2.expiration";
    public static final String TESTDATA_PASTE_NAME = "testdata.paste.v2.name";

    public static PasteV2 getPasteWithCredentialsFromProperty() {
        return new PasteV2(
                TestDataReader.getTestData(TESTDATA_PASTE_CODE),
                TestDataReader.getTestData(TESTDATA_PASTE_SYNTAX),
                TestDataReader.getTestData(TESTDATA_PASTE_EXPIRATION),
                TestDataReader.getTestData(TESTDATA_PASTE_NAME)
        );
    }
}