package com.matmazur.mvcrestspringboot.controller;

import com.matmazur.mvcrestspringboot.model.CityWrapper;
import com.matmazur.mvcrestspringboot.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {

    @RequestMapping(value = "/cities")
    public CityWrapper getCities() {

        List<City> cities = new ArrayList<>();
        cities.add(new City("Gdansk", 200_000));
        cities.add(new City("Warszawa", 600_000));
        cities.add(new City("Poznan", 300_000));
        cities.add(new City("Krakow", 400_000));

        CityWrapper cityWrapper = new CityWrapper();
        cityWrapper.setCities(cities);

        return cityWrapper;
    }

//    @RequestMapping(value = "/cities")
//    public ResponseEntity<List<City>> getCities() {
//
//        return new ResponseEntity<>(Arrays.asList(
//                new City("Gdansk", 200_000),
//                new City("Warszawa", 600_000),
//                new City("Poznan", 300_000),
//                new City("Krakow", 400_000)),
//                HttpStatus.OK);
//    }
}
