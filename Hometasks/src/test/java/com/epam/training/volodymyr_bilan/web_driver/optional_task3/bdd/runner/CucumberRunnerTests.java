package com.epam.training.volodymyr_bilan.web_driver.optional_task3.bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/GoogleCloudPricingCalculator.feature"},
        glue = {"com.epam.training.volodymyr_bilan.web_driver.optional_task3.bdd.definitions"}
)
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}
