package com.prc.vsisproject.controller;

import com.prc.vsisproject.model.Weather;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ResponseController {
    RestTemplate restTemplate = new RestTemplate();
}
