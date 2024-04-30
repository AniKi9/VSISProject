package com.prc.vsisproject.controller;

import com.prc.vsisproject.model.Weather;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weather")
public class ResponseController {
    @PostMapping
    public String weatherForm(@ModelAttribute Weather weather){
        return "weather";
    }
}
