package com.allstate.services;

import com.allstate.entities.Driver;
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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class DriverServiceTest {

    private DriverService driverService;

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
    public void shouldCreateDriver() throws Exception{
        Driver before = new Driver("James Bond", 29, Gender.MALE, "USA007");
        Driver after = this.driverService.create(before);
        assertEquals(3, after.getId());
    }

    @Test
    public void shouldGetDriveryByID() throws Exception{
        Driver driver =  this.driverService.getDriverByID(1);
        assertEquals("Lucie", driver.getName());

    }

    @Test
    public void shouldGetDriverByName() throws Exception{
        Driver driver =  this.driverService.getDriverByName("Lucie");
        assertEquals(1, driver.getId());
        assertEquals(Gender.FEMALE, driver.getGender());

    }
    @Test
    public void shouldRemoveDriver() throws Exception{
        this.driverService.removeDriverByID(1);
        Driver driver=  this.driverService.getDriverByID(1);
        assertNull(driver);
    }

    @Test
    public void shouldUpdateViolationCountOfDriver() throws Exception{
        Driver before=  this.driverService.getDriverByID(1);
        before.setViolationCount(1);
        Driver after = this.driverService.updateDriver(before);
        assertEquals(1, after.getViolationCount());
        assertEquals(1, after.getVersion());
    }

    @Test
    public void shouldReturnTrueIfDriverIsBanned() throws Exception{
        Driver before=  this.driverService.getDriverByID(1);
        before.setViolationCount(4);
        Driver after = this.driverService.updateDriver(before);
        assertEquals(true,this.driverService.isBanned(1));
    }

    @Test
    @Transactional
    public void shouldGetListOfCarsDrivenByDriver() throws Exception{
        Driver driver = this.driverService.getDriverByID(1);
        assertEquals(2,driver.getCars().size());
    }

    @Test
    @Transactional
    public void shouldGetAllTripsByDriverId() throws Exception{
        List<Trip> trips = this.driverService.getTripsByDriverId(1);
        assertEquals(2,trips.size());
    }

}