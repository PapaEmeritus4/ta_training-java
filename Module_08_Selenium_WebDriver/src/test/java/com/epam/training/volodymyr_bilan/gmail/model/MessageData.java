package com.epam.training.volodymyr_bilan.gmail.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageData {

    private String recipient;
    private String subject;
    private String message;
}
