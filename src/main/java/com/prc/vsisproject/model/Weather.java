package com.prc.vsisproject.model;

import lombok.Data;

@Data
public class Weather {
    private String city;
    private String service;
    private String temp;
    private String humidity;
}
