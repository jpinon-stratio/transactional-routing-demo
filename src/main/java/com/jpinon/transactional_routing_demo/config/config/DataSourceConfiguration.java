package com.jpinon.transactional_routing_demo.config.config;

import javax.sql.DataSource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jpinon.transactional_routing_demo.config.DatabaseEnvironment;
import com.jpinon.transactional_routing_demo.config.RoutingDataSource;
import com.jpinon.transactional_routing_demo.config.properties.DatabaseProperties;

@Configuration
public class DataSourceConfiguration {

    @Autowired
    private DatabaseProperties databaseProperties;

    @Bean
    public DataSource dataSource() {
        RoutingDataSource routingDataSource = new RoutingDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseEnvironment.UPDATABLE, readwriteDataSource());
        targetDataSources.put(DatabaseEnvironment.READONLY, readonlyDataSource());
        routingDataSource.setTargetDataSources(targetDataSources);
        routingDataSource.setDefaultTargetDataSource(readwriteDataSource());
        return routingDataSource;
    }

    public DataSource readonlyDataSource() {
        return databaseProperties.getReadonly().toHikariDataSource();
    }

    public DataSource readwriteDataSource() {
        return databaseProperties.getReadwrite().toHikariDataSource();
    }
}
