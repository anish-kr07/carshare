package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.repositories.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    private IPassengerRepository passengerRepository;
    @Autowired
    public void setPassengerRepository(IPassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger create(Passenger passenger){
        return this.passengerRepository.save(passenger);
    }

    public Passenger getPassengerByID(int id){
        return this.passengerRepository.findOne(id);
    }

    public Iterable<Passenger> getPassengerByName(String name){
        return this.passengerRepository.findPassengerByName(name);
    }
    public void removePassengerByID(int id){
        this.passengerRepository.delete(id);
    }
    public Passenger updatePassenger(Passenger passenger){
        return this.passengerRepository.save(passenger);
    }

    public double getMinimumDuration(int id){
        Optional<BigDecimal> value = this.passengerRepository.minimum(id);
        return value.isPresent() ? value.get().doubleValue() : 0;
    }
    public double getMaximumDuration(int id){
        Optional<BigDecimal> value = this.passengerRepository.maximum(id);
        return value.isPresent() ? value.get().doubleValue() : 0;
    }

    public List<Driver> getAllDriversByPassengerId(int id){
        return this.passengerRepository.findAllDriversForPassengerId(id);
    }
}

