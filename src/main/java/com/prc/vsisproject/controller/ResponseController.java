package com.prc.vsisproject.controller;

import com.prc.vsisproject.model.Weather;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/weather")
@SessionAttributes("weather")
public class ResponseController {
    @GetMapping
    public String weatherForm(){
        return "weather";
    }

    @ModelAttribute
    public void model(Model model){
        model.addAttribute("image", "images/" + (int)(Math.round(Math.random()*2)+1) + ".jpg");
    }
}
