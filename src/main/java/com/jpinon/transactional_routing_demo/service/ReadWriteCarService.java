package com.jpinon.transactional_routing_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpinon.transactional_routing_demo.model.Car;
import com.jpinon.transactional_routing_demo.repository.JpaCarRepository;

@Service
public class ReadWriteCarService {

    private static final Integer DEFAULT_ID = 1;

    private final ReadOnlyCarService readOnlyCarService;
    private final JpaCarRepository jpaCarRepository;

    @Autowired
    public ReadWriteCarService(ReadOnlyCarService readOnlyCarService, JpaCarRepository jpaCarRepository) {
        this.readOnlyCarService = readOnlyCarService;
        this.jpaCarRepository = jpaCarRepository;
    }

    @Transactional
    public void newCar() {
        Car newCar = new Car(readOnlyCarService.getCarById(DEFAULT_ID));
        jpaCarRepository.save(newCar);
    }

    @Transactional
    public List<Car> getAll() {
        return jpaCarRepository.findAll();
    }
}
