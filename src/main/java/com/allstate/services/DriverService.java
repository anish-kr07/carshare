package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.entities.Trip;
import com.allstate.repositories.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private IDriverRepository driverRepository;

    @Autowired
    public void setDriverRepository(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver create(Driver driver){
        return this.driverRepository.save(driver);
    }

    public Driver getDriverByID(int id){
        return this.driverRepository.findOne(id);
    }
    public Driver getDriverByName(String name){
        return this.driverRepository.findByName(name);
    }
    public void removeDriverByID(int id){
        this.driverRepository.delete(id);
    }
    public Driver updateDriver(Driver driver){
        return this.driverRepository.save(driver);
    }
    public boolean isBanned(int id){
        return this.driverRepository.findOne(id).getViolationCount() > 3 ? true : false;
    }
    public List<Trip> getTripsByDriverId(int id){
        return this.driverRepository.findAllTripsByDriverId(id);
    }
}
