package com.allstate.services;


import com.allstate.entities.City;
import com.allstate.repositories.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private ICityRepository cityRepository;

    @Autowired
    public void setCityRepository(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City  create(City city){
        return this.cityRepository.save(city);
    }

    public City getCityByID(int id){
        return this.cityRepository.findOne(id);
    }

    public void removeCityByID(int id){
        this.cityRepository.delete(id);
    }

    public City getCityByName(String name){
        return this.cityRepository.findByName(name);
    }

    public Iterable<City> getCitiesByState(String state){
        return this.cityRepository.findByState(state);
    }
}
