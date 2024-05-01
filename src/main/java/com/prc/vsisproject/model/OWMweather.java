package com.prc.vsisproject.model;

import lombok.Data;

@Data
public class OWMweather {
    private Main main;
    private String name;
}
@Data
class Main{
    private Double temp;
    private Double humidity;
}