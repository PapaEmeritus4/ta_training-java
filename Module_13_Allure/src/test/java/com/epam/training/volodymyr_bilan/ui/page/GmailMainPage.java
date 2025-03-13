package com.epam.training.volodymyr_bilan.ui.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class GmailMainPage extends AbstractPage {

    @FindBy(xpath = "//div[text()='epam.qa.mail@gmail.com']")
    private WebElement userEmail;

    public GmailMainPage(WebDriver driver) {
        super(driver);
    }

    public String getUserEmail() {
        String email = userEmail.getText();
        log.info("User email obtained: {}", email);
        return email;
    }
}
