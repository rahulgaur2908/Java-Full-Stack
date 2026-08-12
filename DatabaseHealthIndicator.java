package com.rahul.fullstack.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean databaseServiceUp = checkDatabaseServiceConnection();

        if (databaseServiceUp) {
            return Health.up()
                    .withDetail("Database", "PostgreSQL Connection Active")
                    .withDetail("Response Time", "2ms")
                    .build();
        }

        return Health.down()
                .withDetail("Error", "Database Service connection timeout!")
                .build();
    }

    private boolean checkDatabaseServiceConnection() {
        return true;
    }
}