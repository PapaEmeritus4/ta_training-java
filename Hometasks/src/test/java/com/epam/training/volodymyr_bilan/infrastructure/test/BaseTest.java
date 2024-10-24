package com.epam.training.volodymyr_bilan.infrastructure.test;

import com.epam.training.volodymyr_bilan.infrastructure.driver.DriverSingleton;
import com.epam.training.volodymyr_bilan.infrastructure.util.TestListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterEach()
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
