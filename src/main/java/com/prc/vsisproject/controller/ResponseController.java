package com.prc.vsisproject.controller;

import com.prc.vsisproject.model.Weather;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/weather")
@SessionAttributes("weather")
public class ResponseController {
    @GetMapping
    public String weatherForm(){
        return "weather";
    }
}
