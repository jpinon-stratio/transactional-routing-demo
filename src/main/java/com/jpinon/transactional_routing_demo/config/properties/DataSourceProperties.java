package com.jpinon.transactional_routing_demo.config.properties;

import com.zaxxer.hikari.HikariDataSource;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DataSourceProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private Integer minimumIdle;
    private Integer maximumPoolSize;
    private Integer idleTimeout;
    private String poolName;
    private Integer maxLifetime;
    private Integer connectionTimeout;

    public HikariDataSource toHikariDataSource() {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(this.url);
        hikariDataSource.setUsername(this.username);
        hikariDataSource.setPassword(this.password);
        hikariDataSource.setDriverClassName(this.driverClassName);
        hikariDataSource.setMinimumIdle(this.minimumIdle);
        hikariDataSource.setMaximumPoolSize(this.maximumPoolSize);
        hikariDataSource.setIdleTimeout(this.idleTimeout);
        hikariDataSource.setPoolName(this.poolName);
        hikariDataSource.setMaxLifetime(this.maxLifetime);
        hikariDataSource.setConnectionTimeout(this.connectionTimeout);

        return hikariDataSource;
    }
}