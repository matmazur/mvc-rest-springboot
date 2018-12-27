package com.matmazur.mvcrestspringboot.controller;

import com.matmazur.mvcrestspringboot.model.City;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @RequestMapping("/city")
    public City getCity() {
        return City.builder()
                .withName("Gdansk")
                .withPopulation(300000)
                .build();
    }
}
