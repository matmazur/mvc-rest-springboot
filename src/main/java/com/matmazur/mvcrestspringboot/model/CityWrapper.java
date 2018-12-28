package com.matmazur.mvcrestspringboot.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class CityWrapper {

    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
