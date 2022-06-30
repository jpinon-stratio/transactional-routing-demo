package com.jpinon.transactional_routing_demo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.jpinon.transactional_routing_demo.repository")
@EntityScan(basePackages = "com.jpinon.transactional_routing_demo.model")
@SpringBootApplication(scanBasePackages = "com.jpinon.transactional_routing_demo")
public class StratioSpringBootService {

    public static void main(String[] args) {
        SpringApplication.run(StratioSpringBootService.class, args);
    }

}
