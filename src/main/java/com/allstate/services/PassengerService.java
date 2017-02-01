package com.allstate.services;

import com.allstate.entities.Passenger;
import com.allstate.repositories.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

