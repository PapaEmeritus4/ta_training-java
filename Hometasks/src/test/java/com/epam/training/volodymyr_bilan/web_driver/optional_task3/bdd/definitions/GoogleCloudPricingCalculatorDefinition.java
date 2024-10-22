package com.epam.training.volodymyr_bilan.web_driver.optional_task3.bdd.definitions;

import com.epam.training.volodymyr_bilan.infrastructure.driver.DriverSingleton;
import com.epam.training.volodymyr_bilan.web_driver.optional_task3.model.ComputeEngine;
import com.epam.training.volodymyr_bilan.web_driver.optional_task3.page.ComputeEngineFormPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task3.page.EstimateSummaryPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task3.page.GoogleCloudPricingCalculatorMainPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task3.service.ComputeEngineCreator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;

public class GoogleCloudPricingCalculatorDefinition {

    WebDriver driver = DriverSingleton.getDriver();
    ComputeEngine computeEngine = ComputeEngineCreator.getComputeEngineFromProperty();
    GoogleCloudPricingCalculatorMainPage calculatorPage = new GoogleCloudPricingCalculatorMainPage(driver);
    ComputeEngineFormPage formPage = new ComputeEngineFormPage(driver);
    EstimateSummaryPage estimateSummaryPage = new EstimateSummaryPage(driver);
    String expectedCost;
    String actualCost;

    @Before
    public void setUpCucumber() {
        DriverSingleton.getDriver();
    }

    @Given("User opens the Google Cloud Pricing Calculator page")
    public void userOpenCalculatorPage() {
        calculatorPage.openPage();
    }

    @And("User chooses Add to estimate")
    public void userChooseAddToEstimate() {
        calculatorPage.clickAddToEstimate();
    }

    @When("User fills the form with required data")
    public void userFillForm() {
        expectedCost = formPage
                .fillForm(computeEngine)
                .getEstimatedCost();

    }

    @And("User clicks on the detailed view link")
    public void userClickOnDetailedView() {
        actualCost = formPage
                .clickShareButton()
                .openEstimateSummary()
                .getEstimatedCost();
    }

    @Then("All filled data should be displayed on the Summary View page")
    public void allFilledDataShouldDisplayedOnSummaryPage() {
        String actualNumberOfInstances = computeEngine.getNumberOfInstances();
        String actualOperatingSystem = computeEngine.getOperatingSystem();
        String actualProvisioningModel = computeEngine.getProvisioningModel();
        String actualMachineType = computeEngine.getMachineType();
        String actualNumberOfGPUs = computeEngine.getNumberOfGpus();
        String actualLocalSSD = computeEngine.getLocalSsd();
        String actualRegion = computeEngine.getRegion();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(estimateSummaryPage.getNumberOfInstances()).contains(actualNumberOfInstances);
        softAssertions.assertThat(estimateSummaryPage.getOperatingSystem()).contains(actualOperatingSystem);
        softAssertions.assertThat(estimateSummaryPage.getProvisioningModel()).contains(actualProvisioningModel);
        softAssertions.assertThat(estimateSummaryPage.getMachineType()).contains(actualMachineType);
        softAssertions.assertThat(estimateSummaryPage.getNumberOfGPUs()).contains(actualNumberOfGPUs);
        softAssertions.assertThat(estimateSummaryPage.getLocalSSD()).contains(actualLocalSSD);
        softAssertions.assertThat(estimateSummaryPage.getRegion()).contains(actualRegion);
        softAssertions.assertAll();
    }

    @And("The estimated cost should match")
    public void estimatedCostShouldMatch() {
        assertEquals(expectedCost, actualCost);
    }

    @After
    public void tearDownCucumber() {
        DriverSingleton.closeDriver();
    }
}
