package com.javainuse.controller;

import com.javainuse.model.CityGuide;
import com.javainuse.service.CityGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CityGuideController {

    private final CityGuideService service;

    @Autowired
    public CityGuideController(CityGuideService service){
        this.service = service;
    }

    @GetMapping
    public String getAllCityGuides(Model model){
        List<CityGuide> cityGuides = service.getAllCityGuides();
        model.addAttribute("cityGuides", cityGuides);
        return "welcome";
    }

    @PostMapping
    public String createCityGuide(Model model, @ModelAttribute("cityGuide") CityGuide cityGuide) {
        if(null != cityGuide && null != cityGuide.getCity() && null != cityGuide.getDescription() && !cityGuide.getCity().isEmpty() && !cityGuide.getDescription().isEmpty()){
            if(!service.existsByCity(cityGuide.getCity())){
                cityGuide = service.create(cityGuide);
            }
        }
        return "redirect:/";
    }

    @PutMapping
    public String updateCityGuide(@ModelAttribute("cityGuide") @Valid CityGuide cityGuide) {
        if(null != cityGuide && null != cityGuide.getCity() && null != cityGuide.getDescription() && !cityGuide.getCity().isEmpty() && !cityGuide.getDescription().isEmpty()){
            cityGuide = service.update(cityGuide);
        }
        return "redirect:/";
    }

    @DeleteMapping
    public String deleteCityGuide(@PathVariable(name = "cityGuideID") String id) {
        service.delete(id);
        return "redirect:/";
    }
}
