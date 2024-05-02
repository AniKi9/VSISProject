package com.prc.vsisproject.controller;

import com.prc.vsisproject.model.WeatherRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class WeatherControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherController weatherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();
    }

    @Test
    void testProcessWeather_OpenWeatherMap() throws Exception {
        // Arrange
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setService("OpenWeatherMap");
        weatherRequest.setCity("London");

        // Act & Assert
        mockMvc.perform(post("/")
                        .param("service", weatherRequest.getService())
                        .param("city", weatherRequest.getCity()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/weather"));

    }

    @Test
    void testProcessWeather_VCWeather() throws Exception {
        // Arrange
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setService("VC Weather");
        weatherRequest.setCity("London");

        // Act & Assert
        mockMvc.perform(post("/")
                        .param("service", weatherRequest.getService())
                        .param("city", weatherRequest.getCity()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/weather3"));

    }

    @Test
    @Disabled
    void testProcessWeather_Gismeteo() throws Exception {
        // Arrange
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setService("Gismeteo");
        weatherRequest.setCity("London");

        // Act & Assert
        mockMvc.perform(post("/")
                        .param("service", weatherRequest.getService())
                        .param("city", weatherRequest.getCity()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/weather2"));

    }
}

