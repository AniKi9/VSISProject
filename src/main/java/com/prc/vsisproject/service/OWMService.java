package com.prc.vsisproject.service;

import com.prc.vsisproject.model.Weather;
import org.springframework.web.client.RestTemplate;

public class OWMService {
    private final String API_KEY = "8494c2f2e60ad9eb0914c6bbc02c4208";
    private final RestTemplate restTemplate;
    public OWMService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public Weather getWeather(String city){
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&exclude=current.temp,current.humidity&appid=" + API_KEY + "&units=metric&lang=ru";
        return restTemplate.getForObject(url, Weather.class);
    }
}
