package com.epam.training.volodymyr_bilan.gmail.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginData {

    private String email;
    private String password;
}
