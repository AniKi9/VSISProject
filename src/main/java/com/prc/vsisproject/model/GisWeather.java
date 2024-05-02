package com.prc.vsisproject.model;

import com.prc.vsisproject.service.VCService;
import lombok.Data;

@Data
public class GisWeather {
    private Integer id;

    private String name;

    private Temperature temperature;

    private Humidity humidity;
}
@Data
class Temperature{
    private Air air;
}
@Data
class Air{
    private Double C;
}
@Data
class Humidity{
    Integer percent;
}