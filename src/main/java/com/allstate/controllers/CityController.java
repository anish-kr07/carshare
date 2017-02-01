package com.allstate.controllers;

import com.allstate.entities.City;
import com.allstate.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/city")
public class CityController {
    private CityService cityService;
    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public City findById(@PathVariable int id){
        return this.cityService.getCityByID(id);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public City create(@RequestBody City city){
        return this.cityService.create(city);
    }


}
