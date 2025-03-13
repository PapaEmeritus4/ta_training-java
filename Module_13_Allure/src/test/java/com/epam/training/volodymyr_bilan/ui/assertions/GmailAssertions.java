package com.epam.training.volodymyr_bilan.ui.assertions;

import com.epam.training.volodymyr_bilan.ui.model.LoginData;
import lombok.extern.slf4j.Slf4j;

import static org.testng.Assert.assertEquals;

@Slf4j
public class GmailAssertions {

    public static void verifySuccessfulLogin(String actualEmail, LoginData expectedData) {
        assertEquals(actualEmail, expectedData.getEmail(), "Displayed email does not match expected");
        log.info("Login test passed for email: {}", expectedData.getEmail());
    }
}
