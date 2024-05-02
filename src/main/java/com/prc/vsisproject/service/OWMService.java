package com.prc.vsisproject.service;

import com.prc.vsisproject.model.GisWeather;
import com.prc.vsisproject.model.OWMweather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OWMService extends GisWeather implements com.prc.vsisproject.service.Service {
    private final String API_KEY = "8494c2f2e60ad9eb0914c6bbc02c4208";
    private final RestTemplate restTemplate;
    public OWMService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public OWMweather getWeather(String city){
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&exclude=current.temp,current.humidity&appid=" + API_KEY + "&units=metric&lang=ru";
        return restTemplate.getForObject(url, OWMweather.class);
    }
}
