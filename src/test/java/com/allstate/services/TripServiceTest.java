package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TripServiceTest {
    private TripService tripService;
    private PassengerService passengerService;
    private CarService carService;

    @Autowired
    public void setTripService(TripService tripService) {
        this.tripService = tripService;
    }

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }
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
    public void shouldCreateTrip() throws Exception{
        Passenger p = this.passengerService.getPassengerByID(1);
        Car c = this.carService.getCarByID(1);
        Trip before = new Trip(new Time(8,15,00),new Time(9,00,00),true,8.5d,10);
        before.setPassenger(p);
        before.setCar(c);
        Trip after = this.tripService.create(before);
        assertEquals(4, after.getId());
        assertEquals(45, after.getDuration(),0.1);

    }

    @Test
    public void shouldFindPassengerforGivenTripId() throws Exception{
        Trip trip = this.tripService.getTripByID(1);
        assertEquals("Chyld",trip.getPassenger().getName());
        assertEquals(Gender.MALE,trip.getPassenger().getGender());
    }

    @Test
    public void shouldFindCarForGivenTripId() throws Exception {
        Trip trip = this.tripService.getTripByID(1);
        assertEquals(1,trip.getCar().getId());
        assertEquals("Honda",trip.getCar().getMake());

    }

    @Test
    @Transactional
    public void shouldFindDriverForGivenTripId() throws Exception{
        Trip trip = this.tripService.getTripByID(1);
        assertEquals("Lucie",trip.getCar().getDriver().getName());
    }

}