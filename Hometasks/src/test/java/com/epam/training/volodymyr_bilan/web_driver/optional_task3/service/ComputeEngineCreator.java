package com.epam.training.volodymyr_bilan.web_driver.optional_task3.service;

import com.epam.training.volodymyr_bilan.infrastructure.util.TestDataReader;
import com.epam.training.volodymyr_bilan.web_driver.optional_task3.model.ComputeEngine;

public class ComputeEngineCreator {

    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.google.cloud.calculator.number_of_instances";
    public static final String TESTDATA_OPERATING_SYSTEM = "testdata.google.cloud.calculator.os";
    public static final String TESTDATA_PROVISIONING_MODEL = "testdata.google.cloud.calculator.provisioning_model";
    public static final String TESTDATA_MACHINE_FAMILY = "testdata.google.cloud.calculator.machine_family";
    public static final String TESTDATA_SERIES = "testdata.google.cloud.calculator.series";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.google.cloud.calculator.machine_type";
    public static final String TESTDATA_ADD_GPUS = "testdata.google.cloud.calculator.add_gpus";
    public static final String TESTDATA_GPU_MODEL = "testdata.google.cloud.calculator.gpu_model";
    public static final String TESTDATA_NUMBER_OF_GPUS = "testdata.google.cloud.calculator.number_of_gpus";
    public static final String TESTDATA_LOCAL_SSD = "testdata.google.cloud.calculator.local_ssd";
    public static final String TESTDATA_REGION = "testdata.google.cloud.calculator.region";

    public static ComputeEngine getComputeEngineFromProperty() {
        return new ComputeEngine(
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_PROVISIONING_MODEL),
                TestDataReader.getTestData(TESTDATA_MACHINE_FAMILY),
                TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                Boolean.parseBoolean(TestDataReader.getTestData(TESTDATA_ADD_GPUS)),
                TestDataReader.getTestData(TESTDATA_GPU_MODEL),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_REGION)
        );
    }
}