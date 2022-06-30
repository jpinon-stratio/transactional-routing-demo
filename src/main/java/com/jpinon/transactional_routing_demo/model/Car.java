package com.jpinon.transactional_routing_demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq_gen")
    @SequenceGenerator(name = "car_seq_gen", sequenceName = "car_id_seq")
    private Integer id;

    private String brand;

    private String model;

    public Car(Car car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
    }

}
