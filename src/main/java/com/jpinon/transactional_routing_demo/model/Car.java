package com.jpinon.transactional_routing_demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @JsonIgnore
    private UUID id;

    private String brand;

    private String model;

    public Car(Car car) {
        this.id = UUID.randomUUID();
        this.brand = car.getBrand();
        this.model = car.getModel();
    }

}
