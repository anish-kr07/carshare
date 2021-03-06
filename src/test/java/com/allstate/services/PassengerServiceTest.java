package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class PassengerServiceTest {

    private PassengerService passengerService;
    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreatePassenger() throws Exception{
        Passenger before = new Passenger("Ramesh",50, Gender.MALE,5000d);
        Passenger after = this.passengerService.create(before);
        assertEquals(3, after.getId());
    }

    @Test
    public void shouldGetPassengeryByID() throws Exception{
        Passenger passenger =  this.passengerService.getPassengerByID(1);
        assertEquals("Chyld", passenger.getName());

    }

    @Test
    public void shouldGetPassengerByName() throws Exception{
        ArrayList<Passenger> passengers =  (ArrayList<Passenger>) this.passengerService.getPassengerByName("Chyld");
        assertEquals(1, passengers.size());
    }
    @Test
    public void shouldRemovePassenger() throws Exception{
        this.passengerService.removePassengerByID(1);
        Passenger passenger =  this.passengerService.getPassengerByID(1);
        assertNull(passenger);
    }

    @Test
    public void shouldUpdateCreditBalanceOfPassenger() throws Exception{
        Passenger before=  this.passengerService.getPassengerByID(1);
        before.setCreditBalance(5000d);
        Passenger after = this.passengerService.updatePassenger(before);
        assertEquals(5000d, after.getCreditBalance(),0.01);
        assertEquals(1, after.getVersion());
    }

    @Test
    @Transactional
    public  void shouldFindAllTheTripsForGivenPassengerID() throws Exception {
        Passenger passenger = this.passengerService.getPassengerByID(1);
        assertEquals(2,passenger.getTrips().size());
    }

    @Test
    @Transactional
    public void shouldFindShortestDurationTripForGivenPassengerID() throws Exception{
        double min = this.passengerService.getMinimumDuration(1);
        assertEquals(20,min,0.1);
    }

    @Test
    @Transactional
    public void shouldFindLongestDurationTripForGivenPassengerID() throws Exception {
        double max = this.passengerService.getMaximumDuration(1);
        assertEquals(45,max,0.1);
    }

    @Test
    @Transactional
    public void shouldGetAllDriversForGivenPassengerId() throws Exception{
        List<Driver> drivers = this.passengerService.getAllDriversByPassengerId(1);
        assertEquals(1,drivers.size());
    }

}