package com.allstate.services;

import com.allstate.entities.City;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CityServiceTest {

    CityService cityService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCity() throws Exception{
        City before = new City("Patna","Bihar",40,45);
        City after =  this.cityService.create(before);
        assertEquals(4, after.getId());
        assertEquals("Patna", after.getName());
    }

    @Test
    public void shouldGetCityByID() throws Exception{
        City city =  this.cityService.getCityByID(1);
        assertEquals("Pune", city.getName());
    }

    @Test
    public void shouldGetCityByName() throws Exception{
        City city =  this.cityService.getCityByName("Pune");
        assertEquals(1, city.getId());
    }

    @Test
    public void shouldGetCitiesByState() throws Exception{
        ArrayList<City> cities = (ArrayList) this.cityService.getCitiesByState("Maharashtra");
        assertEquals(2, cities.size());
    }

    @Test
    public void shouldRemoveCity() throws Exception{
        this.cityService.removeCityByID(1);
        City city =  this.cityService.getCityByID(1);
        assertNull(city);
    }


}