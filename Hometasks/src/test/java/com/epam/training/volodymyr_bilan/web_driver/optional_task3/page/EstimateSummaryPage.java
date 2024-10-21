package com.epam.training.volodymyr_bilan.web_driver.optional_task3.page;

import com.epam.training.volodymyr_bilan.infrastructure.page.AbstractPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epam.training.volodymyr_bilan.infrastructure.util.WaitUtils.*;

@Slf4j
public class EstimateSummaryPage extends AbstractPage {

    @FindBy(xpath = "//div[span[text()='Compute']]//span[contains(text(), '$')]")
    private WebElement estimatedCostSummary;

    @FindBy(xpath = "//span[text()='Number of Instances']/following-sibling::span")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//span[text()='Operating System / Software']/following-sibling::span")
    private WebElement operatingSystem;

    @FindBy(xpath = "//span[text()='Provisioning Model']/following-sibling::span")
    private WebElement provisioningModel;

    @FindBy(xpath = "//span[text()='Machine type']/following-sibling::span")
    private WebElement machineType;

    @FindBy(xpath = "//span[text()='GPU Model']/following-sibling::span")
    private WebElement gpuModel;

    @FindBy(xpath = "//span[text()='Number of GPUs']/following-sibling::span")
    private WebElement numberOfGPUs;

    @FindBy(xpath = "//span[text()='Local SSD']/following-sibling::span")
    private WebElement localSSD;

    @FindBy(xpath = "//span[text()='Region']/following-sibling::span")
    private WebElement region;

    public EstimateSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getEstimatedCost() {
        log.info("Estimated cost from summary page was got.");
        return waitForVisibility(estimatedCostSummary).getText();
    }

    public String getNumberOfInstances() {
        return waitForVisibility(numberOfInstances).getText();
    }

    public String getOperatingSystem() {
        return waitForVisibility(operatingSystem).getText();
    }

    public String getProvisioningModel() {
        return waitForVisibility(provisioningModel).getText();
    }


    public String getMachineType() {
        return waitForVisibility(machineType).getText();
    }

    public String getGpuModel() {
        return waitForVisibility(gpuModel).getText();
    }

    public String getNumberOfGPUs() {
        return waitForVisibility(numberOfGPUs).getText();
    }

    public String getLocalSSD() {
        return waitForVisibility(localSSD).getText();
    }

    public String getRegion() {
        return waitForVisibility(region).getText();
    }
}