package com.epam.training.volodymyr_bilan.infrastructure.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected final int WAIT_TIMEOUT_SECONDS = 8;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}