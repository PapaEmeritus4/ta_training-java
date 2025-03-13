package com.epam.training.volodymyr_bilan.ui.steps;

import com.epam.training.volodymyr_bilan.ui.model.LoginData;
import com.epam.training.volodymyr_bilan.ui.page.GmailLoginPage;
import org.openqa.selenium.WebDriver;

public class GmailStepDefinition {

    private final WebDriver driver;

    public GmailStepDefinition(WebDriver driver) {
        this.driver = driver;
    }

    public String performLoginAndGetDisplayedEmail(LoginData data) {
        return new GmailLoginPage(driver)
                .openPage()
                .enterEmail(data.getEmail())
                .enterPassword(data.getPassword())
                .getUserEmail();
    }
}
