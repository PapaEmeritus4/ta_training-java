package com.epam.training.volodymyr_bilan.web_driver.optional_task1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Paste {

    private String code;
    private String pasteExpiration;
    private String pasteName;
}