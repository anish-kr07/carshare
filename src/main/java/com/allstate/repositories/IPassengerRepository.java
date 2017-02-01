package com.allstate.repositories;

import com.allstate.entities.Passenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;


public interface IPassengerRepository extends CrudRepository<Passenger,Integer> {

    public Iterable<Passenger> findPassengerByName(String name);

    String minsql = "select min(t.duration) as minimum from trips t where passenger_id = :id";
    @Query(value = minsql, nativeQuery = true)
    public Optional<BigDecimal> minimum(@Param("id") int id);

    String maxsql = "select max(t.duration) as maximum from trips t where passenger_id = :id";
    @Query(value = maxsql, nativeQuery = true)
    public Optional<BigDecimal> maximum(@Param("id") int id);
}
