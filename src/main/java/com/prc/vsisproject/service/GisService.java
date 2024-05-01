package com.prc.vsisproject.service;

import com.prc.vsisproject.model.GisWeather;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GisService {
    private final RestTemplate restTemplate;
    public GisService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    private final String geoUrl = "https://api.gismeteo.net/v2/search/cities/?query=";
    private final String weatherUrl = "https://api.gismeteo.net/v2/weather/current/";
    private final String API_KEY = "56b30cb255.3443075";
    HttpHeaders headers = new HttpHeaders();

    private Integer getId(String city){
        String url = geoUrl + city;
        headers.set("X-Gismeteo-Token", API_KEY);
        HttpEntity<GisWeather> entity = new HttpEntity<>(headers);
        ResponseEntity<GisWeather> response = restTemplate.exchange(url, HttpMethod.GET, entity, GisWeather.class);
        return response.getBody().getId();
    }
    public GisWeather getWeather(String city){
        String url = weatherUrl + getId(city) + "&lang=ru";
        headers.set("X-Gismeteo-Token", API_KEY);
        HttpEntity<GisWeather> entity = new HttpEntity<>(headers);
        ResponseEntity<GisWeather> response = restTemplate.exchange(url, HttpMethod.GET, entity, GisWeather.class);
        return response.getBody();
    }

}
