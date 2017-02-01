package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.repositories.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private ICarRepository carRepository;

    @Autowired
    public void setCarRepository(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public Car create(Car car){
        return this.carRepository.save(car);
    }

    public Car getCarByID(int id){
        return this.carRepository.findOne(id);
    }

    public void removeCarByID(int id){
        this.carRepository.delete(id);
    }

    public Iterable<Car> getCarsByMake(String make){
        return this.carRepository.findCarByMake(make);
    }

}
