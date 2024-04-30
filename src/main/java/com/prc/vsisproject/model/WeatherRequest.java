package com.prc.vsisproject.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WeatherRequest {
    @NotBlank(message = "Укажите город")
    private String city;

    private String service;
}
