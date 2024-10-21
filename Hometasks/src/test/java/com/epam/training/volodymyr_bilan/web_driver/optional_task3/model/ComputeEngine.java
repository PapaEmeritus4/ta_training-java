package com.epam.training.volodymyr_bilan.web_driver.optional_task3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ComputeEngine {

    private String numberOfInstances;
    private String operatingSystem;
    private String provisioningModel;
    private String machineFamily;
    private String series;
    private String machineType;
    private boolean addGpus;
    private String gpuModel;
    private String numberOfGpus;
    private String localSsd;
    private String region;
}
