package com.epam.training.volodymyr_bilan.ui.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.volodymyr_bilan.ui.utils.WaitUtils.waitForVisibility;

@Slf4j
public class GmailLoginPage extends AbstractPage {

    private final String BASE_URL = "https://accounts.google.com/InteractiveLogin?hl=en&service=mail";

    public GmailLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[text()='Next']")
    private WebElement nextButton;

    public GmailLoginPage openPage() {
        driver.get(BASE_URL);
        log.info("Gmail login page opened");
        return this;
    }

    public GmailLoginPage enterEmail(String email) {
        waitForVisibility(emailInput).clear();
        emailInput.sendKeys(email);
        nextButton.click();
        return this;
    }

    public GmailMainPage enterPassword(String password) {
        waitForVisibility(passwordInput).clear();
        passwordInput.sendKeys(password);
        nextButton.click();
        log.info("Login button clicked");
        return new GmailMainPage(driver);
    }

}
