package com.epam.training.volodymyr_bilan.final_task.bdd.definitions;

import com.epam.training.volodymyr_bilan.final_task.page.SwagLabsLoginPage;
import com.epam.training.volodymyr_bilan.final_task.page.SwagLabsMainPage;
import com.epam.training.volodymyr_bilan.infrastructure.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class SwagLabsLoginDefinitions {

    WebDriver driver;
    SwagLabsLoginPage loginPage;
    SwagLabsMainPage mainPage;

    @Before
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @Given("User open the Swag Labs login page")
    public void openLoginPage() {
        loginPage = new SwagLabsLoginPage(driver);
        loginPage.openPage();
    }

    @When("User enter the username {string} and the password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("User click the login button")
    public void userClickLoginButton() {
        mainPage = loginPage.clickLoginButton();
    }

    @Then("User should see the expected message {string}")
    public void userShouldSeeExpectedMessage(String expectedMessage) {
        if (expectedMessage.equals("Username is required") || expectedMessage.equals("Password is required")) {
            String actualErrorMessage = loginPage.getErrorMessage();
            assertTrue(actualErrorMessage.contains(expectedMessage));
        } else {
            String actualTitle = mainPage.getPageTitle();
            assertEquals(expectedMessage, actualTitle);
        }
    }

    @After
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
