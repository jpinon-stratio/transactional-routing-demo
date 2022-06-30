package com.jpinon.transactional_routing_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpinon.transactional_routing_demo.service.ReadOnlyCarService;
import com.jpinon.transactional_routing_demo.service.ReadWriteCarService;

@RestController
public class CarController {

    private final ReadWriteCarService readWriteCarService;
    private final ReadOnlyCarService readOnlyCarService;

    @Autowired
    public CarController(ReadWriteCarService readWriteCarService, ReadOnlyCarService readOnlyCarService) {
        this.readWriteCarService = readWriteCarService;
        this.readOnlyCarService = readOnlyCarService;
    }

    @PostMapping(path = "/rw/cars/new")
    public ResponseEntity<?> carNew() {

        readWriteCarService.newCar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/rw/cars")
    public ResponseEntity<?> rwCars() {
        return ResponseEntity.ok(readWriteCarService.getAll());
    }

    @GetMapping(path = "/ro/cars")
    public ResponseEntity<?> roCars() {
        return ResponseEntity.ok(readOnlyCarService.getAll());
    }

}
