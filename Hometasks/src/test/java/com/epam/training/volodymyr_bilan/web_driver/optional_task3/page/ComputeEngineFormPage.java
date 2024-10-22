package com.epam.training.volodymyr_bilan.web_driver.optional_task3.page;

import com.epam.training.volodymyr_bilan.infrastructure.page.AbstractPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task3.model.ComputeEngine;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

import static com.epam.training.volodymyr_bilan.infrastructure.util.WaitUtils.*;

@Slf4j
public class ComputeEngineFormPage extends AbstractPage {

    private final String SELECT_BOX_OPTION_LOCATOR = "//li[@data-value='%s']";
    private final String PROVISIONING_MODEL_LOCATOR = "//label[text()='%s']";
    private final By SERVICE_COST_UPDATED_LOCATOR = By.xpath("//div[@class='egBpsb']/following-sibling::div[text()='Service cost updated']");

    @FindBy(xpath = "//input[@value='1']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//ul[@aria-label='Operating System / Software']/../..")
    private WebElement operationSystemSelectBox;

    @FindBy(xpath = "//ul[@aria-label='Machine Family']/../..")
    private WebElement machineFamilySelectBox;

    @FindBy(xpath = "//ul[@aria-label='Series']/../..")
    private WebElement seriesSelectBox;

    @FindBy(xpath = "//ul[@aria-label='Machine type']/../..")
    private WebElement machineTypeSelectBox;

    @FindBy(xpath = "//button[@role='switch' and @aria-label='Add GPUs']")
    private WebElement addGpusButton;

    @FindBy(xpath = "//ul[@aria-label='GPU Model']/../..")
    private WebElement gpuModelSelectBox;

    @FindBy(xpath = "//ul[@aria-label='Number of GPUs']/../..")
    private WebElement numberOfGpusSelectBox;

    @FindBy(xpath = "//ul[@aria-label='Local SSD']/../..")
    private WebElement localSsdSelectBox;

    @FindBy(xpath = "//ul[@aria-label='Region']/../..")
    private WebElement regionSelectBox;

    @FindBy(xpath = "//span[text()='Share']")
    private WebElement shareButton;

    @FindBy(xpath = "//div[text()='Estimated cost']/following::label")
    private WebElement estimatedCost;

    @FindBy(xpath = "//a[text()='Open estimate summary']")
    private WebElement estimateSummaryButton;

    public ComputeEngineFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ComputeEngineFormPage fillForm(ComputeEngine computeEngine) {
        setNumberOfInstances(computeEngine.getNumberOfInstances())
                .selectOperationSystem(computeEngine.getOperatingSystem())
                .selectProvisioningModel(computeEngine.getProvisioningModel())
                .selectMachineFamily(computeEngine.getMachineFamily())
                .selectSeries(computeEngine.getSeries())
                .selectMachineType(computeEngine.getMachineType())
                .toggleAddGpus(computeEngine.isAddGpus())
                .selectGpuType(computeEngine.getGpuModel())
                .selectNumberOfGpus(computeEngine.getNumberOfGpus())
                .selectLocalSsd(computeEngine.getLocalSsd())
                .selectRegion(computeEngine.getRegion());
        waitForVisibility(SERVICE_COST_UPDATED_LOCATOR);
        log.info("Form was filled.");
        return this;
    }

    public String getEstimatedCost() {
        log.info("Estimated cost from calculator page was got.");
        return estimatedCost.getText();
    }

    public ComputeEngineFormPage clickShareButton() {
        shareButton.click();
        return this;
    }

    public EstimateSummaryPage openEstimateSummary() {
        String currentTab = driver.getWindowHandle();

        waitForVisibility(estimateSummaryButton).click();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
        return new EstimateSummaryPage(driver);
    }

    private ComputeEngineFormPage setNumberOfInstances(String number) {
        waitForVisibility(numberOfInstances).clear();
        numberOfInstances.sendKeys(number);
        return this;
    }

    private ComputeEngineFormPage selectOperationSystem(String os) {
        return selectOption(operationSystemSelectBox, os);
    }

    private ComputeEngineFormPage selectProvisioningModel(String model) {
        selectElementByLocator(PROVISIONING_MODEL_LOCATOR, model);
        return this;
    }

    private ComputeEngineFormPage selectMachineFamily(String machineFamily) {
        return selectOption(machineFamilySelectBox, machineFamily);
    }

    private ComputeEngineFormPage selectSeries(String series) {
        return selectOption(seriesSelectBox, series);
    }

    private ComputeEngineFormPage selectMachineType(String type) {
        return selectOption(machineTypeSelectBox, type);
    }

    private ComputeEngineFormPage toggleAddGpus(boolean isAddGpus) {
        scrollToElementWithOffset(addGpusButton);
        String ariaChecked = addGpusButton.getAttribute("aria-checked");
        if (isAddGpus && Objects.equals(ariaChecked, "false")) {
            addGpusButton.click();
        } else if (!isAddGpus && Objects.equals(ariaChecked, "true")) {
            addGpusButton.click();
        }
        return this;
    }

    private ComputeEngineFormPage selectGpuType(String type) {
        waitForVisibility(gpuModelSelectBox);
        return selectOption(gpuModelSelectBox, type);
    }

    private ComputeEngineFormPage selectNumberOfGpus(String number) {
        return selectOption(numberOfGpusSelectBox, number);
    }

    private ComputeEngineFormPage selectLocalSsd(String ssd) {
        String transformedSsd = transformStringToDataValue(ssd);
        localSsdSelectBox.click();
        String localSsdXPath = String.format(SELECT_BOX_OPTION_LOCATOR, transformedSsd);

        List<WebElement> ssdOptions = driver.findElements(By.xpath(localSsdXPath));
        if (ssdOptions.size() >= 2) {
            WebElement secondSsdOption = ssdOptions.get(1);
            waitForVisibility(secondSsdOption).click();
        } else {
            log.error("Local SSD not found");
        }
        return this;
    }

    private ComputeEngineFormPage selectRegion(String region) {
        return selectOption(regionSelectBox, region);
    }

    private ComputeEngineFormPage selectOption(WebElement selectBox, String option) {
        selectBox.click();
        String optionXPath = String.format(SELECT_BOX_OPTION_LOCATOR, transformStringToDataValue(option));
        waitForClickability(By.xpath(optionXPath)).click();
        return this;
    }

    private void selectElementByLocator(String locatorTemplate, String value) {
        String xpath = String.format(locatorTemplate, value);
        waitForVisibility(By.xpath(xpath)).click();
    }

    private String transformStringToDataValue(String input) {
        return input.toLowerCase()
                .replaceAll("[,:;()]", "")
                .replaceAll("\\s+", "-");
    }

    private void scrollToElementWithOffset(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var elementTop = arguments[0].getBoundingClientRect().top;" +
                "window.scrollBy(0, elementTop - arguments[1]);", element, 200);
    }
}