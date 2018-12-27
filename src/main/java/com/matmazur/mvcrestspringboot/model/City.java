package com.matmazur.mvcrestspringboot.model;

public class City {

    private String name;
    private long population;

    public City(String name, long population) {
        this.name = name;
        this.population = population;
    }

    public City() {
    }

    public static Builder builder() {
        return new Builder();
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
