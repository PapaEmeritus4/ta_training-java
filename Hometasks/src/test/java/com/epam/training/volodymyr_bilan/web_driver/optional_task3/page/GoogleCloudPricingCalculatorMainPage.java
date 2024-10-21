package com.epam.training.volodymyr_bilan.web_driver.optional_task3.page;

import com.epam.training.volodymyr_bilan.infrastructure.page.AbstractPage;
import com.epam.training.volodymyr_bilan.infrastructure.util.WaitUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epam.training.volodymyr_bilan.infrastructure.util.WaitUtils.*;

@Slf4j
public class GoogleCloudPricingCalculatorMainPage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//span[text()='Add to estimate']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//h2[text()='Compute Engine']")
    private WebElement computeEngineSelect;


    public GoogleCloudPricingCalculatorMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorMainPage openPage() {
        driver.get(BASE_URL);
        log.info("Google Cloud Pricing Calculator page opened.");
        return this;
    }

    public ComputeEngineFormPage clickAddToEstimate() {
        addToEstimateButton.click();
        waitForVisibility(computeEngineSelect).click();
        return new ComputeEngineFormPage(driver);
    }
}