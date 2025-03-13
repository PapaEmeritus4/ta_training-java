package com.epam.training.volodymyr_bilan.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.volodymyr_bilan.utils.WaitUtils.*;

@Slf4j
public class SwagLabsLoginPage extends AbstractPage {

    private final String BASE_URL = "https://www.saucedemo.com/";

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput ;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public SwagLabsLoginPage(WebDriver driver) {
        super(driver);
    }

    public SwagLabsLoginPage openPage() {
        driver.get(BASE_URL);
        log.info("Login page opened.");
        return this;
    }

    public SwagLabsLoginPage setUsername(String username) {
        waitForVisibility(usernameInput).clear();
        usernameInput.sendKeys(username);
        return this;
    }

    public SwagLabsLoginPage setPassword(String password) {
        waitForVisibility(passwordInput).clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public SwagLabsMainPage clickLoginButton() {
        waitForClickability(loginButton).click();
        log.info("Login button clicked.");
        return new SwagLabsMainPage(driver);
    }

    public String getErrorMessage() {
        String error = waitForVisibility(errorMessage).getText();
        log.info("Error message displayed: {}.", error);
        return error;
    }
}
