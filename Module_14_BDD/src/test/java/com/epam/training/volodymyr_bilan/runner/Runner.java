package com.epam.training.volodymyr_bilan.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/epam/training/volodymyr_bilan/definitions"
)
public class Runner extends AbstractTestNGCucumberTests {
}
