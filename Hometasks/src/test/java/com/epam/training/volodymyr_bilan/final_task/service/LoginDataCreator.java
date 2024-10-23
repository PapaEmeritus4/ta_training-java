package com.epam.training.volodymyr_bilan.final_task.service;

import com.epam.training.volodymyr_bilan.final_task.model.LoginData;
import com.epam.training.volodymyr_bilan.infrastructure.util.TestDataReader;

public class LoginDataCreator {

    public static final String TESTDATA_LOGIN_UC1_USERNAME = "testdata.saucedemo.login.uc1.username";
    public static final String TESTDATA_LOGIN_UC1_PASSWORD = "testdata.saucedemo.login.uc1.password";
    public static final String TESTDATA_LOGIN_UC1_ERROR = "testdata.saucedemo.login.uc1.error";

    public static final String TESTDATA_LOGIN_UC2_USERNAME = "testdata.saucedemo.login.uc2.username";
    public static final String TESTDATA_LOGIN_UC2_PASSWORD = "testdata.saucedemo.login.uc2.password";
    public static final String TESTDATA_LOGIN_UC2_ERROR = "testdata.saucedemo.login.uc2.error";

    public static final String TESTDATA_LOGIN_UC3_USERNAME = "testdata.saucedemo.login.uc3.username";
    public static final String TESTDATA_LOGIN_UC3_PASSWORD = "testdata.saucedemo.login.uc3.password";
    public static final String TESTDATA_LOGIN_UC3_TITLE = "testdata.saucedemo.login.uc3.title";

    public static LoginData getLoginDataForUC1() {
        return new LoginData(
                TestDataReader.getTestData(TESTDATA_LOGIN_UC1_USERNAME),
                TestDataReader.getTestData(TESTDATA_LOGIN_UC1_PASSWORD),
                TestDataReader.getTestData(TESTDATA_LOGIN_UC1_ERROR),
                null
        );
    }

    public static LoginData getLoginDataForUC2() {
        return new LoginData(
                TestDataReader.getTestData(TESTDATA_LOGIN_UC2_USERNAME),
                TestDataReader.getTestData(TESTDATA_LOGIN_UC2_PASSWORD),
                TestDataReader.getTestData(TESTDATA_LOGIN_UC2_ERROR),
                null
        );
    }

    public static LoginData getLoginDataForUC3() {
        return new LoginData(
                TestDataReader.getTestData(TESTDATA_LOGIN_UC3_USERNAME),
                TestDataReader.getTestData(TESTDATA_LOGIN_UC3_PASSWORD),
                null,
                TestDataReader.getTestData(TESTDATA_LOGIN_UC3_TITLE)
        );
    }
}
