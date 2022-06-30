package com.jpinon.transactional_routing_demo.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "database.datasource")
public class DatabaseProperties {

    private DataSourceProperties readwrite;
    private DataSourceProperties readonly;
}
