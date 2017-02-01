package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.enums.Type;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CarServiceTest {
    private CarService carService;
    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCar() throws Exception{
        Car before = new Car("Mahindra","Bollero",2013,"MH137933", Type.BASIC);
        Car after = this.carService.create(before);
        assertEquals(4, after.getId());
    }

    @Test
    public void shouldGetCarByID() throws Exception{
        Car car =  this.carService.getCarByID(1);
        assertEquals("Honda", car.getMake());

    }
    @Test
    public void shouldGetCarsByMake() throws Exception{
        ArrayList<Car> cities = (ArrayList) this.carService.getCarsByMake("Honda");
        assertEquals(2, cities.size());
    }
    @Test
    public void shouldRemoveCar() throws Exception{

        this.carService.removeCarByID(1);
        Car car =  this.carService.getCarByID(1);
        assertNull(car);

    }

    @Test
    @Transactional
    public void shouldFindAllTripsByGivenCarId() throws Exception {
        Car car = this.carService.getCarByID(1);
        assertEquals(1,car.getTrips().size());
    }
}