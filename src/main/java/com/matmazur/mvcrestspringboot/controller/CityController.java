package com.matmazur.mvcrestspringboot.controller;

import com.matmazur.mvcrestspringboot.model.CityWrapper;
import com.matmazur.mvcrestspringboot.model.City;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private List<City> cities;

    public CityController() {
        cities = new ArrayList<>();
        cities.add(new City("Gdansk", 200_000));
        cities.add(new City("Warszawa", 600_000));
        cities.add(new City("Poznan", 300_000));
        cities.add(new City("Krakow", 400_000));
        cities.add(new City("Gdansk", 200_000));
        cities.add(new City("Warszawa", 600_000));
        cities.add(new City("Poznan", 300_000));
        cities.add(new City("Krakow", 400_000));
        cities.add(new City("Gdansk", 200_000));
        cities.add(new City("Warszawa", 600_000));
        cities.add(new City("Poznan", 300_000));
        cities.add(new City("Krakow", 400_000));
        cities.add(new City("Gdansk", 200_000));
        cities.add(new City("Warszawa", 600_000));
        cities.add(new City("Poznan", 300_000));
        cities.add(new City("Krakow", 400_000));
        cities.add(new City("Gdansk", 200_000));
        cities.add(new City("Warszawa", 600_000));
        cities.add(new City("Poznan", 300_000));
        cities.add(new City("Krakow", 400_000));
        cities.add(new City("Gdansk", 200_000));
        cities.add(new City("Warszawa", 600_000));
        cities.add(new City("Poznan", 300_000));
        cities.add(new City("Krakow", 400_000));
    }

    @GetMapping
    public ResponseEntity<CityWrapper> getCities(@RequestParam(required = false) Integer page, @RequestParam(required = false) String order) {

        if (order != null) {
            if (order.equals("asc")) {
                cities.sort(Comparator.comparing(City::getName));
            } else if (order.equals("desc")) {
                cities.sort(Comparator.comparing(City::getName).reversed());
            }
        }

        CityWrapper cityWrapper = new CityWrapper();
        int pageSize = 5;
        if (page != null) {
            PagedListHolder<City> pagedListHolder = new PagedListHolder<>(cities);
            pagedListHolder.setPageSize(pageSize);
            pagedListHolder.setPage(page);
            cityWrapper.setCities(pagedListHolder.getPageList());
            return ResponseEntity.ok(cityWrapper);
        }
        cityWrapper.setCities(cities);
        return ResponseEntity.ok(cityWrapper);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> getCity(@PathVariable int id) {

        City city = cities.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        if (city != null) {
            return ResponseEntity.ok(city);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCity(@RequestBody City city) {

        if (city.getName().isEmpty() || city.getPopulation() == null) {
            return ResponseEntity.badRequest().build();
        }

        City cityCorrect = new City(city.getName(), city.getPopulation());

        if (cities.stream().filter((x -> x.getName().equals(cityCorrect.getName()))).findAny().orElse(null) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        cities.add(cityCorrect);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cities.size() - 1)
                .toUri();

        return ResponseEntity.created(location).body(cityCorrect);
    }
}
