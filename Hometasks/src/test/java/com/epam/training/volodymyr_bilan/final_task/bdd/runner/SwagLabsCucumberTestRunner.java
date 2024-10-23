package com.epam.training.volodymyr_bilan.final_task.bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/LoginSwagLabs.feature"},
        glue = {"com.epam.training.volodymyr_bilan.final_task.bdd.definitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class SwagLabsCucumberTestRunner extends AbstractTestNGCucumberTests {
}
