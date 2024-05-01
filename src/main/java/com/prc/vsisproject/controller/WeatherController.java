package com.prc.vsisproject.controller;

import com.prc.vsisproject.model.Weather;
import com.prc.vsisproject.model.WeatherRequest;
import com.prc.vsisproject.service.OWMService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Controller
@RequestMapping("/")
@SessionAttributes("weather")
public class WeatherController {
    final RestTemplate restTemplate;
    WeatherController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
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
    public String processWeather(@Valid WeatherRequest weatherRequest, Model model){
        if (weatherRequest.getService().equals("OpenWeatherMap")) {
            OWMService owmService = new OWMService(restTemplate);
            model.addAttribute("weather", owmService.getWeather(weatherRequest.getCity()));
        } else if (weatherRequest.getService().equals("Gismeteo")) {

        }
        return "redirect:/weather";
    }

    @GetMapping("/weather")
    public String weatherForm(){
        return "weather";
    }
}
