package com.epam.training.volodymyr_bilan.final_task.bdd.runner;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("com.epam.training.volodymyr_bilan.final_task.bdd.runner")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.epam.training.volodymyr_bilan.final_task.bdd.definitions")
public class SwagLabsCucumberTestRunner {
}
