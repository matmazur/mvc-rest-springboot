package com.matmazur.mvcrestspringboot.controller;

import com.matmazur.mvcrestspringboot.model.CityWrapper;
import com.matmazur.mvcrestspringboot.model.City;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

    @RequestMapping
    public CityWrapper getCities(@RequestParam(required = false) Integer page, @RequestParam(required = false) String order) {

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
            return cityWrapper;
        }

        cityWrapper.setCities(cities);
        return cityWrapper;
    }

    @RequestMapping(value = "/{id}")
    public City getCity(@PathVariable int id) {

        return cities.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    @PostConstruct
    public void starter(){
        System.out.println("start");
    }
    @PreDestroy
    public void destr(){
        System.out.println("destroy");
    }
}
