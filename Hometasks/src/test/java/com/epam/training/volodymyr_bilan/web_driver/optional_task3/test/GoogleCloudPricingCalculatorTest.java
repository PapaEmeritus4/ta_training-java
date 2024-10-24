package com.epam.training.volodymyr_bilan.web_driver.optional_task3.test;

import com.epam.training.volodymyr_bilan.infrastructure.test.BaseTest;
import com.epam.training.volodymyr_bilan.web_driver.optional_task3.model.ComputeEngine;
import com.epam.training.volodymyr_bilan.web_driver.optional_task3.page.ComputeEngineFormPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task3.page.EstimateSummaryPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task3.page.GoogleCloudPricingCalculatorMainPage;
import com.epam.training.volodymyr_bilan.web_driver.optional_task3.service.ComputeEngineCreator;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleCloudPricingCalculatorTest extends BaseTest {

    @Test
    public void testComputeEngineEstimation() {
        ComputeEngine computeEngine = ComputeEngineCreator.getComputeEngineFromProperty();
        String expectedCost = new GoogleCloudPricingCalculatorMainPage(driver)
                .openPage()
                .clickAddToEstimate()
                .fillForm(computeEngine)
                .getEstimatedCost();

        String actualCost = new ComputeEngineFormPage(driver)
                .clickShareButton()
                .openEstimateSummary()
                .getEstimatedCost();

        var estimateSummary = new EstimateSummaryPage(driver);

        assertEquals(expectedCost, actualCost, "Estimated cost does not match expected value.");

        String actualNumberOfInstances = computeEngine.getNumberOfInstances();
        String actualOperatingSystem = computeEngine.getOperatingSystem();
        String actualProvisioningModel = computeEngine.getProvisioningModel();
        String actualMachineType = computeEngine.getMachineType();
        String actualGpuModel = computeEngine.getGpuModel();
        String actualNumberOfGPUs = computeEngine.getNumberOfGpus();
        String actualLocalSSD = computeEngine.getLocalSsd();
        String actualRegion = computeEngine.getRegion();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(estimateSummary.getNumberOfInstances()).contains(actualNumberOfInstances);
        softAssertions.assertThat(estimateSummary.getOperatingSystem()).contains(actualOperatingSystem);
        softAssertions.assertThat(estimateSummary.getProvisioningModel()).contains(actualProvisioningModel);
        softAssertions.assertThat(estimateSummary.getMachineType()).contains(actualMachineType);
        softAssertions.assertThat(estimateSummary.getGpuModel()).contains(actualGpuModel);
        softAssertions.assertThat(estimateSummary.getNumberOfGPUs()).contains(actualNumberOfGPUs);
        softAssertions.assertThat(estimateSummary.getLocalSSD()).contains(actualLocalSSD);
        softAssertions.assertThat(estimateSummary.getRegion()).contains(actualRegion);
    }
}