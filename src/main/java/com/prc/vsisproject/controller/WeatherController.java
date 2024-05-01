package com.prc.vsisproject.controller;

import com.prc.vsisproject.model.Weather;
import com.prc.vsisproject.model.WeatherRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/")
@SessionAttributes("weather")
public class WeatherController {

    @GetMapping
    public String indexForm(){
        return "index";
    }

    @ModelAttribute
    public void model(Model model){
        model.addAttribute("services", new String[]{"OpenWeatherMap", "Gismeteo"});
        model.addAttribute("image", "images/" + (int)(Math.round(Math.random()*2)+1) + ".jpg");
    }

    @ModelAttribute(name = "weatherRequest")
    public WeatherRequest weatherRequest(){
        return new WeatherRequest();
    }

    @ModelAttribute(name = "weather")
    public Weather weather(){
        return new Weather();
    }

    @PostMapping
    public String processWeather(@Valid WeatherRequest weatherRequest, @ModelAttribute Weather weather){
        if (weatherRequest.getService().equals("OpenWeatherMap")) {
            weather.setService("OpenWeatherMap");
        } else if (weatherRequest.getService().equals("Gismeteo")) {
            weather.setService("Gismeteo");
        }
        weather.setCity(weatherRequest.getCity());
        return "redirect:/weather";
    }

    @GetMapping("/weather")
    public String weatherForm(){
        return "weather";
    }
}
