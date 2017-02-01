package com.allstate.repositories;

import com.allstate.entities.Passenger;
import org.springframework.data.repository.CrudRepository;


public interface IPassengerRepository extends CrudRepository<Passenger,Integer> {

    public Iterable<Passenger> findPassengerByName(String name);
}
