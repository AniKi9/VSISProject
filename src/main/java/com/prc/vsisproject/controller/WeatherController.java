package com.prc.vsisproject.controller;

import com.prc.vsisproject.model.Weather;
import com.prc.vsisproject.model.WeatherRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    }

    @ModelAttribute(name = "weatherRequest")
    public WeatherRequest req(){
        return new WeatherRequest();
    }

    @ModelAttribute(name = "weather")
    public Weather resp(){
        return new Weather();
    }

    @PostMapping
    public String processWeather(@Valid WeatherRequest req, @ModelAttribute Weather weather, Errors errors){
        if (errors.hasErrors()) {
            return "redirect:/";
        }

        if (req.getService().equals("OpenWeatherMap")) {
            weather.setService("OpenWeatherMap");
        } else if (req.getService().equals("Gismeteo")) {
            weather.setService("Gismeteo");
        }
        weather.setCity(req.getCity());
        return "redirect:/weather";
    }
}
