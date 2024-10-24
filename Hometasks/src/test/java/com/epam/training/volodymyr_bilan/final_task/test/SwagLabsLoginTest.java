package com.epam.training.volodymyr_bilan.final_task.test;

import com.epam.training.volodymyr_bilan.final_task.model.LoginData;
import com.epam.training.volodymyr_bilan.final_task.page.SwagLabsLoginPage;
import com.epam.training.volodymyr_bilan.final_task.service.LoginDataCreator;
import com.epam.training.volodymyr_bilan.infrastructure.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Slf4j
@Execution(ExecutionMode.CONCURRENT)
public class SwagLabsLoginTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("loginDataProvider")
    public void testLoginForm(LoginData loginData) {
        log.info("Starting login test with username: {}, password: {}", loginData.getUsername(), loginData.getPassword());
        SwagLabsLoginPage loginPage = new SwagLabsLoginPage(driver)
                .openPage()
                .setUsername(loginData.getUsername())
                .setPassword(loginData.getPassword());
        if (loginData.getExpectedMessage() != null) {
            loginPage.clickLoginButton();
            String actualErrorMessage = loginPage.getErrorMessage();
            assertTrue(actualErrorMessage.contains(loginData.getExpectedMessage()),
                    "Expected error message to contain: " + loginData.getExpectedMessage() + ", but was: " + actualErrorMessage);
        } else {
            String actualTitle = loginPage.clickLoginButton()
                    .getPageTitle();
            assertEquals(actualTitle, loginData.getTitle(),
                    "Expected title: " + loginData.getTitle() + ", but was: " + actualTitle);
        }
        log.info("Login test passed for username: {}, password: {}", loginData.getUsername(), loginData.getPassword());
    }

    static Object[][] loginDataProvider() {
        return new Object[][]{
                {LoginDataCreator.getLoginDataForUC1()},
                {LoginDataCreator.getLoginDataForUC2()},
                {LoginDataCreator.getLoginDataForUC3()}
        };
    }
}
