package com.epam.training.volodymyr_bilan.ui.test;

import com.epam.training.volodymyr_bilan.ui.driver.DriverSingleton;
import com.epam.training.volodymyr_bilan.ui.steps.GmailStepDefinition;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Slf4j
@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected GmailStepDefinition gmailSteps;

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
        gmailSteps = new GmailStepDefinition(driver);
        log.info("Driver instance created");
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
        log.info("Driver instance closed");
    }
}
