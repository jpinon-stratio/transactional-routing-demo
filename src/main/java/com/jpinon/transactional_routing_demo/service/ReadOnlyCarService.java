package com.jpinon.transactional_routing_demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpinon.transactional_routing_demo.model.Car;
import com.jpinon.transactional_routing_demo.repository.JpaCarRepository;

@Service
public class ReadOnlyCarService {

    private final JpaCarRepository jpaCarRepository;

    @Autowired
    public ReadOnlyCarService(JpaCarRepository jpaCarRepository) {
        this.jpaCarRepository = jpaCarRepository;
    }

    @Transactional(readOnly = true)
    public Car getCarById(UUID id) {
        return jpaCarRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional(readOnly = true)
    public List<Car> getAll() {
        return jpaCarRepository.findAll();
    }
}
