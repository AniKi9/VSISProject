package com.prc.vsisproject.service;


import com.prc.vsisproject.model.OWMweather;
import com.prc.vsisproject.model.VCWeather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VCService {
    private final String API_KEY = "8T7PKD3GMTM7PWR8XZHZT3E8K";
    private final RestTemplate restTemplate;
    public VCService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public VCWeather getWeather(String city){
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" +
                city + "?key=" + API_KEY + "&include=current&elements=temp,humidity&lang=ru";
        return restTemplate.getForObject(url, VCWeather.class);
    }

}
