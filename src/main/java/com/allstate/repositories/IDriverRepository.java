package com.allstate.repositories;

import com.allstate.entities.Driver;
import com.allstate.entities.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IDriverRepository extends CrudRepository<Driver,Integer> {
    public Driver findByName(String name);

    @Query("select t from Trip t join t.car c join c.driver d where d.id = :id")
    public List<Trip> findAllTripsByDriverId(@Param("id") int id);
}
