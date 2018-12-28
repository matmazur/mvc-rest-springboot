package com.matmazur.mvcrestspringboot.model;

import com.matmazur.mvcrestspringboot.MvcRestSpringbootApplication;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class City {

    private int id;
    private String name;
    private long population;

    public City(String name, long population) {
        this.name = name;
        this.population = population;
        this.id = MvcRestSpringbootApplication.REG;
        MvcRestSpringbootApplication.REG++;
    }

    public City() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public static class Builder {

        private String name;
        private long population;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPopulation(long population) {
            this.population = population;
            return this;
        }

        public City build() {
            return new City(name, population);
        }
    }
}
