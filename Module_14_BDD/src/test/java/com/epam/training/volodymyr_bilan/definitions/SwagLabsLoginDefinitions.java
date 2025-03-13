package com.epam.training.volodymyr_bilan.definitions;

import com.epam.training.volodymyr_bilan.assertions.SwagLabsAssertions;
import com.epam.training.volodymyr_bilan.driver.DriverSingleton;
import com.epam.training.volodymyr_bilan.page.SwagLabsLoginPage;
import com.epam.training.volodymyr_bilan.page.SwagLabsMainPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SwagLabsLoginDefinitions {

    WebDriver driver;
    SwagLabsLoginPage loginPage;
    SwagLabsMainPage mainPage;

    @Before
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @Given("User open the Swag Labs login page")
    public void user_open_the_swag_labs_login_page() {
        loginPage = new SwagLabsLoginPage(driver);
        loginPage.openPage();
    }

    @When("User enter the username {string} and the password {string}")
    public void user_enter_the_username_and_the_password(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("User click the login button")
    public void user_click_the_login_button() {
        mainPage = loginPage.clickLoginButton();
    }

    @Then("User should see the expected message {string}")
    public void user_should_see_the_expected_message(String expectedMessage) {
        if (expectedMessage.equals("Username is required") || expectedMessage.equals("Password is required")) {
            String actualErrorMessage = loginPage.getErrorMessage();
            SwagLabsAssertions.verifyErrorMessage(actualErrorMessage, expectedMessage);
        } else {
            String actualTitle = mainPage.getPageTitle();
            SwagLabsAssertions.verifyPageTitle(actualTitle, expectedMessage);
        }
    }

    @After
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}