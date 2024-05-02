package com.prc.vsisproject.controller;

import com.prc.vsisproject.model.WeatherRequest;
import com.prc.vsisproject.service.GisService;
import com.prc.vsisproject.service.OWMService;
import com.prc.vsisproject.service.VCService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
@SessionAttributes("weather")
public class WeatherController {

    @Autowired
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
        model.addAttribute("services", new String[]{"OpenWeatherMap", "VC Weather", "Gismeteo"});
        model.addAttribute("image", "images/" + (int)(Math.round(Math.random()*6)+1) + ".jpg");
    }

    @ModelAttribute(name = "weatherRequest")
    public WeatherRequest weatherRequest(){
        return new WeatherRequest();
    }

    @PostMapping
    public String processWeather(@Valid WeatherRequest weatherRequest, Model model){
        if (weatherRequest.getService().equals("OpenWeatherMap")) {
            OWMService owmService = new OWMService(restTemplate);
            model.addAttribute("weather", owmService.getWeather(weatherRequest.getCity()));
            return "redirect:/weather";
        } else if (weatherRequest.getService().equals("Gismeteo")) {
            GisService gisService = new GisService(restTemplate);
            model.addAttribute("weather",gisService.getWeather(weatherRequest.getCity()));
            return "redirect:/weather2";
        } else if (weatherRequest.getService().equals("VC Weather")){
            VCService vcService = new VCService(restTemplate);
            model.addAttribute("weather", vcService.getWeather(weatherRequest.getCity()));
            return "redirect:/weather3";
        }
        return "redirect:/";
    }

    @GetMapping("/weather")
    public String weatherForm(){
        return "weather";
    }
    @GetMapping("/weather2")
    public String weather2Form(){
        return "weather2";
    }
    @GetMapping("/weather3")
    public String weather3Form(){
        return "weather3";
    }
}
