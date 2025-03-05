package com.epam.training.volodymyr_bilan.infrastructure.test;

import com.epam.training.volodymyr_bilan.infrastructure.driver.DriverSingleton;
import com.epam.training.volodymyr_bilan.infrastructure.util.TestListener;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Slf4j
@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
        log.info("Driver instance created");
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
        log.info("Driver instance closed");
    }
}
