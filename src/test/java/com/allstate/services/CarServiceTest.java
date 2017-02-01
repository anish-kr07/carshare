package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
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
    private DriverService driverService;
    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }
    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCar() throws Exception{
        Driver driver = this.driverService.getDriverByID(1);
        Car before = new Car("Mahindra","Bollero",2013,"MH137933", Type.BASIC);
        before.setDriver(driver);
        Car after = this.carService.create(before);
        assertEquals(4, after.getId());
        assertEquals("Lucie",after.getDriver().getName());
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
        assertEquals(2,car.getTrips().size());
    }

    @Test
    public void shouldFindDriverForGivenCarId() throws Exception{
        Car car =this.carService.getCarByID(2);
        assertEquals(1,car.getDriver().getId());
        assertEquals("Lucie",car.getDriver().getName());

    }
}