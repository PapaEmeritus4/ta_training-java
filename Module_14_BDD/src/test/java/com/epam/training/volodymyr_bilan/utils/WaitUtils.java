package com.epam.training.volodymyr_bilan.utils;

import com.epam.training.volodymyr_bilan.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final WebDriver DRIVER = DriverSingleton.getDriver();
    private static final long DEFAULT_TIMEOUT = 10;

    public static WebElement waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static WebElement waitForClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
