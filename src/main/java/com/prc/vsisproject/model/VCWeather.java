package com.prc.vsisproject.model;

import lombok.Data;

@Data
public class VCWeather {
    private String address;
    private CurrentConditions currentConditions;
}

@Data
class CurrentConditions{
    private Double temp;
    private Double humidity;
}
