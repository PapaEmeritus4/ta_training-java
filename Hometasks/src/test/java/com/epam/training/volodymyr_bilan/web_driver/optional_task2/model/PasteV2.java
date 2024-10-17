package com.epam.training.volodymyr_bilan.web_driver.optional_task2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PasteV2 {

    private String code;
    private String syntax;
    private String pasteExpiration;
    private String pasteName;
}