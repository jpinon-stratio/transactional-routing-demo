package com.jpinon.transactional_routing_demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpinon.transactional_routing_demo.model.Car;

public interface JpaCarRepository extends JpaRepository<Car, UUID> {

}
