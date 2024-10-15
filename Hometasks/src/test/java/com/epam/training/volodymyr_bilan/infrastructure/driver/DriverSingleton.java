package com.epam.training.volodymyr_bilan.infrastructure.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {

    }

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                case "chromium": {
                    WebDriverManager.chromiumdriver().setup();
                    driver = new ChromeDriver();
                }
                case "safari": {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                }
                case "ie": {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                }
            }
            //if we need implicitly waits
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver.close();
    }
}