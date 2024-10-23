package com.epam.training.volodymyr_bilan.final_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginData {

    private String username;
    private String password;
    private String expectedMessage;
    private String title;
}