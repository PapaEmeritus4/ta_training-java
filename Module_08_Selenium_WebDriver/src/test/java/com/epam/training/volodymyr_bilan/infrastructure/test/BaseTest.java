package com.epam.training.volodymyr_bilan.infrastructure.test;

import com.epam.training.volodymyr_bilan.infrastructure.driver.DriverSingleton;
import com.epam.training.volodymyr_bilan.infrastructure.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
