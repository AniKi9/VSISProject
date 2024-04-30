package com.prc.vsisproject.model;

import lombok.Data;

@Data
public class WeatherRequest {

    private String city;

    private String service;
}
