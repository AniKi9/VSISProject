package com.prc.vsisproject.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Weather {
    private Main main;
    private String name;
}
@Getter
@Setter
@NoArgsConstructor
class Main{
    private Double temp;
    private Double humidity;
}